package com.etantolling.testrunner.test.utils.monitoring;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ZabbixSender {
	String zabbixHost;
	String zabbixIP;
	Integer zabbixPort;
	
	public ZabbixSender(String zabbixHost, String zabbixIP, Integer zabbixPort){
		this.zabbixHost = zabbixHost;
		this.zabbixIP = zabbixIP;
		this.zabbixPort = zabbixPort;
	}
	
	public void send(String key, String message) throws UnknownHostException, IOException{
		Socket socket = new Socket(zabbixIP, zabbixPort);
		try
		{
			String json = buildJSonString(key, message);
			writeMessage(socket.getOutputStream(), json.getBytes());
			System.out.println("LOG SENT SUCCESSFULLY: \r\n" + json);
		}
		finally {
			socket.close();
		}
		
	}
	
	String buildJSonString(String key, String message){
		String json = "{"
				+ "\"request\":\"sender data\",\n"
				+ "\"data\":[\n";

		json += "{\n"
				+                "\"host\":\"" + zabbixHost + "\",\n"
				+                "\"key\":\"" + key + "\",\n"
				+                "\"value\":\"" + message.replace("\\", "\\\\") + "\"}\n" ;
		
		json += "]}\n";

		return json;
	}

	 void writeMessage(OutputStream out, byte[] data) throws IOException {
		int length = data.length;
		
		out.write(new byte[] {
				'Z', 'B', 'X', 'D', 
				'\1',
				(byte)(length & 0xFF), 
				(byte)((length >> 8) & 0x00FF), 
				(byte)((length >> 16) & 0x0000FF), 
				(byte)((length >> 24) & 0x000000FF),
				'\0','\0','\0','\0'});
		
		out.write(data);
	}
	
}
