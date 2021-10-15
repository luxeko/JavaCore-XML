package java1.src.Buoi8.BTVN.Bai3;

import java.util.Scanner;

public class TaiLieu {
    private String taiLieuID;
    private String taiLieuName;
    private String nhaXbName;
    private int soBanPhatHanh;

    public TaiLieu(){
    }
    public TaiLieu(String taiLieuID, String taiLieuName, String nhaXbName, int soBanPhatHanh) {
        this.taiLieuID = taiLieuID;
        this.taiLieuName = taiLieuName;
        this.nhaXbName = nhaXbName;
        this.soBanPhatHanh = soBanPhatHanh;
    }
    public String getTaiLieuID() {
        return taiLieuID;
    }
    public void setTaiLieuID(String taiLieuID) {
        this.taiLieuID = taiLieuID;
    }
    public String getTaiLieuName() {
        return taiLieuName;
    }
    public void setTaiLieuName(String taiLieuName) {
        this.taiLieuName = taiLieuName;
    }
    public String getNhaXbName() {
        return nhaXbName;
    }
    public void setNhaXbName(String nhaXbName) {
        this.nhaXbName = nhaXbName;
    }
    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }
    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma tai lieu: ");
        this.taiLieuID = sc.nextLine();
        System.out.println("Nhap ten tai lieu: ");
        this.taiLieuName = sc.nextLine();
        System.out.println("Nhap ten nha XB");
        this.nhaXbName = sc.nextLine();
        System.out.println("Nhap so ban phat hanh: ");
        this.soBanPhatHanh = Integer.parseInt(sc.nextLine());
        sc.close();
    }
    public void output(){
        System.out.println("Ma tai lieu: " + this.taiLieuID);
        System.out.println("Ten tai lieu: " + this.taiLieuName);
        System.out.println("Ten nha xb: " + this.nhaXbName);
        System.out.println("So ban phat hanh: " + this.soBanPhatHanh );
    }
}

