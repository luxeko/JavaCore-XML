package java1.src.Buoi7.BTVN.bai1;

import java.util.Scanner;

public class bai1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int functionID = 0;
        boolean flag = true;
        Bai1 test = new Bai1();
        do{
            showMenu();
            System.out.print("Choose: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1:
                    test.nhap();;
                    break;
                case 2:
                    test.duyet();
                    break;
                case 3:
                    test.loaiCacPhanTuTrung();
                    break;
                case 4:
                case 5:
                    test.showInfo();
                    break;
                case 6:
                    test.daoNguoc();
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
        System.out.println("======= Arraylist Manage =======");
        System.out.println("1. Nhap cac phan tu vao Arraylist");
        System.out.println("2. Duyet mang bang nhieu cach");
        System.out.println("3. Loai bo cac phan tu trung nhau va hien thi list");
        System.out.println("4. Dem so lan xuat hien cua cac phan tu");
        System.out.println("5. Nhap 1 so tu ban phim, hien thi cac chi so(index) cua phan tu ay");
        System.out.println("6. Dao nguoc va xao tron mang");
        System.out.println("7. Thoat");
    }
}
