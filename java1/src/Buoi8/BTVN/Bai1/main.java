package java1.src.Buoi8.BTVN.Bai1;

import java.util.Scanner;

import java.util.ArrayList;

public class main {
    public static void Main(String[] args) {
        ArrayList<person> listNguoi = new ArrayList<person>();
        ArrayList<person> listHs = new ArrayList<person>();
        ArrayList<person> listGv = new ArrayList<person>();
        Scanner sc = new Scanner(System.in);
        int functionID = 0;
        boolean flag = true;
        do{
           
            showMenu();
            System.out.print("Choose: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1:
                    person gv = new teacher();
                    gv.nhap();
                    listNguoi.add(gv);
                    listGv.add(gv);
                    break;
                case 2:
                    person hs = new student();
                    hs.nhap();
                    listNguoi.add(hs);
                    listHs.add(hs);
                    break;
                case 3:
                    person nguoi = new person();
                    nguoi.nhap();
                    listNguoi.add(nguoi);
                    break;
                case 4:
                    for(int i = 0; i< listNguoi.size(); i++){
                        System.out.println("---Person " + (i+1) + "---");
                        person tmp = listNguoi.get(i);           
                        if(tmp instanceof person){
                            tmp.xuat(); // xuat cua nguoi
                        }
                    }
                    break;
                case 5:  
                    for(int i = 0; i< listHs.size(); i++){
                        System.out.println("---Hoc vien thu " + (i+1) + "---");
                        person tmp = listHs.get(i);           
                        if(tmp instanceof student){
                            tmp.xuat(); // xuat cua hoc vien
                        }
                    }  
                    break;
                case 6:
                    for(int i = 0; i< listGv.size(); i++){
                        System.out.println("---Giang vien thu " + (i+1) + "---");
                        person tmp = listGv.get(i);           
                        if(tmp instanceof teacher){
                            tmp.xuat(); // xuat cua giang vien
                        }     
                        
                    }
                    break;
                case 7:
                    System.out.println("Ket thuc!");
                    System.exit(1);
                default:
                    System.out.println("Nhap khong dung lua chon");

            }
            if(functionID == 7 ) flag = false;
        }while(flag == true);
        
        sc.close();

    }

    public static void showMenu() {
        System.out.println("======= School Manage =======");
        System.out.println("1. Nhap giang vien va them giang vien");
        System.out.println("2. Nhap hoc sinh va them hoc sinh");
        System.out.println("3. Nhap nguoi va them nguoi");
        System.out.println("4. Hien thi thong tin danh sach quan ly");
        System.out.println("5. Hien thi danh sach sinh vien va xep loai");
        System.out.println("6. Hien thi danh sach giao vien va luong giao vien");
        System.out.println("7. Thoat");
        
    }
}
