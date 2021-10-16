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
import Java2.src.Assignment.Manager.imp.ITaiKhoanDao;
import Java2.src.Assignment.Obj.TaiKhoan;
import Java2.src.Assignment.Variable.ConnectionDB;

public class QuanLyTaiKhoan implements ITaiKhoanDao {
    Connection con = ConnectionDB.getInstance().getConnection();
    private static Scanner sc = new Scanner(System.in);
    private SimpleDateFormat sdf_sql = new SimpleDateFormat("yyyy-MM-dd");
    //--------------- Hàm add tài khoản vào SQL -------------
    @Override
    public void createAccount(TaiKhoan tk) {
        tk.input();
        //B1: kết nối đến database
        //   Connection con = ConnectionDB.getInstance().getConnection();
        if(con == null){
            System.out.println("Connection failed!");
        }
        //B2: THUC HIEN SQL
        String sql_add = "insert into TaiKhoan (kh_id, soTK, loaiTK, trangThai, ngayTao, soTien, hanMuc) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql_add);
            Date date_sql = Date.valueOf(sdf_sql.format(tk.getNgayTao()));
            ps.setInt(1,tk.getKh_id());
            ps.setString(2,tk.getSoTK());
            ps.setString(3,tk.getLoaiTK());
            ps.setString(4,tk.getTrangThai());
            ps.setDate(5,date_sql);
            ps.setDouble(6,tk.getSoTien());;
            ps.setDouble(7,tk.getHanMuc());
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
      //   ConnectionDB.getInstance().closeConnection(con); 
    }

