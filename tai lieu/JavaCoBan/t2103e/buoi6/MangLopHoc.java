package buoi6;

import java.util.Scanner;


/*
 * Viet chuong trinh nhap lophoc vao mang
 * in ra thong tin lophoc trong mang
 * tim lophoc co ton tai hay khong trong mang, co thi in thong tin
 * sap xep cac lophoc co trong mang theo chieu giam dan cua malop
 * */
public class MangLopHoc {
	private LopHoc[] dsLopHoc;
	// bien danh dau so luong phan tu lophoc != null trong dsLopHoc
	private int count;
	
	public MangLopHoc() {
		this.dsLopHoc = new LopHoc[50];
		this.count = 0;
	}

	public LopHoc[] getDsLopHoc() {
		return dsLopHoc;
	}
	public void setDsLopHoc(LopHoc[] dsLopHoc) {
		this.dsLopHoc = dsLopHoc;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	// them 1 lophoc tu ban phim vao mang:
	public void addLopHoc() {
		// tao 1 lophoc va nhap thong tin
		LopHoc lopHoc = new LopHoc();
		lopHoc.nhap();
		// add vao mang
		this.dsLopHoc[this.count++] = lopHoc;
	}
	// in ra ds cac phan tu != null cua mang 
	public void showDs() {
		System.out.println("In danh sach lop hoc: ");
		for(int i=0; i< this.count; i++) {
			System.out.println("LopHoc thu "+ (i+1) + ":");
			System.out.println(this.dsLopHoc[i].xuat());
		}
	}
	// nhap malop can tim lop
	public LopHoc findLopHoc() {
		///nhap 1 malop roi tra ve lophoc co malop = malop nhap
		Scanner sc = new Scanner(System.in);
		System.out.println("Ma lop hoc can tim: ");
		String malopfind = sc.nextLine();
		for (int i=0; i< this.count; i++) {
			LopHoc lh = this.dsLopHoc[i];
			if (malopfind.equalsIgnoreCase(lh.getMaLop())) {
				return lh;
			}
		}
		return null;
	}
	// sap xep giam dan lophoc theo ma
	public void sortDs() {
		
	}
}
