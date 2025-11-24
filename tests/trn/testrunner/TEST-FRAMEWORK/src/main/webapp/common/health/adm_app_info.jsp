<html>
	<table border="1" cellspacing="0" cellpadding="4">
<%
	java.sql.Connection conn = com.jsantos.orm.MainDb.getConnection();

	try{
		java.sql.Statement st = conn.createStatement();
		java.sql.ResultSet rs = st.executeQuery("select * from adm_app_info order by 1");
		while(rs.next()){
%>
		<tr><td><%=rs.getString("skey")%></td><td><%=rs.getString("svalue")%></td></tr>
<%
		}
		rs.close();
		st.close();
	}
	catch (java.sql.SQLException e){
		System.out.println("Error in adm_app_info! stack trace:");
		e.printStackTrace();
		out.println("ERROR");
	}
	finally{
		conn.close();
	}
%>
	</table>
</html>