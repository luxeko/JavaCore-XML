package java1.src.Buoi9;

import java1.src.Buoi8.Nguoi;

public class NhanVienMain {
    public static void main(String[] args) {
        /**
         * NhanVien nv1 = new NhanVien(); sai!
         * - class abstract thi ko tao dc doi tuong tu class nay
         */
        NhanVien nv1 = new NhanVienFullTime();
        Nguoi n1 = new NhanVienFullTime();
        NhanVienFullTime nvft = new NhanVienFullTime();
        ((NhanVienFullTime)n1).tinhCong();
        nv1.nhap();
        nv1.xuat();
        nvft.nhap();
        nvft.xuat();

        NhanVien partime = new NhanVienPartTime();
        partime.nhap();
        partime.xuat();
    }
}
