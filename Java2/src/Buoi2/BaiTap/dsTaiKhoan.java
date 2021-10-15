package Java2.src.Buoi2.BaiTap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class dsTaiKhoan {
	private static ArrayList<TaiKhoan> dsTk = new ArrayList<TaiKhoan>();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static boolean addANew(TaiKhoan tk) {
		if (tk == null)
			return false;
		else {
			dsTk.add(tk);
			return true;
		}
	}

	public static boolean updateTkFromSoTk () {
		String soTk = "";
		TaiKhoan tk = null;
		int index = -1;
		try(Scanner sc = new Scanner(System.in);){
			while (true) {
				System.out.println("Nhap so tk can phai thay doi: ");
				soTk = sc.nextLine();
				tk = findTkBySoTk(soTk);
				if (tk != null) {
					index = dsTk.indexOf(tk);
					break;
				} else {
					System.out.println("Khong tim thay tai khoan trong ds.");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		tk.input();;
		dsTk.set(index, tk);
		return true;
	}


	public static void showDs(ArrayList<TaiKhoan> dsTaiKhoan) {
		if (dsTaiKhoan == null || dsTaiKhoan.size() == 0) {
			System.out.println("Ds empty");
		}
		for(int i=0; i< dsTaiKhoan.size(); i++) {
			System.out.println("-------"+ (i+1) + "---------");
			dsTaiKhoan.get(i).output();
		}
	}
	public void inRaTK(){
		for(TaiKhoan tk : dsTk){
			tk.output();
		}
	}
    
	public TaiKhoan findTk() {
		Scanner sc = new Scanner(System.in);
		String choose = "";
		do {
			System.out.println("Ban muon tim tk theo ma kh (1) hoac so tk (2): ");
			choose = sc.nextLine();
		} while(!"1".equals(choose) && !"2".equals(choose));
		sc.close();
		if ("1".equals(choose)) {
			System.out.println("Nhap ma khach hang: ");
			String makh = sc.nextLine();
			return findTkByMaKh(makh);
		} else {
			System.out.println("Nhap so tai khoan: ");
			String sotk = sc.nextLine();
			return findTkBySoTk(sotk);
		}
	}
	
	private static TaiKhoan findTkBySoTk(String sotk) {
		// validate input
		if (sotk == null){
			System.out.println("Số tk ko tồn tại!");
			return null;
		}
		// xu ly nghiep vu
		for (TaiKhoan tk : dsTk) {
			if(sotk.equalsIgnoreCase(tk.getSoTK())) {
				tk.output();
				return tk;
			}
		}
		return null;
	}

	public static ArrayList<TaiKhoan> readFile(String fileName){
		ArrayList<TaiKhoan> result = new ArrayList<TaiKhoan>();
		File file = new File(fileName);
		try(Scanner sc = new Scanner(file);){
			// doc file
			while (sc.hasNext()) {
				String line = sc.nextLine();
				// validate line va chuyen line -> TaiKhoan
				TaiKhoan tk = convertToTk(line);
				if (tk != null) {
					result.add(tk);	
				}
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static ArrayList<TaiKhoan> resetFile(String fileName){
		ArrayList<TaiKhoan> result = new ArrayList<TaiKhoan>();
		File file = new File(fileName);
		try(Scanner sc = new Scanner(file)){
			// doc file
			while (sc.hasNext()) {
				String line = sc.nextLine();
				// validate line va chuyen line -> TaiKhoan
				validateLineTk(line);
				System.out.println("Danh sach tk: " + line);
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	

	/*
	 * kiem tra xem 1 dong text phan tach cac thanh phan co hop le hay khong?
	 * neu co phat sinh ngoai le -> loi
	 * con khong hop le
	 * */
	private static void validateLineTk(String line) {
		if (line == null){
			throw new NullPointerException("Input is empty");
		}
		String[] arrLine = line.split(",");
		for(String st : arrLine){
			System.out.println(st);
		}
		if (arrLine.length != 8) {
			throw new InputMismatchException("Input is not match");
		}
		try {
			Long.parseLong(arrLine[3]);
		}catch(Exception e) {
			throw new NumberFormatException("So tk is not valid");
		}
		if (!arrLine[3].startsWith("00")) {
			throw new NumberFormatException("So tk is not match");
		}
		if (arrLine[2] == null || (!"0".equals(arrLine[2]) && !"1".equals(arrLine[2]))) {
			throw new InputMismatchException("Loai kh is not valid (0|1)");
		}
		// ngay sinh
		String ngaySinh = arrLine[4];
		
		try {
			sdf.parse(ngaySinh);
		} catch (ParseException e) {
			throw new InputMismatchException("Ngay sinh is not valid");
		}
		// ngay tao
		String ngayTao = arrLine[6];
		try {
			sdf.parse(ngayTao);
		} catch (ParseException e) {
			throw new InputMismatchException("Ngay tao is not valid");
		}
		// so tien:
		String soTien = arrLine[7];
		double d_soTien = 0;
		try {
			d_soTien = Double.parseDouble(soTien);
		}catch(Exception e) {
			throw new InputMismatchException("Ngay tao must double type");
		}
		if (d_soTien < 0) {
			throw new InputMismatchException("Ngay tao must >= 0");
		}
	}

	private static TaiKhoan convertToTk(String line) {
		try {
			validateLineTk(line);
		}catch(Exception e) {
			System.out.println(line + ": "+ e.getMessage());
			return null;
		}
		// chuyen doi line -> Tai khoan
		String[] arrLine = line.split(",");
		TaiKhoan tk;
		try {
			tk = new TaiKhoan(arrLine[0], 
								arrLine[1], 
								arrLine[2], 
								arrLine[3], 
								sdf.parse(arrLine[4]), 
								Long.parseLong(arrLine[5]) , 
								sdf.parse(arrLine[6]), 
								Double.parseDouble(arrLine[7]));
			return tk;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean appendLineToFile(String fileName, TaiKhoan tk) {
		if (tk == null) {
			System.out.println("Tai khoan is empty");
			return false;
		}
		File file = new File(fileName);
		try(FileWriter fw = new FileWriter(file, true)){
			fw.write(tk.toString());
			return true;
		}catch(IOException e) {
			System.out.println("File not found");
			return false;
		}
	}

	static TaiKhoan findTkByMaKh(String makh) {
		// validate input
		boolean check = false;
		if (makh == null){
			System.out.println("Mã kh ko tôn tại!");
			return null;
		}
		for (TaiKhoan tk : dsTk) {
			if(makh.equalsIgnoreCase(tk.getMaKH())) {
				tk.output();
				check = true;
				return tk;
			}
		}if(check == false){
			System.out.println("Sai ma kh");
			
		}
		return null;
	}

	public void napTien(){
		Scanner sc = new Scanner(System.in);
		String maTk;
		while(true){
			System.out.println("Nhap ma tk: ");
			maTk = sc.nextLine();
			TaiKhoan tkCheck = findTkByMaKh(maTk);
			if(tkCheck != null){
				break;
			}
		}
		System.out.println("Nhap so tien can them: ");
		Double tienNap = Double.parseDouble(sc.nextLine());
		for(TaiKhoan tk : dsTk){
			if(maTk.equals(tk.getMaKH())){
				tk.napTien(tienNap);
				System.out.println("Số dư tk: " + tk);
				break;
			}
		}sc.close();
		
	}

	public void rutTien(){
		Scanner sc = new Scanner(System.in);
		String maTk;
		while(true){
			System.out.println("Nhap ma tk: ");
			maTk = sc.nextLine();
			TaiKhoan tkCheck = findTkByMaKh(maTk);
			if(tkCheck != null){
				break;
			}
		}
		System.out.println("Nhap so tien can rut: ");
		Double tienRut = Double.parseDouble(sc.nextLine());
		for(TaiKhoan tk : dsTk){
			if(maTk.equals(tk.getMaKH())){
				tk.rutTien(tienRut);
				System.out.println("Số dư tk: " + tk);
				break;
			}
		}sc.close();
	}
	
}

