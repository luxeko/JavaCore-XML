package Exam_Package;

import java.util.ResourceBundle;

public class Constraint_Variable {

	public static String url;
	public static String userDB;
	public static String passwordDB;
	
	public static void loadConfigDB() {
		ResourceBundle rs = ResourceBundle.getBundle("Exam_Package.ConfigDB");
		if(rs.containsKey("database_Url")) {
			url = rs.getString("database_Url");
		}else {
			url ="jdbc:sqlserver://127.0.0.1:1433;databaseName=jdbcExam";
		}
		if(rs.containsKey("database_UserName")) {
			userDB = rs.getString("database_UserName");
		}else {
			userDB = "hieunguyen";
		}
		if(rs.containsKey("database_PassWord")) {
			passwordDB = rs.getString("database_PassWord");
		}else {
			passwordDB ="123456";
		}
	}
}
