package java1.src.Buoi8.BTVN.Bai1;

import java.util.Scanner;

public class student extends person{
    private String maSV;
    private float diemTB;
    private String email;
    Scanner sc = new Scanner(System.in);
    
    public student(){
        super();
    }
    public student(String ten, String gioiTinh, int namSinh, String diaChi, String maSV, float diemTB, String email) {
        super(ten, gioiTinh, namSinh, diaChi);
        this.maSV = maSV;
        this.diemTB = diemTB;
        this.email = email;
    }
    public String getMaSV() {
        return maSV;
    }
    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
    public float getDiemTB() {
        return diemTB;
    }
    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Nhap maSV: ");
        this.maSV = sc.nextLine();
        while(true){
            System.out.println("Nhap diem TB: ");
            this.diemTB = sc.nextFloat();
            sc.nextLine();
            if(this.diemTB > 10 || this.diemTB < 0){
                System.out.println("Diem TB nhap vao khong dung!");
            }
            else{
                break;
            }
        }
        System.out.println("Nhap email: ");
        this.email = sc.nextLine();
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("MaSV: " + this.maSV);
        if(this.diemTB < 5 && this.diemTB >= 0){
            System.out.println("Hoc luc: Yeu");
        }else if(this.diemTB < 7){
            System.out.println("Hoc luc: Trung binh");
        }else if(this.diemTB < 9){
            System.out.println("Hoc luc: Kha");
        }else if(this.diemTB < 11){
            System.out.println("Hoc luc: Gioi");
        }
        System.out.println("Email: " + this.email);
    }
    
    
    
}
