package Java2.src.Assignment.Manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Java2.src.Assignment.Manager.imp.IGiaoDichDao;
import Java2.src.Assignment.Obj.GiaoDich;
import Java2.src.Assignment.Obj.TaiKhoan;
import Java2.src.Assignment.Variable.ConnectionDB;

public class QuanLyGiaoDich implements IGiaoDichDao {
    Connection con = ConnectionDB.getInstance().getConnection();
    private static Scanner sc = new Scanner(System.in);
    private SimpleDateFormat sdf_sql = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date date_Current = new java.util.Date();
    @Override
    public void createGiaoDich(String soTK, String loaiThaoTac, Double soTien ) {
        if(con == null){
            System.out.println("Connection failed!");
        }
        String sql = "insert into GiaoDich (soTK, loaiThaoTac, soTien, ngayGiaoDich, noiThucHien) values (?, ?, ?, ?, ?)";
        try {
            Date date_sql = Date.valueOf(sdf_sql.format(date_Current));
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, soTK);
            ps.setString(2, loaiThaoTac);
            ps.setDouble(3, soTien);
            ps.setDate(4, date_sql);
            ps.setString(5, "HaNoi");
            int result = ps.executeUpdate();
            ps.close();
            //B3:XU LY KET QUA
            if (result != 0)
                System.out.println("Lưu giao dịch thành công");
			else
				System.out.println("Lưu giao dịch thất bại!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void displayTransactionLogBysoTK() {
		List<GiaoDich> listGiaoDich = new ArrayList<GiaoDich>(); 
		QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
		String soTK;
		String dateStart;
		String dateEnd;
		System.out.print("Nhập số tài khoản: ");
		soTK = sc.nextLine();
		if (qltk.validateAccount(soTK) == true) {
			while (true) {
				System.out.print("Nhập thời gian bắt đầu: ");
				dateStart = sc.nextLine();
				try {
					sdf.parse(dateStart);
					if (dateStart != null)
						break;
				} catch (Exception e) {
					System.out.println("Ngày phải là định dạng 'dd/MM/yyyy'");
				}
			}
			while (true) {
				System.out.print("Nhập thời gian kết thúc: ");
				dateEnd = sc.nextLine();
				try {
					sdf.parse(dateEnd);
					if (dateEnd != null)
						break;
				} catch (Exception e) {
					System.out.println("Ngày phải là định dạng 'dd/MM/yyyy'");
				}
			}
			if (con == null)
				System.out.println("Connection failed");
			String sql = "select * from GiaoDich where ngayGiaoDich between convert(date, ?, 103) and convert(date, ?, 103) and soTK = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dateStart);
				ps.setString(2, dateEnd);
				ps.setString(3, soTK);
				ResultSet rs = ps.executeQuery();
				boolean flag = false;
                System.out.format("%-10s %-20s %-20s %-20s %-20s %-20s\n",  
                            "ID",
                            "Số TK",
                            "Loại thao tác",
                            "Số tiền",
                            "Ngày giao dịch",
                            "Nơi giao dịch");
				while (rs.next()) {
					flag = true;
					GiaoDich gd = new GiaoDich(
                        rs.getInt("id"),
                        rs.getString("soTK"),
                        rs.getString("loaiThaoTac"),
                        rs.getDouble("soTien"),
                        rs.getDate("ngayGiaoDich"),
                        rs.getString("noiThucHien"));
					listGiaoDich.add(gd);
				}
				for (GiaoDich o : listGiaoDich) {
					o.output();
				}
				if (flag == false)
					System.out.println("Data not found");
                rs.close();
                ps.close();
                listGiaoDich.clear();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else
			System.out.println("Số tài khoản không tồn tại");
	}
    public void displayTransactionLogByCustomerID() {
        List<TaiKhoan> listTaiKhoan = new ArrayList<TaiKhoan>();
		List<GiaoDich> listGiaoDich = new ArrayList<GiaoDich>(); 
		QuanLyTaiKhoan qltk = new QuanLyTaiKhoan();
		int kh_id;
		String dateStart;
		String dateEnd;
		System.out.print("Nhập ID khách hàng: ");
		kh_id = Integer.parseInt(sc.nextLine());
		if (qltk.validateKH_ID(kh_id) == true) {
            if (con == null){
                System.out.println("Connection failed");
            }
			String sql_id = "select soTK from TaiKhoan where kh_id = ?";
			try {
				PreparedStatement ps1 = con.prepareStatement(sql_id);
				ps1.setInt(1, kh_id);
				ResultSet rs1 = ps1.executeQuery();
				
				while (rs1.next()) {
					TaiKhoan tk  = new TaiKhoan (rs1.getString("soTK"));
                    listTaiKhoan.add(tk);
				}
                rs1.close();
                ps1.close();
			} catch (SQLException e) {
				e.printStackTrace(); 
            }
            while (true) {
                System.out.print("Nhập ngày bắt đầu: ");
                dateStart = sc.nextLine();
                try {
                    sdf.parse(dateStart);
                    if (dateStart != null)
                        break;
                } catch (Exception e) {
                    System.out.println("Ngày phải là định dạng 'dd/MM/yyyy'");
                }
            }
            while (true) {
                System.out.print("Nhập ngày kết thúc: ");
                dateEnd = sc.nextLine();
                try {
                    sdf.parse(dateEnd);
                    if (dateEnd != null)
                        break;
                } catch (Exception e) {
                    System.out.println("Ngày phải là định dạng 'dd/MM/yyyy'");
                }
            }
            System.out.format("%-10s %-20s %-20s %-20s %-20s %-20s\n",  
                            "ID",
                            "Số TK",
                            "Loại thao tác",
                            "Số tiền",
                            "Ngày giao dịch",
                            "Nơi giao dịch");
            for(TaiKhoan tk : listTaiKhoan){
                tk.getSoTK();
                String sql_soTK = "select * from GiaoDich where ngayGiaoDich between convert(date, ?, 103) and convert(date, ?, 103) and soTK = ?";
                try {
                    PreparedStatement ps2 = con.prepareStatement(sql_soTK);
                    ps2.setString(1, dateStart);
                    ps2.setString(2, dateEnd);
                    ps2.setString(3, tk.getSoTK());
                    ResultSet rs2 = ps2.executeQuery();
                    boolean flag2 = false;
                    while (rs2.next()) {
                        flag2 = true;
                        GiaoDich gd = new GiaoDich(
                                rs2.getInt("id"),
                                rs2.getString("soTK"),
                                rs2.getString("loaiThaoTac"),
                                rs2.getDouble("soTien"),
                                rs2.getDate("ngayGiaoDich"),
                                rs2.getString("noiThucHien"));
                        listGiaoDich.add(gd);
                    }
                    for (GiaoDich o : listGiaoDich) {
                        o.output();;
                    }
                    if (flag2 == false)
                        System.out.println("Data not found");
                    rs2.close();
                    ps2.close();
                    listGiaoDich.clear();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
		} else
			System.out.println("ID khách hàng không tồn tại!");
	}
    
}
