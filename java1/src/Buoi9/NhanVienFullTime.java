package java1.src.Buoi9;

import java.util.Scanner;

public class NhanVienFullTime extends NhanVien {
    private float hsLuongBh;
    private float hsLuongCb;


    public NhanVienFullTime(){
        super();
    }
    public NhanVienFullTime(float hsLuongBh, float hsLuongCb) {
        super();
        this.hsLuongBh = hsLuongBh;
        this.hsLuongCb = hsLuongCb;
    }
    public float getHsLuongBh() {
        return hsLuongBh;
    }
    public void setHsLuongBh(float hsLuongBh) {
        this.hsLuongBh = hsLuongBh;
    }
    public float getHsLuongCb() {
        return hsLuongCb;
    }
    public void setHsLuongCb(float hsLuongCb) {
        this.hsLuongCb = hsLuongCb;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.println("Nhap hsLuongBh: ");
        this.hsLuongBh = sc.nextFloat();
        System.out.println("Nhap hsLuongCb: ");
        this.hsLuongCb = sc.nextFloat();
        sc.close();
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Nhap hsLuongBh: " + this.hsLuongBh);
        System.out.println("Nhap hsLuongCb: " + this.hsLuongCb);
        System.out.println("Cong: " + this.tinhCong() + "; " + "Luong: " + this.tinhLuong());

    }
    @Override
    public float tinhCong() {
        // Vi tri nv: nhan vien hoac nv thi 24 ngay cong
        // Nguoc lai: 26 ngay cong
        if (this.getViTriLv().startsWith("nv") || this.getViTriLv().contains("nhan vien")){
            return 24;
        }else{
            return 26;
        }
    }
    @Override
    public long tinhLuong() {
        return (long)((this.hsLuongBh + this.hsLuongCb) * this.tinhCong()*1000);
    }
    
    
}
