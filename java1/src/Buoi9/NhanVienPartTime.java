package java1.src.Buoi9;

import java.util.Scanner;

public class NhanVienPartTime extends NhanVien {
    private float soGioLv;


    public NhanVienPartTime(){
        super();
    }
    public NhanVienPartTime(String ten, int tuoi, String cmt, String email, String viTriLv, String manv,
            float soGioLv) {
        super(ten, tuoi, cmt, email, viTriLv, manv);
        this.soGioLv = soGioLv;
    }
    public float getSoGioLv() {
        return soGioLv;
    }
    public void setSoGioLv(float soGioLv) {
        this.soGioLv = soGioLv;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so gio lv: ");
        this.soGioLv = sc.nextFloat();
        sc.close();
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Gio lam viec " + this.soGioLv);
        System.out.println("Cong: " + this.tinhCong() + "; " + "Luong: " + this.tinhLuong());
        
    }
    @Override
    public float tinhCong() {
        // Vi tri nv: nhan vien hoac nv thi 24 ngay cong
        // Nguoc lai: 26 ngay cong
        return (float)(this.soGioLv/8);
    }
    @Override
    public long tinhLuong() {
        return (long)(this.tinhCong()*5000);
    }
    
    
}
