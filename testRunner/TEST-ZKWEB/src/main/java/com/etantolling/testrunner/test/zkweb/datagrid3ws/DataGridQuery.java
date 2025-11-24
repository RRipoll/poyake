package com.etantolling.testrunner.test.zkweb.datagrid3ws;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.etantolling.testrunner.test.utils.webservice.HttpHeader;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class DataGridQuery {
	
	private static final Logger logger = LoggerFactory.getLogger(DataGridQuery.class);
	
	String wsURL;
	String wsHeader; 
	String wsRequest;
	String wsHttpMethod;
	Class<?> refClass;
	List<Object> data;
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
	//String dataGridQueryID;
	
	
	public Vector<String> columnNames = new Vector<String>();
	Hashtable<String, Integer> dataTypes = new Hashtable<String, Integer>();
	
	Vector<OrderByItem> orderByVector = new Vector<OrderByItem>();
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
	
	
	public DataGridQuery(String wsURL, String wsHeader, String wsRequest, String wsHttpMethod, Class<?> refClass) throws Exception {
		this.wsURL = wsURL;
		this.wsHeader = wsHeader;
		this.wsRequest = wsRequest;
		this.wsHttpMethod = wsHttpMethod;
		this.refClass = refClass;
		initMetadata();
	}
	
	public DataGridQuery(String wsURL, String wsHeader, String wsRequest, String wsHttpMethod, Class<?> refClass, Hashtable<String,Object>initialParameters, Hashtable<String,Object>initialMetaData) throws Exception {
		this.wsURL = wsURL;
		this.wsHeader = wsHeader;
		this.wsRequest = wsRequest;
		this.wsHttpMethod = wsHttpMethod;
		this.refClass = refClass;
		this.initialParameters=initialParameters;
		//this.dataGridQueryID=dataGridQueryID;
		if(null!=initialMetaData)this.initialMetaData=initialMetaData;
		initMetadata();
	}
	
	public DataGridQuery(String wsURL, String wsHeader, String wsRequest, String wsHttpMethod, Class<?> refClass, String selectSection, String whereSection, String groupBySection) throws Exception {
		this.wsURL = wsURL;
		this.wsHeader = wsHeader;
		this.wsRequest = wsRequest;
		this.wsHttpMethod = wsHttpMethod;
		this.refClass = refClass;
		this.selectSection = selectSection;
		this.whereSection = whereSection;
		this.groupBySection = groupBySection;
		initMetadata();
	}
	
	public Hashtable<String, Object> getInitialMetaData() {
		return initialMetaData;
	}

	public void setInitialMetaData(Hashtable<String, Object> initialMetaData) {
		this.initialMetaData = initialMetaData;
	}


	String getSql() {
		if (null == whereSection) {
			if (!StringUtils.isEmpty(filterSection))
				return wsURL + " " + filterSection;
			return wsURL;
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

	private void initMetadata() throws Exception {

		data = (List<Object>) callWS();
		/*
		Object[] dataSorted = data.stream().sorted((f1, f2) -> f1.).toArray();
		data = Arrays.asList(dataSorted);
		*/
		rowCount = data.size();
		
		if(refClass != null) {
			//Field[] fields = refClass.getDeclaredFields();
			List<Field> fields = getAllFields(new LinkedList<Field>(), refClass);
			for(Field f : fields) {
				columnNames.add(f.getName());
				dataTypes.put(f.getName(), 1);
			}
			if(null==initialMetaData || initialMetaData.size()==0){
				if(null==initialMetaData)initialMetaData= new Hashtable<String, Object>();
				initialMetaData.put("COLUMNNAMES", columnNames);
				initialMetaData.put("DATATYPES", dataTypes);
			}
		}
		
		//Collections.sort(data, new BeanComparator<Object>(columnNames.get(0)));

	}
	
	private Object callWS() throws JsonParseException, JsonMappingException, IOException {
		String urlRequest = wsURL;
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		if (wsHttpMethod.equals(HttpMethod.GET.name())) {
			logger.info("*** Calling GET rest web service");
			 	    //for localhost testing only
			
			/*
			javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
				    new javax.net.ssl.HostnameVerifier(){

				            @Override
				        public boolean verify(String hostname,
				                javax.net.ssl.SSLSession sslSession) {
				            
				                return true;
				            
				        }
				    });
			*/
			
			response = restTemplate.getForEntity(urlRequest, String.class);
		} else {
			logger.info("*** Calling {} rest web service", wsHttpMethod);
			
			
			/*
			javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
				    new javax.net.ssl.HostnameVerifier(){

				            @Override
				        public boolean verify(String hostname,
				                javax.net.ssl.SSLSession sslSession) {
				            
				                return true;
				            
				        }
				    });
			 */
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);
			if (wsHeader != null) {
				ObjectMapper objectMapper = new ObjectMapper();
				HttpHeader httpHeader = objectMapper.readValue(wsHeader, HttpHeader.class);
				requestHeaders.set("inputSourceCode", httpHeader.getInputSourceCode());
				requestHeaders.set("inputUserId", httpHeader.getInputUserId());
			}
			HttpEntity<String> entity = new HttpEntity<String>(wsRequest, requestHeaders);
			response = new RestTemplate().exchange(urlRequest, HttpMethod.valueOf(wsHttpMethod), entity, String.class);
		}

		logger.info("*** -------------------------- SUMMARY -------------------------------------- ***");
		logger.info("*** Request = {}", urlRequest);
		logger.info("*** Response.getStatusCode = {}", response.getStatusCode().toString());
		ObjectMapper mapper = new ObjectMapper();
		Object jsonResponse = null;
		try {
			jsonResponse = mapper.readValue(response.getBody().toString(), mapper.getTypeFactory().constructCollectionType(List.class, refClass));
		} catch (Exception ex) {
			// is it not a JSON format?
			logger.info("It is not JSON format");
			logger.info("*** Response.body = {}", response.getBody());
		}
		logger.info("*** ------------------------------------------------------------------------- ***");
		
		return jsonResponse;
	}

	public Vector<LinkedHashMap<String, Object>> getPage(int pageNumber) throws Exception {
		log.info("[" + new Date() + "] ====================== getting page...");
		Vector<LinkedHashMap<String, Object>> retValue = new Vector<LinkedHashMap<String, Object>>();
		int firstRecord = pageNumber * pageSize;
		
		List<Object> filtered = new ArrayList<Object>();
		if(parameters != null && !parameters.isEmpty()) {
			for(Object ob : data) {
				List<Boolean> match = new ArrayList<Boolean>();
				for(String field : parameters.keySet()) {
					Method[] methods = refClass.getMethods();
					Object value = null;
					for(Method m : methods) {
						if(m.getName().toUpperCase().equals("GET" + field.toUpperCase())) {
							value = m.invoke(ob, null);
							break;
						}
					}
					
					Object filterValue = parameters.get(field);
					if(field.toUpperCase().endsWith("ID"))
						match.add(new Boolean(value != null && value.toString().toUpperCase().equals(filterValue.toString().toUpperCase())));
					else
						match.add(new Boolean(value != null && value.toString().toUpperCase().contains(filterValue.toString().toUpperCase())));
					
				}
				if(match.stream().allMatch(x -> x.booleanValue() == true))
					filtered.add(ob);
			}
		}
		else
			filtered = data;

		rowCount = filtered.size();
		
		log.info("[" + new Date() + "]============== Got page results...");
		for (int i = 0; i < pageSize; i++) {
			LinkedHashMap<String, Object> row = new LinkedHashMap<String, Object>();
			for (String columnName : columnNames) {
				try {
					//Object obj = data.get(firstRecord + i);	
					Object obj = filtered.get(firstRecord + i);
					Method[] methods = refClass.getMethods();
					Object value = null;
					for(Method m : methods) {
						if(m.getName().toUpperCase().equals("GET" + columnName.toUpperCase())) {
							value = m.invoke(obj, null);
							if(value instanceof Date) {
								DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm");
								formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
								value = formatter.format(value);
							}
							break;
						}
					}
					row.put(columnName, value);
					
				}
				catch(IndexOutOfBoundsException ignore) {
					;
				}
				
			}

			if(!row.keySet().isEmpty())
				retValue.add(row);
		}
			
		return retValue;
	}

	
	private List<Field> getAllFields(List<Field> fields, Class<?> type) {
		fields.addAll(Arrays.asList(type.getDeclaredFields()));

	    if (type.getSuperclass() != null) {
	        fields = getAllFields(fields, type.getSuperclass());
	    }

	    return fields;
	}


	
	public Vector<LinkedHashMap<String, Object>> getTotalResults() throws Exception {
		Vector<LinkedHashMap<String, Object>> retValue = new Vector<LinkedHashMap<String, Object>>();
		for (int i = 0; i < data.size(); i++) {
			LinkedHashMap<String, Object> row = new LinkedHashMap<String, Object>();
			for (String columnName : columnNames) {
				try {
					//Object obj = data.get(firstRecord + i);	
					Object obj = data.get(i);
					Method[] methods = refClass.getMethods();
					Object value = null;
					for(Method m : methods) {
						if(m.getName().toUpperCase().equals("GET" + columnName.toUpperCase())) {
							value = m.invoke(obj, null);
							break;
						}
					}
					row.put(columnName, value);
					
				}
				catch(IndexOutOfBoundsException ignore) {
					;
				}
				
			}

			if(!row.keySet().isEmpty())
				retValue.add(row);
		}
		
		return retValue;
	}
	
	
	String buildOrderBySection(){
		if (0 == orderByVector.size()) return " ORDER BY " + columnNames.get(0) + " ";
		String orderBySection = " ORDER BY ";
		for (OrderByItem orderByItem: orderByVector){
			if (0 < orderByVector.indexOf(orderByItem)) orderBySection +=",";
			orderBySection += orderByItem.fieldName + " " + (orderByItem.asc ? " asc ": " desc ");
		}
		if (null != uniqueOrderedColumnForSQLServerOptimizer)
			if (null == getOrderByItem(uniqueOrderedColumnForSQLServerOptimizer))
				orderBySection += "," + uniqueOrderedColumnForSQLServerOptimizer + " ";
		return orderBySection;
	}
	
	public int getColumnNumber(String columnName){
		return 1 + columnNames.indexOf(columnName);		
	}
	
	public String getWsURL() {
		return wsURL;
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
		if (0<orderByVector.size()) return orderByVector.get(0).fieldName;
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

	public void setAsc(String fieldName, boolean asc){
		OrderByItem orderByItem = getOrderByItem(fieldName);
		if (null != orderByItem) 
			orderByItem.asc = asc;
	}
	
	
	public void setOrderByField(String orderByField, boolean asc) {
		orderByVector.clear();
		if(asc)
			Collections.sort(data, new BeanComparator<Object>(orderByField));
		else
			Collections.sort(data, new BeanComparator<Object>(orderByField, Collections.reverseOrder()));
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Vector<String> getColumnNames() {
		return columnNames;
	}

	
	public void setFilterSection(String filterSection, Hashtable<String,Object>parameters) {
		this.parameters=parameters;
		if (!filterSection.equals(this.filterSection)) {
			this.filterSection = filterSection;
		}
	}
	public Integer getRowCount() {
		return rowCount;
	}

	class OrderByItem{
		String fieldName = null;
		Boolean asc = true;
		
		OrderByItem(String fieldName, Boolean asc){
			this.fieldName = fieldName;
			this.asc = asc;
		}
	}
	
	public OrderByItem getOrderByItem(String fieldName){
		for (OrderByItem orderByItem:orderByVector){
			if (orderByItem.fieldName.equals(fieldName))
				return orderByItem;
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
	public void setWsURL(String wsURL) {
		this.wsURL=wsURL;
		
	}
	
	public Hashtable<String,Object> totalParameters(){
		
		Hashtable<String,Object> tmp= new 	Hashtable<String,Object>();
		if(null!=initialParameters)tmp.putAll(initialParameters);
		if(null!=parameters)tmp.putAll(parameters);
		
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
}
