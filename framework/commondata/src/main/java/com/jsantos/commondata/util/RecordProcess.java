package com.jsantos.commondata.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.DTOFactory;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.dbstatement.Sequence;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTHelper;
import com.jsantos.orm.mt.MTTable;

public class RecordProcess {

	
	public static MapValues<Object> process( File fileURL) throws Exception {
		Integer inserted=0;
		Integer updated=0;
		Integer deleted=0;
		MapValues<Object> retValue= new MapValues<Object>();
		
			{  
			try{  
				JSONArray jsonarray = new JSONArray(FileUtils.readFileToString(fileURL));
				for (int i = 0; i < jsonarray.length(); i++) {
				    JSONObject jsonobject = jsonarray.getJSONObject(i);
				    String tableName = jsonobject.getString("tableName");
				    Integer recorderTypeId = jsonobject.getInt("recorderTypeId");
				    String data = jsonobject.getString("data");
				    
				    ObjectMapper mapper = new ObjectMapper();
				    MapValues<Object> mapValues=mapper.readValue(data, MapValues.class);
				    MTMapValues<Object> mtMapValues= MTHelper.getValues(mapValues, tableName);
				    IDetachedRecord dto=DTOFactory.get(MTBase.getTable(tableName));
				    dto.setValues(mtMapValues);
				    
				    if(recorderTypeId==1) {
				    	MTTable table=dto.getTable();
				    	if(null!=dto.getPk() && null!=table.getPrimaryKey() ) {
				    		for (MTField field : table.getPrimaryKeys()) {
				    			if(null==field.getForeignKey() && field.getDataType().equals(MTDataTypes.INT)   && (null!=field.getSequence() || !field.getSequence().equals("null")))
				    				while (((Integer)Sequence.nextForTable(field.getTable()))<Integer.parseInt(dto.getPk().toString()));
							}
				    	}
				    	dto.insert();
				    	inserted++;
				    }
				    else if(recorderTypeId==2) {
				    	dto.update();
				    	updated++;
				    }
				    else if(recorderTypeId==3) {
				    	dto.delete();
				    	deleted++;
				    }
				}
				retValue.put("inserted",inserted );
				retValue.put("updated", updated);
				retValue.put("deleted",deleted );
				retValue.put("total",deleted+updated+inserted );
				}  
				catch(IOException e)  
					{  
					e.printStackTrace();  
					}  
				}
			return retValue;  
			}  
	
	
}
