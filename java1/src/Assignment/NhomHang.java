package java1.src.Assignment;

import java.util.Scanner;

public class NhomHang {
    private String maNhomHang;
    private String tenNhomHang;
    private float vat;

    public NhomHang(){
    }
    public NhomHang(String maNhomHang, String tenNhomHang, float vat) {
        this.maNhomHang = maNhomHang;
        this.tenNhomHang = tenNhomHang;
        this.vat = vat;
    }
    public String getMaNhomHang() {
        return maNhomHang;
    }
    public void setMaNhomHang(String maNhomHang) {
        this.maNhomHang = maNhomHang;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Nhập mã nhóm hàng: "); 
            this.maNhomHang = sc.nextLine();
            if (this.maNhomHang.trim().equals("")) {
                System.out.println("Bạn chưa nhập mã!");
            }else if(this.maNhomHang.length()!=4){
                System.out.println("Mã nhóm hàng phải có 4 ký tự");                  
            }else{
                break;
            }
        }
        System.out.println("Nhập tên nhóm hàng: ");
        this.tenNhomHang = sc.nextLine();
        while(true){
            System.out.println("Nhập thuế VAT: ");
            try {
                this.vat = Float.parseFloat(sc.nextLine());
                if(this.vat > 0 && this.vat < 1){
                    break;
                }else{
                    System.out.println("VAT phải > 0 và < 1");
                }
            } catch (Exception e) {
                System.out.println("VAT phải là kiểu số");
            }
        }sc.close();
    }
    public void output(){
        System.out.println("==============================");
        System.out.println("Mã nhóm hàng: " + this.maNhomHang);
        System.out.println("Tên nhóm hàng: " + this.tenNhomHang);
        System.out.println("VAT: " + this.vat);
    }
    public String inMaNhomHang(){
        return "Mã nhóm hàng hiện có: " + maNhomHang;
    }
    @Override
    public String toString() {
        return "NhomHang [maNhomHang=" + maNhomHang + ", tenNhomHang=" + tenNhomHang + ", vat=" + vat + "]";
    }

    


}
