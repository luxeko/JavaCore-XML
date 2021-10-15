package Java2.src.Assignment.Manager;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Java2.src.Assignment.Manager.imp.IKhachHangDao;
import Java2.src.Assignment.Obj.KhachHang;
import Java2.src.Assignment.Obj.TaiKhoan;
import Java2.src.Assignment.Variable.ConnectionDB;

public class QuanLyKhachHang implements IKhachHangDao {
    // private List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
    private static Scanner sc = new Scanner(System.in);
    private SimpleDateFormat sdf_sql = new SimpleDateFormat("yyyy-MM-dd");
    Connection con = ConnectionDB.getInstance().getConnection();    

    //--------------- Hàm add khách hàng vào SQL -------------
    @Override
    public void createKhachHang(KhachHang kh){ 
        kh.input();
        //B1: kết nối đến database
        // Connection con = ConnectionDB.getInstance().getConnection();
        if(con == null){
            System.out.println("Connection failed!");
        }
        //B2: THUC HIEN SQL
        String sql_add = "insert into KhachHang (maKH, tenKH, CMT, soDT, email, ngaySinh, gioiTinh, adRess, loaiKH) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql_add);
            Date date_sql = Date.valueOf(sdf_sql.format(kh.getNgaySinh()));
            ps.setString(1,kh.getMaKH());
            ps.setString(2,kh.getTenKH());
            ps.setString(3,kh.getCmt());
            ps.setString(4,kh.getSoDT());
            ps.setString(5,kh.getEmail());
            ps.setDate(6,date_sql);
            ps.setString(7,kh.getGioiTinh());
            ps.setString(8,kh.getAddress());
            ps.setString(9,kh.getLoaikh());
            int result = ps.executeUpdate();
            ps.close();
            //B3:XU LY KET QUA
            if (result == 0)
                System.out.println("Tạo thất bại");
			else
				System.out.println("Tạo thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //B4:DONG KET NOI
        // ConnectionDB.getInstance().closeConnection(con);
    }
    
    //--------------- Hàm cập nhật 1 khách hàng dựa vào mã khách hàng ----------- 
    @Override
    public void updateKhachHang(KhachHang kh){
        kh.inputUpdate();
        //B1: kết nối đến database
        // Connection con = ConnectionDB.getInstance().getConnection();
        if(con == null){
            System.out.println("Connection failed!");
        }
        //B2: THUC HIEN SQL
        String sql_add = "exec CustomerUpdate ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
        try {
            CallableStatement ps = con.prepareCall(sql_add);
            Date date_sql = Date.valueOf(sdf_sql.format(kh.getNgaySinh()));
            ps.setString(1,kh.getMaKH());
            ps.setString(2,kh.getTenKH());
            ps.setString(3,kh.getCmt());
            ps.setString(4,kh.getSoDT());
            ps.setString(5,kh.getEmail());
            ps.setDate(6,date_sql);
            ps.setString(7,kh.getGioiTinh());
            ps.setString(8,kh.getAddress());
            ps.setString(9,kh.getLoaikh());
            // tham so out
		    ps.registerOutParameter(10, Types.INTEGER);
		    ps.registerOutParameter(11, Types.NVARCHAR);
            ps.executeUpdate();
            int result = ps.getInt(10);
            String response_message = ps.getString(11);
            ps.close();
            //B3:XU LY KET QUA
            if (result == 1){
                System.out.println(response_message);
            }else{
                System.out.println(response_message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //B4:DONG KET NOI
        // ConnectionDB.getInstance().closeConnection(con);
        
    }
    //--------------- Hàm xoá 1 khách hàng dựa vào mã khách hàng. Nếu khách hàng đã đăng ký tài khoản thì ko xoá dc
    @Override
    public void deleteKhachHang() {
        // Connection con = ConnectionDB.getInstance().getConnection();
        System.out.println("Nhập mã khách hàng để delete: ");
        String maKH = sc.nextLine();
        int flag = getIdTableKhachHang(maKH);
        if(flag == -1){
            System.out.println("Không tồn tại mã khách hàng!");
        }else if(flag == 1){
            System.out.println("Khách hàng đã đăng ký tài khoản nên ko thể xoá!");
        }
        else{
            if(con == null){
                System.out.println("Connection failed!");
            }
            String delete = "delete from KhachHang where maKH = ?";
            try {
                PreparedStatement ps = con.prepareStatement(delete);
                ps.setString(1, maKH);
                int result = ps.executeUpdate();
                ps.close();
                if(result == 0){
                    System.out.println("Xoá thất bại");
                }else{
                    System.out.println("Xoá thành công");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        // ConnectionDB.getInstance().closeConnection(con);
    } 
    
    /**Hàm lấy ra id của bảng KhachHang và đối chiếu với kh_id bên TaiKhoan
     * return = 1: tồn tại trong bảng KhachHang và = kh_id bên TaiKhoan => ko xoá
     * return = 0: tồn tại trong bảng KhachHang và != kh_id bên TaiKhoan => xoá
     * return = -1: ko tồn tại trong bảng KhachHang 
     */
    public int getIdTableKhachHang(String maKH){
        int id = 0;
        int count = 0;
        List<KhachHang> listKhachHang = displayListKhachHang();
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
        List<TaiKhoan> listTaiKhoan = qltk.displayListTaiKhoan();
        //check id có tồn tại trong KhachHang
        boolean flag = false;
        for(KhachHang kh : listKhachHang){
            if(maKH.equals(kh.getMaKH())){
                id = kh.getId();
                flag = true;
            }
        }        
        //Tồn tại id thì kiểm tra xem có trùng với kh_id bên TaiKhoan.
        if(flag == true){
            for(TaiKhoan tk : listTaiKhoan){
                if(id == tk.getKh_id()){
                    count++;
                }
            }
            //id không trùng kh_id, return 0;
            if(count == 0){
                return 0;
            }
            //id trùng kh_id, return 0;
            else{
                return 1;
            }
        }
        //Ko tồn tại id, return -1
        else{
            return -1;
        }
    }
    public List<KhachHang> displayList(){
        List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
        // Connection con = ConnectionDB.getInstance().getConnection();
        if(con == null){
            System.out.println("Connection failed!");
        }
        String sql = "select id, maKH, tenKH, CMT, soDT, email, ngaySinh, gioiTinh, adRess, loaiKH from KhachHang";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            boolean flag = false;
            System.out.format("%-10s %-10s %-20s %-20s %-20s %-20s %-20s %-15s %-20s %-20s\n",  
                            "ID",
                            "Mã KH",
                            "Tên khách hàng",
                            "CMT",
                            "SDT",
                            "Email",
                            "Ngày sinh",
                            "Giới tính",
                            "Address",
                            "Loại khách hàng");
            while (rs.next()) {
                flag = true;
                KhachHang kh = new KhachHang(
                    rs.getInt("id"),
                    rs.getString("maKH"),
                    rs.getString("tenKH"),
                    rs.getString("CMT"),
                    rs.getString("soDT"),
                    rs.getString("email"),
                    rs.getDate("ngaySinh"),
                    rs.getString("gioiTinh"),
                    rs.getString("adRess"),
                    rs.getString("loaiKH"));
                listKhachHang.add(kh);
            }
            for(KhachHang kh : listKhachHang){
                kh.output();
            }
            rs.close();
			ps.close();
            listKhachHang.clear();
            if (flag == false)
				System.out.println("Chưa có data");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ConnectionDB.getInstance().closeConnection(con);
        return listKhachHang;
    }    
    
    //------------- Hàm hiển thị danh sách ---------------------
    @Override
    public List<KhachHang> displayListKhachHang(){
        List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
        // Connection con = ConnectionDB.getInstance().getConnection();
        if(con == null){
            System.out.println("Connection failed!");
        }
        String sql = "select id, maKH, tenKH, CMT, soDT, email, ngaySinh, gioiTinh, adRess, loaiKH from KhachHang";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            boolean flag = false;
            System.out.format("%-10s %-10s %-20s %-20s %-20s %-20s %-20s %-15s %-20s %-20s\n",  
                            "ID",
                            "Mã KH",
                            "Tên khách hàng",
                            "CMT",
                            "SDT",
                            "Email",
                            "Ngày sinh",
                            "Giới tính",
                            "Address",
                            "Loại khách hàng");
            while (rs.next()) {
                flag = true;
                KhachHang kh = new KhachHang(
                    rs.getInt("id"),
                    rs.getString("maKH"),
                    rs.getString("tenKH"),
                    rs.getString("CMT"),
                    rs.getString("soDT"),
                    rs.getString("email"),
                    rs.getDate("ngaySinh"),
                    rs.getString("gioiTinh"),
                    rs.getString("adRess"),
                    rs.getString("loaiKH"));
                listKhachHang.add(kh);
            }
            for(KhachHang kh : listKhachHang){
                kh.output();
            }
            rs.close();
			ps.close();
            if (flag == false)
				System.out.println("Chưa có data");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ConnectionDB.getInstance().closeConnection(con);
        return listKhachHang;
    }    
}
