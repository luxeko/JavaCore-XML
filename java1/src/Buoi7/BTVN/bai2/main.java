package java1.src.Buoi7.BTVN.bai2;

import java.util.Scanner;

public class main {
    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int functionID = 0;
        boolean flag = true;
        sinhVien test = new sinhVien();
        dsSV test2 = new dsSV();
        do{
            showMenu();
            System.out.print("Choose: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1:
                    test.nhap();
                    test.xuat();
                    break;
                case 2:
                    test2.taoDSSV();
                    break;
                case 3:
                    test2.addSV();
                    break;
                case 4:
                case 5:

                    break;
                case 6:
                    test2.deleteSV();
                    break;
                case 7:
                    System.out.println("Ket thuc!");
                    System.exit(1);
                default:
                    System.out.println("Nhap khong dung lua chon");

            }
            if(functionID ==6 ) flag = false;
        }while(flag == true);
        sc.close();
    }
    public static void showMenu() {
        System.out.println("======= SinhVien Manage =======");
        System.out.println("1. Tao doi tuong sinh vien");
        System.out.println("2. Tao danh sach sinh vien");
        System.out.println("3. Them sinh vien vao danh sach sinh vien");
        System.out.println("4. Sap xep danh sach sinh vien theo thu tu tang dan ten hoac nganh hoc");
        System.out.println("5. Xoa sinh vien khi nhap ma sv");
        System.out.println("6. Thoat");
    }
}