    //Hàm lấy ra tài khoản trả trước và số tiền trong tài khoản để nạp tiền
    @Override
    public void payinAccount() {
        QuanLyGiaoDich qlgd = new QuanLyGiaoDich();
        Double napTien;
        String soTK;
        String trangThai = "Active";
        System.out.println("Nhập số tài khoản: ");
        soTK = sc.nextLine();
        String chon = "";
        //lấy ra số tiền của tài khoản
        Double amount = queryAmountByAccountId(soTK);
        //check tài khoản tồn tại hay ko? true == tồn tại
        if(validateAccount(soTK) == true){
           //check loại tài khoản là thường hay visa? == 0 là tk thường
           if(checkLoaiTK(soTK) == 0){ 
               //check xem tài khoản đã actice? == 1 là disable, 0 là active
               if(checkActive(soTK) == false){
                   System.out.println("Tài khoản của bạn đang Disable! Bạn có muốn Active? Chọn 'y' để đồng ý");
                   while (true) {
                        chon = sc.nextLine();
                        if(chon.equals("y")){
                            System.out.println("Active thành công");
                            UpdateTrangThai(soTK, "TraTruoc", trangThai);
                            break;
                        }else{
                            break;
                        }
                   }
               }else if(checkActive(soTK) == true){
                    System.out.println("Số tiền trong tài khoản " + soTK + " là : " +  amount);
                    System.out.println("Nhập số tiền thêm vào: ");
                    try {
                    napTien = Double.parseDouble(sc.nextLine());
                    if(napTien > 0){
                        amount+=(Double) napTien;
                        //sau khi nạp thì update lại số tiền trong database
                        UpdateAmountByAccountId(soTK, amount);
                        qlgd.createGiaoDich(soTK, "NapTien", napTien);
                    }else{
                        System.out.println("Số tiền bắt buộc phải > 0");
                    }
                    } catch (NumberFormatException e) {
                        System.out.println("Số tiền phải là kiểu số");
                    }
               }
               
            }else{
                System.out.println("Bạn chỉ có thể nạp tiền vào tài khoản trả trước!");
            }
        }else{
            System.out.println("Tài khoản không tồn tại!");
        }
   }
   //Hàm rút tiền
   @Override
    public void withdrawAccount() {
        QuanLyGiaoDich qlgd = new QuanLyGiaoDich();
        Double rutTien;
        String soTK;
        String trangThai = "Active";
        String chon = "";
        System.out.println("Nhập số tài khoản: ");
        soTK = sc.nextLine();
        //lấy ra số tiền của tài khoản
        Double amount = queryAmountByAccountId(soTK);
        int hanMuc = getHanMucByAcc(soTK);
        //check tài khoản tồn tại hay ko? true == tồn tại
        if(validateAccount(soTK) == true){
            //check loại tài khoản là thường hay visa?  0: là tk thường, 1: visa
            if(checkLoaiTK(soTK) == 0){
                if(checkActive(soTK) == false){
                    System.out.println("Tài khoản của bạn đang Disable! Bạn có muốn Active? Chọn 'y' để đồng ý");
                    while (true) {
                         chon = sc.nextLine();
                         if(chon.equals("y")){
                             System.out.println("Active thành công");
                             UpdateTrangThai(soTK, "TraTruoc", trangThai);
                             break;
                         }else{
                             break;
                         }
                    }
                }else{
                    System.out.println("Số tiền có trong tài khoản: " + (Double)amount);
                    System.out.println("Hạn mức: " +  hanMuc);
                    System.out.println("Nhập số tiền muốn rút: ");
                    try {
                        rutTien = Double.parseDouble(sc.nextLine());
                        if(rutTien > 0){
                            if(rutTien <= hanMuc){
                                if(rutTien <= amount){
                                    amount -= (Double) rutTien;
                                    UpdateAmountByAccountId(soTK, amount);
                                    qlgd.createGiaoDich(soTK, "RutTien", rutTien);
                                }else{
                                    System.out.println("Số tiền trong tài khoản không đủ!");
                                }
                            }else{
                                System.out.println("Bạn không được rút quá hạn mức: " + hanMuc);
    
                            }
                        }else{
                            System.out.println("Số tiền phải là số dương");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Số tiền phải là kiểu số!");
                    }
                }
            }else{
                if(checkActive(soTK) == false){
                    System.out.println("Tài khoản của bạn đang Disable! Bạn có muốn Active? Chọn 'y' để đồng ý");
                    while (true) {
                         chon = sc.nextLine();
                         if(chon.equals("y")){
                             System.out.println("Active thành công");
                             UpdateTrangThai(soTK, "TraSau (VISA)", trangThai);
                             break;
                         }else{
                             break;
                         }
                    }
                }else{
                    System.out.println("Hạn mức: " +  hanMuc);
                    System.out.println("Nhập số tiền muốn rút: ");
                    try {
                        rutTien = Double.parseDouble(sc.nextLine());
                        if(rutTien > 0){
                            if(amount >= rutTien && amount >= 0){
                                amount -= (Double) rutTien;
                                hanMuc -= (Double) rutTien;
                                checkHanMuc(soTK, amount, hanMuc);
                                qlgd.createGiaoDich(soTK, "RutTien", rutTien);
                            }else{
                                System.out.println("Bạn đã rút tối đa hạn mức cho phép!");
                            }
                        }else{
                            System.out.println("Số tiền phải là số dương");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Số tiền phải là kiểu số!");
                    }
                }
            }
        }else{
           System.out.println("Tài khoản không tồn tại!");
        }
    }
    // Hàm update số tiền trong tài khoản khi đã nạp tiền/rút tiền
	public void UpdateAmountByAccountId(String soTK, Double soTien) {
        // Connection con = ConnectionDB.getInstance().getConnection();
		if (con == null){
            System.out.println("Connection failed");
        }
		String sql = "exec TaiKhoanUpdate ?, ?, ?, ?";
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, soTK);
			cs.setDouble(2, soTien);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.NVARCHAR);
			cs.executeUpdate();
			int code_res = cs.getInt(3);
			String mess_res = cs.getString(4);
			cs.close();
			if (code_res == 0){
            System.out.println(mess_res);
        }else{
            System.out.println(mess_res);
            System.out.println("Số tiền còn trong tài khoản: " + (Double) soTien);
        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ConnectionDB.getInstance().closeConnection(con);
	}

    // Hàm update số hạn mức trong tài khoản
	public void checkHanMuc(String soTK, Double soTien, int hanMuc ) {
        // Connection con = ConnectionDB.getInstance().getConnection();
		if (con == null){
            System.out.println("Connection failed");
        }
		String sql = "exec HanMucUpdate ?, ?, ?, ?, ?";
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, soTK);
            cs.setDouble(2, soTien);
			cs.setInt(3, hanMuc);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.registerOutParameter(5, Types.NVARCHAR);
			cs.executeUpdate();
			int code_res = cs.getInt(4);
			String mess_res = cs.getString(5);
			cs.close();
			if (code_res == 0){
            System.out.println(mess_res);
        }else{
            System.out.println(mess_res);
            System.out.println("Số hạn mức còn trong tk: " + hanMuc);
        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ConnectionDB.getInstance().closeConnection(con);
	}

    // Account ton tai: true
	// Account khong ton tai: false
    public boolean validateAccount(String accountID){
        List<TaiKhoan> listTaiKhoan = displayListTaiKhoan();
        for (TaiKhoan tk : listTaiKhoan){
            if(accountID.equals(tk.getSoTK())){
                return true;
            }
        }return false;
    }
    
    //hàm lấy ra số tiền trong tài khoản
    public Double queryAmountByAccountId(String soTK){
        TaiKhoan tk = new TaiKhoan();
		// Connection con = ConnectionDB.getInstance().getConnection();
		if (con == null){
            System.out.println("Connection failed");
        }
		String sql = "select soTK, soTien from TaiKhoan where soTK = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, soTK);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tk = new TaiKhoan(rs.getString("soTK"),rs.getDouble("soTien"));
			}
         rs.close();
         ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ConnectionDB.getInstance().closeConnection(con);
		return tk.getSoTien();
    }
    //hàm lấy ra số hạn mức trong tài khoản
    public int getHanMucByAcc(String soTK){
        TaiKhoan tk = new TaiKhoan();
        // Connection con = ConnectionDB.getInstance().getConnection();
        if (con == null){
           System.out.println("Connection failed");
        }
        String sql = "select soTK,hanMuc from TaiKhoan where soTK = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, soTK);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tk = new TaiKhoan(rs.getString("soTK") , rs.getInt("hanMuc"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ConnectionDB.getInstance().closeConnection(con);
        return tk.getHanMuc();
    }

