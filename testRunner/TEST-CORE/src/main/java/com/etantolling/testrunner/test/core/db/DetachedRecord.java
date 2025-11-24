package com.etantolling.testrunner.test.core.db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.core.metadata.MTTable;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.db.NamedParameterStatement;
import com.etantolling.testrunner.test.utils.db.Sequence;


public class DetachedRecord {
	
	private static final Logger log = LoggerFactory.getLogger(DetachedRecord.class);
	
	private HashMap<MTField, Object> originalValues = new HashMap<MTField,Object>();
	private HashMap<MTField, Object> updates = new HashMap<MTField,Object>();
	private MTTable table = null;
	private Vector<MTField> fields = new Vector<MTField>();
	private Integer pk = null;
	private String whereExpression = null;
	
	public DetachedRecord(){
	}

	public DetachedRecord(MTTable table){
		this.table = table;
		for (MTField field:table.getFields().values()) fields.add(field);
		for (MTField field:fields)
			originalValues.put(field, null);
	}
	
	public DetachedRecord(MTTable table, int pk) throws SQLException{
		load(table, pk);
	}
	
	public DetachedRecord(MTTable table, String whereExpression) throws SQLException{
		load(table, whereExpression);
	}
	
	public DetachedRecord(MTTable table, String whereExpression, Connection conn) throws SQLException{
		if(conn != null)
		   load(table, whereExpression, conn);
		else
		   load(table, whereExpression);
	}
	
	public DetachedRecord load(MTTable table, int pk) throws SQLException{
		
		try(Connection conn = MainDb.getConnection()){
			load(table, pk, conn);
		}
		return this;
	}

	public DetachedRecord load(MTTable table, int pk, Connection conn) throws SQLException{
		this.table = table;
		this.pk = pk;
		for (MTField field:table.getFields().values()) fields.add(field);
		loadValues(conn);
		return this;
	}

	public DetachedRecord load(MTTable table, String whereExpression) throws SQLException{
		try(Connection conn = MainDb.getConnection()){
			load(table, whereExpression, conn);
		}
		return this;
	}	
	
	public DetachedRecord load(MTTable table, String whereExpression, Connection conn) throws SQLException{
		log.info("DetachedRecord  load Conn obj +++ " + (conn != null ?conn.toString() : ""));
		this.table = table;
		this.whereExpression = whereExpression;
		for (MTField field:table.getFields().values()) fields.add(field);
		loadValues(conn);
		return this;
	}
	
	
	public DetachedRecord load(MTTable table, int pk, MTField[] fieldArray) throws SQLException{
		try(Connection conn = MainDb.getConnection()){
			load(table, pk, fieldArray, conn);
		}
		
		return this;
	}

	public DetachedRecord load(MTTable table, int pk, MTField[] fieldArray, Connection conn) throws SQLException{
		this.table = table;
		this.pk = pk;
		for (MTField field:fieldArray) fields.add(field);
		loadValues(conn);
		return this;
	}

	public void save(Connection conn) throws SQLException{
		if (null == pk) insertIntoDB(conn);
		else updateDB(conn);
	}
	
