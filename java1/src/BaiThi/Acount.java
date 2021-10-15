package java1.src.BaiThi;

import java.util.Scanner;

public class Acount {
    private String customerCode;
    private String customerName;
    private int accNumber;
    private long amount = 0;
    public Acount(){

    }
    public Acount(String customerCode, String customerName, int accNumber, long amount) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.accNumber = accNumber;
        this.amount = amount;
    }
    public String getCustomerCode() {
        return customerCode;
    }
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public int getAccNumber() {
        return accNumber;
    }
    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }
    public long getAmount() {
        return amount;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Nhập ID khách hàng: ");
            this.customerCode = sc.nextLine();
            if(this.customerCode.length()==5){
                break;
            }else{
                System.out.println("ID phải có 5 ký tự!!!");
            }
        }
        System.out.println("Nhập tên khách hàng: ");
        this.customerName = sc.nextLine();
        
        while(true){
            System.out.println("Nhập số tài khoản: ");
            try {
                this.accNumber = Integer.parseInt(sc.nextLine());
                if(this.accNumber < 100000 || this.accNumber > 999999){
                    System.out.println("Số tài khoản phải có 6 chữ số"); 
                }
                else if(this.accNumber > 100999){
                    System.out.println("Số tài khoản phải bắt đầu từ 100"); 
                }else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Số tài khoản phải là kiểu số");
            }
           
        }sc.close();
    }
    public void askCustomer() {
        Scanner sc = new Scanner(System.in);
        int type = -1;
        String confirm;
        do {
            while(true){
                System.out.println("Gửi tiền hoăc Rút tiền?");
                System.out.println("0. Gửi tiền" + "\n1. Rút tiền");
                type = Integer.parseInt(sc.nextLine());
                if(type != 0 && type != 1){
                    System.out.println("Vui lòng chọn 0 hoặc 1");
                }else{
                    break;
                }
            }
            System.out.print("Nhap so tien: ");
            try {
                Long money = sc.nextLong();
                this.depositAndWithdraw(money, type);
            } catch (Exception e) {
                System.out.println("Số tiền không hợp lệ!");
            }
            System.out.println("Tiếp tục thao tác? Nhấn 's' để dừng");
            sc.nextLine();
            confirm = sc.nextLine();
        } while (!confirm.equalsIgnoreCase("s"));
        sc.close();
    }

    public void depositAndWithdraw(long money, int type) {
        switch (type) {
            case 0:
                if(money <= 0) {
                    System.out.println("Số tiền phải lớn hơn 0");
                } else {
                    this.amount += money;
                }
                this.output();
                break;
            case 1:
                if(money > 0 && money <= this.amount) {
                    this.amount -= money;
                    System.out.println("Rút tiền thành công");
                    
                } else {
                    System.out.println("Số dư không đủ");
                }
                this.output();
                break;
            default:
                System.out.println("Vui lòng chọn 0 hoac 1");
                break;
        }
    }

    public void output(){
        System.out.println("----- Thông tin tài khoản -----");
        System.out.println("ID khách hàng: " + this.customerCode);
        System.out.println("Tên khách hàng: " + this.customerName);
        System.out.println("Số tài khoản: " + this.accNumber);
        System.out.println("Số dư: " + this.amount);
    }
    @Override
    public String toString() {
        return "Acount [accNumber=" + accNumber + ", amount=" + amount + ", customerCode=" + customerCode
                + ", customerName=" + customerName + "]";
    }

    
}
