package java1.src.Buoi6;

import java.util.Scanner;

import java1.src.Buoi4.LopHoc;

public class mainBuoi6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MangLopHoc mangLopHoc = new MangLopHoc();
        /**
         * Xay dung menu quan ly lophoc
         * 1. Them 1 lop hoc moi vao ds
         * 2. Hien thi lop hoc != null
         * 3. Tim lophoc theo ma
         * 4. Sap xep ds lop hoc giam dan theo malop
         * 5. Thoat
         */
        String confirm = "";
        do{
            //in ra menu
            System.out.println("===== Quan ly lop hoc =====");
            System.out.println("1. Them 1 lop hoc moi vao ds");
            System.out.println("2. Hien thi lop hoc != null");
            System.out.println("3. Tim lop hoc theo ma");
            System.out.println("4. Sap xep ds lop hoc giam dan theo malop");
            System.out.println("5. So luong lop hoc va tong so luong hoc sinh");
            System.out.println("6. Lop hoc co so luong hoc vien nho nhat va lon nhat");
            System.out.println("7. Sap xep ds lop hoc theo tang dan cua so luong hoc vien");
            System.out.println("8. Thoat");
            //lua chon
            System.out.printf("Nhap lua chon: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch(choose){
                case 1:
                    System.out.println("1. Them 1 lop hoc moi vao ds");
                    mangLopHoc.addLopHoc();
                    break;
                case 2:
                    System.out.println("2. Hien thi lop hoc");
                    mangLopHoc.showDs();
                    break;
                case 3:
                    System.out.println("3. Tim lophoc theo ma");
                    LopHoc lhFind = mangLopHoc.searchDs();
					if (lhFind != null) {
						System.out.println(lhFind.xuat());
					} else {
						System.out.println("Khong tim thay lop hoc!");
					}
					break;
                    
                case 4:
                    System.out.println("4. Sap xep ds lop hoc giam dan theo malop");
                    mangLopHoc.sortDs();
                    mangLopHoc.showDs();
                    break;
                case 5:
                    System.out.println("5. So luong lop hoc va tong so luong hoc sinh");
                    mangLopHoc.sumLopHoc(); 
                    mangLopHoc.showDs();
                    break;
                case 6:
                    System.out.println("6. Lop hoc co so luong hoc vien nho nhat va lon nhat");
                    mangLopHoc.minMax(); 
                    mangLopHoc.showDs();
                    break;
                case 7: 
                    System.out.println("7. Sap xep ds lop hoc tang dan cua so luong hoc vien");
                    mangLopHoc.sortHocVien();
                    mangLopHoc.showDs();
                    break;
                case 8:
                    System.out.println("Ket thuc!");
					System.exit(1);
                default:
                    System.out.println("Nhap khong dung lua chon");

            }

            System.out.println("Ban co muon stop nhap Lop Hoc? (n: stop)");
            confirm = sc.nextLine();
        }while(!confirm.equalsIgnoreCase("n"));
        sc.close();
    }
}
