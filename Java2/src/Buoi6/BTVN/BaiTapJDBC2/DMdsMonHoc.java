package Java2.src.Buoi6.BTVN.BaiTapJDBC2;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class DMdsMonHoc {
    //----------FIELD-----------
    private static Scanner sc = new Scanner(System.in);
    //-----------MEHTHOD-----------
    public static void showMenu() {
        boolean check = true;
        int choose;
        do{
            System.out.println("3.1 Thêm môn học");
            System.out.println("3.2 Cập nhât thông tin 1 môn học");
            System.out.println("3.3 Xoá 1 môn học");
            System.out.println("3.4 Hiển thị danh sách môn học");
            System.out.println("3.5 Thêm nhiều bản ghi môn học từ file txt");
            System.out.println("3.6 Thoát");
            System.out.println("Choose: ");
            try {
                choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        addMonHoc();
                        break;
                    case 2:
                        updateMH();
                        break;
                    case 3: 
                        xoaMonHoc();
                        break;
                    case 4:
                        findMonHoc();
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("Kết thúc!");
                        break;
                    default:
                        System.out.println("Nhập sai!. Vui lòng nhập lại");
                }
                if(choose == 6) check = false;
            } catch (Exception e) {
                System.out.println("ERROR FOUND  " + e.getMessage());
				e.printStackTrace();
            }

        }while(check == true);
    }
    //-----------------METHOD ADD MONHOC-------------
    public static void addMonHoc() throws CustomException, SQLException {
        //B1: kết nối đến database
        Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CustomException("ERROR CONNECTION");
		}
		//B2: THUC HIEN SQL
		String sql_AddMonHoc = "insert into MonHoc(maMonHoc, tenMonHoc) values(?, ?)";
		PreparedStatement ps = con.prepareStatement(sql_AddMonHoc);
		DMMonHoc mh = new DMMonHoc();
		mh.addInfoMonHoc();
		ps.setString(1,mh.getMaMonHoc());
		ps.setString(2,mh.getTenMonHoc());
		int runsql = ps.executeUpdate();
		ps.close();
		//B3:XU LY KET QUA
		if(runsql == 0) {
			throw new CustomException("Error found add");
		}else {
			System.out.println("Thao tác thành công");
		}
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
    }

    //---------------METHOD SHOW DSMONHOC----------------------
    public static void hienThiDanhSach() throws CustomException, SQLException {
        //B1: kết nối đến database
        Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CustomException("ERROR CONNECTION");
		}
        //B2: THUC HIEN SQL
        String sql_show = "SELECT MAMONHOC,TENMONHOC FROM DMMonHoc";
        Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql_show);
		while(rs.next()) {
			String mamh = rs.getString(1);
			String tenmh = rs.getString(2);
			System.out.println(mamh +"   "+ tenmh );
		}
		//B3:XU LY KET QUA
		rs.close();
		st.close();
		//B4: DONG KET NOI
		ConnectionDB.closeConnection(con);		
    }
    //---------------METHOD XOA MONHOC----------------------
    public static void xoaMonHoc() throws CustomException, SQLException {
        //B1: kết nối đến database
        Connection con = ConnectionDB.getConnection();
        if(con == null) {
            throw new CustomException("ERROR CONNECTION");
        }
        //B2: THUC HIEN SQL
		String sql_deleteMH = "DELETE FROM DMMonHoc WHERE MAMONHOC = ?";
		PreparedStatement ps = con.prepareStatement(sql_deleteMH);
		System.out.print("Nhập mã môn học muốn xoá: ");
		String mamonhoc = sc.nextLine();
		ps.setString(1, mamonhoc);
		int runsql = ps.executeUpdate();
		ps.close();
		//B3:XU LY KET QUA
		if(runsql == 0) {
			throw new CustomException("ERROR FOUND! Kiểm tra lại mã môn học");
		}else {
			System.out.println("Thao tác thành công");
		}
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
    }
    //-----------------METHOD CAP NHAT--------------------
    public static void updateMH() throws CustomException, SQLException {
        //B1: kết nối đến database
        Connection con = ConnectionDB.getConnection();
        if(con == null) {
            throw new CustomException("ERROR CONNECTION");
        }
        //B2: THUC HIEN SQL
		String sql_updateMN = "EXEC update DMMonHoc ?,?,?";
		CallableStatement cs = con.prepareCall(sql_updateMN);
		DMMonHoc newmh = new DMMonHoc();
		newmh.addInfoMonHoc();
		cs.setString(1, newmh.getMaMonHoc());
		cs.setString(2, newmh.getTenMonHoc());
		cs.registerOutParameter(3, Types.NVARCHAR);
		String mess = cs.getString(3);
		cs.close();
		//B3:XY LU KET QUA
		if(mess == null) {
			System.out.println("Thao tác thành công");
		}else {
			System.out.println("Không thành công! Vui lòng kiểm tra mã môn học");
		}
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
    }
    //-----------------METHOD FIND MONHOC----------------
    public static void findMonHoc() throws CustomException, SQLException {
        //B1: kết nối đến database
        Connection con = ConnectionDB.getConnection();
        if(con == null) {
            throw new CustomException("ERROR CONNECTION");
        }
        //B2: KET NOI SQL
		String sql_findMH = "SELECT MAMONHOC,TENMONHOC FROM MonHoc WHERE MAMONHOC = ?";
		PreparedStatement ps = con.prepareStatement(sql_findMH);
		System.out.print("Nhập mã môn học cần tìm: ");
		String mamonhoc = sc.nextLine();
		ps.setString(1,mamonhoc);
		ResultSet rs = ps.executeQuery();  
		while(rs.next()){  
			System.out.println("Mã môn học: "+rs.getString(1)+"    "+"Tên môn học: "+rs.getString(2));  
			}  
		//B3:XU LY KET QUA
		ps.close();
		rs.close();
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
    }
}
