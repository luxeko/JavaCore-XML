package Buoi4_bt2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	//-----------------
	private static final String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=jdbcThucHanh2";
	private static final String userDB = "hieunguyen";
	private static final String passwordDB = "123456";
	
	//-----------------
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userDB, passwordDB);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("CONNECT SUCCESS");
		return con;
	}
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
}
