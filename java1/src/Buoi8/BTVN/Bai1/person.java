package java1.src.Buoi8.BTVN.Bai1;

import java.util.Scanner;

public class person {
    private String ten;
    private String gioiTinh;
    private int namSinh;
    private String diaChi;
    Scanner sc = new Scanner(System.in);
    
    public person(){
        super();
    }
    public person(String ten, String gioiTinh, int namSinh, String diaChi) {
        super();
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public int getNamSinh() {
        return namSinh;
    }
    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void nhap(){
        System.out.println("Nhap ten: " );
        this.ten = sc.nextLine();
        System.out.println("Nhap gioi tinh: ");
        this.gioiTinh = sc.nextLine();
        System.out.println("Nhap nam sinh: ");
        this.namSinh = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap dia chi: ");
        this.diaChi = sc.nextLine();
    }
    public void xuat(){
        System.out.println("Ten: " + this.ten);
        System.out.println("Gioi tinh: " + this.gioiTinh);
        System.out.println("Nam sinh: " + this.namSinh);
        System.out.println("Dia chi: " + this.diaChi);
    }

}
