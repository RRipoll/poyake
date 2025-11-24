package com.etantolling.testrunner.test.core.db;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.db.DBUtils;
import com.etantolling.testrunner.test.utils.db.NamedParameterStatement;


public class DataGridQuery {
	String fullSql;
	String selectSection = null;
	String whereSection = null;
	String filterSection = null;
	String groupBySection = null;
	String orderByField = null;
	Integer pageSize = 6;
	public Integer rowCount = null;
	Integer maxResults=null;
	Hashtable<String,Object> initialParameters;
	Hashtable<String,Object> parameters;
	boolean avoidRowCount=false;
	//String dataGridQueryID;
	
	
	public Vector<String> columnNames = new Vector<String>();
	Hashtable<String, Integer> dataTypes = new Hashtable<String, Integer>();
	
	Vector<OrderByItem> orderByVector= new Vector<OrderByItem>() ;
	OrderByItem orderByItemActive;
	
	int numberOfOrderedColumns = 1;
	String uniqueOrderedColumnForSQLServerOptimizer = null;
	Hashtable<String, Object> initialMetaData;
	
	private static final Logger log = LoggerFactory.getLogger(DataGridQuery.class);
	
	public Hashtable<String, Object> getInitialParameters() {
		return initialParameters;
	}

	public void seInitialtParameters(Hashtable<String, Object> initialParameters) {
		this.initialParameters = initialParameters;
		//this.dataGridQueryID=dataGridQueryID;
	
	}
	public void setInitialParameter(String name, Object initialParameter) {
		if(null==initialParameters) initialParameters= new Hashtable<String, Object>();
		initialParameters.put(name, initialParameters);
	}
	
	

	
	public DataGridQuery(Connection conn, String sql) throws SQLException {
		this.fullSql = sql;
		initMetadataFromResultsetMetadata(conn);
		//rowCount = getRowCount(conn);versionDate
	}
	
	
	
	
	
	public DataGridQuery(Connection conn, String sql,Hashtable<String,Object>initialParameters ,Hashtable<String,Object>initialMetaData) throws SQLException {
		this.fullSql = sql;
		this.initialParameters=initialParameters;
		//this.dataGridQueryID=dataGridQueryID;
		if(null!=initialMetaData)this.initialMetaData=initialMetaData;
		initMetadataFromResultsetMetadata(conn);
	}
	
	public Hashtable<String, Object> getInitialMetaData() {
		return initialMetaData;
	}

	public void setInitialMetaData(Hashtable<String, Object> initialMetaData) {
		this.initialMetaData = initialMetaData;
	}

	public DataGridQuery(Connection conn, String selectSection, String whereSection, String groupBySection) throws SQLException {
		this.selectSection = selectSection;
		this.whereSection = whereSection;
		this.groupBySection = groupBySection;
		//this.initialMetaData=initialMetaData;
		initMetadataFromResultsetMetadata(conn);
	}

	String getSql() {
		if (null == whereSection) {
			if (!StringUtils.isEmpty(filterSection))
				return fullSql + " " + filterSection;
			return fullSql;
		} else {
			StringBuilder sb = new StringBuilder(selectSection);
			if (!StringUtils.isEmpty(whereSection))
				sb.append(" ").append(whereSection);
			if (!StringUtils.isEmpty(filterSection))
				sb.append(" ").append(filterSection);
			if (!StringUtils.isEmpty(groupBySection))
				sb.append(" ").append(groupBySection);
			if (null != orderByField)
				sb.append(" order by ").append(orderByField);
			else 
				sb.append(" order by ").append(columnNames.get(0));
			return sb.toString();
		}
	}

