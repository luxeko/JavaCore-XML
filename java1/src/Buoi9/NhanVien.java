package java1.src.Buoi9;

import java.util.Scanner;

import java1.src.Buoi8.Nguoi;


public abstract class NhanVien extends Nguoi{
    private String viTriLv;
    private String manv;

    public NhanVien() {
        
    }
    public NhanVien(String ten, int tuoi, String cmt, String email, String viTriLv, String manv) {
        super(ten, tuoi, cmt, email);
        this.viTriLv = viTriLv;
        this.manv = manv;
    }
    public String getViTriLv() {
        return viTriLv;
    }
    public void setViTriLv(String viTriLv) {
        this.viTriLv = viTriLv;
    }
    public String getManv() {
        return manv;
    }
    public void setManv(String manv) {
        this.manv = manv;
    }

    
    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap manv: ");
        this.manv = sc.nextLine();
        System.out.println("Nhap vi tri nv: ");
        this.viTriLv = sc.nextLine();
        sc.close();
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Ma NV " + this.manv);
        System.out.println("Vi tri nv: " + this.viTriLv);
    }

    // Ham truu tuong: ham chi khai bao va khong co than ham. Tuc la ko co { }
    public abstract long tinhLuong();
    public abstract float tinhCong();
    
}
