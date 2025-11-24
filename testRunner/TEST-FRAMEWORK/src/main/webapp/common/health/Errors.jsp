<html>

<h1>Errors:</h1>

<table border="1" cellspacing="0" cellpadding="4px">
<tr><td>Entry Date</td><td>Error Count</td><td>Module</td><td>SubModule</td></tr>
<%
	java.sql.Connection conn = com.etantolling.testrunner.test.utils.appcontext.MainDb.getConnection();
	try{
		java.sql.Statement st = conn.createStatement();
		java.sql.ResultSet rs = st.executeQuery("select cast(created as date) EntryDate, count(*) Errors, Module, SubModule from adm_ApplicationLog where Created>dateadd(day, -7, sysdatetime()) and LogLevel='Error' group by Module, SubModule, cast(created as date) order by EntryDate desc, Module, SubModule");
		while(rs.next()){
	out.print("<tr><td>");
	out.print(rs.getString("EntryDate"));
	out.println("</td>");
	out.print("<td>");
	out.print(rs.getString("Errors"));
	out.println("</td>");
	out.print("<td>");
	out.print(rs.getString("Module"));
	out.println("</td>");
	out.print("<td>");
	out.print(rs.getString("SubModule"));
	out.println("</td></tr>");
		}
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
</table>
</html>