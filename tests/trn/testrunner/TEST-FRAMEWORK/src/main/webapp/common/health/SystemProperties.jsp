<%@page import="java.security.Security"%>
<%@page import="java.security.Provider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%
Provider[] providerList = Security.getProviders();
for (int i = 0; i < providerList.length; i++) {
	out.println("<tr><td>");
	out.println(providerList[i].getName() );
	out.println("</td><td>");
	out.println(providerList[i].getClass().getName() + " (" + providerList[i].getVersion() + ") - " + providerList[i].getInfo());
	out.println("</td></tr>");
}
java.util.Properties systemProps = java.lang.System.getProperties();
java.util.Enumeration en= systemProps.propertyNames();
while (en.hasMoreElements()){
	String name = (String)en.nextElement();
	out.println("<tr><td>");
	out.println(name);
	out.println("</td><td>");
	out.println(systemProps.get(name));
	out.println("</td></tr>");
}
%>
</table>
</body>
</html>