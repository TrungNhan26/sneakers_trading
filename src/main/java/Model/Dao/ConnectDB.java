package Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	static String serverName = "LAPTOP-0DP7SHTA\\SQLEXPRESS";
	static String db = "cnw";
	static String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName =" + db + ";encrypt=true;trustServerCertificate=true;";
	static String user = "sa";
	static String pass = "123456";

	public static Connection getConnection() {// connection function
		Connection cnn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cnn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnn;	
	}
}
