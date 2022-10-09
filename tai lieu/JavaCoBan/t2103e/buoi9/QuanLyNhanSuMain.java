package buoi9;

import java.util.Scanner;

import buoi8.GiangVien;

public class QuanLyNhanSuMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// menu 
		
		// thuc thi chuong trinh
		System.out.println("Chon lua chuc nang: ");
		int choose = sc.nextInt();
		switch(choose) {
			case 1:
				System.out.println("1. Them 1 Giang vien moi vao mang: ");
				GiangVien gv = new GiangVien();
				gv.nhap();
				if (QuanLyNhanSu.addNew(gv)) {
					System.out.println("Them 1 gv thanh cong.");
				} else {
					System.out.println("Them 1 gv that bai.");
				}
				break;
			case 2:
				System.out.println("2. Them 1 Nhan vien fulltime moi vao mang: ");
				NhanVienFullTime nv = new NhanVienFullTime();
				nv.nhap();
				if (QuanLyNhanSu.addNew(nv)) {
					System.out.println("Them 1 nvft thanh cong.");
				} else {
					System.out.println("Them 1 nvft that bai.");
				}
				break;
			case 3:
				//
				break;
			case 4:
				//
				break;
			case 5:
				// tim kiem
				break;
			case 6:
				// hien thi ds
				QuanLyNhanSu.showDs();
				break;
			case 7:
				QuanLyNhanSu.sapXepNguoiByTenDesc();
				break;
			default:
				break;
		}
		
		// tiep tuc
		
		
	}

}
