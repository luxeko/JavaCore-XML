package assignment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
	// B1: TAO BIEN PRIVATE DUY NHAT CUA CLASS
	private static ConnectionDb instance;
	// B2: TAO 1 PRIVATE CONSTRUCTOR DUY NHAT CUA CLASS
	private ConnectionDb() {
		
	}
	// B3: TAO 1 HAM TRA VE DOI TUONG/INSTANCE DUY NHAT CUA CLASS -> STATIC
	public static synchronized ConnectionDb getInstance() {
		if (instance == null) {
			instance = new ConnectionDb();
		}
		return instance;
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(Constant.URL, Constant.USER_DB, Constant.PASSWORD_DB);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public void closeConnection(Connection con) {
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
