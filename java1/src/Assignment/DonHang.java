package java1.src.Assignment;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import java.text.ParseException;

public class DonHang {
    private String tenKhachHang;
    private ArrayList<SanPham> dsSanPham;
    private Date ngayMua;
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public DonHang() {
        this.dsSanPham = new ArrayList<SanPham>();
    }
    
    public ArrayList<SanPham> getDsSanPham() {
        return dsSanPham;
    }
    public void setDsSanPham(ArrayList<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }
    public DonHang(String tenKhachHang, ArrayList<SanPham> dsSanPham, Date ngayMua) {
        this.tenKhachHang = tenKhachHang;
        this.dsSanPham = dsSanPham;
        this.ngayMua = ngayMua;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Nhập tên khách hàng: ");
            this.tenKhachHang = sc.nextLine();
            if (this.tenKhachHang.length() > 1) {
                break;
            }else{
                System.out.println("Tên khách hàng phải có 2 ký tự trở lên");
            }
        }
        do{
            System.out.println("Nhập ngày mua hàng: ");
            String sdate = sc.nextLine();
            // su dung sdf de chuyen doi string sang date
            try {
                this.ngayMua = sdf.parse(sdate);
            } catch (ParseException e) {
                System.out.println("Ngày mua ko hợp!");;
            }
        }while(this.ngayMua == null);
    }

    void nhapSpVaoDonHang(DsSanPham dsSanPham) {
        Scanner sc = new Scanner(System.in);
        String confirm = "";
        String maSP;
        do{
            int count = 0;
            System.out.println("Nhập mã sản phẩm muốn thêm vào đơn hàng: ");
            maSP = sc.nextLine();
            for(SanPham sp : dsSanPham.getDsSanPham()){
                if(maSP.equals(sp.getMaSanPham())){
                    this.dsSanPham.add(sp);
                    count++;
                }
            }
            if(count == 0) {
                System.out.println("Không có sản phẩm");
            }
            System.out.println("Bạn có muốn thêm sản phẩm vào đơn hàng? Nhấn 'n' để thoát");
            confirm = sc.nextLine();
        }while(!confirm.equalsIgnoreCase("n"));
    }
    String xuatDonHang(){
        String s = "";
        for(SanPham sp : this.dsSanPham){
            s += (sp.toString() + "\n");
        }
        return s;
    }
    public void output(){
        System.out.println("Tên khách hàng: " + this.tenKhachHang);
        System.out.println("Ngày mua " +  sdf.format(this.ngayMua));
        System.out.println("Danh sách sản phẩm: ");
        System.out.println(this.xuatDonHang());
    }    

    
}
