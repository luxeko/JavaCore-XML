package Java2.src.Assignment.Variable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static ConnectionDB instance;
    
    private ConnectionDB() {
    }
    public static synchronized ConnectionDB getInstance() {
		if(instance == null) {
			Constraint_Variable.loadConfigDB();
			instance = new ConnectionDB();
		}
		return instance;
	}

    //Create Connection
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(Constraint_Variable.url, Constraint_Variable.userDB, Constraint_Variable.passwordDB);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connect Successfully");
		return con;
	}
	//Close Connection
	public void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
            System.out.println("Connect close");
			} catch (SQLException e) {
				System.out.println("Connect Found "+ e.getMessage());
			}
		}
	}
}
