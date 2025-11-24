<%@ page import="java.net.*,java.util.*,java.io.*"%>
<%@ page contentType="text/xml" %>
<%

out.println("<d>");
out.println("<path>" + request.getSession().getServletContext().getRealPath("/") + "</path>");
out.println("<request-object>");
out.println("<is-request-secure>" + request.isSecure() + "</is-request-secure>");
out.println("<getServerName>" + request.getServerName() + "</getServerName>");
out.println("<getServerPort>" + request.getServerPort() + "</getServerPort>");
out.println("<getRemoteHost>" + request.getRemoteHost() + "</getRemoteHost>");
out.println("<getRemoteAddr>" + request.getRemoteAddr() + "</getRemoteAddr>");
out.println("<getLocalName>" + request.getLocalName() + "</getLocalName>");
out.println("<getLocalAddr>" + request.getLocalAddr() + "</getLocalAddr>");
out.println("<getLocalPort>" + request.getLocalPort() + "</getLocalPort>");
out.println("</request-object>");
out.println("<InetAddress>");
try
{
	InetAddress localaddr = InetAddress.getLocalHost();
	out.println( "<os><![CDATA[" + System.getProperty("os.arch") + " - " + System.getProperty("os.name") + " - " + System.getProperty("os.version") + "]]></os>" );
	out.println( "<jvm><![CDATA[" + System.getProperty("java.vm.name") + " " + System.getProperty("java.vm.version") + "]]></jvm>" );
	out.println( "<tc><![CDATA[" + request.getSession().getServletContext().getServerInfo() + "]]></tc>" );
	
	out.println( "<InetAddress-getHostAddress>" + localaddr.getHostAddress() + "</InetAddress-getHostAddress>" );
	out.println( "<InetAddress-getHostName>" + localaddr.getHostName() + "</InetAddress-getHostName>" );
	
	InetAddress[] localaddrs = InetAddress.getAllByName ("localhost");
	for ( int j=0; j<localaddrs.length; j++ )
	{
		out.println("<alt-InetAddress-" + j + ">" );
	   	if ( ! localaddrs[j].equals( localaddr ) )
	    {
			out.println( "<alt-InetAddress-getHostAddress>" + localaddrs[j].getHostAddress() + "</alt-InetAddress-getHostAddress>");
		    out.println( "<alt-InetAddress-getHostName>" + localaddrs[j].getHostName() + "</alt-InetAddress-getHostName>");
	  	}
		out.println("</alt-InetAddress-" + j + ">" );
   	}
}
catch ( UnknownHostException e )
{
	//out.println( "<InetAddress-problem>" + e.getCause() + " ---- " + e.getMessage() + "</InetAddress-problem>");
	out.println( "<InetAddress-problem>" + e + "</InetAddress-problem>");
}
out.println("</InetAddress>");


out.println("<NetworkCards>");
Enumeration e = NetworkInterface.getNetworkInterfaces();
int i=0;
while(e.hasMoreElements()) 
{
	NetworkInterface ni = (NetworkInterface)e.nextElement();
	Enumeration e2 = ni.getInetAddresses();
	out.println("<networkcard-" + i + " name=\"" +  ni.getName() + "\" display-name=\"" +  ni.getDisplayName() + "\">" );
	while (e2.hasMoreElements())
	{
		out.println("<InetAddress>");
		InetAddress ip = (InetAddress)e2.nextElement();
		out.println("<networkcard-getHostAddress>" + ip.getHostAddress() + "</networkcard-getHostAddress>");
		//out.println("<networkcard-getCanonicalHostName>" + ip.getCanonicalHostName() + "</networkcard-getCanonicalHostName>");
		out.println("<networkcard-getHostName>" + ip.getHostName() + "</networkcard-getHostName>");
		out.println("</InetAddress>");
		//out.println("<networkcard-getLocalHost>" + ip.getLocalHost() + "</networkcard-getLocalHost>");
	}
	out.println("</networkcard-" + i + ">" );
	i++;
}
out.println("</NetworkCards>");
/*
out.println("<getByHostNameCommand>");
Process p = Runtime.getRuntime().exec("hostname");
InputStream stdoutStream = new BufferedInputStream(p.getInputStream());

StringBuffer buffer= new StringBuffer();
for (;;) {
    int c = stdoutStream.read();
    if (c == -1) break;
    buffer.append((char)c);
}
out.println(buffer.toString());

out.println("</getByHostNameCommand>");

stdoutStream.close();
*/
out.println("</d>");
out.flush();
%>
