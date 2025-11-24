package com.jsantos.orm.dbstatement;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsantos.common.util.FieldValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.ORMClassRegistry;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.dbstatement.DBValueMapper.Null;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTHelper;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.orm.mt.MTTrigger;

public class DetachedRecord implements IDetachedRecord {
	@JsonIgnore
	protected FieldValues originalValues = new FieldValues();
	@JsonIgnore
	protected FieldValues updates = new FieldValues();
	@JsonIgnore
	protected MTTable table = null;
	@JsonIgnore
	protected ArrayList<MTField> fields = new ArrayList<MTField>();
	@JsonIgnore
	protected String whereExpression = null;
	@JsonIgnore
	protected MapValues<Object> params;
	@JsonIgnore
	protected IDetachedRecord extendedDetachedRecord = null;
	@JsonIgnore
	protected int recordsFound = 0;

	public DetachedRecord(MTTable table) {
		this.table = table;
		for (MTField field : table.getFields())
			fields.add(field);

		for (MTField field : fields) {
			originalValues.set(field, DBValueMapper.getDefaultValue(field));
		}

		if (null != table.getExtendsTable())
			extendedDetachedRecord = new DetachedRecord(table.getExtendsTable());

	}

	public DetachedRecord(MTTable table, Object pk) {
		this(table);
		findByPk(pk);
	}

	@Override
	public IDetachedRecord findByPk(Object pk) {
		
		whereExpression = table.getPrimaryKey() + " = :" + table.getPrimaryKey();
		find(new MapValues<Object>().add(table.getPrimaryKey().toString(), pk));
		return this;
	}

	public DetachedRecord(MTTable table, String whereExpression) {
		this(table);
		this.whereExpression = whereExpression;
		load();
		if (null != table.getExtendsTable())
			extendedDetachedRecord = new DetachedRecord(table.getExtendsTable(), getPk());

	}

	public DetachedRecord(MTTable table, String whereExpression, MapValues<Object> params) {
		this(table);
		find(whereExpression, params);
	}

	@Override
	public IDetachedRecord find(String whereExpression, MapValues<Object> params) {
		this.whereExpression = whereExpression;
		this.params = params;
		load();
		if (null != table.getExtendsTable())
			extendedDetachedRecord = new DetachedRecord(table.getExtendsTable(), getPk());
		return this;
	}

	@Override
	public IDetachedRecord find(MTTable table, MapValues<Object> params) {
		this.table = table;
		return find(params);
	}

	public DetachedRecord(MTTable table, MapValues<Object> params) {
		this(table);
		find(params);
	}

	@Override
	public IDetachedRecord find(MapValues<Object> params) {
		this.whereExpression = "(1=1) " + params.keySet().stream()
				.map(element -> new String("and " + element + "=:" + element)).collect(Collectors.joining(" "));
		this.params = params;
		load();
		if (null != table.getExtendsTable())
			extendedDetachedRecord = new DetachedRecord(table.getExtendsTable(), getPk());
		return this;
	}

	public DetachedRecord(MTTable table, ResultSet rs) {
		this(table);
		for (MTField field : fields) {
			try {
				originalValues.set(field, DBValueMapper.loadValue(rs, field));
				recordsFound++;
			} catch (Exception e) {
				System.out.println(
						"Exception " + e + " when getting value of field: " + field.getName() + " from Resultset ");
				e.printStackTrace();
				throw new RecoverableDataAccessException(
						"Exception " + e + " when getting value of field: " + field.getName() + " from Resultset ", e);
			}
		}
		if (null != table.getExtendsTable())
			extendedDetachedRecord = new DetachedRecord(table.getExtendsTable(), rs);
	}