	@SuppressWarnings("unchecked")
	private void initMetadataFromResultsetMetadata(Connection conn ) throws SQLException {
		log.debug("metadata query: ");
		Date startTime = new Date();
		
		if(null!=initialMetaData &&  initialMetaData.size()>0){
			log.debug("[" + new Date() + "] getting metadata query from Desktop: ");
			columnNames=(Vector<String>) initialMetaData.get("COLUMNNAMES");
			dataTypes=(Hashtable<String, Integer>) initialMetaData.get("DATATYPES");
		}else {
		String sql = getSql();
		
		sql = "select /*+ FIRST_ROWS(1) */ *  from (" + sql + ") metadataquery where 1=2";
		log.debug("This is the metadata query: " + sql);
		try{
			NamedParameterStatement nps= new NamedParameterStatement(conn,sql);
			if(totalParameters().size()>0){
				nps.setParameters(totalParameters());
			}
			ResultSet rs = nps.executeQuery();
			reportQueryRunTime(startTime, " metadata query " , sql);
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				String columnName = rs.getMetaData().getColumnName(i + 1);
				columnNames.add(columnName);
				dataTypes.put(columnName, rs.getMetaData().getColumnType(i + 1));
			}
			rs.close();
			nps.close();
		}
		catch (SQLException e){
			log.error("Exception [" + e.getMessage() + "] when running sql: " + sql);
			log.error("ERROR STACKTRACE:",e);
			throw e;
		}
		if(null==initialMetaData || initialMetaData.size()==0){
			if(null==initialMetaData)initialMetaData= new Hashtable<String, Object>();
			initialMetaData.put("COLUMNNAMES", columnNames);
			initialMetaData.put("DATATYPES", dataTypes);
		}
		}
	}

	public Integer getRowCount(Connection conn) throws SQLException {
		if(avoidRowCount)return null;
		Date startTime = new Date();
		String sql = getSql();
		//sql=sql.replaceAll(":versionDate", EnvironmentHelper.getVersionDate());
		sql = "select count(*) from (" + getSql() + ") agg1";
		log.debug("============getRowCount================");
		try{
			NamedParameterStatement nps= new NamedParameterStatement(conn,sql);
			
			if(totalParameters().size()>0){
				nps.setParameters(totalParameters());
			}
			ResultSet rs = nps.executeQuery();
		
			reportQueryRunTime(startTime, " get row count " , sql);

			rs.next();
			int retValue = rs.getInt(1);
			rs.close();
			nps.close();
			rowCount=retValue;
			/*
			if(maxResults!=null){
				if(maxResults<retValue)
					throw new WrongValueException(null,"Search returns more than 1000 results, Please refine your search ");
			}
			*/
			
			return retValue;
		}
		catch (SQLException e){
			log.error("Problem running sql:");
			log.error(sql);
			throw e;
		}
	}

	public Vector<LinkedHashMap<String, Object>> getPage(Connection conn, int pageNumber) throws SQLException {
		Date startTime = new Date();
		log.debug("====================== getting page...");
		Vector<LinkedHashMap<String, Object>> retValue = new Vector<LinkedHashMap<String, Object>>();
		int firstRecord = pageNumber * pageSize;
		String sql; 
		String orderby=buildOrderBySection(conn);
		if(DBUtils.isOracle(conn)) sql = "select * from (" + getSql() + ") pc1 " + orderby + " offset " + firstRecord + " rows fetch next " + pageSize + " rows only ";
		if(DBUtils.isMSSqlServer(conn)) sql = "SELECT  * FROM    (select row_number() over (" + orderby + ") as rowNum, * from (" + getSql() + ")pc1) pc2 WHERE   -RowNum < -" + firstRecord + "    AND -RowNum >= -" + (firstRecord + pageSize) + " ORDER BY RowNum";
	    else sql = "select * from (" + getSql() + ") pc1 " + orderby + " offset " + firstRecord + " rows fetch next " + pageSize + " rows only ";
		
		
		try{
			NamedParameterStatement nps= new NamedParameterStatement(conn,sql);
			if(totalParameters().size()>0){
				nps.setParameters(totalParameters());
			}
			ResultSet rs = nps.executeQuery();

			reportQueryRunTime(startTime, " getting page ", sql);
				
			System.out.println(totalParameters().toString());
			
			for (int i = 0; i < pageSize; i++) {
				if (rs.next()) {
					LinkedHashMap<String, Object> row = new LinkedHashMap<String, Object>();
	
					for (String columnName : columnNames){
						
						
						
						/*
						int sqlType =rs.getMetaData().getColumnType( getColumnNumber(columnName)); 
						
						System.out.println(rs.getMetaData().getColumnType( getColumnNumber(columnName)));
						System.out.println(rs.getMetaData().getColumnTypeName( getColumnNumber(columnName)));
						
						
						//log.info(columnName + "[" + rs.getMetaData().getColumnName(getColumnNumber(columnName)) + "]: Sql data type: " + sqlType + " type name: " + rs.getMetaData().getColumnTypeName(getColumnNumber(columnName)));
						//log.info(columnName + "[" + rs.getMetaData().getPrecision(getColumnNumber(columnName)) + "]: precision: " );
						//log.info(columnName + "[" + rs.getMetaData().getScale(getColumnNumber(columnName)) + "]: scale: " );
						
						
						
						if (isDate(rs, getColumnNumber(columnName))){
							row.put(columnName, rs.getDate(columnName));
						}
						else if (Types.VARCHAR == sqlType || Types.CHAR == sqlType || Types.LONGNVARCHAR == sqlType || Types.LONGVARCHAR == sqlType || Types.NCHAR == sqlType || Types.NVARCHAR == sqlType ){ // we convert CLOBS to Strings here by using getString on VARCHAR just in case it is varchar(max). We can't pass the streaming object after the recordset is closed
							row.put(columnName, rs.getString(columnName));
						}
						else if(Types.INTEGER == sqlType ||Types.BIGINT == sqlType || (Types.NUMERIC == sqlType  && 0>= rs.getMetaData().getScale(getColumnNumber(columnName)))){
							if(null==rs.getString(columnName)){
								row.put(columnName, (Integer) null);
							}else row.put(columnName, new Integer(rs.getInt(columnName)));
						}
						else if(93 == sqlType && 0== rs.getMetaData().getScale(getColumnNumber(columnName))){
							row.put(columnName, rs.getDate(columnName));
							
						}else{	
							Object theValue = rs.getObject(columnName);
							
							if (theValue instanceof Clob)
								theValue =  new String( DBUtils.CLOBToString((Clob) theValue));
							row.put(columnName, theValue);
						}
						
					}
					*/
						int sqlType =rs.getMetaData().getColumnType( getColumnNumber(columnName)); 
						
						//System.out.println(columnName+"  "+sqlType);
						/*
						if (isTimeStamp(rs, getColumnNumber(columnName))){
							row.put(columnName, rs.getTimestamp(columnName));
						}
						
						else if (isDate(rs, getColumnNumber(columnName))){
							row.put(columnName, rs.getDate(columnName));
						}
						//else if (Types.VARCHAR == sqlType){ // we convert CLOBS to Strings here by using getString on VARCHAR just in case it is varchar(max). We can't pass the streaming object after the recordset is closed
							//row.put(columnName, rs.getString(columnName));
						//}
						else{
						*/
							Object theValue = rs.getObject(columnName);
							
							// we can't afford having Clobs running around
							//if (theValue instanceof ClobImpl)
								//theValue =  DBHelper.clobToString((Clob) theValue);
							
							row.put(columnName, theValue);
						//}
					}
					
					retValue.add(row);
				}
			}
			rs.close();
			nps.close();
		}
		catch (SQLException e){
			log.error("Exception [" + e.getMessage() + "] when running sql: " + sql);
			log.error("ERROR STACKTRACE:",e);
			throw e;
		}
		
			
		return retValue;
	}

	
	public boolean isTimeStamp(ResultSet rs, int columnNumber){
		boolean isDate = false;
		try{
			//System.out.print(rs.getMetaData().getColumnType(columnNumber));
			//System.out.print(rs.getMetaData().getColumnDisplaySize(columnNumber));
			if (rs.getMetaData().getColumnType(columnNumber) == 12 
					//&& rs.getMetaData().getColumnDisplaySize(columnNumber) == 10
					){
				Date date=rs.getTimestamp(columnNumber);
				if(date.getMinutes()!=0)
					isDate = true;
			}
		}
		catch (Exception e){
		}
		return isDate;
	}
	
	
	public Vector<LinkedHashMap<String, Object>> getTotalResults(Connection conn) throws SQLException {
		Date startTime = new Date();
		Vector<LinkedHashMap<String, Object>> retValue = new Vector<LinkedHashMap<String, Object>>();
		String sql = "select * from (" + getSql() + ") pc1 " + buildOrderBySection(conn);
		
		log.debug("========================== get total results: ");
		try{
			NamedParameterStatement nps= new NamedParameterStatement(conn,sql);
			if(totalParameters().size()>0){
				nps.setParameters(totalParameters());
			}
			ResultSet rs = nps.executeQuery();

			reportQueryRunTime(startTime, " get total results ", sql);
			
				while (rs.next()) {
					LinkedHashMap<String, Object> row = new LinkedHashMap<String, Object>();
	
					for (String columnName : columnNames){
						
						
						int sqlType =rs.getMetaData().getColumnType( getColumnNumber(columnName)); 
						
						if (isDate(rs, getColumnNumber(columnName))){
							row.put(columnName, rs.getDate(columnName));
						}
						else if (Types.VARCHAR == sqlType || Types.CHAR == sqlType || Types.LONGNVARCHAR == sqlType || Types.LONGVARCHAR == sqlType || Types.NCHAR == sqlType || Types.NVARCHAR == sqlType ){ // we convert CLOBS to Strings here by using getString on VARCHAR just in case it is varchar(max). We can't pass the streaming object after the recordset is closed
							row.put(columnName, rs.getString(columnName));
						}
						else if(Types.INTEGER == sqlType || (Types.NUMERIC == sqlType  && 0>= rs.getMetaData().getScale(getColumnNumber(columnName))))
							row.put(columnName, new Integer(rs.getInt(columnName)));
						
						else if(93 == sqlType && 0== rs.getMetaData().getScale(getColumnNumber(columnName))){
							row.put(columnName, rs.getDate(columnName));
							
						}else{	
							Object theValue = rs.getObject(columnName);
							
							if (theValue instanceof Clob)
								theValue =  new String( DBUtils.CLOBToString((Clob) theValue));
							row.put(columnName, theValue);
						}
					}	
					retValue.add(row);
					
				}
			rs.close();
			nps.close();
		}
		catch (SQLException e){
			log.error("Exception [" + e.getMessage() + "] when running sql: " + sql);
			log.error("ERROR STACKTRACE:",e);
			throw e;
		}

		return retValue;
	}
	
	
	String buildOrderBySection(Connection conn) throws SQLException{
		if (null==orderByItemActive) return " ORDER BY " + columnNames.get(0) + " ";
		String orderBySection = " ORDER BY ";
		
		
		for (OrderByItem orderByItem: orderByVector){
			if (0 < orderByVector.indexOf(orderByItem)) orderBySection +=",";
			orderBySection += orderByItem.getOrder();
		}
		
		orderBySection += orderByItemActive.getOrder();

		if (DBUtils.isMSSqlServer(conn) && null != uniqueOrderedColumnForSQLServerOptimizer)
			if (null == getOrderByItem(uniqueOrderedColumnForSQLServerOptimizer))
				orderBySection += "," + uniqueOrderedColumnForSQLServerOptimizer + " ";
		
		return orderBySection;
	
	}
	
	public int getColumnNumber(String columnName){
		return 1 + columnNames.indexOf(columnName);		
	}
	
	public boolean isDate(ResultSet rs, int columnNumber){
		boolean isDate = false;
		try{
			if (rs.getMetaData().getColumnType(columnNumber) == 12 
					){
				rs.getDate(columnNumber);
				isDate = true;
			}
		}
		catch (Exception e){
		}
		return isDate;
	}
	
	public String getFullSql() {
		return fullSql;
	}

	public String getSelectSection() {
		return selectSection;
	}

	public String getWhereSection() {
		return whereSection;
	}

	public String getGroupBySection() {
		return groupBySection;
	}

	public String getOrderByField() {
		if (null!=orderByItemActive) return orderByItemActive.fieldName;
		else return null;
	}
	
	public boolean isAsc(String fieldName){
		OrderByItem orderByItem = getOrderByItem(fieldName);
		if (null != orderByItem) 
			return orderByItem.asc;
		return true;
	}
	
	public boolean isFirstOrderedColumnAsc(){
		if (0<orderByVector.size()) 
			return orderByVector.get(0).asc;
		return true;
	}
