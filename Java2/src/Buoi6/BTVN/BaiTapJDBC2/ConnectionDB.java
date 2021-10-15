package Java2.src.Buoi6.BTVN.BaiTapJDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=QuanLySv";
    private static final String userDb = "DucAnh";
    private static final String passwordDb = "Khongnoiduoc1";

    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, userDb, passwordDb);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Connect succes!");
        return con;
    }
        
    public static void closeConnection(Connection con) {
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
