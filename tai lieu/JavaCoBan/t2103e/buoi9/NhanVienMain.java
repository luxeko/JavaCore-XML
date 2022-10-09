package buoi9;

import buoi8.Nguoi;

public class NhanVienMain {

	public static void main(String[] args) {
		/*
		 - class abstract thi khong tao duoc doi tuong tu class nay
		 * */
		NhanVien nv1 = new NhanVienFullTime();
		Nguoi n1 = new NhanVienFullTime();
		NhanVienFullTime nvft = new NhanVienFullTime();
		
		nv1.nhap();
		nv1.xuat();
	}

}