	@Override
	public DetachedRecord insert() {
		for (MTTrigger trigger : ORMClassRegistry.getTriggers())
			trigger.beforeInsert(this);

		if (table.isView()) {
			IDetachedRecord realTable = MTHelper.getTableFromView(this);
			if(realTable.getTable().isView())return null ;
			realTable.insert();
			this.set(table.getPrimaryKey(), realTable.get(realTable.getTable().getMainFk()));
		} else {
			boolean isPkFromSequence = false;
			boolean isPkFromExtendedTable = false;

			if (null != extendedDetachedRecord) {
				extendedDetachedRecord.insert();
				this.set(table.getPrimaryKey(), extendedDetachedRecord.getPk());
				isPkFromExtendedTable = true;
			}
			// Object update=updates.get(table.getPrimaryKey());
			// Object originalUpdate=originalValues.get(table.getPrimaryKey());

			/*
			if ((null == updates.get(table.getPrimaryKey()) || DBValueMapper.NULL == updates.get(table.getPrimaryKey()))
					&& (null == originalValues.get(table.getPrimaryKey())
							|| DBValueMapper.NULL == originalValues.get(table.getPrimaryKey()))
			*/
			if ((null == get(table.getPrimaryKey()) || DBValueMapper.NULL ==get(table.getPrimaryKey()))
					&& null != table.getPrimaryKey().getSequence()) {
				set(table.getPrimaryKey(), Sequence.nextForTable(table));
				isPkFromSequence = true;
			}

			String sql = buildSqlForInsert();
			System.out.println(sql);
			MapSqlParameterSource namedParameters = new MapSqlParameterSource();
			for (MTField field : getCopyValues().keySet()) {
				if (field.isTransient())
					continue;
				namedParameters.addValue(field.getName(), DBValueMapper.unloadValue(field, this));
				System.out.println(field.getName() + " -> " + updates.get(field));
			}

			NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(MainDb.getMainDataSource());

			if (!isPkFromSequence && !isPkFromExtendedTable && null == updates.get(table.getPrimaryKey())) {
				KeyHolder keyHolder = new GeneratedKeyHolder();
				jdbcTemplate.update(sql, namedParameters, keyHolder);
				originalValues.set(table.getPrimaryKey(), keyHolder.getKey().intValue());
				updates.set(table.getPrimaryKey(), keyHolder.getKey().intValue());
			} else
				jdbcTemplate.update(sql, namedParameters);

		}
		for (MTTrigger trigger : ORMClassRegistry.getTriggers())
			trigger.afterInsert(this);

		return this;

	}

	String buildSqlForInsert() {
		String sql = "insert into ";
		if (null != table.getSchema())
			sql += table.getSchema() + ".";
		sql += table + " (";

		sql += getCopyValues().keySet().stream().filter(num -> !num.isTransient()).map(Object::toString)
				.collect(Collectors.joining(","));
		sql += ") values (";
		boolean comma = false;
		for (MTField field : getCopyValues().keySet()) {
			if (field.isTransient())
				continue;
			if (comma)
				sql += ",";
			sql += ":" + field;
			comma = true;
		}
		sql += ")";

		return sql;
	}

	@Override
	public void update() {
		for (MTTrigger trigger : ORMClassRegistry.getTriggers())
			trigger.beforeUpdate(this);

		if (table.isView()) {
			MTHelper.getTableFromView(this).update();
		} else {

			// inheritance
			if (null != extendedDetachedRecord)
				extendedDetachedRecord.update();

			if (!isUpdated())
				return;

			NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(MainDb.getMainDataSource());
			MapSqlParameterSource namedParameters = new MapSqlParameterSource();

			for (MTField field : updates.keySet()) {
				if (field.isTransient())
					continue;
				namedParameters.addValue(field.getName(), DBValueMapper.unloadValue(field, this));
			}

			String sql = buildSqlForUpdate(namedParameters);

			jdbcTemplate.update(sql, namedParameters);
		}
		for (MTTrigger trigger : ORMClassRegistry.getTriggers())
			trigger.afterUpdate(this);

	}

