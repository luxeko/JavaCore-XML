package Exam_Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentDao {
	public static Map<String,Student> listStu = new LinkedHashMap<String, Student>();
	
	
	public static void addStuList() {
		Student newStudent = new Student();
		newStudent.addInfo();
		listStu.put(newStudent.getStudentID(), newStudent);
	}
	public static void showStuList() {
		System.out.println("List Student In Collection");
		addTitle();
		for(Map.Entry<String, Student> sv : listStu.entrySet()) {
			System.out.println(sv.getValue());
		}
	}
	public static void addListStu() throws SQLException {
		//B1:Connection DB
		Connection con = DB_Connection1.getInstance().getConnection();
		if(con == null) {
			System.out.println("Error Connection");
		}
		con.setAutoCommit(false);
		//B2:Create SQL Query
		String sql_add = "Insert Into Student(StudentId,StudentName,Address,Phone) Values(?,?,?,?)";
		boolean flag = false;
		try {
			PreparedStatement ps =con.prepareStatement(sql_add);
			for(Map.Entry<String, Student> sv : listStu.entrySet()) {
				ps.setString(1, sv.getValue().getStudentID());
				ps.setString(2, sv.getValue().getName());
				ps.setString(3, sv.getValue().getAddress());
				ps.setString(4, sv.getValue().getPhone());
				ps.addBatch();
				
			}
			int[] run = ps.executeBatch();
			if(flag) {
				System.out.println("Add Successfully");
			}
			//Clear All Element In Map
			listStu.clear();
			//B3:
			ps.close();
			con.commit();
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//B4:Close Connection
		DB_Connection1.getInstance().CloseConnection(con);
		
	}
	public static void addTitle() {
		System.out.println("StudentID             "+"Student Name             "+"Address             "+"Phone             ");
	}
}
