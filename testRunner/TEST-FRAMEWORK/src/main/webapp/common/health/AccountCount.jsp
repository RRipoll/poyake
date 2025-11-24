<html>
<%
	java.sql.Connection conn = com.etantolling.testrunner.test.utils.appcontext.MainDb.getConnection();
	try{
		java.sql.Statement st = conn.createStatement();
		java.sql.ResultSet rs = st.executeQuery("select count(*) from accounts");
		rs.next();
		out.println("[OK] (" + rs.getInt(1) + ")" );
		rs.close();
		st.close(); 
	}
	catch (java.sql.SQLException e){
		System.out.println("Error in Health Check! stack trace:");
		e.printStackTrace();
		out.println("ERROR");
	}
	finally{
		conn.close();
	}
%>
</html>