/*
	public void setAsc(String fieldName, boolean asc){
		OrderByItem orderByItem = getOrderByItem(fieldName);
		if (null != orderByItem) 
			orderByItem.asc = asc;
	}
*/	
	
	public void setOrderByField(String orderByField, boolean asc) {
			if(null!=orderByVector){
				for(OrderByItem item : orderByVector) {
					if(item.fieldName.toUpperCase().equals(orderByField.toUpperCase())){
						orderByItemActive=item;
				  		item.asc=asc;
				  		return;
				  	}
				} 	
			}
			orderByItemActive=new OrderByItem(orderByField, asc);
		}
		//orderByVector.clear();
		//addOrderByField(orderByField, asc);
	/*
	public void addOrderByField(String orderByField, boolean asc) {
		orderByVector.add(new OrderByItem(orderByField,asc));
	}
	
	public void setOrderByField(String orderByField,String stringAsc,String stringDesc, boolean asc) {
		orderByVector.clear();
		addOrderByField(orderByField,stringAsc,stringDesc, asc);
	}

	public void addOrderByField(String orderByField,String stringAsc,String stringDesc, boolean asc) {
		orderByVector.add(new OrderByItem(orderByField, stringAsc, stringDesc,asc));getRowCount
	}
	*/
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Vector<String> getColumnNames() {
		return columnNames;
	}

	
	public void setFilterSection(String filterSection,Hashtable<String,Object>parameters,boolean avoidRowCount) throws SQLException {
		this.parameters=parameters;
		this.avoidRowCount=avoidRowCount;
		if (!filterSection.equals(this.filterSection)) {
			Connection conn =null;
			try{
				conn= MainDb.getConnection();
				this.filterSection = filterSection;
				rowCount = getRowCount(conn);
			} finally {
				conn.close();
			}
		}
	}
	public Integer getRowCount() throws SQLException {
		if (null == rowCount){
			Connection conn = MainDb.getConnection();
			try{
				rowCount = getRowCount(conn);
			} finally {
				conn.close();
			}
		}
		return rowCount;
	}

	public Integer forceRowCount() throws SQLException {
			Connection conn = MainDb.getConnection();
			try{
				rowCount = getRowCount(conn);
			} finally {
				conn.close();
			}
		return rowCount;
	}
	
	public OrderByItem getOrderByItem(String fieldName){
		if(null!=orderByItemActive && orderByItemActive.fieldName.equals(fieldName))
			return orderByItemActive;
		if(null!=orderByVector){
			for (OrderByItem orderByItem:orderByVector){
				if (orderByItem.fieldName.equals(fieldName))
					return orderByItem;
			}
		}
		return null;
	}

	public String getUniqueOrderedColumnForSQLServerOptimizer() {
		return uniqueOrderedColumnForSQLServerOptimizer;
	}

	public void setUniqueOrderedColumnForSQLServerOptimizer(String uniqueOrderedColumnForSQLServerOptimizer) {
		this.uniqueOrderedColumnForSQLServerOptimizer = uniqueOrderedColumnForSQLServerOptimizer;
	}

	public Integer getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}
	public void setFullSql(String sqlModified) {
		fullSql=sqlModified;// TODO Auto-generated method stub
		
	}
	
	public Hashtable<String,Object> totalParameters(){
		
		Hashtable<String,Object> tmp= new 	Hashtable<String,Object>();
		if(null!=initialParameters)tmp.putAll(initialParameters);
		

		if(null!=parameters)tmp.putAll(parameters);
		
			tmp.put("versionDate", EnvironmentHelper.getVersionTimeStamp());
		
		return tmp;
	}
	
	public static String getMetaName(String dataTableNameId,String sql){
		if(null==dataTableNameId)return null;
		String retValue="";
		if(null!=dataTableNameId)retValue+=dataTableNameId;
		retValue+=sql.toLowerCase();
		if(retValue.contains("where"))
			retValue=retValue.substring(0,retValue.indexOf("where"));
		retValue=retValue.replaceAll("[\\d]", "");
		retValue=retValue.replaceAll("'(.+)'", "");
		return retValue;
	}

	public void setOrderByVector(Vector<OrderByItem> orderByVector) {
		this.orderByVector=orderByVector;
		
	}

	public OrderByItem getOrderByItemActive() {
		return orderByItemActive;
	}

	public void setOrderByItemActive(OrderByItem orderByItemActive) {
		this.orderByItemActive = orderByItemActive;
	}
	
	public void reportQueryRunTime(Date startTime, String message, String sql){
		
		long queryRunningTime = new Date().getTime() - startTime.getTime(); 

		if (5000 < queryRunningTime)
			log.warn("DATAGRIDQUERY_LONG_QUERY: " + queryRunningTime + " ms. " + message + " sql: " + sql);
		else
			log.debug("DATAGRIDQUERY_QUERY_TIMING: " + queryRunningTime + " ms. " + message + " sql: " + sql);
		
	}}
