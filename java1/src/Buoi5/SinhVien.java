package java1.src.Buoi5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java1.src.Buoi4.LopHoc;

public class SinhVien {
    //1. fields - thuộc tính
    private String hoTen;
    private Date ngaySinh;
    private String maSV;
    private float diemToan;
    private float diemVan;
    private float diemAnh = -1;
    private String email;
    private LopHoc lopHoc;
    private float diemTb;
    private String hocLuc;
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
   //2. constructor: public
    public SinhVien(){

    }
    public SinhVien(String hoTen, Date ngaySinh, String maSV, float diemToan, float diemVan, float diemAnh, String email, LopHoc lopHoc) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.maSV = maSV;
        this.diemToan = diemToan;
        this.diemVan = diemVan;
        this.diemAnh = diemAnh;
        this.email = email;
        this.lopHoc = lopHoc;
    }
    
    //3. set(gán giá trị cho thuộc tính)/get: lấy giá trị cho thuộc tính
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public Date getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getMaSV() {
        return maSV;
    }
    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
    public float getDiemToan() {
        return diemToan;
    }
    public void setDiemToan(float diemToan) {
        this.diemToan = diemToan;
        this.setDiemTb();
    }
    public float getDiemVan() {
        return diemVan;
    }
    public void setDiemVan(float diemVan) {
        this.diemVan = diemVan;
        this.setDiemTb();
    }
    public float getDiemAnh() {
        return diemAnh;
    }
    public void setDiemAnh(float diemAnh) {
        this.diemAnh = diemAnh;
        this.setDiemTb();
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LopHoc getLopHoc() {
        return lopHoc;
    }
    public void setLopHoc(LopHoc lopHoc) {
        this.lopHoc = lopHoc;
    }
    public float getDiemTb() {
        return diemTb ;
    }
    public void setDiemTb() {
        this.diemTb = (this.diemToan + this.diemAnh + this.diemVan)/3;
        this.setHocLuc();
    }
    public String getHocLuc() {
        return hocLuc;
    }
    public void setHocLuc() {
        if(diemTb < 4 && diemTb >= 0){
            this.hocLuc = "Yeu";
        }else if(diemTb < 7){
            this.hocLuc = "Trung Binh";
        }else if(diemTb <8.5){
            this.hocLuc = "Kha";
        } else {
			this.hocLuc = "Gioi";
		}
        
    }
    //4. method nghiệp vụ: public
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho ten: ");
        this.hoTen = sc.nextLine();
        
        do{
            System.out.println("Nhap ngay sinh: ");
            String sdate = sc.nextLine();
            // su dung sdf de chuyen doi string sang date
            try {
                this.ngaySinh = sdf.parse(sdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
           
        }while(this.ngaySinh == null);

        while(true){
            System.out.println("Nhap ma sinh vien: ");
            this.maSV = sc.nextLine();
            //dk thoat lap:
            if( this.maSV.length()==5 ){
                break;
            }else{
                System.out.println("Ma sinh vien phai co 5 ky tu");
            }
        }
        do {
            System.out.println("Nhap diem Toan: ");
            this.diemToan = sc.nextFloat();
        }while(this.diemToan < 0 || this.diemToan > 10);

        while(true){
            System.out.println("Nhap diem Van: ");
            this.diemVan = sc.nextFloat();
            if(this.diemVan >=0 && this.diemVan <=10){
                break;
            }
        }
        while(this.diemAnh == -1){
            System.out.println("Nhap diem Anh: ");
            this.diemAnh = sc.nextFloat();
            sc.nextLine();
            if(this.diemAnh < 0 || this.diemAnh > 10){
                this.diemAnh = -1;
            }
        }
    
        //email
        System.out.println("Nhap email: ");
        this.email = sc.nextLine();

        //maLop, soluongHV
        System.out.println("Nhap thong tin lop hoc: ");
        this.lopHoc = new LopHoc();
        this.lopHoc.nhap(); 

        sc.close();
    }
    public void xuat(){
        System.out.println("--- Thong tin sinh vien ---");
        System.out.println("Ho va Ten: " + this.hoTen);
        System.out.println("Ma sinh vien: " + this.maSV);
        System.out.println("Ngay sinh: " + sdf.format(this.ngaySinh));
        System.out.println("Diem Toan: " + this.diemToan);
        System.out.println("Diem Van: " + this.diemVan);
        System.out.println("Diem Anh: " + this.diemAnh);
        System.out.println("Email: " + this.email);
        System.out.println("Diem TB: " + this.diemTb + " ; Hoc Luc: " + this.hocLuc);
        System.out.println("Lop Hoc: " + this.lopHoc.xuat());
    }
 

}
