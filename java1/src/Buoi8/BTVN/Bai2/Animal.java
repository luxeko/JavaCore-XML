package java1.src.Buoi8.BTVN.Bai2;

import java.util.Scanner;

public abstract class Animal{
    private String ten, mota;
    private int tuoi;
    Scanner sc = new Scanner(System.in);
    
    public Animal(){
    }
    public Animal(String ten, String mota, int tuoi) {
        this.ten = ten;
        this.mota = mota;
        this.tuoi = tuoi;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getMota() {
        return mota;
    }
    public void setMota(String mota) {
        this.mota = mota;
    }
    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public void nhap() {
        System.out.println("Nhap ten: ");
        ten = sc.nextLine();
        
        System.out.println("Nhap mo ta: ");
        mota = sc.nextLine();
        
        System.out.println("Nhap tuoi: ");
        tuoi = Integer.parseInt(sc.nextLine());
    }
    public void xuat() {
        System.out.println("Ten: "+ ten + ", Tuoi: " + tuoi + ", Mo ta: " + mota );
    }
    public abstract void tiengKeu();
    

}


    