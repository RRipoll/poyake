package com.jsantos.commondata.util;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

//@Slf4j

public class DataFormatter {

	public static final DateTimeFormatter usDateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	public static final DateTimeFormatter usDateTimeMinuteFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
	public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	public static final DateTimeFormatter yyyyMMddHHmmssFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	public static final DateTimeFormatter iso8601Formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static final SimpleDateFormat dFormatDateTime = new SimpleDateFormat("MM-dd-yyyy HH:mm");
	public static final SimpleDateFormat dFormatDate = new SimpleDateFormat("MM-dd-yyyy");
	public static final SimpleDateFormat dFormatTime = new SimpleDateFormat("H:mm:ss:SSS");
	public static final SimpleDateFormat DFormatTimeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
	public static final SimpleDateFormat isoDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	public static final SimpleDateFormat dFormatIso8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	public static final SimpleDateFormat dFormatIso86011 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	public static final SimpleDateFormat dFormatIso8601date = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat dFormatIso8601dateTime = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
	public static final SimpleDateFormat dFormatIso8601dateTimes = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	public final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public final static SimpleDateFormat SIMPLE_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String formatAsString(MTField mtField, Object value) {
		if (null == value)
			return null;
		return value.toString();
	}

	public static String formatAsHtml(MTField mtField, Object value) {
		if (null == value)
			return null;
		return value.toString();
	}

	static public String formatValue(Object theValue, MTDataType mtDataType) throws SQLException {

		if (null != theValue) {
			if (null != mtDataType) {
				if (mtDataType.equals(MTDataTypes.DATE) || mtDataType.equals(MTDataTypes.TIME)
						|| mtDataType.equals(MTDataTypes.DATETIME)) {
					return formatDate(theValue, mtDataType);
				} else if (mtDataType.equals("currency") && (theValue instanceof BigDecimal
						|| theValue instanceof Integer || theValue instanceof Long)) {
					return NumberFormat.getCurrencyInstance(Locale.US).format(theValue);
				} else if (mtDataType.equals("string"))
					return theValue.toString();

			} else if (theValue instanceof BigDecimal) { // by default we only display two decimal digits
				BigDecimal bigDecimal = ((BigDecimal) theValue).setScale(2, BigDecimal.ROUND_DOWN);
				return bigDecimal.toString();
			} else if (theValue instanceof Date) {
				if (theValue instanceof Timestamp) {
					return dFormatDateTime.format(theValue);
				} else {
					return dFormatDate.format(theValue);
				}
			} else if (theValue instanceof Time) {
				Date date = new Date(((Time) theValue).getTime());
				return dFormatDateTime.format(date);
			} else {
				return theValue.toString();
			}
		}
		return null;
	}

	static public String formatDate(Object theValue, Object dataType) {

		Date date = null;

		if (theValue instanceof Date) {
			date = (Date) theValue;
		} else if (theValue instanceof Time) {
			date = new Date(((Time) theValue).getTime());
		} else if (theValue instanceof java.sql.Date) {
			date = new Date(((java.sql.Date) theValue).getTime());
		}

		if (dataType.equals("date") && null != date) {
			return dFormatDate.format(date);
		} else if (dataType.equals("time") && null != date) {
			return dFormatTime.format(date);
		} else if (dataType.equals("datetime") && null != date) {
			return dFormatDateTime.format(date);
		}
		return theValue.toString();
	}

	static public String formatDate(Object theValue) {

		if (null == theValue)
			return null;
		if (theValue instanceof Date) {
			return isoDateTime.format(theValue).toString();
		}
		return theValue.toString();
	}
	
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
		return "TO_DATE('" + getDateFormat(date) + "', '" + SIMPLE_DATE_FORMAT.toPattern() + "')";   
	}
	
	public static String getToDatetimeOracle(Date date) {
		return "TO_DATE('" + getDatetimeFormat(date) + "', 'yyyy-MM-dd HH24:MI:SS')";   
	}

	public static LocalDateTime toLocalDateTime(Date date) {
		
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	public static LocalDateTime toLocalDateTime(String date) {
		Instant timestampDate = Instant.parse(date);
		return timestampDate.atZone(ZoneId.systemDefault()).toLocalDateTime();
	}	
	
	
	
}
