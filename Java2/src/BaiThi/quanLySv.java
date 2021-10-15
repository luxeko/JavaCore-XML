package Java2.src.BaiThi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class quanLySv {
    public static  List<Student> danhSachSv = new ArrayList<Student>();
    public quanLySv() {
    }

    public static void addSV() {
		Student newStudent = new Student();
		newStudent.input();
		danhSachSv.add(newStudent);
	}
	public static void showList() {
		System.out.println("List Student In Collection");
		for(Student sv : danhSachSv) {
			System.out.println(sv.toString());
		}
	}
    //-----------------METHOD ADD STUDENT-------------
    public static void addAll() throws SQLException, CustomException {
        //B1: kết nối đến database
        Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CustomException("ERROR CONNECTION");
		}
        con.setAutoCommit(false);
		//B2: THUC HIEN SQL
		String sql_AddMonHoc = "insert into student(studentID, studentName, adress, phone) values(?, ?, ?, ?)";
        boolean flag = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql_AddMonHoc);
            for(Student sv : danhSachSv){
                ps.setString(1, sv.getStudentId());
				ps.setString(2, sv.getName());
				ps.setString(3, sv.getAdress());
				ps.setString(4, sv.getPhone());
                ps.addBatch();
                
            }int[] runsql = ps.executeBatch();
            ps.close();
            con.commit();
			con.rollback();
            danhSachSv.clear();
            if(flag) {
                System.out.println("Add Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
    }
}
