package com.jsantos.custom.fieldrenderer;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Vector;

import com.jsantos.common.registry.IMTFieldRenderer;
import com.jsantos.common.util.FieldValues;
import com.jsantos.metadata.MT;
import com.jsantos.orm.dbstatement.DBQuery;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;

public class CustomerFieldRenderer implements IMTFieldRenderer {
	
	@Override
	public String render(Object value, MTField mtField, IDetachedRecord values, Locale locale) {
		if(null==value) return null;
		
		String sql="select * from crm.HCustomer c "
				+ "	join crm.HPersonOrCompany  p on p.personOrCompanyId=c.mainContactPersonOrCompanyId "
				+ "    and getPostingDate()>=p.startDate and p.endDate>getPostingDate() "
				+ "    and getPostingDate()>=c.startDate and c.endDate>getPostingDate() "
				+ "	and c.customerId="+value;
		
		DBQuery dqr= new DBQuery(MT.HPERSONORCOMPANY);
		dqr.setCustomSql(sql);
		
		String retValue=value.toString();
		
		try {
			Vector<FieldValues> result=dqr.getSqlResult();
			FieldValues row=result.get(0);
			if (null!=row) {
				for (MTField description : MT.HPERSONORCOMPANY.getDescriptionFields()) {
					retValue+=" - " + row.get(description);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	@Override
	public MTField forField() {
		
		return MT.CUSTOMERPK.CUSTOMERID;
	}

	

}
