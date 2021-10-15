
package java1.src.Buoi8;

import java.util.ArrayList;
import java.util.Scanner;

//lop Giang Vien: lop con, lop dan xuat
public class GiangVien extends Nguoi{
    // fields rieng cua GiangVien
	private String maGv;
	private float hsLuong;
	private int soGioDay;
	private ArrayList<String> dsLop = new ArrayList<String>();
	Scanner sc = new Scanner(System.in);
	public GiangVien() {
		super();
	}
	public GiangVien(String ten, int tuoi, String cmt, String emai, String maGv, float hsLuong, int soGioDay) {
		super(ten, tuoi, cmt, emai);
		this.maGv = maGv;
		this.hsLuong = hsLuong;
		this.soGioDay = soGioDay;
	}
	public String getMaGv() {
		return maGv;
	}
	public void setMaGv(String maGv) {
		this.maGv = maGv;
	}
	public float getHsLuong() {
		return hsLuong;
	}
	public void setHsLuong(float hsLuong) {
		this.hsLuong = hsLuong;
	}
	public int getSoGioDay() {
		return soGioDay;
	}
	public void setSoGioDay(int soGioDay) {
		this.soGioDay = soGioDay;
	}
	
	/*
	public GiangVien(String ten, int tuoi, String cmt, String emai, 
			String maGv, float hsLuong, int soGioDay) {
		this(ten, tuoi, cmt, emai);
		this.maGv = maGv;
		this.hsLuong = hsLuong;
		this.soGioDay = soGioDay;
	}

	public GiangVien(String ten, int tuoi, String cmt, String emai) {
		super(ten, tuoi, cmt, emai);
	}
	*/
	
	//@Override
	public void xuat() {
		// xuat thong tin chung cua Nguoi
		super.xuat();
		// xuat thong tin rieng cua Giangvien
		System.out.println("Ma gv: "+ this.maGv);
		System.out.println("So gio day: "+ this.soGioDay);
		System.out.println("He so luong: "+ this.hsLuong);
		System.out.println("Ds lop hoc: "+ this.getDsLopStr());
		
	}
	// chuyen doi tu arraylist -> string
	public String getDsLopStr() {
		//String str1 = null;
		//String str2 = new String("");
		StringBuilder sbuilder = new StringBuilder();
		//StringBuffer sbuffer = new StringBuffer();
		
		//String result = "";
		sbuilder = new StringBuilder("dungpt");
		sbuilder = new StringBuilder("");
		for (String lop : this.dsLop) {
			sbuilder.append(lop + ",");
		}
		String result = "";
		if (sbuilder.toString().lastIndexOf(",") > -1)
			result = sbuilder.toString().substring(0, sbuilder.toString().length() -1);
		return result;
	}
	//@Override
	public void nhap() {
		super.nhap();
		// nhap cac thong tin tu ban phim cua giang vien
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter idTeacher:");
		this.maGv = scanner.nextLine();
		System.out.println("Enter Salary:");
		this.hsLuong = scanner.nextFloat();
		System.out.println("Enter NumberHourTeaching:");
		this.soGioDay = scanner.nextInt();
		scanner.nextLine();
		// t2103e,t2000e,t3000e
		System.out.println("Nhap ds lop hoc( cac lop hoc cach nhau boi dau phay, ): ");
		String dslh = scanner.nextLine();
		// chuyen doi chuoi sang mang:
		String[] array_dslh = dslh.split(",");
		for(String lh : array_dslh) {
			this.dsLop.add(lh);
		}
		scanner.close();
		
	}
	public void tinhLuong() {
		System.out.println("Luong: "+ (this.soGioDay *100));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GiangVien)) {
			return false;
		}
		GiangVien objGv = (GiangVien)obj;
		return this.maGv.equals(objGv.getMaGv());
	}
	
	@Override
	public String toString() {
		return "Gv: "+ this.maGv;
	}
    

}
   
    
    

    

