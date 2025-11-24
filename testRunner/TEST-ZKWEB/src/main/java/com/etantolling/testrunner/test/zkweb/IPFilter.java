package com.etantolling.testrunner.test.zkweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class IPFilter implements Filter {
	
	private static final Logger log = LoggerFactory.getLogger(IPFilter.class);
	
	String allowedIPs = null;
	
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {
		try{
			Connection conn = MainDb.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from adm_app_info where skey='ALLOWED_IPS'");
			if (rs.next()){
				System.out.println("Allowed IPs:" + rs.getString("sValue"));
				allowedIPs = rs.getString("sValue");
			}
			else {
				System.out.println("No IP Restriction");
			}
		}
		catch (Exception e){
			log.error("ERROR STACKTRACE: ", e);
		}
	}

	public void destroy() {
	}


}
