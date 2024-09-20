package configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectSLQServer {
	private final String serverName = "DESKTOP-S9KCI2C\\MSSQLSERVER01";

	 private final String dbName = "LTWEB";

	 private final String portNumber = "1433";

	 private final String instance = "";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE

	 private final String userID = "sa";


	 private final String password = "123";



	 public Connection getConnection() throws Exception {


	 String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;


	 if (instance == null || instance.trim().isEmpty())

	 url = "jdbc:sqlserver://" + serverName + ";databaseName=" + dbName;

	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	 return DriverManager.getConnection(url, userID, password);

	 }



	 // Test chương trình. Kích phải chuột chọn run as->java application


	 public static void main(String[] args) {


	 try {


	 System.out.println(new DBConnectSLQServer().getConnection());


	 } catch (Exception e) {


	 e.printStackTrace();


	 }


	 }





}