	public Integer makeAcopy(Connection conn) throws SQLException{
		
		//Integer id=Sequence.nextForTable(conn, table.getTableName());
		
		for (MTField mtField : originalValues.keySet()) {
			if(!updates.containsValue(mtField) && !(mtField.getName().equals(table.getPrimaryKey().getName())))
					updates.put(mtField, originalValues.get(mtField));
		}
		return insertIntoDB(conn);
		
	}
	public Integer insertIntoDB(Connection conn,boolean full) throws SQLException{
		String sql = "insert into " + table + " (";
		
		
		boolean comma = false;
		if(updates.keySet().size()==0)return null;
		
		MTField namepk=table.getField(table.getTableName()+"ID");
		
		if(null==get(table.getField(namepk.getName())) && table.getFields().containsKey("STARTDATE") && table.getFields().containsKey("ENDDATE")){
			
			pk=Sequence.nextForTable(conn, table.getTableName());
			updates.put(namepk, pk);
			set(table.getPrimaryKey(),pk);
		}
		
		if(full){
			for (MTField field:fields){
			if(field.getName().equals("STARTDATE"))continue;
			if (comma) sql += ",";
			comma = true;
			sql += field.getName();
			}
		}else 
			for (MTField field:updates.keySet()){
				if(field.getName().equals("STARTDATE"))continue;
				if (comma) sql += ",";
				comma = true;
				sql += field.getName();
			}
		
		sql +=") values (";
		
		comma = false;
		if(full){
		for (MTField field:fields){
			if(field.getName().equals("STARTDATE"))continue;
			if (comma) sql += ",";
			comma = true;
			sql += ":"+field.getName();
			}
		}else
			for (MTField field:updates.keySet()){
				if(field.getName().equals("STARTDATE"))continue;
				if (comma) sql += ",";
				comma = true;
				sql += ":"+field.getName();
			}
		
		sql +=")";
		try(NamedParameterStatement pst = new NamedParameterStatement(conn,sql,Statement.RETURN_GENERATED_KEYS)){
		//PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		setFields(pst,full);
		pst.executeUpdate();
		ResultSet rs = pst.getGeneratedKeys();
		if(rs.next()){
			if(rs.getInt(1)!=0)pk = rs.getInt(1);
			if(null!=table.getPrimaryKey())
				set(table.getPrimaryKey(),pk);
			}
		}
		return pk;
	}
	
	
	@SuppressWarnings("unused")
	Integer insertIntoDB(Connection conn) throws SQLException{
		String sql = "insert into " + table + " (";
		
		MTField namepk=table.getField(table.getTableName()+"ID");
		
		if(null==get(table.getField(namepk.getName()))  && table.getFields().containsKey("STARTDATE") && table.getFields().containsKey("ENDDATE")){
			pk=Sequence.nextForTable(conn, table.getTableName());
			updates.put(namepk, pk);
			set(table.getPrimaryKey(),pk);
		}
		
		
		boolean comma = false;
		if(updates.keySet().size()==0)return null;
		for (MTField field:updates.keySet()){
			if(field.getName().equals("STARTDATE"))continue;
			if (comma) sql += ",";
			comma = true;
			sql += field.getName();
		}
		
		sql +=") values (";
		
		comma = false;
		for (MTField field:updates.keySet()){
			if (comma) sql += ",";
			comma = true;
			sql += ":"+field.getName();
		}
		
		sql +=")";
		try(NamedParameterStatement pst = new NamedParameterStatement(conn,sql, Statement.RETURN_GENERATED_KEYS)){
		//PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		setFields(pst);
		pst.executeUpdate();
		if(null==pk){
		ResultSet rs = pst.getGeneratedKeys();
		rs.next();
		if(rs.getInt(1)!=0)pk = rs.getInt(1);
		if(null!=table.getPrimaryKey())
			set(table.getPrimaryKey(),pk);
		}
		}
		return pk;
	}
	
	 boolean updateDB(Connection conn) throws SQLException{
		 
			if(table.getFields().containsKey("STARTDATE") && table.getFields().containsKey("ENDDATE")){
				if(updates.size()==0) return false;
				//H2//
				String sqlseq = "update "+table.getTableName()+" set enddate=CURRENT_TIMESTAMP() where enddate>CURRENT_TIMESTAMP() and "+table.getTableName()+"ID="+pk;
				//String sqlseq = "update "+table.getTableName()+" set enddate=SYSDATETIME() where enddate>SYSDATETIME() and "+table.getTableName()+"ID="+pk;
				try (NamedParameterStatement pst = new NamedParameterStatement(conn,sqlseq)){
					pst.executeUpdate();
				}
				insertIntoDB(conn,true);
			}else { 
		 
			String sql = "update " + table + " set ";
			boolean comma = false;
			if(updates.keySet().size()==0)return false;
			for (MTField field:updates.keySet()){
				if (comma) sql += ",";
				comma = true;
				sql += field + "=:"+field;
			}
			sql += " where " + table.getPrimaryKey().toString() + "=" + pk; 
			try(NamedParameterStatement pst = new NamedParameterStatement(conn,sql)){
				setFields(pst);
				pst.executeUpdate();
			}
			}
		return true;
	}
	
	private void setFields(NamedParameterStatement pst) throws SQLException{
		int position = 1;
		for (MTField field:updates.keySet()){
			if(field.getName().equals("STARTDATE"))continue;
			Object value = updates.get(field);
			
			//System.out.println(field.getName()+" / "+value);
			
				switch (field.getSqlType()){
				case Types.CHAR:
				case Types.NCHAR:
				case Types.NVARCHAR:
				case Types.VARCHAR:
					pst.setString(field.getName(), value.toString());
					break;
				case Types.BIGINT:
				case Types.BIT:
				case Types.INTEGER:
					pst.setInt(field.getName(), getInt(field));
					break;
				case Types.DATE:
				case Types.TIMESTAMP:
					if(value instanceof Date)
						pst.setDate(field.getName(),(Date)value);
					else pst.setTimestamp(field.getName(), new Timestamp(((java.util.Date)value).getTime()));
					break;
				//case Types.TIMESTAMP:
					//pst.setTimestamp(position, (Timestamp)value);
					//break;
				case Types.DECIMAL:
					if(value instanceof BigDecimal)
						pst.setBigDecimal(field.getName(), (BigDecimal) value);
					else if (null==value)pst.setInt(field.getName(), null);
					else pst.setInt(field.getName(), (Integer) value);
					break;	
				default:
					throw new RuntimeException("DataType: " + field.getNativeTypeName() + " with sqlType: " + field.getSqlType() + " not handled yet");
				}
			
			position++;
		}		
	}
	
