package Java2.src.Buoi2.BaiTap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class TaiKhoan {
    private String maKH;
    private String tenKH;
    private String loaiKH = "";
    private String soTK;
    private Date ngaySinh;
    private long cMT;
    private Date ngayTao;
    private Double soTien;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public TaiKhoan(){

    }
    public TaiKhoan(String maKH, String tenKH, String loaiKH, String soTK, Date ngaySinh, long cMT, Date ngayTao,
            Double soTien) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.loaiKH = loaiKH;
        this.soTK = soTK;
        this.ngaySinh = ngaySinh;
        this.cMT = cMT;
        this.ngayTao = ngayTao;
        this.soTien = soTien;
    }
        
    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public String getTenKH() {
        return tenKH;
    }
    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
    public String getSoTK() {
        return soTK;
    }
    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }
    
    public Double getSoTien() {
        return soTien;
    }
    public void setSoTien(Double soTien) {
        this.soTien = soTien;
    }
    void input(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Nhập mã kh: ");
            this.maKH = sc.nextLine();
            if (this.maKH.trim().equals("")) {
                System.out.println("Bạn chưa nhập!");
            }else{
                break;
            }
        }
        while(true){
            System.out.println("Nhập tên kh: ");
            this.tenKH = sc.nextLine();
            if(this.tenKH.length() > 1 ){
                break;
            }else if(this.tenKH.trim().equals("")){
                System.out.println("Bạn chưa nhập!");
            }else{
                System.out.println("Tên hơi ngắn :)) ");
            }
        }
        while(true){
            System.out.println("Loại kh");
            System.out.println("0. Cá nhân");
            System.out.println("1. Doanh nghiệp");
            System.out.printf("Chọn: ");
            try {
                int choose = Integer.parseInt(sc.nextLine());
                if(choose == 0){
                    this.loaiKH = "Cá nhân";
                    break;
                }else if(choose == 1){
                    this.loaiKH = "Doanh nghiệp";
                    break;
                }
                else{
                    System.out.println("Chọn 0 hoặc 1");
                }
            } catch (NullPointerException e) {
                System.out.println("Chọn 0 hoặc 1");
            }
        }
        while(true){
            System.out.println("Nhập số tk: ");
            this.soTK = sc.nextLine();
            if(this.soTK.startsWith("00") && this.soTK.length() == 8){
                break;
            }else{
                System.out.println("Số tk phải bắu đầu bằng 00 và có 8 ký tự");
            }
        }
        while(true){
            System.out.println("Nhập cmt: ");
            try {
                this.cMT = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("CMT phải là kiểu số");
            }
        }
        do{
            System.out.println("Nhập ngày sinh kh: ");
            String sdate = sc.nextLine();
            // su dung sdf de chuyen doi string sang date
            try {
                this.ngaySinh = sdf.parse(sdate);
            } catch (ParseException e) {
                System.out.println("Ngay sinh khong hop le!");;
            }
        }while(this.ngaySinh == null);
        this.ngayTao = new java.util.Date(); 
        while (true) {
            System.out.println("Nhập số tiền: ");
            try {
                this.soTien = Double.parseDouble(sc.nextLine());
                break;
            } catch (NullPointerException e) {
                System.out.println("Tiền phải là kiểu số");
            }
        }sc.close();
    }
    void output(){
        System.out.println("Mã kh: " + this.maKH);
        System.out.println("Tên kh: " + this.tenKH);
        System.out.println("Loại kh: " + this.loaiKH);
        System.out.println("Số tk: " + this.soTK);
        System.out.println("Ngày sinh: " + sdf.format(ngaySinh));
        System.out.println("CMT: " + this.cMT);
        System.out.println("Ngày tạo tk: " + this.ngayTao);
        System.out.println("Số tiền trong tk: " + this.soTien);
    }
    
    /*
	 * Nap tien vao tk:
	 * >0: nap thanh cong
	 * -1: so tien can nap khong hop le
	 * */
    public void napTien(double sotienCanNap) {
		if (sotienCanNap > 0) {
			this.soTien += sotienCanNap;
		}
	}
	/*
	 * Rut tien trong tk:
	 * >=0: rut thanh cong
	 * = -2: so tien can rut khong hop le
	 * = -1: so tien trong tk khong du de rut
	 * */
	public void rutTien(double sotienCanRut) {
		if (sotienCanRut > 0 && this.soTien >= sotienCanRut) {
			this.soTien -= sotienCanRut;
		} 
	}
    @Override
    public String toString() {
        return "Mã kh: " + this.maKH + ", " + " Tên kh: " + this.tenKH + ", " + " Loại kh: " + this.loaiKH + ", " + " Số tk: " + this.soTK + ", " + " Ngày sinh: " +  sdf.format(ngaySinh) + ", " + " CMT: " + this.cMT + ", " + " Ngày tạo tk: " +  sdf.format(ngayTao) + ", " + " Số tiền trong tk: " + this.soTien;
    }
    

}