    //Hàm lấy ra trạng thái tài khoản
    public boolean checkActive(String soTK) {
        List<TaiKhoan> listTaiKhoan = new ArrayList<TaiKhoan>();
        if (con == null){
            System.out.println("Connection failed");
        }
        String sql = "select soTK,loaiTK, trangThai from TaiKhoan where soTK = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, soTK);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(rs.getString("soTK"), rs.getString("loaiTK"), rs.getString("trangThai"));
                listTaiKhoan.add(tk);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(TaiKhoan tk : listTaiKhoan){
            if(tk.getTrangThai().equals("Active"))
            return true;
        }
        return false;
    }

    //Hàm update trạng thái vào database
    public void UpdateTrangThai(String soTK, String loaiTK, String trangThai) {
        // Connection con = ConnectionDB.getInstance().getConnection();
		if (con == null){
            System.out.println("Connection failed");
        }
		String sql = "exec TrangThaiUpdate ?, ?, ?, ?, ?";
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, soTK);
			cs.setString(2, loaiTK);
            cs.setString(3, trangThai);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.registerOutParameter(5, Types.NVARCHAR);
			cs.executeUpdate();
			int code_res = cs.getInt(4);
			String mess_res = cs.getString(5);
			cs.close();
			if (code_res == 0){
            System.out.println(mess_res);
        }else{
            System.out.println(mess_res);
        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ConnectionDB.getInstance().closeConnection(con);
	}
    //hàm check loại tài khoản
    //nếu là TraTruoc thì return 0
    //ngược lại return 1;
    public int checkLoaiTK(String soTK) {
        List<TaiKhoan> listTaiKhoan = new ArrayList<TaiKhoan>();
        //  Connection con = ConnectionDB.getInstance().getConnection();
        if(con == null){
            System.out.println("Connection failed!");
        }
        String sql = "select soTK, loaiTK, trangThai from TaiKhoan where soTK = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, soTK);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(rs.getString("soTK"), rs.getString("loaiTK"), rs.getString("trangThai"));
                listTaiKhoan.add(tk);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //   ConnectionDB.getInstance().closeConnection(con);
        for(TaiKhoan tk : listTaiKhoan){
            if(tk.getLoaiTK().equalsIgnoreCase("TraTruoc")){
                return 0;
            }
        }
        return 1;
    }