	private void setFields(NamedParameterStatement pst,boolean full) throws SQLException{
		
		Collection<MTField> set=updates.keySet();
		if(full)set=fields;
		
		for (MTField field:set){
			Object value = updates.get(field);
			if(full && null==value)value=originalValues.get(field);
			
			//System.out.println(field.getName()+" / "+value);
			
				switch (field.getSqlType()){
				case Types.CHAR:
				case Types.NCHAR:
				case Types.NVARCHAR:
				case Types.VARCHAR:
					
					    pst.setString(field.getName(), (String) value);
					break;
				case Types.BIGINT:
				case Types.BIT:
				case Types.INTEGER:
					pst.setInt(field.getName(), getInt(field));
					break;
				case Types.DECIMAL:
					if(value instanceof BigDecimal)
						pst.setBigDecimal(field.getName(), (BigDecimal) value);
					else pst.setInt(field.getName(), (Integer) value);
					break;	
				case Types.DATE:
				case Types.TIMESTAMP:
					if(value instanceof Date)
						pst.setDate(field.getName(),(Date)value);
					else {
						if(null==value)pst.setTimestamp(field.getName(), null);
						else pst.setTimestamp(field.getName(), new Timestamp(((java.util.Date)value).getTime()));
					}
					break;
				//case Types.TIMESTAMP:
					//pst.setTimestamp(position, (Timestamp)value);
					//break;
				default:
					throw new RuntimeException("DataType: " + field.getNativeTypeName() + " with sqlType: " + field.getSqlType() + " not handled yet");
				}
			}
				
	}
	
	public Integer getInt(MTField field){
		
		if (null == get(field)) return null;
		if (get(field) instanceof Integer) return (Integer)get(field);
		if (get(field) instanceof Long) return (Integer)((Long)get(field)).intValue();
		if (get(field) instanceof BigDecimal) return (Integer)((BigDecimal)get(field)).intValue();
		if (get(field) instanceof String) {
			if (null == get(field)) return null;
			return Integer.parseInt((String)get(field));
		}
		throw new RuntimeException("value :" +  get(field) + " can't be converted to an integer");
	}
	
	private void loadValues(Connection conn) throws SQLException{
		String sql = "select * from " + table + " where " + table.getPrimaryKey() + " = " + pk;
		
		if(fields.contains(table.getField("STARTDATE"))  && fields.contains(table.getField("endDATE")))
			sql+= " and startdate<=:versionDate and enddate>=:versionDate ";
		
		if (!StringUtils.isEmpty(whereExpression))
			sql = "select * from " + table + " where " + whereExpression;
		try(NamedParameterStatement pst = new NamedParameterStatement(conn, sql);
				
				){
			pst.setTimestamp("versionDate", EnvironmentHelper.getVersionTimeStamp());
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			for (MTField field:fields){
				try{
			//	log.info(field.getName());DATATABLENAME
				if (null == rs.getObject(field.getName())){
					originalValues.put(field,null);
					continue;
				}
				if (Types.DATE == field.getSqlType()){
					originalValues.put(field, rs.getDate(field.getName()));
				}
				else if (Types.TIMESTAMP == field.getSqlType()){
					originalValues.put(field, rs.getTimestamp(field.getName()));
					//SimpleDateFormat formatter = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
					//originalValues.put(field, formatter.format(rs.getTimestamp(field.getName())));
				}
				else if (Types.VARCHAR == field.getSqlType()){ // we convert CLOBS to Strings here by using getString on VARCHAR just in case it is varchar(max). We can't pass the streaming object after the recordset is closed
					originalValues.put(field, rs.getString(field.getName()));
				}
				else{
					switch (field.getNativeTypeName()){
					case "CHAR":
					case "VARCHAR2":
					case "CLOB":
						originalValues.put(field, rs.getString(field.getName()));
						break;
					case "NUMBER":
						if (0 == field.getDecimalDigits() 
						//|| field.getSqlType()==10
						){
							originalValues.put(field, rs.getInt(field.getName()));
							if(table.getPrimaryKey().getName().equals(field.getName()))
								pk=rs.getInt(field.getName());
						}else 
							originalValues.put(field, rs.getBigDecimal(field.getName()));
						break;
					case "DATE":
						originalValues.put(field, rs.getDate(field.getName()));
						break;
					case "TIMESTAMP(6)":
						originalValues.put(field, rs.getTimestamp(field.getName()));
						break;
					default:
						throw new RuntimeException("DataType: " + field.getNativeTypeName() + " with sqlType: " + field.getSqlType() + " not handled yet");
					}
					
					//originalValues.put(field, rs.getObject(field.getName()));
				}
			}
			catch (Exception e){
				log.info("Exception " + e + " when getting value of field: " + field.getName());
				throw e;
			}
		}
		}
	}
	
