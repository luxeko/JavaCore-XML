package java1.src.Buoi8.BTVN.Bai3;

import java.util.Scanner;

public class TapChi extends TaiLieu{
    private int soPhatHanh;
    private int thangPhatHanh;
    public TapChi() {
       super();
    }
    public TapChi(String taiLieuID, String taiLieuName, String nhaXbName, int soBanPhatHanh, int soPhatHanh,
            int thangPhatHanh) {
        super(taiLieuID, taiLieuName, nhaXbName, soBanPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }
    public int getSoPhatHanh() {
        return soPhatHanh;
    }
    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }
    public int getThangPhatHanh() {
        return thangPhatHanh;
    }
    public void setThangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }
    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so phat hanh: ");
        this.soPhatHanh = Integer.parseInt(sc.nextLine());
        while(true){
            System.out.println("Nhap thang phat hanh: ");
            this.thangPhatHanh = Integer.parseInt(sc.nextLine());
            if(this.thangPhatHanh > 12 || this.thangPhatHanh < 0){
                System.out.println("Thang phat hanh khong chinh xac!");
            }else{
                break;
            }
        }sc.close();
    }
    @Override
    public void output() {
        System.out.println("\n"+ "--- Info Tap Chi ---");
        super.output();
        System.out.println("So phat hanh: " + this.soPhatHanh);
        System.out.println("Thang phat hanh: " + this.thangPhatHanh);
    }
    
    
}
