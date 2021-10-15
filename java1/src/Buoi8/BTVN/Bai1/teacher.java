package java1.src.Buoi8.BTVN.Bai1;

import java.util.Scanner;

public class teacher extends person {
    private String maLop;
    private long luongMotGio;
    private float soGioDay;
    Scanner sc = new Scanner(System.in);
    public teacher(){
        super();
    }
    public teacher(String ten, String gioiTinh, int namSinh, String diaChi, String maLop, long luongMotGio,
            float soGioDay) {
        super(ten, gioiTinh, namSinh, diaChi);
        this.maLop = maLop;
        this.luongMotGio = luongMotGio;
        this.soGioDay = soGioDay;
    }
    public String getMaLop() {
        return maLop;
    }
    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
    public float getLuongMotGio() {
        return luongMotGio;
    }
    public void setLuongMotGio(long luongMotGio) {
        this.luongMotGio = luongMotGio;
    }
    public float getSoGioDay() {
        return soGioDay;
    }
    public void setSoGioDay(float soGioDay) {
        this.soGioDay = soGioDay;
    }
    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Nhap ma lop: ");
        this.maLop = sc.nextLine();
        System.out.println("Nhap luong/h: ");
        this.luongMotGio = sc.nextInt();
        System.out.println("Nhap so gio day/thang: ");
        this.soGioDay = sc.nextFloat();
        sc.nextLine();
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Ma lop: " + this.maLop);
        System.out.println("Luong: " + this.tinhLuong());
        System.out.println("Gio day: " + this.soGioDay);
    }

    public long tinhLuong() {
        if (this.getMaLop().startsWith("T") || this.getMaLop().startsWith("V") || this.getMaLop().startsWith("A") ){
            return (long)((this.luongMotGio + 50000)*this.soGioDay);
        }else if(this.getMaLop().startsWith("L") || this.getMaLop().startsWith("H") || this.getMaLop().startsWith("S") ){
            return (long)((this.luongMotGio - 20000)*this.soGioDay);
        }
        else{
            return (long)(this.luongMotGio*this.soGioDay);
        }
    }
    
    
}
