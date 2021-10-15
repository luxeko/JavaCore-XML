package java1.src.Buoi7.BTVN.bai2;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class sinhVien {
    Scanner sc = new Scanner(System.in);
    private int idSinhVien;
    private String name;
    private int ngaySinh;
    private String address;
    private String sex;
    private String idMonHoc;

    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public sinhVien(){

    }
    public sinhVien(int idSinhVien, String name, int ngaySinh, String address, String sex, String idMonHoc) {
        this.idSinhVien = idSinhVien;
        this.name = name;
        this.ngaySinh = ngaySinh;
        this.address = address;
        this.sex = sex;
        this.idMonHoc = idMonHoc;
    }
    public int getIdSinhVien() {
        return idSinhVien;
    }
    public void setIdSinhVien(int idSinhVien) {
        this.idSinhVien = idSinhVien;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(int ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getIdMonHoc() {
        return idMonHoc;
    }
    public void setIdMonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public void nhap(){
        System.out.println("Tao doi tuong sinh vien: ");
        while(true){
            System.out.println("Nhap ID: ");
            this.idSinhVien = sc.nextInt();
            sc.nextLine();
            //dk thoat lap:
            if( this.idMonHoc == null){
                break;
            }else{
                System.out.println("Ma sinh vien da ton tai");
            }
        }
        System.out.println("Ten sinh vien: ");
        this.name = sc.nextLine();

        while(true){
            System.out.println("Nhap ngay sinh: ");
            ngaySinh = sc.nextInt();
            if (this.ngaySinh != 0) {
                System.out.println("Ngay sinh ko hop le!");
            }else{
                break;
            }
        }

        System.out.println("Adress: ");
        this.address = sc.nextLine();

        int functionID = 0;
        boolean flag = true;
        do{
            System.out.println("Gioi tinh: ");
            System.out.println("1: Nam");
            System.out.println("2: Nu");
            System.out.println("3: Gioi tinh khac");
            System.out.println("-----------------");
            System.out.printf("Lua chon: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1: 
                    this.sex = "Nam";
                    System.out.println("Nam");
                    break;
                case 2:
                    this.sex = "Nu";
                    System.out.println("Nu");
                    break;
                case 3:
                    this.sex = "Gioi tinh khac";
                    System.out.println("Gioi tinh khac");
                    break;
                default:
                    System.out.println("Vui long chon gioi tinh!");
                    System.out.println("=================");
            }
            break;
        }while(flag == true);
        

        do{
            System.out.println("Ma nganh hoc: ");
            System.out.println("1: CNTT");
            System.out.println("2: QTKD");
            System.out.println("3: Bao Tri");
            System.out.println("4: Ke Toan");
            System.out.println("5: Luat");
            System.out.println("-----------------");
            System.out.printf("Lua chon: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1:
                    this.idMonHoc = "CNTT";
                    System.out.println("CNTT");
                    break;
                case 2:
                    this.idMonHoc = "QTKD";
                    System.out.println("QTKD");
                    break;
                case 3:
                    this.idMonHoc = "Bao Tri";
                    System.out.println("Bao Tri");
                    break;
                case 4:
                    this.idMonHoc = "Ke Toan";
                    System.out.println("Ke Toan");
                    break;
                case 5:
                    this.idMonHoc = "Luat";
                    System.out.println("Luat");
                    break;
                default: 
                    System.out.println("Vui long chon ma nganh!");
                    System.out.println("=================");
            }
            break;
        }while(flag == true);
    }
    public String xuat(){
        return "--- Thong tin sinh vien ---" + "\n" +
        "ID: " + this.idSinhVien + "\n" + "Name: " + this.name + "\n" + "Ngay sinh: " + this.ngaySinh + "\n" + "Adress: " + this.address + "\n" + "Sex: " + this.sex + "\n" + "Ma Nganh: " + this.idMonHoc;
    }
    
}
