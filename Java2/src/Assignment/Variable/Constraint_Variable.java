package Java2.src.Assignment.Variable;

import java.util.ResourceBundle;

public class Constraint_Variable {
    public static String url;
	public static String userDB;
	public static String passwordDB;

    public static void loadConfigDB() {
		ResourceBundle rs = ResourceBundle.getBundle("Java2.src.Assignment.Variable.ConfigDB");
		if(rs.containsKey("database_Url")) {
			url = rs.getString("database_Url");
		}else {
			url ="jdbc:sqlserver://127.0.0.1:1433;databaseName=NganHang";
		}
		if(rs.containsKey("database_UserName")) {
			userDB = rs.getString("database_UserName");
		}else {
			userDB = "DucAnh";
		}
		if(rs.containsKey("database_PassWord")) {
			passwordDB = rs.getString("database_PassWord");
		}else {
			passwordDB ="123456";
		}
	}
}
