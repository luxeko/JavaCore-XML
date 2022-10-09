package Buoi4_bt2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;

public class KHAODAO {

	// FIELD
	private static Scanner sc = new Scanner(System.in);

	// METHOD
	public static void menuKHOA() {
		String confirm = "";
		boolean flag = false;
		do {
			System.out.println("MENU CRUD KHOA");
			System.out.println("===============");
			System.out.println("1: THEM 1 KHOA");
			System.out.println("2: CAP NHAT THONG TIN 1 KHOA");
			System.out.println("3: XOA 1 KHOA TRONG DS KHOA");
			System.out.println("4: HIEN THI DS KHOA");
			System.out.println("5: TIM KIEM 1 KHOA THEO MA KHOA");
			System.out.println("6: THEM 1 LIST KHOA VAO TRONG DS");
			System.out.println("7: THOAT!");
			System.out.print("NHAP LUA CHON: ");
			try {
				int choose = sc.nextInt();
				sc.nextLine();
				switch (choose) {
				case 1:
					addKHOA();
					break;
				case 2:
					updateKHOA();
					break;
				case 3:
					deleteKHOA();
					break;
				case 4:
					showListKhoa();
					break;
				case 5:
					findKhoa();
					break;
				case 6:
					addListKhoa();
					break;
				case 7:
					flag = true;
					break;
				default:
					System.out.println("VUI LONG NHAP THEO MENU");
					break;
				}		
			} catch (Exception e) {
				System.out.println("ERROR FOUND  " + e.getMessage());
			}
			if (!flag) {
				System.out.print("BAN CO MUON TIEP TUC THAO TAC VOI MENU KHOA(n:THOAT!): ");
				confirm = sc.nextLine();
			}
		} while (!confirm.equalsIgnoreCase("n") && !flag);
	}