	public boolean isUpdated(){
		return updates.size()>0;
	}
	
	public boolean isFieldUpdated(MTField field){
		return updates.containsKey(field);
	}
	
	public void set(MTField field, Object value){
		if (!table.getFields().containsValue(field))
			throw new RuntimeException("Field: " + field.getTable() + "."+ field + " not found in DetachedRecord.set() for MTTable: " + table);
		if(null == value && (null == originalValues.get(field) || null==originalValues.get(field) ) ) return ;
		if (null == value && null != originalValues.get(field) && !(null==originalValues.get(field) ) ){ 
			updates.put(field, null);
		}else if(null != value && (null == originalValues.get(field) || null==originalValues.get(field) )){
			updates.put(field, value);
		}else if(value instanceof Integer){
			if (!originalValues.get(field).toString().equals(value.toString())) 
				updates.put(field, value);
		}else if(value instanceof Date){
			if (getSqlDate(originalValues.get(field)).getTime()!=getSqlDate(value).getTime()) 
				updates.put(field, value);
		}else if ( !originalValues.get(field).equals(value)){ 
			updates.put(field, value);
			}
	}
	
	public Object get(MTField field){
		Object retValue = internalGet(field);
		return retValue;
	}
	
	public Integer getInteger(MTField field){
		Object retValue = internalGet(field);
		if (null==retValue ) return null;
		else if (retValue instanceof Integer) return (Integer)retValue;
		else Integer.parseInt(retValue.toString());
		throw new RuntimeException("Can't map field " + field + " into an integer");
	}

	public Long getLong(MTField field){
		Object retValue = internalGet(field);
		if (null==retValue) return null;
		else if (retValue instanceof Long) return (Long)retValue;
		else if (retValue instanceof BigDecimal) return ((BigDecimal)retValue).longValueExact();
		throw new RuntimeException("Can't map field " + field + " into an long");
	}
	
	public java.sql.Date getDate(MTField field){
		Object retValue = null;
		try {
			retValue=internalGet(field);
			return getSqlDate(retValue);
		} catch (Exception e) {
			throw new RuntimeException("Can't map field " + field + " into an date. Class is: " + retValue.getClass());
		}
		
	}
	
	public java.sql.Date getSqlDate(Object retValue){
		if (null==retValue ) 
			return null;
		if (retValue instanceof Timestamp)
			return new java.sql.Date(((Timestamp)retValue).getTime());
		
		else if (retValue instanceof java.sql.Date)
			return (java.sql.Date)retValue;
		else if (retValue instanceof java.util.Date)
			return (new java.sql.Date(((java.util.Date)retValue).getTime()));
		else
			throw new RuntimeException("Can't map field  into an date. Class is: " + retValue.getClass());
	}
	
	
	private Object internalGet(MTField field){
		if (updates.containsKey(field)) return updates.get(field); 
		if (originalValues.containsKey(field)) return originalValues.get(field);
		else
			throw new RuntimeException("Field: " + field + " not found in DetachedRecord for MTTable: " + table);
	}

	public Vector<MTField> getFields() {
		return fields;
	}

	public HashMap<MTField, Object> getOriginalValues() {
		return originalValues;
	}

	public HashMap<MTField, Object> getUpdates() {
		return updates;
	}

	public MTTable getTable() {
		return table;
	}

	public Integer getPk() {
		return pk;
	}
	
	public void clearModifiedFlags(){
		for (MTField updatedField:updates.keySet()) originalValues.put(updatedField, updates.get(updatedField));
		updates.clear();
	}
}
