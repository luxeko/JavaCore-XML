package Buoi4_bt2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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

public class KETQUADAO {
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void menuKetQua() {
		String confirm = "";
		boolean flag = false;
		do {
			System.out.println("MENU BAO CAO");
			System.out.println("------------");
			System.out.println("1: TAO 1 PHIEU KET QUA");
			System.out.println("2: HIEN THI DANH SACH PHIEU KET QUA");
			System.out.println("3: CAP NHAT THONG TIN 1 PHIEU KET QUA");
			System.out.println("4: TIM KIEM KET QUA THI CUA SINH VIEN THEO MA SINH VIEN");
			System.out.println("5: XOA 1 PHIEU KET QUA TRONG DANH SACH THEO MA SINH VIEN");
			System.out.println("6: HIEN THI DS DIEM THI THEO MA MON HOC");
			System.out.println("7: THEM 1 LIST KET QUA VAO TRONG DANH SACH");
			System.out.println("8: THOAT!");
			System.out.print("NHAP LUA CHON: ");
			try {
				int choose = sc.nextInt();
				sc.nextLine();
				switch(choose) {
				case 1:
					addKetQua();
					break;
				case 2:
					showListKQ();
					break;
				case 3:
					updatePKQ();
					break;
				case 4:
					findKQSV();
					break;
				case 5:
					deleteKQ();
					break;
				case 6:
					findKQMH();
					break;
				case 7:
					addListKQ();
					break;
				case 8:
					flag = true;
					break;
				default:
					System.out.println("VUI LONG NHAP THEO MENU");
					break;
				}
				if(!flag) {
					System.out.print("BAN CO MUON TIEP TUC CHUONG TRINH VOI KET QUA KHONG(n:THOAT!): ");
					confirm = sc.nextLine();
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(!confirm.equalsIgnoreCase("n") && !flag);
	}
	
	
	//METHOD THEM KET QUA CUA HOC SINH
	public static void addKetQua() throws CS_EXCEPTION, SQLException {
		//B1:KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2:THUC HIEN SQL
		String sql_Add = "INSERT INTO KETQUA(MAMONHOC,MASV,DIEM) VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql_Add);
		KETQUA ketqua = new KETQUA();
		ketqua.addInfoKQ();
		ps.setString(1, ketqua.getMaMH());
		ps.setString(2, ketqua.getMaSV());
		ps.setFloat(3, ketqua.getDiemThi());
		int runsql = ps.executeUpdate();
		//B3:XU LY KET QUA
		ps.close();
		if(runsql == 0) {
			System.out.println("THAO TAC KHONG THANH CONG VUI LONG KIEM TRA LAI");
		}else {
			System.out.println("THAO TAC THANH CONG");
		}
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}
	//METHOD HIEN THI DANH SACH PHIEU KET QUA
	public static void showListKQ() throws CS_EXCEPTION, SQLException {
		//B1: KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2: THUC HIEN SQL
		String sql_Show = "SELECT MAMONHOC,MASV,DIEM FROM KETQUA";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql_Show);
		while(rs.next()) {
			String mamh = rs.getString(1); 
			String masv = rs.getString(2);
			float diem = rs.getFloat(3);
			System.out.println("MA MON HOC: "+mamh+"     "+"MA SINH VIEN: "+masv+"      "+"DIEM THI: "+diem);
		}
		//B3:XU LY KET NOI
		st.close();
		rs.close();
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}
	//METHOD CAP NHAT THONG TIN 1 PHIEU KET QUA
	public static void updatePKQ() throws CS_EXCEPTION, SQLException {
		//B1:KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2:THUC HIEN SQL
		String sql_Update = "exec updateKQ ?,?,?,?";
		CallableStatement cs = con.prepareCall(sql_Update);
		KETQUA newkq = new KETQUA();
		newkq.addInfoKQ();
		cs.setString(1, newkq.getMaSV());
		cs.setString(2, newkq.getMaMH());
		cs.setFloat(3, newkq.getDiemThi());
		
		cs.registerOutParameter(4, Types.NVARCHAR);
		String mess = cs.getString(4);
		//B3:XU LY KET QUA
		cs.close();
		if(mess == null) {
			System.out.println("THAO TAC THANH CONG");
		}else {
			System.out.println("VUI LONG KIEM TRA LAI MA SINH VIEN HOAC MA MON HOC");
		}
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}
	//METHOD TIM KIEM KET QUA CUA SINH VIEN THEO MA SINH VIEN
	public static void findKQSV() throws CS_EXCEPTION, SQLException {
		//B1:KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2:THUC HIEN SQL
		String sql_findSV = "SELECT * FROM KETQUA WHERE MASV = ?";
		PreparedStatement ps = con.prepareStatement(sql_findSV);
		System.out.print("NHAP MA SINH VIEN MUON XEM KET QUA: ");
		String mafind = sc.nextLine();
		ps.setString(1, mafind);
		ResultSet rs= ps.executeQuery();
		while (rs.next()) {
			System.out.println("MA MON HOC: "+rs.getString(1)+"    "+"MA SINH VIEN: "+rs.getString(2)+"    "+"DIEM: "+rs.getFloat(3));
		}
		//B3:XU LY KET QUA
		ps.close();
		rs.close();
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}
	//METHOD XOA 1 PHIEU KET QUA
	public static void deleteKQ() throws CS_EXCEPTION, SQLException {
		//B1:KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con ==null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2:THUC HIEN SQL
		String sql_dele = "DELETE FROM KETQUA WHERE MASV =?";
		PreparedStatement ps = con.prepareStatement(sql_dele);
		System.out.print("NHAP MA SINH VIEN MUON XOA KET QUA: ");
		String mahs = sc.nextLine(); 
		ps.setString(1, mahs);
		int runsql = ps.executeUpdate();
		ps.close();
		//B3:XU LY KET QUA
		if(runsql == 0) {
			System.out.println("VUI LONG KIEM TRA LAI MA SINH VIEN");
		}else {
			System.out.println("THAO TAC THANH CONG");
		}
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}
	//METHOD DIEN THI DS KET QUA THI THEO MA MON HOC
	public static void findKQMH() throws CS_EXCEPTION, SQLException {
		//B1:KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		//B2:THUC HIEN SQL
		String sql_find = "SELECT * FROM KETQUA WHERE MAMONHOC = ?";
		PreparedStatement ps = con.prepareStatement(sql_find);
		System.out.print("NHAP MA MON HOC MUON XEM KET QUA: ");
		String mamn = sc.nextLine();
		ps.setString(1, mamn);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			System.out.println("MA MON HOC: "+rs.getString(1)+"    "+"MA SINH VIEN: "+rs.getString(2)+"    "+"DIEM: "+rs.getFloat(3));
		}
		//B3:XU LY KET QUA
		ps.close();
		rs.close();
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}
	//METHOD ADD LIST KETQUA VAO DS
	public static void addListKQ() throws CS_EXCEPTION, SQLException {
		SINHVIENDAO.listfiletxt();
		//CHON LIST KETQUA
		System.out.print("CHON FILE MUON THEM: ");
		String name = sc.nextLine();
		boolean flag = false;
		for(File fl: MainQLSV.listFileStore) {
			if (name.equals(fl.getName())) {
				System.out.println("TRUE");
				addListDB(readFileKQ(fl.getName()));
				moveFileReaded(fl.getName());
				flag = true;
				break;
			}
		}
		if(!flag)System.out.println(name+"  BAN TIM KIEM KHONG TON TAI");
	}
	//METHOD DOC FILE
	public static ArrayList<KETQUA> readFileKQ(String filename){
		ArrayList<KETQUA> result = new ArrayList<KETQUA>();
		try (BufferedReader fs = new BufferedReader(new FileReader(filename));) {
			String line = fs.readLine();
			while (line != null) {
				System.out.println(line);
				KETQUA sv = covertKQ(line);
				if (sv != null) {
					result.add(sv);
				}
				line = fs.readLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public static void addListDB(ArrayList<KETQUA> list) throws CS_EXCEPTION, SQLException {
		//B1:KET NOI DB
		Connection con = ConnectionDB.getConnection();
		if(con == null) {
			throw new CS_EXCEPTION("ERROR CONNECTION");
		}
		con.setAutoCommit(false);
		//THUC HIEN SQL
		String sql_add ="INSERT INTO KETQUA(MAMONHOC,MASV,DIEM) VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql_add);
		
		for(KETQUA kq : list) {
			
			ps.setString(1, kq.getMaMH());
			ps.setString(2, kq.getMaSV());
			ps.setFloat(3, kq.getDiemThi());
			ps.addBatch();
		}
		int run[] = ps.executeBatch();

		//B3:XU LY KET QUA
		ps.close();
		con.commit();
		con.rollback();
		//B4:DONG KET NOI
		ConnectionDB.closeConnection(con);
	}
	//METHOD COVERT KETQUA
	public static KETQUA covertKQ(String line) {
		try {
			validateKQ(line);
		}catch(Exception e) {
			e.printStackTrace();
		}
		String[] arr = line.split(",");
		float f = Float.parseFloat(arr[2]);
		KETQUA newkq = new KETQUA(arr[0],arr[1],f);
		return newkq;
	}
	//METHOD VALIDATE FILE KETQUA
	public static void validateKQ(String line) throws CS_EXCEPTION {
		if(line == null) {
			throw new CS_EXCEPTION("INPUT EMPTY");
		}
		String[] arrLine = line.split(",");
		if(arrLine.length != 3) {
			throw new CS_EXCEPTION("INPUT NOT MATCH");
		}else {
			if(arrLine[0].length() != 4) {
				throw new CS_EXCEPTION("MA MON HOC BAT BUOC PHAI CO 4 KY TU");
			}
			if(arrLine[1].length() != 4) {
				throw new CS_EXCEPTION("MA SINH VIEN BAT BUOC PHAI CO 4 KY TU");
			}
			String tien = arrLine[2];
			float tiens = 0;
			try {
				tiens =Float.parseFloat(tien);				
			}catch(Exception e) {
				System.out.println("SO TIEN BAT BUOC PHAI LA SO");
			}
		}
	}
	//
	public static void moveFileReaded(String name) {
		File[] dsFile = MainQLSV.fileRoot.listFiles();
		for(File fl : dsFile) {
			if(fl.getName() == name) {
				System.out.println(fl.getAbsolutePath());
			}
		}	
	System.out.println(MainQLSV.folderInputed.isDirectory());
		
	}
	public static void main(String[] args) {
		menuKetQua();
	}
}