    @Override
    public List<TaiKhoan> displayAccountInfoByAccountId() {
        List<TaiKhoan> listTaiKhoan = new ArrayList<TaiKhoan>();
        System.out.println("Nhập số tài khoản: ");
        String soTKfind = sc.nextLine();
        if(validateAccount(soTKfind) == true){
            // Connection con = ConnectionDB.getInstance().getConnection();
            if(con == null){
                System.out.println("Connection failed!");
            }
            String sql = "select id, kh_id, soTK, loaiTK, trangThai, ngayTao, soTien, hanMuc from TaiKhoan where soTK = ? ";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, soTKfind);
                ResultSet rs = ps.executeQuery();
                boolean flag = false;
                System.out.format("%-10s %-10s %-10s %-15s %-15s %-20s %-20s %-20s\n",  
                                    "ID",
                                    "ID_KH",
                                    "Số TK",
                                    "Loại TK",
                                    "Trạng thái",
                                    "Ngày tạo",
                                    "Số tiền",
                                    "Hạn mức");
                while (rs.next()) {
                    flag = true;
                    TaiKhoan tk = new TaiKhoan(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getDouble(7),
                        rs.getInt(8));
                    listTaiKhoan.add(tk);
                }
                for(TaiKhoan tk : listTaiKhoan){
                    tk.output();
                }
                if (flag == false)
					System.out.println("Không tìm thấy data");
                rs.close();
                ps.close();
                listTaiKhoan.clear();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // ConnectionDB.getInstance().closeConnection(con);
        }else{
            System.out.println("Số tài khoản không tồn tại!");
        }
        return listTaiKhoan;
    }

    //kh_id ton tai: true
    //nguoc lai: false
    public boolean validateKH_ID(int kh_id){
        List<TaiKhoan> listTaiKhoan = displayListTaiKhoan();
        for(TaiKhoan tk : listTaiKhoan){
            if(kh_id == tk.getKh_id()){
                return true;
            }
        }
        return false;
    }
    @Override
    public List<TaiKhoan> displayAccountByCustomerId() {
        List<TaiKhoan> listTaiKhoan = new ArrayList<TaiKhoan>();
        System.out.print("Nhập id của khách hàng: ");
        int kh_id = Integer.parseInt(sc.nextLine());
        if ( validateKH_ID(kh_id) == true) {
            // Connection con = ConnectionDB.getInstance().getConnection();
            if(con == null){
                System.out.println("Connection failed!");
            }
            String sql = "select id, kh_id, soTK, loaiTK, trangThai, ngayTao, soTien, hanMuc from TaiKhoan where kh_id = ? ";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, kh_id);
                ResultSet rs = ps.executeQuery();
                boolean flag = false;
                System.out.format("%-10s %-10s %-10s %-15s %-15s %-20s %-20s %-20s\n",  
                                    "ID",
                                    "ID_KH",
                                    "Số TK",
                                    "Loại TK",
                                    "Trạng thái",
                                    "Ngày tạo",
                                    "Số tiền",
                                    "Hạn mức");
                while (rs.next()) {
                    flag = true;
                    TaiKhoan account = new TaiKhoan(
                            rs.getInt(1), 
                            rs.getInt(2), 
                            rs.getString(3), 
                            rs.getString(4),
                            rs.getString(5), 
                            rs.getDate(6), 
                            rs.getDouble(7), 
                            rs.getInt(8));
                    listTaiKhoan.add(account);
                }
                for(TaiKhoan tk : listTaiKhoan){
                    tk.output();
                }
                if (flag == false)
                    System.out.println("No data found");
                rs.close();
                ps.close();
                listTaiKhoan.clear();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else
            System.out.println("Không tìm thấy id khách hàng");
        return listTaiKhoan;
    }

    @Override
    public List<TaiKhoan> displayListTaiKhoan() {
         List<TaiKhoan> listTaiKhoan = new ArrayList<TaiKhoan>();
      //   Connection con = ConnectionDB.getInstance().getConnection();
        if(con == null){
            System.out.println("Connection failed!");
        }
        String sql = "select id, kh_id, soTK, loaiTK, trangThai, ngayTao, soTien, hanMuc from TaiKhoan";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            boolean flag = false;
            while (rs.next()) {
                flag = true;
                TaiKhoan tk = new TaiKhoan();
                tk.setId(rs.getInt("id"));
                tk.setKh_id(rs.getInt("kh_id"));
                tk.setSoTK(rs.getString("soTK"));
                tk.setLoaiTK(rs.getString("loaiTK"));
                tk.setTrangThai(rs.getString("trangThai"));
                tk.setNgayTao(rs.getDate("ngayTao"));
                tk.setSoTien(rs.getDouble("soTien"));
                tk.setHanMuc(rs.getInt("hanMuc"));
                listTaiKhoan.add(tk);
            }
            rs.close();
            ps.close();
            if (flag == false){
                System.out.println("Chưa có data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //   ConnectionDB.getInstance().closeConnection(con);
        return listTaiKhoan;
    }
    public String getAccountIdByKH_ID() {
        TaiKhoan tk = new TaiKhoan();
        int kh_id = Integer.parseInt(sc.nextLine());
		if (validateKH_ID(kh_id) == true) {
			if (con == null)
				System.out.println("Connection failed");
			String sql = "select soTK from TaiKhoan where kh_id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, kh_id);
				ResultSet rs = ps.executeQuery();
				boolean flag = false;
				while (rs.next()) {
					flag = true;
					tk = new TaiKhoan (rs.getString("soTK"));
				}
				
				if (flag == false)
					System.out.println("No data found");
			} catch (SQLException e) {
				e.printStackTrace(); 
            }
		} else{
            System.out.println("ID khách hàng không tồn tại");
        }
        return  tk.getSoTK();	
		
	}
    
}
