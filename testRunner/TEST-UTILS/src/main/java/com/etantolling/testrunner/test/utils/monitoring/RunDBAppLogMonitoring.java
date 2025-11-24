package com.etantolling.testrunner.test.utils.monitoring;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RunDBAppLogMonitoring{

	private static final String ZABBIX_SERVER_IP = "10.0.0.8";
	private static final int ZABBIX_SERVER_PORT = 10051;
	
	public static void main(String[] args) {

		try {
			String query = args[0];
			if(query == null)
				throw new Exception();
			
			selectRecordsFromTable(query);

		} catch (Exception e) {
			String msg = "USAGE: java nhquery.RunNHQuery DB_QUERY\r\nUsing database: ******";
			System.out.println(e.getMessage() + "\r\n\r\n" + msg);
		}
	}
	
	private static void selectRecordsFromTable(String query) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			//preparedStatement.setInt(1, 1001);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			
			List<String> result = new ArrayList<String>();
			while (rs.next()) {
				String line = "";
				for(int i = 1; i <= rsmd.getColumnCount(); i++) {
					line += rs.getObject(i) + " ";
				}
				result.add(line);
				System.out.println("QUERY RESULT: " + line);
			}
			
			
			Socket socket = new Socket(ZABBIX_SERVER_IP, ZABBIX_SERVER_PORT);
			try
			{
				String json = buildJSonString("NHDevDB", "applog", result);
				writeMessage(socket.getOutputStream(), json.getBytes());
				System.out.println("LOG SENT SUCCESSFULLY: \r\n" + json);
			}
			finally {
				socket.close();
			}
			

		} catch (Exception e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
	
	private static Connection getDBConnection() {
		String DB_HOST = "nhdevdb.cloudapp.net";
		String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
		String DB_PASSWORD = "IDeeSee";
		String DB_PORT = "1521";
		String DB_SID = "nhdevdb";
		String DB_USER = "nhdev";
		String DB_CONNECTION = "jdbc:oracle:thin:@" + DB_HOST + ":" + DB_PORT + ":" + DB_SID;

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}
	
	private static String buildJSonString(String host, String item, List<String> items)
	{
		String json = "{"
        + "\"request\":\"sender data\",\n"
        + "\"data\":[\n";
        
		String jsonData = "";
		for(String value : items) {
			jsonData += "{\n"
	        +                "\"host\":\"" + host + "\",\n"
	        +                "\"key\":\"" + item + "\",\n"
	        +                "\"value\":\"" + value.replace("\\", "\\\\") + "\"},\n" ;
		}
		json += jsonData.substring(0, jsonData.length()-2);
		json += "]}\n";
		
		return json;
	}

	protected static void writeMessage(OutputStream out, byte[] data) throws IOException {
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


