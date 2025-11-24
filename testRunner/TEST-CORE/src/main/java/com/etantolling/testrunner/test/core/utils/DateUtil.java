package com.etantolling.testrunner.test.core.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public final static SimpleDateFormat SIMPLE_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat isoDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	public static Date getCurrentTime(final Connection conn) throws SQLException{
		PreparedStatement pst = null;
		ResultSet rs = null;
		Date currentTime= null;
		try{
			pst = conn.prepareStatement("select getPostingDateTime() from dual");
			rs = pst.executeQuery();
			
			if(rs.next()){
				currentTime = rs.getDate(1);
			}
		}finally{
			if(pst != null)
				pst.close();
			
			if(rs != null)
				rs.close();
		}
		
		return currentTime;
	}
	
	public static String getDateFormat(Date date) {
		if (date != null) {
			return SIMPLE_DATE_FORMAT.format(date);
		}
		else {
			return "";
		}
	}

	public static String getDatetimeFormat(Date date) {
		if (date != null) {
			return SIMPLE_DATETIME_FORMAT.format(date);
		}
		else {
			return "";
		}
	}
	
	public static String getToDateOracle(Date date) {
		return "TO_DATE('" + DateUtil.getDateFormat(date) + "', '" + DateUtil.SIMPLE_DATE_FORMAT.toPattern() + "')";   
	}
	
	public static String getToDatetimeOracle(Date date) {
		return "TO_DATE('" + DateUtil.getDatetimeFormat(date) + "', 'yyyy-MM-dd HH24:MI:SS')";   
	}
	
	
}
