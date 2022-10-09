package Buoi4_bt2;

import java.util.Scanner;

public class KETQUA {
	Scanner sc = new Scanner(System.in);
	
	//------------------
	//FIELD
	private String maSV;
	private String maMH;
	private float diemThi;
	//------------------
	//SETTER & GETTER
	public String getMaSV() {
		return maSV;
	}


	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}


	public String getMaMH() {
		return maMH;
	}


	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}


	public float getDiemThi() {
		return diemThi;
	}


	public void setDiemThi(float diemThi) {
		this.diemThi = diemThi;
	}
	//----------------------
	//CONTRUCTOR
	public KETQUA(String maSV, String maMH, float diemThi) {
		super();
		this.maSV = maSV;
		this.maMH = maMH;
		this.diemThi = diemThi;
	}
	
	public KETQUA() {
		super();
	}

	//----------------------
	//METHOD
	
	public void addInfoKQ() {
		//MA SINH VIEN
		while(true) {
			System.out.print("NHAP MA SINH VIEN: ");
			this.maSV = sc.nextLine();
			if(this.maSV.length() != 4) {
				System.out.println("VUI LONG NHAP MA SINH VIEN CO 4 KY TU");
			}else {
				break;
			}
		}
		//MA MON HOC
		while(true) {
			System.out.print("NHAP MA MON HOC: ");
			this.maMH = sc.nextLine();
			if(this.maMH.length() != 4) {
				System.out.println("VUI LONG NHAP MA MON HOC CO 4 KY TU");
			}else {
				break;
			}
		}
		//DIEM
		while(true) {
			System.out.print("NHAP DIEM CUA MON HOC: ");
			this.diemThi = sc.nextFloat();
			if(this.diemThi > 10 || this.diemThi < 0) {
				System.out.println("VUI LONG NHAP DIEM THI LON 0 VA NHO HON 10");
			}else {
				break;
			}
		}
	}

}
