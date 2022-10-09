package Buoi4_bt2;

import java.util.Scanner;

public class MONHOC {
	Scanner sc = new Scanner(System.in);
	//------------------
	//FIELD
	private String maMonHoc;
	private String tenMonHoc;
		
	//------------------
	//SETTER AND GETTER
	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	//CONTRUCTOR
	public MONHOC(String maMonHoc, String tenMonHoc) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
	}
	
	public MONHOC() {
		super();
	}

	//------------------
	//METHOD
	public void addInfoMonHoc() {
		//FIELD MA MON HOC
		while(true) {
			System.out.print("NHAP MA MON HOC: ");
			this.maMonHoc = sc.nextLine();
			if(this.maMonHoc.length() != 4) {
				System.out.println("VUI LONG NHAP MA MON HOC CO 4 KY TU");
			}else {
				break;
			}
		}
		//FIELD TEN MON HOC
		while(true) {
			System.out.print("NHAP TEN MON HOC: ");
			this.tenMonHoc = sc.nextLine();
			if(this.tenMonHoc != null) {
				break;
			}else {
				System.out.println("VUI LONG KHONG DE TRONG TEN MON HOC");
			}
		}
	}


}
