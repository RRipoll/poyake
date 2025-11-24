package com.jsantos.service;

import java.util.List;
import java.util.Locale;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jsantos.common.i18n.LabelCache;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.internationalization.ILabelProvider;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class LabelProvider extends MapValues<String> implements ILabelProvider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Locale language=Locale.US;

	public LabelProvider(Locale language) {
		super();
		this.language = language;
	}
	
	public LabelProvider() {
		super();
	}

	@Override
	public String get(Object shortCode) {
		return get(shortCode, language);
	}
	
	@Override
	public  String get(MTField mtField, Locale language) {
		if(null==mtField) return null;
		return get(mtField.getFullyQualifiedName(), language);
	}

	public String load(Object shortCode) {
		return load( shortCode,  language);
		
	}
	public String load(Object shortCode, Locale language) {
		List<String> labels = null;
		try {
			String sql = " select " + language.toLanguageTag().replace("-", "_") + " from "
					+ MTBase.getTable("MTlabel").getFullTableName() + " where shortcode ='" + shortCode + "'";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(MainDb.getMainDataSource());
			labels = jdbcTemplate.queryForList(sql, String.class);
			if(labels.size()!=0) {
				LabelCache.set(language, shortCode.toString(), labels.get(0));
				return labels.get(0);
			}
		} catch (EmptyResultDataAccessException e) {
			;
		}
		try {
			String sql = " select " + language.toLanguageTag().replace("-", "_") + " from "
					+ MTBase.getTable("MTlabel").getFullTableName() + " where shortcode ='"
					+ getLabelName(shortCode.toString()) + "'";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(MainDb.getMainDataSource());
			labels = jdbcTemplate.queryForList(sql, String.class);
			if(labels.size()!=0) {
				LabelCache.set(language, shortCode.toString(), labels.get(0));
				return labels.get(0);
			}
			
		} catch (EmptyResultDataAccessException e) {
			;
		}	
		return null;
	}
	
	
	public  String get(Object shortCode, Locale language) {

		String label = null;
		label = LabelCache.get(language, shortCode.toString());
		if (null == label) {
			label = LabelCache.get(language, getLabelName(shortCode.toString()));
		}
		if (null != label)
			return label;
		
		label=load(shortCode, language);
		if (null != label)
			return label;
		
		return shortCode.toString();
	}
	
	@Override
	public  String getScreenSearchSql(MTTable mtTable) {

		String customSql = "select * from label.MTlabel where  shortCode='" + mtTable.getTableName() + "' "
				+ "	union select null,'" + mtTable.getTableName() + "','" + mtTable.getTableName() + "',null,null "
				+ "	where '" + mtTable.getTableName()
				+ "' not in (select shortcode from label.MTlabel where  shortcode='" + mtTable.getTableName() + "')";
		for (MTField iter : mtTable.getFields()) {

			customSql += " union select * from label.MTlabel where shortcode='" + iter.getFullyQualifiedName() + "'"
					+ "	union select null,'" + iter.getFullyQualifiedName() + "','" + mtTable.getTableName()
					+ "',null,null " + "	where '" + iter.getFullyQualifiedName()
					+ "' not in (select shortcode from label.MTlabel where  shortcode='" + iter.getFullyQualifiedName()
					+ "')";
		}
		return customSql;
	}

	public Locale getLanguage() {
		return language;
	}

	public void setLanguage(Locale language) {
		this.language = language;
	}

	private static String getLabelName(String label) {
		if (!label.contains("."))
			return label;
		String subLabel = label.substring(label.lastIndexOf(".") + 1, label.length());
		return subLabel;

	}

	@Override
	public boolean isImplemented() {
		return true;
	}

	

}