package Java2.src.Buoi3.BTVN.Bai2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class sinhVien implements Comparable<sinhVien>{
    private int studentID;
    private String name;
    private Date ngaySinh;
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String address;
    private String sex;
    private String maNganh;

    public sinhVien(){}
    public sinhVien(int studentID, String name, Date ngaySinh, String address, String sex, String maNganh) {
        this.studentID = studentID;
        this.name = name;
        this.ngaySinh = ngaySinh;
        this.address = address;
        this.sex = sex;
        this.maNganh = maNganh;
    }
    
    public Date getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMaNganh() {
        return maNganh;
    }
    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }
    public void input(dsSinhVien dssv){
        Scanner sc = new Scanner(System.in);
        while(true){
            int count = 0;
            System.out.println("Nhập mã sinh viên: ");
            try {
                studentID = Integer.parseInt(sc.nextLine());
                if(studentID > 0){
                    for(sinhVien sv : dssv.getDsSinhVien()){
                        if(studentID == sv.getStudentID()){
                            System.out.println("Mã sv đã tồn tại");
                            count++;
                        }
                    }if(count == 0){
                        break;
                    }
                }
                if(studentID < 0 ){
                    System.out.println("Mã sinh viên không hợp lệ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Mã sinh viên phải là số");
            }
        }        
        while(true){
            System.out.println("Nhập tên sinh viên: ");
            name = sc.nextLine();
            if(this.name.trim().equals("")){
                System.out.println("Bạn chưa nhập tên");
            }else{
                break;
            }
        }
        do{
            System.out.println("Nhập ngày sinh: ");
            String sdate = sc.nextLine();
            // su dung sdf de chuyen doi string sang date
            try {
                this.ngaySinh = sdf.parse(sdate);
            } catch (ParseException e) {
                System.out.println("Ngày sinh ko hợp lệ!");;
            }
        }while(this.ngaySinh == null);

        while(true){
            System.out.println("Nhập địa chỉ: ");
            address = sc.nextLine();
            if(this.address.trim().equals("")){
                System.out.println("Bạn chưa nhập địa chỉ");
            }else{
                break;
            }
        }
        while(true){
            System.out.println("Nhập giới tính (Nam, Nu, Khac): ");
            sex = sc.nextLine();
            if(this.sex.equalsIgnoreCase("Nam")){
                break;
            }else if( this.sex.equalsIgnoreCase("Nu")){
                break;
            }
            else if(this.sex.equalsIgnoreCase("Khac")){
                break;
            }
            else{
                System.out.println("Giới tính không hợp lệ");
            }  
        }
        System.out.println("Nhập mã ngành học: ");
        maNganh = sc.nextLine();
        
    }
    public void xuat(){
        System.out.println("Mã sv: " + this.studentID + "; Tên sv: " + this.name + "; Ngày sinh: " + sdf.format(this.ngaySinh) + "; Địa chỉ: " + this.address + "; Giới tính: " + this.sex + "; Mã ngành: " + this.maNganh);
    }
    @Override
    public int compareTo(sinhVien o) {
        int soSanhTen = this.getName().compareTo(o.getName());
        if (soSanhTen == 0){
            return this.getMaNganh().compareTo(o.getMaNganh());
        }
        return this.getName().compareTo(o.getName());
    }
    @Override
    public String toString() {
        return "Sinh Vien [address=" + address + ", maNganh=" + maNganh + ", name=" + name + ", ngaySinh=" + sdf.format(this.ngaySinh) + ", sex=" + sex + ", studentID=" + studentID + "]";
    }
    public String maSinhVien(){
        return "Sinh viên " + this.studentID;
    }
    @Override
    public boolean equals(Object o) {
        if(o == null)
        return false;
        if(!(o instanceof sinhVien)){
            return false;
        }
        sinhVien other = (sinhVien) o;
        if(this.name != null && this.name.equals(other.getName())){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    
    

}
 