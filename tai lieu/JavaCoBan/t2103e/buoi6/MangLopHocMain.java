package buoi6;

import java.util.Scanner;


public class MangLopHocMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MangLopHoc mangLopHoc = new MangLopHoc();
		/*
		 * Xay dung menu quan ly lophoc
		 * 1. them 1 lop hoc moi vao ds
		 * 2. hien thi ds lophoc != null
		 * 3. tim lophoc theo ma
		 * 4. sapxep ds lop hoc giam dan theo ten
		 * 5. thoat
		 * */
		
		int i=0;
		String confirm = "";
		do {
			// in ra menu
			System.out.println("------quan ly lophoc-----");
			System.out.println("1. them 1 lop hoc moi vao ds");
			System.out.println("2. hien thi ds lophoc != null");
			System.out.println("3. tim lophoc theo ma");
			System.out.println("4. sapxep ds lop hoc giam dan theo ten");
			System.out.println("5. thoat");
			// lua chon
			System.out.println("Nhap lua chon: ");
			int choose = sc.nextInt();
			sc.nextLine();
			switch(choose) {
				case 1:
					System.out.println("1. them 1 lop hoc moi vao ds");
					mangLopHoc.addLopHoc();
					break;
				case 2:
					System.out.println("2. hien thi ds lophoc != null");
					mangLopHoc.showDs();
					break;
				case 3:
					System.out.println("3. tim lophoc theo ma");
					LopHoc lhFind = mangLopHoc.findLopHoc();
					if (lhFind != null) {
						System.out.println(lhFind.xuat());
					} else {
						System.out.println("Khong tim thay lop hoc!");
					}
					break;
				case 4:
					System.out.println("4. sapxep ds lop hoc giam dan theo ten");
					mangLopHoc.sortDs();
					mangLopHoc.showDs();
					break;
				case 5:
					System.out.println("Ket thuc!");
					System.exit(1);
				default:
					System.out.println("Nhap khong dung lua chon.");
			}
			
			
			System.out.println("Ban co muon stop chuong trinh hay khong? (n: stop)");
			confirm = sc.nextLine();
		}while(!confirm.equalsIgnoreCase("n"));
		
		mangLopHoc.showDs();
	}
}
