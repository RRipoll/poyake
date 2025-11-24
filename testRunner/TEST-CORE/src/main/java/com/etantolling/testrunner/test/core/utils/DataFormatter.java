package com.etantolling.testrunner.test.core.utils;

import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.SubTypes;
import com.etantolling.testrunner.test.utils.db.DBUtils;


public class DataFormatter {
	
	//private static final Logger log = LoggerFactory.getLogger(DataFormatter.class);
	
	public static SimpleDateFormat dFormatDateTime = new SimpleDateFormat("MM-dd-yyyy HH:mm");
	public static SimpleDateFormat dFormatDate = new SimpleDateFormat("MM-dd-yyyy");
	public static SimpleDateFormat dFormatTime = new SimpleDateFormat("H:mm:ss:SSS");
	public static SimpleDateFormat DFormatTimeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
	public final static SimpleDateFormat isoDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	
	public static String formatAsString(MTField mtField, Object value) throws SQLException{
		if (null == value) 
			return null;
		if (SubTypes.ENUM_MULTI.equals(mtField.getSubType()))
			return MultiEnumHelper.getCommaSeparatedDescriptionForValue(mtField, (Integer)value);
		return value.toString();
	}

	public static String formatAsHtml(MTField mtField, Object value) throws SQLException{
		if (null == value) 
			return null;
		if (SubTypes.ENUM_MULTI.equals(mtField.getSubType()))
			return MultiEnumHelper.getCommaSeparatedDescriptionForValue(mtField, (Integer)value);
		return value.toString();//.replace("\n", "<br/>");
	}
	
	
	static public String formatValue(Object theValue, String dataType) throws SQLException {

		if (null != theValue) {
			if(null!=dataType){
				 if(dataType.equals("date")  || dataType.equals("time") || dataType.equals("datetime") ){
					return formatDate(theValue, dataType);
				}else if(dataType.equals("currency") && (theValue instanceof BigDecimal || theValue instanceof Integer  || theValue instanceof Long )){
                    return NumberFormat.getCurrencyInstance(Locale.US).format(theValue);
				}else if(dataType.equals("string"))return theValue.toString();
			
			}else if (theValue instanceof BigDecimal) { // by default we only display two decimal digits
				BigDecimal bigDecimal = ((BigDecimal) theValue).setScale(2, BigDecimal.ROUND_DOWN);
				return bigDecimal.toString();
			} else if (theValue instanceof Clob){
				return  DBUtils.CLOBToString((Clob) theValue);
			}else if (theValue instanceof Date) {
				if (theValue instanceof Timestamp){
					return dFormatDateTime.format(theValue);
				}
				else{
					return dFormatDate.format(theValue);
				}
			}else if (theValue instanceof Time) {
				Date date= new Date(((Time)theValue).getTime());
				return dFormatDateTime.format(date);
			}
			else{
				return theValue.toString();
			}
		}
		return null;
	}
	
	
	
	
	
	static public String formatDate(Object theValue, Object dataType){
		
		Date date = null;
		
		  if (theValue instanceof Date) {
				date=(Date) theValue;
		 }else if (theValue instanceof Time) {
				date= new Date(((Time)theValue).getTime());
		 }else if (theValue instanceof java.sql.Date) {
				date= new Date(((java.sql.Date)theValue).getTime());
		 }
	 	
		 if(dataType.equals("date") && null!=date){
			  return dFormatDate.format(date);
		 }else if(dataType.equals("time") && null!=date){
			  return dFormatTime.format(date);
		 }else if(dataType.equals("datetime") && null!=date){
			  return dFormatDateTime.format(date);
		 }
		return theValue.toString();
	}
	
	static public String formatDate(Object theValue){
	
		if(null==theValue)return null;
		if (theValue instanceof Date) {		
			 return isoDateTime.format(theValue).toString();
		 }
		return theValue.toString(); 
	}
	}
