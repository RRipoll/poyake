<html>
<%
	java.sql.Connection conn = com.jsantos.orm.MainDb.getConnection();
	try{
		java.sql.Statement st = conn.createStatement();
		java.sql.ResultSet rs = st.executeQuery("select sysdatetime()");
		rs.next();
		rs.close();
		st.close();
		out.println("[OK]");
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