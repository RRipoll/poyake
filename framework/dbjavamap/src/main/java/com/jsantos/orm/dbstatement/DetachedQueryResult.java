package com.jsantos.orm.dbstatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.DTOFactory;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.DBUtil.DbPageMSSUtil;
import com.jsantos.orm.DBUtil.OrderByItem;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;
//@Slf4j
/**
 * @author raul ripoll
 * @author javier santos
 */

public class DetachedQueryResult extends DBQuery implements IDetachedResult{
    private Integer pageSize = 15;
    private Integer rowCount = null;
    private Integer maxResults = null;
    private MapValues<Object> initialParameters;
    private boolean avoidRowCount = false;
	private String asOfDate;
	private String filterSection = null;
	private List<OrderByItem> orderByVector;
	private String selectCustomItems = "*";
	
    public DetachedQueryResult(MTTable table){
        super(table);
    }
    
    public DetachedQueryResult(MTTable table, String whereSection){
        super(table);
        setWhereSection(whereSection);
    }
   
    public DetachedQueryResult(MTTable table,MapValues<Object> parameters){
        super(table);
        this.setWhereSection(" " + parameters.keySet().stream()
    			.map(element -> new String("and " + element + "=:" + element)).collect(Collectors.joining(" ")));
        this.setParameters(parameters);
    }
    
    
    
    public DetachedQueryResult(MTTable table, String whereSection,MapValues<Object> parameters){
        super(table);
        this.setWhereSection(whereSection);
        this.setParameters(parameters);
    }
  
    public DetachedQueryResult( MTTable table,String selectSection, String whereSection, String groupBySection,MapValues<Object> initialParameters){
    	super(table);
    	setSelectSection(selectSection);
        setWhereSection(whereSection);
        setGroupBySection(groupBySection);
        this.setInitialParameters(initialParameters);
    }

    @Override
    public DQResults<IDetachedRecord> getPage(Integer pageNumber){
    	return getPage(pageNumber, DetachedRecord.class);
     }
    
    
    public <T extends IDetachedRecord> DQResults getPage(Integer pageNumber, Class<T> c1){
    	ListValues<T> results = new ListValues<>();
    	
 		String sql= "";
 		
 		if(null!=getCustomSql()) { sql=getCustomSql();pageSize=null; }
 		else if (null == pageSize || null ==pageNumber)
 			sql = DbPageMSSUtil.getSql(getmTTable().getFullTableName(), getSelectSection(), getWhereSection(), buildOrderBySection(), getSelectCustomItems(), asOfDate);
 		else if(avoidRowCount)
 			sql=DbPageMSSUtil.getSqlPageableNoCount(getmTTable().getFullTableName(), getPageSize(), pageNumber, getSelectSection(), getWhereSection(), buildOrderBySection(), getSelectCustomItems(), asOfDate);
 		else  
 			sql=DbPageMSSUtil.getSqlPageable(getmTTable().getFullTableName(), getPageSize(), pageNumber, getSelectSection(), (getWhereSection()==null?"":getWhereSection()) +  (filterSection==null?"":' '+filterSection), buildOrderBySection(), getSelectCustomItems(), asOfDate);
 		
 		System.out.println(sql);
 		
         NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(MainDb.getMainDataSource());
 		
 		jdbcTemplate.query(sql,new MapSqlParameterSource().addValues(getTotalParameters()), new RowCallbackHandler() {
 			@Override
 			public void processRow(ResultSet rs) throws SQLException {
 				results.add((T)DTOFactory.get(getmTTable()).set(rs));
 				if (null != pageSize && null !=pageNumber)
 					maxResults= rs.getInt("querytotalcount");
 			}
 		});
 		rowCount=results.size();
  	
 		DQResults<T> dqResults=new DQResults<T>();
 		dqResults.setRawData( results);
 		dqResults.setSize(rowCount);
 		dqResults.setTotal(maxResults);
 		dqResults.setPage(pageNumber);
 		
    	return dqResults;
    }
    
    public  ArrayList<MapValues<Object>> getPlainPage(Integer pageNumber){
    	ArrayList<MapValues<Object>> results = new ArrayList<MapValues<Object>>();
    	
 		String sql= "";
 		
 		if (null == pageSize)
 			sql = DbPageMSSUtil.getSql(getmTTable().getFullTableName(), getSelectSection(), getWhereSection(), buildOrderBySection(), getSelectCustomItems(), asOfDate);
 		else if(avoidRowCount)
 			sql=DbPageMSSUtil.getSqlPageableNoCount(getmTTable().getFullTableName(), getPageSize(), pageNumber, getSelectSection(), getWhereSection(), buildOrderBySection(), getSelectCustomItems(), asOfDate);
 		else  
 			sql=DbPageMSSUtil.getSqlPageable(getmTTable().getFullTableName(), getPageSize(), pageNumber, getSelectSection(), (getWhereSection()==null?"":getWhereSection()) +  (filterSection==null?"":' '+filterSection), buildOrderBySection(), getSelectCustomItems(), asOfDate);
 		
 		System.out.println(sql);
 		
         NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(MainDb.getMainDataSource());
 		
 		jdbcTemplate.query(sql,new MapSqlParameterSource().addValues(getTotalParameters()), new RowCallbackHandler() {
 			@Override
 			public void processRow(ResultSet rs) throws SQLException {
 				MapValues<Object> dr=new MapValues<Object>();
 				results.add(dr);
 				for (MTField field:getFields()){
 					dr.put(field.getName(),DBValueMapper.loadValue(rs, field));
 				}
 				if (null != pageSize)
 					maxResults= rs.getInt("querytotalcount");
 			}
 		});
 		rowCount=results.size();
    	return results;
    }
 
    public Integer getPageSize() {
        return pageSize;
    }
    
	@Override
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRowCount() throws SQLException {
        return rowCount;
    }

    public Integer getMaxResults() {
    	if (null == maxResults)
    		getPage(0);
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }
  
    public MapValues<Object> getTotalParameters() {
    	
           return  getParameters().add(getInitialParameters());
        
    }
 
    private String buildOrderBySection() {
    	if (null != orderByVector) {
        	   return orderByVector.stream().map( n -> n.getOrder() ).collect( Collectors.joining( "," ) );
           }
           return getOrderBySection();
    }
    
    public MapValues<Object> getInitialParameters() {
        return initialParameters;
    }
    public void setOrderByVector(List<OrderByItem> orderByVector) {
        this.orderByVector = orderByVector;
    }

    public void seInitialtParameters(MapValues<Object> initialParameters) {
        this.initialParameters = initialParameters;
    }

    public void setInitialParameter(String name, Object parameter) {
        if (null == initialParameters) {
            initialParameters = new MapValues<Object>();
        }
        initialParameters.put(name, parameter);
    }

	public boolean isAvoidRowCount() {
		return avoidRowCount;
	}

	public void setAvoidRowCount(boolean avoidRowCount) {
		this.avoidRowCount = avoidRowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public void setInitialParameters(MapValues<Object> initialParameters) {
		this.initialParameters = initialParameters;
	}

	public String getFilterSection() {
		return filterSection;
	}

	public void setFilterSection(String filterSection) {
		this.filterSection = filterSection;
	}

	public String getSelectCustomItems() {
		return selectCustomItems;
	}

	public void setSelectCustomItems(String selectCustomItems) {
		this.selectCustomItems = selectCustomItems;
	}

	

	
	
}

