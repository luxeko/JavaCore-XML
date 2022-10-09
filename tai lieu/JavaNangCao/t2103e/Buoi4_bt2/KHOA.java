package Buoi4_bt2;

import java.util.Scanner;

public class KHOA {
	Scanner sc = new Scanner(System.in);
	//FIELD
	//------------------------
	private String maKhoa;
	private String tenKhoa;
	
	//SETTER & GETTER
	//------------------------
	public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	
	public KHOA(String maKhoa, String tenKhoa) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
	}
	
	public KHOA() {
		super();
	}
	//---------------------------
	//METHOD
	public void addInfoKHOA() {
		
		//MAKHOA FIELD
		while(true) {
			System.out.print("NHAP MA KHOA: ");
			this.maKhoa = sc.nextLine();
			if(this.maKhoa.length() == 4) {
				break;
			}else {
				System.out.println("VUI LONG NHAP MA KHOA CO 4 KY TU");
			}
		}
		//TENKHOA FIELD
		while(true) {
			System.out.print("NHAP TEN KHOA: ");
			this.tenKhoa = sc.nextLine();
			if(this.tenKhoa == null) {
				System.out.println("VUI LONG KHONG BO TRONG TEN KHOA");
			}else {
				break;
			}
		}
	}	
}
