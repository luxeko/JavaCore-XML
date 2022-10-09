package Buoi4_bt2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SINHVIENDAO {
	private static String root = System.getProperty("user.dir");
	private static File fileRoot = new File(root);
	private static Scanner sc = new Scanner(System.in);
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat fmdate = new SimpleDateFormat("dd/MM/yyyy");
	// ---------------------------
	// METHOD

	// METHOD MENU SINH VIEN
	public static void menuSV() {
		String confirm = "";
		boolean flag = false;
		do {
			System.out.println("MENU CRUD SINH VIEN");
			System.out.println("====================");
			System.out.println("1: THEM 1 SINH VIEN");
			System.out.println("2: CAP NHAT 1 DOI TUONG SINH VIEN BANG MA SINH VIEN NHAP TU BAN PHIM");
			System.out.println("3: XOA 1 DOI TUONG SINH VIEN KHI NHAP MA KHOA TU BAN PHIM");
			System.out.println("4: HIEN THI DS SINH VIEN");
			System.out.println("5: THEM 1 LIST SINH VIEN TU 1 FILE TXT");
			System.out.println("6: TIM KIEM SINH VIEN THONG QUA MA SINH VIEN");
			System.out.println("7: THOAT!");
			System.out.print("NHAP LUA CHON: ");
			try {
				int choose = sc.nextInt();
				sc.nextLine();
				switch (choose) {
				case 1:
					addSV();
					break;
				case 2:
					updateSV();
					break;
				case 3:
					deteleSV();
					break;
				case 4:
					showSVList();
					break;
				case 5:
					addLISTSV();
					break;
				case 6:
					
					break;
				case 7:
					flag = true;
					break;
				default:
					System.out.println("VUI LONG NHAP THEO MENU");
					break;
				}
				if (!flag) {
					System.out.print("BAN CO MUON TIEP TUC VOI MENU SINH VIEN(n:THOAT!): ");
					confirm = sc.nextLine();
				}
			} catch (Exception e) {
				sc.nextLine();
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		} while (!confirm.equalsIgnoreCase("n") && !flag);
	}

	// METHOD THEM 1 SINH VIEN
	public static void addSV() throws CS_EXCEPTION {
		// NHAP THONG TIN SINH VIEN
		SinhVien newSinhVien = new SinhVien();
		newSinhVien.addInfoSV();
		// THEM VAO DB
		// B1: CONNECT DB
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CS_EXCEPTION("CONNECTION FAILED");
		}
		// B2: THUC THI SQL
		String sql_addSV = "INSERT INTO SINHVIEN(MASV,TENSV,NGAYSINH,PHONE,EMAIL,DIACHI,GIOITINH,MAKHOA) VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql_addSV);
			// BIND THAM SO
			Date sql_date = Date.valueOf(dateFormat.format(newSinhVien.getNgaySinh()));
			ps.setString(1, newSinhVien.getMaSV());
			ps.setString(2, newSinhVien.getTenSV());
			ps.setDate(3, sql_date);
			ps.setString(4, newSinhVien.getPhone());
			ps.setString(5, newSinhVien.getEmail());
			ps.setString(6, newSinhVien.getDiachi());
			ps.setString(7, newSinhVien.getGioitinh());
			ps.setString(8, newSinhVien.getMaKhoa());
			int flagAddSV = ps.executeUpdate();
			ps.close();
			// B3: XU LY KET QUA
			if (flagAddSV == 0) {
				System.out.println("THEM SINH VIEN CHUA THANH CONG");
			} else {
				System.out.println("THAO TAC THANH CONG");
			}
		} catch (SQLException e) {
			System.out.println("ERROR FOUND  " + e.getMessage());
		}
		// B4: DONG KET NOI
		ConnectionDB.closeConnection(con);
	}

	// METHOD CAP NHAT 1 DOI TUONG SINH VIEN
	public static void updateSV() throws CS_EXCEPTION, SQLException {
		// B1: TAO CONNECTION DB
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CS_EXCEPTION("CONNECT FAILED");
		}
		// B2: THUC HIEN SQL
		String sql_updateSV = "exec updateSinhVien ?,?,?,?,?,?,?,?,?";
		CallableStatement cs = con.prepareCall(sql_updateSV);
		SinhVien svupdate = new SinhVien();
		svupdate.addInfoSV();
		Date sql_date = Date.valueOf(dateFormat.format(svupdate.getNgaySinh()));

		svupdate.addInfoSV();
		cs.setString(1, svupdate.getMaSV());
		cs.setString(2, svupdate.getTenSV());
		cs.setDate(3, sql_date);
		cs.setString(4, svupdate.getPhone());
		cs.setString(5, svupdate.getEmail());
		cs.setString(6, svupdate.getDiachi());
		cs.setString(7, svupdate.getGioitinh());

		cs.registerOutParameter(8, Types.INTEGER);
		cs.registerOutParameter(9, Types.NVARCHAR);

		// B3:XU LY KET QUA
		int respin_code = cs.getInt(8);
		String respon_mes = cs.getString(9);
		cs.close();
		if (respin_code != 1) {
			throw new CS_EXCEPTION(respon_mes);
		}
		// B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}

	// METHOD XOA 1 DOI TUONG SINH VIEN
	public static void deteleSV() throws CS_EXCEPTION, SQLException {
		// B1: CONNECT DB
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CS_EXCEPTION("CONNECTION FAILED");
		}
		// B2: THUC HIEN SQL
		String sql_deleteSV = "DELETE FROM SINHVIEN WHERE MASV = ?";
		PreparedStatement ps = con.prepareStatement(sql_deleteSV);
		System.out.print("NHAP MA SINH VIEN MUON XOA: ");
		String masv = sc.nextLine();
		ps.setString(1, masv);
		int flagDelete = ps.executeUpdate();
		ps.close();
		if (flagDelete == 0) {
			throw new CS_EXCEPTION("THAO TAC KHONG THANH CONG! VUI LONG KIEM TRA LAI MA SINH VIEN");
		} else {
			System.out.println("THAO TAC THANH CONG");
		}
		// B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}

	// METHOD HIEN THI DS SINH VIEN
	public static void showSVList() throws CS_EXCEPTION, SQLException {
		// B1:KET NOI BD
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CS_EXCEPTION("CONNECT FAILED");
		}
		// B2:THUC HIEN SQL
		String sql_ShowSV = "Select MASV,TENSV,(Select CONVERT(varchar,NGAYSINH,103)) as 'NGAY SINH',PHONE,EMAIL,DIACHI,GIOITINH from SINHVIEN;";
		Statement ss = con.createStatement();
		ResultSet st = ss.executeQuery(sql_ShowSV);
		while (st.next()) {
			String masv = st.getString(1);
			String tensv = st.getString(2);
			String date_s = st.getString(3);
			String phone = st.getString(4);
			String email = st.getString(5);
			String diachi = st.getString(6);
			String gioitinh = st.getString(7);
			System.out.println(masv + "    " + tensv + "    " + date_s + "    " + phone + "    " + email + "    "
					+ diachi + "    " + gioitinh);
		}
		// B3:XU LY KET QUA
		ss.close();
		st.close();
		// B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}

	//METHOD TIM KIEM 1 SINH VIEN
	public static void findSV() throws CS_EXCEPTION, SQLException {
		//B1:THIET LAP KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2:THUC HIEN SQL
		String sql_find = "Select MASV,TENSV,(Select CONVERT(varchar,NGAYSINH,103)) as 'NGAY SINH',PHONE,EMAIL,DIACHI,GIOITINH,MAKHOA from SINHVIEN WHERE MASV =?";
		PreparedStatement ps = con.prepareStatement(sql_find);
		System.out.print("NHAP MA SINH VIEN: ");
		String namefind = sc.nextLine();
		ps.setString(1,namefind);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			String masv = rs.getString(1);
			String tensv = rs.getString(2);
			String date_s = rs.getString(3);
			String phone = rs.getString(4);
			String email = rs.getString(5);
			String diachi = rs.getString(6);
			String gioitinh = rs.getString(7);
			System.out.println(masv + "    " + tensv + "    " + date_s + "    " + phone + "    " + email + "    "
					+ diachi + "    " + gioitinh);
		}
		//B3:XU LY KET QUA
		rs.close();
		ps.close();
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
		
	}

	// METHOD THEM 1 LIST SINH VIEN TU FILE TXT
	public static void addLISTSV() throws CS_EXCEPTION, SQLException {
		listfiletxt();
		System.out.print("NHAP TEN FILE TXT MUON THEM: ");
		String namefile = sc.nextLine();
		boolean flag = false;
		for (File fl : MainQLSV.listFileStore) {
			if (namefile.equals(fl.getName())) {
				addFileName(readFile(fl.getName()));
				flag = true;
				break;
			}
		}
		if (!flag)
			System.out.println(namefile + " BAN TIM KIEM KHONG TON TAI");
	}
	public static void listfiletxt() {
		System.out.println("DANH SACH FILE TXT");
		System.out.println("------------------");
		int i = 1;
		for (File fl : MainQLSV.listFileStore) {
			if (fl.isFile()) {
				if (getExtensionFile(fl).equals("txt")) {
					System.out.println(i++ + ": " + fl.getName());
				}
			}
		}
	}
	public static void addFileName(ArrayList<SinhVien> list) throws CS_EXCEPTION, SQLException {
		// B1: KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CS_EXCEPTION("CONNECT ERROR");
		}
		con.setAutoCommit(false);
		
		// B2: THUC HIEN SQL
		String sql_listSV = "INSERT INTO SINHVIEN(MASV,TENSV,NGAYSINH,PHONE,EMAIL,DIACHI,GIOITINH,MAKHOA) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql_listSV);

		for (SinhVien sv : list) {
			// BIND THAM SO
			Date sql_date = Date.valueOf(dateFormat.format(sv.getNgaySinh()));
			ps.setString(1, sv.getMaSV());
			ps.setString(2, sv.getTenSV());
			ps.setDate(3, sql_date);
			ps.setString(4, sv.getPhone());
			ps.setString(5, sv.getEmail());
			ps.setString(6, sv.getDiachi());
			ps.setString(7, sv.getGioitinh());
			ps.setString(8, sv.getMaKhoa());
			ps.addBatch();
		}
		// B3: XU LY KET QUA
		int runSQL[] = ps.executeBatch();
		ps.close();
		con.commit();
		con.rollback();
		// B4: DONG KET NOI
		ConnectionDB.closeConnection(con);

	}

	public static String getExtensionFile(File fl) {
		String extension = "";
		String fileName = fl.toString();
		int index = fileName.lastIndexOf(".");
		if (index > 0) {
			extension = fileName.substring(index + 1);
		}
		return extension;
	}

	// METHOD DOC FILE TXT TRUYEN VAO QUA TEN FILE
	public static ArrayList<SinhVien> readFile(String filename) {
		ArrayList<SinhVien> result = new ArrayList<SinhVien>();
		try (BufferedReader fs = new BufferedReader(new FileReader(filename));) {
			String line = fs.readLine();
			while (line != null) {
				SinhVien sv = covertSV(line);
				if (sv != null) {
					result.add(sv);
				}
				line = fs.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// METHOD CHUYEN 1 LINE THANH TAI KHOAN
	public static SinhVien covertSV(String line) {
		SinhVien sv = null;
		try {
			validateFile(line);
		} catch (Exception ez) {
			System.out.println("ERROR VALIDATE LINE");
		}
		// CONVERT LINE TO ARRAY
		String[] arr = null;
		try {
			arr = line.split(",");
			java.util.Date cvdate = null;
			try {
				cvdate = fmdate.parse(arr[2]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			sv = new SinhVien(arr[0], arr[1], cvdate, arr[3], arr[4], arr[5], arr[6], arr[7]);
		}catch (Exception e) {
			System.out.println("ERROR");
		}
		return sv;			
	}

	// METHOD KIEM TRA CA FILE CUA 1 FILE
	public static void validateFile(String line) throws CS_EXCEPTION {
		// KIEM TRA FILE CO NULL KHONG
		if (line == null) {
			throw new CS_EXCEPTION("LINE IS EMPTY");
		}
		// KIEM TRA CAC FILED NAM TRONG FILE
		String[] arrLine = line.split(",");
		if (arrLine.length != 8) {
			throw new CS_EXCEPTION("INPUT IS NOT MATCH");
		}else {
			// CHECK FILE MA SINH VIEN
			if (arrLine[0].length() != 4) {
				throw new CS_EXCEPTION("MA SINH VIEN PHAI BANG 1 KY TU");
			}

			// CHECK FIELD HO TEN SINH VIEN
			if (arrLine[1].length() < 10) {
				throw new CS_EXCEPTION("HO TEN PHAI NHIEU HON 10 KY TU");
			}

			// CHECK FIELD NGAY SINH
			try {
				fmdate.parse(arrLine[2]);
			} catch (ParseException e) {
				throw new CS_EXCEPTION("NGAY SINH SINH NHAP KHONG DUNG DINH DANG dd/MM/yyyy");
			}

			// CHECK FIELD SO DIEN THOAI
			if (arrLine[3].length() != 10 && !arrLine[3].startsWith("09")) {
				throw new CS_EXCEPTION("SO DIEN THOAI PHAI BAT DAU BANG 09 VA PHAI CO 10 KY TU");
			}
			// CHECK FIELD EMAIL
			if (!(arrLine[4].length() > 10) && !(arrLine[4].contains("@"))) {
				throw new CS_EXCEPTION("EMAIL PHAI NHIEU HON 10 KY TU VA PHAI CHUA @");
			}
			// CHECK FIELD DIA CHI
			if (arrLine[5] == null) {
				throw new CS_EXCEPTION("TRUONG NAY KHONG CO GIA TRI");
			}
			// CHECK FIELD GIOI TINH
			if ((arrLine[6].equals("Nam")) || (arrLine[6].equals("Nu"))) {
			}else {
				throw new CS_EXCEPTION("TRUONG NAY KHONG DUNG DINH DANG");
			}
			// CHECK FIELD MA KHOA
			if (arrLine[7].length() != 4) {
				throw new CS_EXCEPTION("MA KHOA PHAI CO 4 KY TU");
			}
		}	
	}

	// METHOD LAY LIST FILE
	public static void travserFile(File parent) {
		if (!parent.exists()) {
			return;
		}
		if (parent.isDirectory()) {
			File[] dsFile = parent.listFiles();
			for (File fl : dsFile) {
				MainQLSV.listFileStore.add(fl);
				travserFile(fl);
			}
		}
	}
}
