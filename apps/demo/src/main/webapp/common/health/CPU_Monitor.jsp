<html>
<%
	java.sql.Connection conn = com.jsantos.orm.MainDb.getConnection();
	try{
		java.sql.Statement st = conn.createStatement();
		java.sql.ResultSet rs = st.executeQuery("select top(1) SQL_Server_Process_CPU_Utilization from adm_cpumonitor Order by Event_Time desc");
		rs.next();
		out.println("CPU: " + rs.getInt(1));
		if (90<rs.getInt(1)) out.println(" - CPU over 90%");
		if (80<rs.getInt(1)) out.println(" - CPU over 80%");
		if (70<rs.getInt(1)) out.println(" - CPU over 70%");
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