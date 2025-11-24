package com.jsantos.orm.DBUtil;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jsantos.orm.MainDb;

/**
 * Tool to run database scripts
 */
public class SQLScriptRunner {

    private static final String DEFAULT_DELIMITER = ";";

 	public static void runScript(Reader input)  {
		
			BufferedReader in = new BufferedReader(input);
			NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(MainDb.getMainDataSource());
			String sLine = null;
			String statement = "";
			try {
				while ((sLine = in.readLine()) != null) {
					if (sLine.trim().startsWith(DEFAULT_DELIMITER)) {
						if (StringUtils.isNotBlank(statement)) {
							System.out.println(statement);
							jdbcTemplate.getJdbcOperations().execute(statement);
						}
						statement = "";
					} else {
						statement += sLine + "\r\n";
					}
				}
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
}

