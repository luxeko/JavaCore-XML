package java1.src.Buoi7.BTVN.bai2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class dsSV {
    long nhapID;
    public dsSV(){

    }
    public dsSV(int nhapID) {
        this.nhapID = nhapID;
    }
    public long getNhapID() {
        return nhapID;
    }
    public void setNhapID(long nhapID) {
        this.nhapID = nhapID;
    }

    public dsSV(ArrayList<sinhVien> dsSV) {
        this.dsSV = dsSV;
    }

    ArrayList<sinhVien> dsSV = new ArrayList<sinhVien>();
    Scanner sc = new Scanner(System.in);
    public void taoDSSV(){
        dsSV.add(new sinhVien());
        sinhVien sinhvien1 = new sinhVien(001, "DucAnh", 1999 , "Thanh Hoa", "Nam", "CNTT");
        dsSV.add(sinhvien1);
        dsSV.add(new sinhVien(002, "Hoang", 1999 , "Ha Noi", "Nam", "CNTT"));
        dsSV.add(new sinhVien(003, "Trang", 2000 , "Ha Noi", "Nu", "Ke Toan"));
        dsSV.add(new sinhVien(004, "Linh", 1999 , "Ha Noi", "Nu", "QTKD"));
        dsSV.add(new sinhVien(005, "Tuan", 1999 , "Hai Phong", "Nam", "Luat"));
        dsSV.add(new sinhVien(006, "Nam", 1998 , "Nghe An", "Nam", "Bao Tri"));
        dsSV.add(new sinhVien(007, "Tung", 1999 , "Bac Giang", "Nam", "CNTT"));

        Iterator<sinhVien> ite = dsSV.iterator();
        while(ite.hasNext()){
            sinhVien obj = ite.next();
            System.out.println(obj.xuat());
        }
    }

    public void addSV(){

    }
    public void sortSV(){

    }

    public void searchSV(){

    }
    public void deleteSV(){
        sinhVien sv1 = new sinhVien();
        System.out.println("Nhap ma sinh vien muon xoa: ");
        this.nhapID = sc.nextInt();
        do{
            if(this.nhapID == sv1.getIdSinhVien()){
                dsSV.remove(new sinhVien());
                Iterator<sinhVien> ite = dsSV.iterator();
                while(ite.hasNext()){
                    sinhVien obj = ite.next();
                    System.out.println(obj.xuat());
                }  
                break;
            }else{
                System.out.println("Ma sinh vien khong ton tai!");
            }
        }while(this.nhapID < 000  && this.nhapID > 999);

    }

}