	// METHOD THEM 1 KHOA
	public static void addKHOA() throws CS_EXCEPTION, SQLException {
		// B1: KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CS_EXCEPTION("ERROR CONNECT");
		}
		KHOA newKHOA = new KHOA();
		newKHOA.addInfoKHOA();
		// B2: THUC HIEN SQL
		String sql_addKHOA = "INSERT INTO KHOA(MAKHOA,TENKHOA) VALUES(?,?)";
		PreparedStatement ps = con.prepareStatement(sql_addKHOA);
		ps.setString(1, newKHOA.getMaKhoa());
		ps.setString(2, newKHOA.getTenKhoa());
		int runsql = ps.executeUpdate();
		ps.close();
		// B3:XU LY KET QUA
		if (runsql == 0) {
			System.out.println("THAO TAC KHONG THANH CONG");
		} else {
			System.out.println("THAO TAC THANH CONG");
		}
		// B4: DONG KET NOI
		ConnectionDB.closeConnection(con);
	}

	// METHOD CAP NHAT THONG TIN 1 KHOA
	public static void updateKHOA() throws CS_EXCEPTION, SQLException {
		// B1: KET NOI BD
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		// B2: THUC HIEN SQL
		String sql_updateKHOA = "exec updateKhoa ?,?,?";
		CallableStatement cs = con.prepareCall(sql_updateKHOA);
		KHOA khoa_upate = new KHOA();
		khoa_upate.addInfoKHOA();
		cs.setString(1, khoa_upate.getMaKhoa());
		cs.setString(2, khoa_upate.getTenKhoa());

		cs.registerOutParameter(3, Types.NVARCHAR);
		String mess = cs.getString(3);
		cs.close();
		// B3: XU LY KET QUA
		if (mess == null) {
			System.out.println(mess);
		} else {
			throw new CS_EXCEPTION(mess);
		}
		// B4: DONG KET NOI
		ConnectionDB.closeConnection(con);
	}

	// METHOD XOA 1 KHOA TRONG DS
	public static void deleteKHOA() throws CS_EXCEPTION, SQLException {
		// B1: KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		// B2: THUC HIEN SQL
		String sql_deleteKHOA = "DELETE FROM KHOA WHERE MAKHOA = ?";
		PreparedStatement ps = con.prepareStatement(sql_deleteKHOA);
		System.out.print("NHAP MA KHOA MUON XOA: ");
		String makhoa = sc.nextLine();
		ps.setString(1, makhoa);
		int runsql = ps.executeUpdate();
		// B3: XU LY KET QUA
		ps.close();
		if (runsql == 0) {
			System.out.println("THAO TAC KHONG THANH CONG VUI LONG KIEM TRA LAI MA KHOA");
		} else {
			System.out.println("THAO TAC THANH CONG");
		}
		// B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}

	// METHOD HIEN THI DANH SACH KHOA
	public static void showListKhoa() throws CS_EXCEPTION, SQLException {
		// B1:KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		// B2:THUC HIEN SQL
		String sql_showKhoa = "SELECT MAKHOA,TENKHOA FROM KHOA";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql_showKhoa);
		while (rs.next()) {
			String makhoa = rs.getString(1);
			String tenkhoa = rs.getString(2);
			System.out.println("MA KHOA: " + makhoa + "  " + " TEN KHOA: " + tenkhoa);
		}
		// B3:XU LY KET NOI
		rs.close();
		st.close();
		// B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}

	// METHOD TIM KIEM 1 TT 1 KHOA THEO MA KHOA
	public static void findKhoa() throws CS_EXCEPTION, SQLException {
		// B1:KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		// B2: THUC HIEN SQL
		String sql_maKhoa = "SELECT * FROM KHOA WHERE MAKHOA = ?";
		PreparedStatement ps = con.prepareStatement(sql_maKhoa);
		System.out.print("NHAP MA KHOA CAN TIM: ");
		String mk = sc.nextLine();
		ps.setString(1, mk);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("MA KHOA: "+rs.getString(1)+"    "+"TEN KHOA: "+rs.getString(2)+"");
		}
		// B3:XU LY KET QUA
		ps.close();
		rs.close();
		// B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}

	// METHOD THEM 1 LIST KHOA VAO TRONG DANH SACH
	public static void addListKhoa() throws CS_EXCEPTION, SQLException {
		//DS FILE TXT
		SINHVIENDAO.listfiletxt();
		//CHON LIST MUON THEM
		sc.nextLine();
		System.out.print("NHAP TEN FILE CAN THEM: ");
		String filename = sc.nextLine();
		boolean flag = false;
		for (File fl : MainQLSV.listFileStore) {
			if (filename.equals(fl.getName())) {
				addListKhoaDB(readFileKhoa(fl.getName()));
				flag = true;
				break;
			}
		}
		if (!flag)
			System.out.println(filename + " BAN TIM KIEM KHONG TON TAI");
	}
	//METHOD ADD LIST KHOA DB
	public static void addListKhoaDB(ArrayList<KHOA> listkhoa) throws CS_EXCEPTION, SQLException {
		//B1:CONNECT DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2: THUC HIEN SQL
		con.setAutoCommit(false);
		String sql_addList ="INSERT INTO KHOA(MAKHOA,TENKHOA) VALUES(?,?)";
		PreparedStatement ps = con.prepareStatement(sql_addList);
		for(KHOA k : listkhoa) {
			ps.setString(1,k.getMaKhoa());
			ps.setString(2,k.getTenKhoa());
			ps.addBatch();
		}
		int[] runsql = ps.executeBatch();
		//B3:XU LY KET QUA
		ps.close();
		con.commit();
		con.rollback();
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}
	//METHOD VALIDATE FILE KHOA
	public static void validateFileKhoa(String line) throws CS_EXCEPTION {
		if(line == null) {
			throw new CS_EXCEPTION("LINE IS EMPTY");
		}
		String[] arrLine = line.split(",");
		if(arrLine.length != 2) {
			throw new CS_EXCEPTION("INPUT IS NOT MATCH");
		}else {
			if(arrLine[0].length() != 4) {
				throw new CS_EXCEPTION("MA KHOA PHAI CO 4 KY TU");
			}
			if(arrLine[1] == null) {
				throw new CS_EXCEPTION("TEN KHOA KHONG DUOC DE TRONG");
			}
		}
	}
	//METHOD COVERT 
	public static KHOA covertKhoa(String line) {
		KHOA kh = null;
		try {
			validateFileKhoa(line);
		} catch (CS_EXCEPTION e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] arr = line.split(",");
		kh = new KHOA(arr[0],arr[1]);
		return kh;
	}
	//METHOD READ FILE
	public static ArrayList<KHOA> readFileKhoa(String filename){
		ArrayList<KHOA> kh = new ArrayList<KHOA>();
		try(
				BufferedReader reader = new BufferedReader(new FileReader(filename));
				){
				String line = reader.readLine();
				while(line != null) {
					KHOA khs = covertKhoa(line);
					if(khs != null) {
						kh.add(khs);
					}
					line = reader.readLine();
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return kh;
	}
}
