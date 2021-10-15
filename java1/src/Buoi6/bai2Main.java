package java1.src.Buoi6;

import java.util.Scanner;

public class bai2Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bai2 test = new Bai2();
        String confirm = "";
        do{
            System.out.println("===== Thao tac voi mang mot chieu =====");
            System.out.println("1. Khai bao mang");
            System.out.println("2. Nhap cac phan tu cho mang");
            System.out.println("3. In ra phan tu nho nhat va lon nhat");
            System.out.println("4. Tim so lan xuat hien cua phan tu");
            System.out.println("5. Sap xep mang theo giam dan");
            System.out.println("6. Thoat");
            System.out.printf("Nhap lua chon: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.println("1. Khai bao mang: ");
                    test.khaiBaoMang();
                    break;
                case 2:
                    System.out.println("2. Nhap cac phan tu cho mang: ");
                    test.nhapMang();
                    break;
                case 3:
                    System.out.println("3. In ra phan tu nho nhat va lon nhat:");
                    test.minMax();
                    break;
                case 4:
                    System.out.println("4. Tim so lan xuat hien cua phan tu:");
                    test.demSo();
                    break;
                case 5:
                    System.out.println("5. Sap xep thu tu giam dan cua cac phan tu: ");
                    test.sortArr();
                    break;
                case 6:
                    System.out.println("Ket thuc!");
                    System.exit(1);
                default:
                    System.out.println("Nhap khong dung lua chon");
            }
            System.out.println("Ban co muon dung chuong trinh? (n: stop)");
            confirm = sc.nextLine();
        }while(!confirm.equalsIgnoreCase("n"));
        sc.close();
    }
}
