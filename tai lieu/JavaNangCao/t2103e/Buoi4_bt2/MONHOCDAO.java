package Buoi4_bt2;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MONHOCDAO {

	//FIELD
	private static Scanner sc = new Scanner(System.in);
	
	//-----------------------
	//METHOD
	public static void menuMonHoc() {
		String confirm = "";
		boolean flag = false;
		do {
			System.out.println("MENU MON HOC");
			System.out.println("-------------");
			System.out.println("1: THEM 1 MON HOC");
			System.out.println("2: HIEN THI DS MON HOC");
			System.out.println("3: XOA 1 MON HOC TRONG LIST");
			System.out.println("4: CAP NHAT THONG TIN 1 MON HOC TRONG LIST");
			System.out.println("5: TIM KIEM THONG TIN MON HOC THEO MA MON HOC");
			System.out.println("6: THEM 1 LIST MON HOC VAO LIST");
			System.out.println("7: THOAT!");
			System.out.print("NHAP LUA CHON: ");
			try {
				int choose = sc.nextInt();
				sc.nextLine();
				switch(choose) {
				case 1:
					addMonHoc();
					break;
				case 2:
					showListMH();
					break;
				case 3:
					deleteMonHoc();
					break;
				case 4:
					updateMN();
					break;
				case 5:
					findMonHoc();
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
				if(!flag) {
					System.out.print("BAN CO MUON TIEP TUC THAO TAC VOI MENU MON HOC(n:THOAT!): ");
					confirm = sc.nextLine();
				}
			}catch(Exception e) {
				System.out.println("ERROR FOUND  " + e.getMessage());
				e.printStackTrace();
			}
		}while(!confirm.equalsIgnoreCase("n") && !flag);
	}
	//METHOD ADD 1 MON HOC
	public static void addMonHoc() throws CS_EXCEPTION, SQLException {
		//B1: KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2: THUC HIEN SQL
		String sql_AddMH = "INSERT INTO MONHOC(MAMONHOC,TENMONHOC) VALUES(?,?)";
		PreparedStatement ps = con.prepareStatement(sql_AddMH);
		MONHOC mh = new MONHOC();
		mh.addInfoMonHoc();
		ps.setString(1,mh.getMaMonHoc());
		ps.setString(2,mh.getTenMonHoc());
		int runsql = ps.executeUpdate();
		ps.close();
		//B3:XU LY KET QUA
		if(runsql == 0) {
			throw new CS_EXCEPTION("ERROR FOUND ADD");
		}else {
			System.out.println("THAO TAC THANH CONG");
		}
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}
	//METHOD HIEN THI DANH SACH MON HOC
	public static void showListMH() throws CS_EXCEPTION, SQLException {
		//B1:KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2: THUC HIEN SQL 
		String sql_show = "SELECT MAMONHOC,TENMONHOC FROM MONHOC";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql_show);
		while(rs.next()) {
			String mamh = rs.getString(1);
			String tenmh = rs.getString(2);
			System.out.println(mamh +"   "+tenmh );
		}
		//B3:XU LY KET QUA
		rs.close();
		st.close();
		//B4: DONG KET NOI
		ConnectionDB.closeConnection(con);		
	}
	//METHOD XOA THONG TIN 1 MON HOC
	public static void deleteMonHoc() throws CS_EXCEPTION, SQLException {
		//B1: KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2: THUC HIEN SQL
		String sql_deleteMH = "DELETE FROM MONHOC WHERE MAMONHOC = ?";
		PreparedStatement ps = con.prepareStatement(sql_deleteMH);
		System.out.print("NHAP MA MON HOC MUON XOA: ");
		String mamonhoc = sc.nextLine();
		ps.setString(1, mamonhoc);
		int runsql = ps.executeUpdate();
		ps.close();
		//B3:XU LY KET QUA
		if(runsql == 0) {
			throw new CS_EXCEPTION("ERROR FOUND! VUI LONG KIEM TRA LAI MA MON HOC");
		}else {
			System.out.println("THAO TAC THANH CONG");
		}
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}
	//METHOD CAP NHAT THONG TIN 1 MON HOC
	public static void updateMN() throws CS_EXCEPTION, SQLException {
		//B1:KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2: THUC HIEN SQL
		String sql_updateMN = "EXEC updateMonHoc ?,?,?";
		CallableStatement cs = con.prepareCall(sql_updateMN);
		MONHOC newmh = new MONHOC();
		newmh.addInfoMonHoc();
		cs.setString(1, newmh.getMaMonHoc());
		cs.setString(2, newmh.getTenMonHoc());
		
		cs.registerOutParameter(3, Types.NVARCHAR);
		String mess = cs.getString(3);
		cs.close();
		//B3:XY LU KET QUA
		if(mess == null) {
			System.out.println("THAO TAC THANH CONG");
		}else {
			System.out.println("THAO TAC KHONG THANH CONG VUI LONG KIEM TRA LAI MA MON HOC");
		}
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}
	//METHOD TIM KIEM THONG TIN MON HOC THEO MA MON HOC
	public static void findMonHoc() throws SQLException, CS_EXCEPTION {
		//B1: KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2: KET NOI SQL
		String sql_findMH = "SELECT MAMONHOC,TENMONHOC FROM MONHOC WHERE MAMONHOC = ?";
		PreparedStatement ps = con.prepareStatement(sql_findMH);
		System.out.print("NHAP MA MON HOC CAN TIM: ");
		String mamonhoc = sc.nextLine();
		ps.setString(1,mamonhoc);
		ResultSet rs = ps.executeQuery();  
		while(rs.next()){  
			System.out.println("MA MON HOC: "+rs.getString(1)+"    "+"TEN MON HOC: "+rs.getString(2));  
			}  
		//B3:XU LY KET QUA
		ps.close();
		rs.close();
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}
	//METHOD THEM 1 LIST MON HOC
	public static void addListMonHoc() throws CS_EXCEPTION, SQLException {
		SINHVIENDAO.listfiletxt();
		//CHON LIST MON HOC
		System.out.print("CHON FILE MUON THEM: ");
		String name = sc.nextLine();
		boolean flag = false;
		for (File fl : MainQLSV.listFileStore) {
			if (name.equals(fl.getName())) {
				addMHDB(readFileMH(fl.getName()));
				flag = true;
				break;
			}
		}
		if (!flag)
			System.out.println(name + " BAN TIM KIEM KHONG TON TAI");
	}
	//METHOD ADD LIST MON HOC DB
	public static void addMHDB(ArrayList<MONHOC> listmh) throws CS_EXCEPTION, SQLException {
		//B1:KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		con.setAutoCommit(false);
		//B2: THUC HIEN SQL
		String sql_addlist = "INSERT INTO MONHOC(MAMONHOC,TENMONHOC) VALUES(?,?)";
		PreparedStatement ps = con.prepareStatement(sql_addlist);
		for(MONHOC mh : listmh) {
			ps.setString(1, mh.getMaMonHoc());
			ps.setString(2, mh.getTenMonHoc());
			ps.addBatch();
		}
		//B3:XU LY KET QUA
		int[] runsql = ps.executeBatch();
		ps.close();
		con.commit();
		con.rollback();
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
		
	}
	//METHOD READ FILE MON HOC
	public static ArrayList<MONHOC> readFileMH(String filename){
		ArrayList<MONHOC> result = new ArrayList<MONHOC>();
		List<String> allLines = null;
		Path currentDir = Paths.get(".");
		try {
			allLines = Files.readAllLines(currentDir.resolve(filename));
			for(String line : allLines) {
				MONHOC mh = covertMH(line);
				if(mh != null) {
					result.add(mh);
				}
			}		
		}catch(Exception e){
			System.out.println("ERROR FOUND  "+e.getMessage());
		}
		return result;
	}
	//METHOD COVERT LINE MON HOC
	public static MONHOC covertMH(String line) {
		MONHOC mh = null;
		try {
			validateFieldMH(line);
			String[] arrLine = line.split(",");
			mh = new MONHOC(arrLine[0],arrLine[1]);
		}catch(Exception e) {
			System.out.println("ERROR FOUND  " + e.getMessage());
		}	
		return mh;
	}
	//METHOD VALIDATE FIEL MON HOC
	public static void validateFieldMH(String line) throws CS_EXCEPTION {
		if(line == null) {
			throw new CS_EXCEPTION("INPUT EMPTY");
		}
		String[] arrLine =line.split(",");
		if(arrLine.length != 2) {
			throw new CS_EXCEPTION("INPUT IS NOT MATCH");
		}else {
			if(arrLine[0].length() != 4) {
				throw new CS_EXCEPTION("MA MON HOC PHAI CO 4 KY TU");
			}
			if(arrLine[1] == null) {
				throw new CS_EXCEPTION("MA MON HOC KHONG DUOC DE TRONG");
			}
		}
	}
}
