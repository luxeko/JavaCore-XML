package java1.src.Assignment;

import java.util.Scanner;

public class SanPham{
    private String maNhomHang;
    private String maSanPham;
    private String maVach;
    private String tenHang;
    private String moTa;
    private float giaNhap;
    private float giaBan;
    public static int ascNumber = 1;

    public SanPham(){
    }

    public SanPham (String maNhomHang , String maSanPham, String maVach, String tenHang,
            String moTa, float giaNhap, float giaBan) {
        this.maNhomHang = maNhomHang;
        this.maSanPham = maSanPham;
        this.maVach = maVach;
        this.tenHang = tenHang;
        this.moTa = moTa;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }
    
    public String getMaSanPham() {
        return maSanPham;
    }
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }
    public float getGiaBan() {
        return giaBan;
    }
    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public void input(DsNhomHang dsNhomHang){
        Scanner sc = new Scanner(System.in);
        String maNhomHang;
        boolean isAvailble = false;
        while (true) {
            while (true) {
                System.out.print("Nhập mã nhóm hàng của sản phẩm: ");
                maNhomHang = sc.nextLine();
                for(NhomHang nh : dsNhomHang.getDsNhomHang()) {
                    if(maNhomHang.equals(nh.getMaNhomHang())) {
                        this.maNhomHang = maNhomHang;
                        isAvailble = true;
                        break;
                    }
                }
                if(isAvailble) {
                    break;
                }
                System.out.println("Mã ko tồn tại");
            }
            if(this.maNhomHang.length() == 4) break;
            System.out.println("Mã nhóm hàng phải có 4 ký tự và không được để trống!");
        }
        String s = String.valueOf(ascNumber);
        if(ascNumber < 10) {
            this.maSanPham = this.maNhomHang + "000" + s;
        } else if (ascNumber < 100) {
            this.maSanPham = this.maNhomHang + "00" + s;
        } else if (ascNumber < 1000) {
            this.maSanPham = this.maNhomHang + "0" + s; 
        } else {
            this.maSanPham = this.maNhomHang + s;
            
        }
        ascNumber ++;
        System.out.println("Nhập mã vạch: ");
        this.maVach = sc.nextLine();
        System.out.println("Nhập tên: ");
        this.tenHang = sc.nextLine();
        System.out.println("Nhập mô tả: ");
        this.moTa = sc.nextLine();
        while(true){
            System.out.println("Nhập giá nhập: ");
            try {
                this.giaNhap = Float.parseFloat(sc.nextLine());
                if(this.giaNhap > 0){
                    break;
                }else{
                    System.out.println("Giá nhập phải > 0");
                }
            } catch (Exception e) {
                System.out.println("Giá phải là kiểu số");
            }
        }
        while(true){
            System.out.println("Nhập giá bán: ");
            try {
                this.giaBan = Float.parseFloat(sc.nextLine());
                if(this.giaBan > 0){
                    break;
                }else{
                    System.out.println("Giá nhập phải > 0");
                }
            } catch (Exception e) {
                System.out.println("GIá phải là kiểu số");
            }
        }
    }
    
    public void output() {
        System.out.println("Mã sản phẩm: " + this.maSanPham);
        System.out.println("Mã vạch: " + this.maVach);
        System.out.println("Tên sản phẩm: " + this.tenHang);
        System.out.println("Mô tả: " + this.moTa);
        System.out.println("Giá nhập: " + this.giaNhap);
        System.out.println("Giá bán: " + this.giaBan + "\n");
    }

    @Override
    public String toString() {
        return " [maSanPham=" + maSanPham  + ", maVach=" + maVach
                + ", moTa=" + moTa + ", tenHang=" + tenHang + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + "]";
    }
    public String inMaSanPham(){
        return  "Mã sản phẩm hiện có: " + maSanPham;
    }
    
}
