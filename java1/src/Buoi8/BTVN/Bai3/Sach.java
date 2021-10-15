package java1.src.Buoi8.BTVN.Bai3;

import java.util.Scanner;

public class Sach extends TaiLieu{
    private String tacGiaName;
    private int soTrang;

    public Sach() {
        super();
    }
    public Sach(String taiLieuID, String taiLieuName, String nhaXbName, int soBanPhatHanh, String tacGiaName,
            int soTrang) {
        super(taiLieuID, taiLieuName, nhaXbName, soBanPhatHanh);
        this.tacGiaName = tacGiaName;
        this.soTrang = soTrang;
    }
    public String getTacGiaName() {
        return tacGiaName;
    }
    public void setTacGiaName(String tacGiaName) {
        this.tacGiaName = tacGiaName;
    }
    public int getSoTrang() {
        return soTrang;
    }
    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }
    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten tac gia: ");
        this.tacGiaName = sc.nextLine();
        System.out.println("Nhap so trang: ");
        this.soTrang = Integer.parseInt(sc.nextLine());  
        sc.close();
    }
    @Override
    public void output() {
        System.out.println("\n"+ "--- Info Sach ---");
        super.output();
        System.out.println("Ten tac gia: " + this.tacGiaName);
        System.out.println("So trang: " + this.soTrang );
    }
    

    
}
