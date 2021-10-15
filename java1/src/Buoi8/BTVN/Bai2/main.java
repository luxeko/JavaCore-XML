package java1.src.Buoi8.BTVN.Bai2;

import java.util.Scanner;

public class main {

    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int functionID;
        boolean flag = true;
        Zoo soThu = new Zoo();
        do{
            showMenu();
            System.out.print("Choose: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1:
                    Chuong chuong = new Chuong();
                    chuong.nhap();
                    soThu.addChuong(chuong);
                    break;
                case 2:
                    System.out.println("Nhap ma chuong can xoa: ");
                    int maChuong = Integer.parseInt(sc.nextLine());
                    soThu.removeChuong(maChuong);
                    break;
                case 3:
                    soThu.addAnimal();
                    break;
                case 4:
                    soThu.removeAnimal();
                    break;
                case 5: 
                    soThu.xuat();
                    break;
                case 6:
                    System.out.println("Ket thuc!");
                    System.exit(1);
                default:
                    System.out.println("Nhap khong dung lua chon");

            }
            if(functionID == 6 ) flag = false;
        }while(flag == true);
        
        sc.close();

    }

    public static void showMenu() {
        System.out.println("======= Zoo Manage =======");
        System.out.println("1. Them chuong");
        System.out.println("2. Xoa chuong");
        System.out.println("3. Them con vat");
        System.out.println("4. Xoa con vat");
        System.out.println("5. Xem tat ca cac con vat");
        System.out.println("6. Thoat");        
    }
}

