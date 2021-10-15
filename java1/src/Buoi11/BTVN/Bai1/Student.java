package java1.src.Buoi11.BTVN.Bai1;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;


public class Student {
    private String studentId;
    private String studentName;
    
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private float point;
    private String xepLoai;
    private Date date;

    public Student(){
    }
    public Student(String studentId, String studentName, Date date, float point, String xepLoai) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.date = date;
        this.point = point;
        this.xepLoai = xepLoai;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public Date getdate() {
        return date;
    }
    public void setdate(Date date) {
        this.date = date;
    }
    public SimpleDateFormat getSdf() {
        return sdf;
    }
    public float getPoint() {
        return point;
    }
    public void setPoint(float point) {
        this.point = point;
    }
    public String getXepLoai() {
        return xepLoai;
    }
    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter Student ID: "); 
            this.studentId = sc.nextLine();
            if (this.studentId.trim().equals("")) {
                System.out.println("Ban chua nhap chu so hoac toan khoang trang!");
            }else{
                break;
            }
        }
        while(true){
            System.out.println("Enter Student Name");
            this.studentName = sc.nextLine();
            if (this.studentName.trim().equals("")) {
                System.out.println("Ban chua nhap chu so hoac toan khoang trang!");
            }else{
                break;
            }
        }
        do{
            System.out.println("Enter date of birth: ");
            String sdate = sc.nextLine();
            // su dung sdf de chuyen doi string sang date
            try {
                this.date = sdf.parse(sdate);
            } catch (ParseException e) {
                System.out.println("Ngay sinh khong hop le!");;
            }
        }while(this.date == null);

        while(true){
            System.out.println("Enter Score: ");
            this.point = sc.nextFloat();
            sc.nextLine();
            if(this.point < 0 || this.point > 10){
                System.out.println("Điểm số không hợp lệ!");
            }else{
                break;
            }
        }sc.close();
    }
    
    public void tinhNgaySinh(){
        try {
            Date dateNow = new Date(System.currentTimeMillis());
            long startValue = this.date.getTime() ;
            long endValue = dateNow.getTime();
            long betWeen = endValue - startValue;
            Long result =  betWeen/(24*60*60*1000);
            if(result == 0){
                System.out.println("Happy Birthday");
            }else{
                System.out.println("Còn " + dateNow + " ngày đến sinh nhật");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
	public String tinhHocLuc() {
        if(this.point < 5 && this.point >= 0){
            return "Kém";
        }else if(point < 7){
            return "Trung bình";
        }else if(point < 9){
            return "Khá";
        } else {
		    return "Gioi";
		}
	}
    public void output(){
        System.out.println("---- Student Information ----");
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Student Name: " + this.studentName);
        System.out.println("Date of Birth: " + sdf.format(this.date));
        System.out.println("Score: " + this.point);
        System.out.println("Academic Ability: " + this.tinhHocLuc());
    }
    
}
