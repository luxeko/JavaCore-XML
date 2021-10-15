package java1.src.Buoi8;
import java.util.Scanner;

import java1.src.Buoi10.IInputOutput;
import java1.src.Buoi10.IWork;



// lop cha, lop super, lop base
// class final: class ko cho phep ke thua
// public class final Nguoi {
public class Nguoi implements IInputOutput, IWork{
    // fields - instance/ doi tuong
    private String ten;
    private int tuoi;
    private String cmt;
    private String emai;
    
    // fields - lop / static
    private static String CLASS_NAME;
    // khoi tinh
    static {
        CLASS_NAME = "PEOPLE";
    }
    // methods - instance/ doi tuong
    public Nguoi() {
        super();
    }
    public Nguoi(String ten, int tuoi, String cmt, String emai) {
        super();
        this.ten = ten;
        this.tuoi = tuoi;
        this.cmt = cmt;
        this.emai = emai;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public String getCmt() {
        return cmt;
    }
    public void setCmt(String cmt) {
        this.cmt = cmt;
    }
    public String getEmai() {
        return emai;
    }
    
    public void setEmai(String emai) {
        this.emai = emai;
    }
    @Override
    public void nhap(){
        // nhap tu ban phim thong tin cua nguoi
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name:");
        this.ten = scanner.nextLine();
        System.out.println("Enter Age:");
        this.tuoi = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Identity:");
        this.cmt = scanner.nextLine();
        System.out.println("Enter Email:");
        this.emai = scanner.nextLine();
        System.out.println("Nhap ten loai doi tuong: ");
        Nguoi.CLASS_NAME = scanner.nextLine();
        scanner.close();
    }
    @Override
    public void xuat() {
        System.out.println("Ten: "+ this.ten);
        System.out.println("Tuoi: "+ this.tuoi);
        System.out.println("Cmt: "+ this.cmt);
        System.out.println("Email: "+ this.emai);
        System.out.println("Loai: "+ Nguoi.getClass_name());
    }
    // ham final la ham khong cho phep override o lop con
    public final void yeucau () {
        System.out.println(" Nhu cau cua con nguoi la gi.");
    }
    // method - lop/ static: chi truy cap duoc toi cac thanh phan tinh
    public static String getClass_name () {
        return Nguoi.CLASS_NAME;
    }
    public void doWork() {
        System.out.println("Nguoi phai co cong viec");
    }
}


