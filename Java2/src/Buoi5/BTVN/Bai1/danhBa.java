package Java2.src.Buoi5.BTVN.Bai1;

import java.util.Scanner;

public class danhBa {
    private String phoneNumber;
    private String tenNguoiDung;
    public danhBa(String phoneNumber, String tenNguoiDung) {
        this.phoneNumber = phoneNumber;
        this.tenNguoiDung = tenNguoiDung;
    }
    public danhBa() {
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getTenNguoiDung() {
        return tenNguoiDung;
    }
    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập số điện thoại: " );
            this.phoneNumber = sc.nextLine();
            if(this.phoneNumber.length() > 10){
                break;
            }else if(this.phoneNumber.trim().equals("")){
                System.out.println("Bạn chưa nhập!");
            }else{
                System.out.println("Sdt hơi ngắn. bro");
            }
        }
        while(true){
            System.out.println("Nhập tên kh: ");
            this.tenNguoiDung = sc.nextLine();
            if(this.tenNguoiDung.length() > 1 ){
                break;
            }else if(this.tenNguoiDung.trim().equals("")){
                System.out.println("Bạn chưa nhập!");
            }else{
                System.out.println("Tên hơi ngắn. bro");
            }
        }
    }
    @Override
    public String toString() {
        return this.phoneNumber + ": " + this.tenNguoiDung + "\n";
    }
    
}
