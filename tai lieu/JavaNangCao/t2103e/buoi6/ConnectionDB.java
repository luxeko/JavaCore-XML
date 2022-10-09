package buoi6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private static final String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=t2103e";
	private static final String userDb = "sa";
	private static final String passworDb = "123456";
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userDb, passworDb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
