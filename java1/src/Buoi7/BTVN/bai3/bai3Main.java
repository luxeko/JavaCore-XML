package java1.src.Buoi7.BTVN.bai3;

import java.util.Scanner;

public class bai3Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int functionID = 0;
        boolean flag = true;
        BookHouse test = new BookHouse();
        do{
            showMenu();
            System.out.print("Choose: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1:
                    test.nhap1();
                    break;
                case 2:
                    test.nhap2();
                case 3:

                case 4:
                    
                case 5:    
                    test.inSach();
                    break;
                case 6:
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
        System.out.println("======= Book Manage =======");
        System.out.println("1. Them 1 quyen sach vao ke theo ma ke");
        System.out.println("2. Them 1 quyen sach vao ke theo vi tri ke");
        System.out.println("3. Hien thi thong tin sach nam o ke nao theo ma sach");
        System.out.println("4. In thong tin danh sach nha sach");
        System.out.println("5. In tong so sach nha sach hien co");
        System.out.println("6. Thoat");
        
    }
}