	protected String buildSqlForUpdate(MapSqlParameterSource namedParameters) {
		String sql = "update ";
		if (null != table.getSchema())
			sql += table.getSchema() + ".";
		sql += table + " set ";

		boolean comma = false;
		if (0 < updates.size()) {
			for (MTField field : updates.keySet()) {
				if (field.isTransient())
					continue;
				if (comma)
					sql += ",";
				sql += field.getName() + "=:" + field.getName();
				comma = true;
			}
		}
		sql += " where " + table.getPrimaryKey().toString() + "=:" + table.getPrimaryKey();
		namedParameters.addValue(table.getPrimaryKey().toString(), get(table.getPrimaryKey()));

		return sql;

	}

	@Override
	@JsonIgnore
	public Integer getInt(MTField field) {

		if (null == get(field))
			return null;
		if (get(field) instanceof Integer)
			return (Integer) get(field);
		if (get(field) instanceof Long)
			return (Integer) ((Long) get(field)).intValue();
		if (get(field) instanceof BigDecimal)
			return (Integer) ((BigDecimal) get(field)).intValue();
		if (get(field) instanceof String) {
			if (null == get(field))
				return null;
			return Integer.parseInt((String) get(field));
		}
		throw new RuntimeException("value :" + get(field) + " can't be converted to an integer");
	}

