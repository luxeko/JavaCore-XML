package java1.src.Buoi8.BTVN.Bai3;

import java.util.Scanner;

public class main {
    
    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int functionID;
        boolean flag = true;
        QuanLyThuVien qltv = new QuanLyThuVien();
        do{
            showMenu();
            System.out.print("Choose: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1:
                    TaiLieu tl = new TaiLieu();
                    tl.input();
                    qltv.addTaiLieu(tl);
                    break;
                case 2:
                    Sach sach = new Sach();
                    sach.input();
                    qltv.addSach(sach);
                    break;
                case 3:
                    TapChi tapChi = new TapChi();
                    tapChi.input();
                    qltv.addTapChi(tapChi);
                    break;
                case 4:
                    Bao bao = new Bao();
                    bao.input();
                    qltv.addBao(bao);
                    break;
                case 5: 
                    qltv.output();
                    break;
                case 6: 
                    qltv.kiemtraSach();
                    break; 
                case 7: 
                    qltv.removeTaiLieu();
                    break;
                case 8: 
                    qltv.timLoaiSach();
                    break;
                case 9: 
                    qltv.kiemtraSach();
                    break; 
                case 10:
                    System.out.println("Ket thuc!");
                    System.exit(1);
                default:
                    System.out.println("Nhap khong dung lua chon");

            }
            if(functionID == 10 ) flag = false;
        }while(flag == true);
        sc.close();
    }

    public static void showMenu() {
        System.out.println("======= Thu Vien Manage =======");
        System.out.println("1. Them 1 tai lieu");
        System.out.println("2. Them 1 sach");
        System.out.println("3. Them 1 tap chi");
        System.out.println("4. Them 1 bao");
        System.out.println("5. Xem danh sach");
        System.out.println("6. In thong tin tai lieu tu 1 doi tuong tai lieu dau vao");   
        System.out.println("7. Xoa tai lieu, sach, tap chi, bao khoi ds tai lieu");
        System.out.println("8. Tim danh sach doi tuong theo loai va hien thi ket qua tim kiem");
        System.out.println("9. Tim kiem sach tu ten sach va hien thi ket qua");
        System.out.println("10. Thoat!");     
    }
}
