package java1.src.Buoi8.BTVN.Bai3;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Bao extends TaiLieu{
    private Date ngayPhatHanh;
    final SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

    public Bao() {
    }
    public Bao(String taiLieuID, String taiLieuName, String nhaXbName, int soBanPhatHanh, Date ngayPhatHanh) {
        super(taiLieuID, taiLieuName, nhaXbName, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }
    public Date getNgayPhatHanh() {
        return ngayPhatHanh;
    }
    public void setNgayPhatHanh(Date ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }
    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Nhap ngay phat hanh: ");
            String sdate = sc.nextLine();
            // su dung sdf de chuyen doi string sang date
            try {
                this.ngayPhatHanh = sdf.parse(sdate);
            } catch (ParseException e) {
                System.out.println("Ngay phat hanh khong chinh xac!");
            }
        }while(this.ngayPhatHanh == null);
        sc.close();
    }
    @Override
    public void output() {
        System.out.println("\n"+"--- Info Bao ---");
        super.output();
        System.out.println("Ngay phat hanh: " + this.ngayPhatHanh);
    }
    
    
}