	private void loadValues() {

		String sqlTmp = table.getSql();
		if (!StringUtils.isEmpty(whereExpression))
			sqlTmp += " where " + whereExpression;

		final String sql = sqlTmp;
		recordsFound = 0;
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(MainDb.getMainDataSource());
		jdbcTemplate.query(sql, new MapSqlParameterSource(params), new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				for (MTField field : fields) {
					try {
						if(null!=rs.getObject(field.getName())){
							originalValues.set(field, DBValueMapper.loadValue(rs, field));
							recordsFound++;
						}
					} catch (Exception e) {
						System.out.println("Exception " + e + " when getting value of field: " + field.getName()
								+ " from sql: " + sql);
						e.printStackTrace();
						throw e;
					}
				}
			}
		});
		if (0 == recordsFound)
			throw new RecoverableDataAccessException("No records found when loading entity: " + table.getFullTableName()
					+ " with filter " + whereExpression);
	}

	@Override
	@JsonIgnore
	public boolean isUpdated() {
		return updates.size() > 0;
	}

	@Override
	@JsonIgnore
	public boolean isFieldUpdated(MTField field) {
		return updates.containsKey(field);
	}

	@Override
	public IDetachedRecord set(ResultSet rs) {

		for (MTField field : fields) {
			try {
				originalValues.set(field, DBValueMapper.loadValue(rs, field));
				recordsFound++;
			} catch (Exception e) {
				System.out.println(
						"Exception " + e + " when getting value of field: " + field.getName() + " from Resultset ");
				e.printStackTrace();
				throw new RecoverableDataAccessException(
						"Exception " + e + " when getting value of field: " + field.getName() + " from Resultset ", e);
			}
		}
		if (null != table.getExtendsTable())
			extendedDetachedRecord = new DetachedRecord(table.getExtendsTable(), rs);
		return this;
	}

	@Override
	public void set(MTField field, Object value) {

		// inheritance
		if (!MTHelper.containField(table.getFields(), field)) {
			if (null != extendedDetachedRecord && MTHelper.containField(extendedDetachedRecord.getFields(), field)) {
				extendedDetachedRecord.set(field, value);
				return;
			} else
				throw new RuntimeException("Field: " + field.getTable() + "." + field
						+ " not found in DetachedRecord.set() for MTTable: " + table);
		}

		if (null == value) {
			if (null == originalValues.get(field) || originalValues.get(field) instanceof Null)
				return;
			else if (null != originalValues.get(field) && !(originalValues.get(field) instanceof Null))
				updates.set(field, DBValueMapper.NULL);
		} else {
			if (null == originalValues.get(field)) {
					updates.set(field, value);
			}else if (value instanceof Integer) {
					if (!originalValues.get(field).toString().equals(value.toString()))
						updates.set(field, value);
			} else if (value instanceof Date) {
				Date origValue=getSqlDate(originalValues.get(field));
				if (null==origValue ||  origValue.getTime() != getSqlDate(value).getTime())
					updates.set(field, value);
			} else if (!originalValues.get(field).equals(value)) {
				System.out.println("--------");
				System.out.println(field);
				System.out.println(value.toString());
				System.out.println(originalValues.get(field).toString());
				System.out.println("--------");
				updates.set(field, value);
			}
		}
	}

	@Override
	@JsonIgnore
	public Object get(MTField field) {
		Object retValue = internalGet(field);
		if (retValue instanceof Null)
			return null;
		else
			return retValue;
	}

	@Override
	@JsonIgnore
	public String getString(MTField field) {
		Object retValue = internalGet(field);
		if (retValue instanceof Null)
			return null;
		else
			return retValue.toString();
	}

	@Override
	@JsonIgnore
	public Integer getInteger(MTField field) {
		Object retValue = internalGet(field);
		if (retValue instanceof Null)
			return null;
		else if (retValue instanceof Integer)
			return (Integer) retValue;
		else
			Integer.parseInt(retValue.toString());
		throw new RuntimeException("Can't map field " + field + " into an integer");
	}

	@Override
	@JsonIgnore
	public Long getLong(MTField field) {
		Object retValue = internalGet(field);
		if (retValue instanceof Null)
			return null;
		else if (retValue instanceof Long)
			return (Long) retValue;
		else if (retValue instanceof BigDecimal)
			return ((BigDecimal) retValue).longValueExact();
		throw new RuntimeException("Can't map field " + field + " into an long");
	}

	@Override
	@JsonIgnore
	public java.sql.Date getDate(MTField field) {
		Object retValue = null;
		try {
			retValue = internalGet(field);
			return getSqlDate(retValue);
		} catch (Exception e) {
			throw new RuntimeException("Can't map field " + field + " into an date. Class is: " + retValue.getClass());
		}

	}

	@Override
	@JsonIgnore
	public BigDecimal getBigDecimal(MTField field) {
		Object retValue = null;
		try {
			retValue = internalGet(field);
			return (BigDecimal) retValue;
		} catch (Exception e) {
			throw new RuntimeException("Can't map field " + field + " into an date. Class is: " + retValue.getClass());
		}

	}

	@Override
	@JsonIgnore
	public java.sql.Date getSqlDate(Object retValue) {
		if (retValue instanceof Null || retValue instanceof DBValueMapper.Null)
			return null;
		if (retValue instanceof Timestamp)
			return new java.sql.Date(((Timestamp) retValue).getTime());
		else if (retValue instanceof java.sql.Date)
			return (java.sql.Date) retValue;
		else if (retValue instanceof java.util.Date)
			return (new java.sql.Date(((java.util.Date) retValue).getTime()));
		else
			throw new RuntimeException("Can't map field  into an date. Class is: " + retValue.getClass());
	}

	private Object internalGet(MTField field) {
		if (updates.containsKey(field))
			return updates.get(field);
		if (originalValues.containsKey(field))
			return originalValues.get(field);
		if (null != extendedDetachedRecord && MTHelper.containField(extendedDetachedRecord.getFields(), field))
			return extendedDetachedRecord.get(field);

		throw new RuntimeException("Field: " + field + " not found in DetachedRecord for MTTable: " + table);
	}

	@Override
	@JsonIgnore
	public ArrayList<MTField> getFields() {
		return fields;
	}

	@Override
	@JsonIgnore
	public FieldValues getOriginalValues() {
		return originalValues;
	}

	@Override
	@JsonIgnore
	public FieldValues getUpdates() {
		return updates;
	}

	@Override
	@JsonIgnore
	public MTTable getTable() {
		return table;
	}

	@Override
	public void clearModifiedFlags() {
		for (MTField updatedField : updates.keySet())
			originalValues.set(updatedField, updates.get(updatedField));
		updates.clear();
	}

	@Override
	public IDetachedRecord load() {
		loadValues();

		return this;
	}

	@Override
	@JsonIgnore
	public Object getPk() {
		if (null == table.getPrimaryKey()) {
			if (table.isView()) {
				System.out.println("???  VIEW " + table + " doesn't have a primary key");
				return null;
			} else
				throw new RuntimeException("Table " + table + " doesn't have a primary key");
		}
		return get(table.getPrimaryKey());
	}

	@Override
	public void delete() {
		for (MTTrigger trigger : ORMClassRegistry.getTriggers())
			trigger.beforeDelete(this);

		if (table.isView()) {
			IDetachedRecord realTable = MTHelper.getTableFromView(this);
			realTable.delete();
		} else {

			NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(MainDb.getMainDataSource());
			MapSqlParameterSource namedParameters = new MapSqlParameterSource();

			if (table.getPatterns().contains("AutoHistory")) {
				String sql = "update " + table.getFullTableName() + " set endDate=getPostingDate() where "
						+ table.getPrimaryKey().getName() + "=:" + table.getPrimaryKey().getName();
				// + get(table.getPrimaryKey());
				namedParameters.addValue(table.getPrimaryKey().getName(), get(table.getPrimaryKey()));
				jdbcTemplate.update(sql, namedParameters);

				return;
			}

			String sql = " delete from " + table.getFullTableName() + " where " + table.getPrimaryKey().getName()
					+ " =:" + table.getPrimaryKey().getName();
			// + get(table.getPrimaryKey());
			namedParameters.addValue(table.getPrimaryKey().getName(), get(table.getPrimaryKey()));
			jdbcTemplate.update(sql, namedParameters);
		}
		for (MTTrigger trigger : ORMClassRegistry.getTriggers())
			trigger.afterDelete(this);
	}

	@Override
	public String toString() {
		return "Original Values: " + originalValues + "\r\nUpdates: " + updates;
	}

	@Override
	public MTField findFieldByname(String fieldName) {
		for (MTField field : getFields())
			if (field.getName().equalsIgnoreCase(fieldName))
				return field;
		return null;
	}

	@Override
	public void insertOrUpdate() {
		if (null == getPk())
			insert();
		else
			update();
	}

	@Override
	@JsonIgnore
	public MTMapValues<Object> getCopyValues() {

		MTMapValues<Object> values = new MTMapValues<Object>();
		for (MTField mtField : fields) {
			values.put(mtField, get(mtField));
		}
		return values;
	}

	@Override
	@JsonIgnore
	public MTMapValues<Object> getCopyValuesToDB() {

		MTMapValues<Object> values = new MTMapValues<Object>();
		for (MTField mtField : fields) {
			values.put(mtField, DBValueMapper.unloadValue(mtField, this));
		}
		return values;
	}

	@Override
	public DetachedRecord setValues(MTMapValues<Object> values) {

		for (Entry<MTField, Object> mtField : values.entrySet()) {
			set(mtField.getKey(), mtField.getValue());
		}
		return this;
	}

	@Override
	@JsonIgnore
	public String getWhereExpression() {
		return whereExpression;
	}

	@Override
	public void setWhereExpression(String whereExpression) {
		this.whereExpression = whereExpression;
	}

	@Override
	@JsonIgnore
	public IDetachedRecord getExtendedDetachedRecord() {
		return extendedDetachedRecord;
	}

	@Override
	public void setExtendedDetachedRecord(IDetachedRecord extendedDetachedRecord) {
		this.extendedDetachedRecord = extendedDetachedRecord;
	}

	@Override
	public MapValues<Object> getParams() {
		return params;
	}

	@Override
	public void setParams(MapValues<Object> params) {
		this.params = params;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (super.equals(obj))
			return true;
		for (MTField mtField : fields) {
			//if (null == ((IDetachedRecord) obj).get(mtField))
			//	return false;
			try {
				if (!this.get(mtField).equals(((IDetachedRecord) obj).get(mtField)))
					return false;
			} catch (RuntimeException e) {
				return false;
			}
			
		}
		return true;
	}

}
