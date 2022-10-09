package Exam_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection1 {
	private static DB_Connection1 instance;
	
	private DB_Connection1() {
		
	}
	public synchronized static DB_Connection1 getInstance() {
		if(instance == null) {
			Constraint_Variable.loadConfigDB();
			instance = new DB_Connection1();
		}
		return instance;
	}
	//Create Connection
	public Connection getConnection() {
		Connection con = null;
		try {
			con =DriverManager.getConnection(Constraint_Variable.url, Constraint_Variable.userDB, Constraint_Variable.passwordDB);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connect Successfully");
		return con;
	}
	//Close Connection
	public void CloseConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Connect Found "+e.getMessage());
		}
	}
}
