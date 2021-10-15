package java1.src.Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class DsNhomHang {
    private ArrayList<NhomHang> dsNhomHang;
    public DsNhomHang(){
        this.dsNhomHang = new ArrayList<NhomHang>();
    }
    
    public DsNhomHang(ArrayList<NhomHang> dsNhomHang) {
        this.dsNhomHang = dsNhomHang;
    }

    public ArrayList<NhomHang> getDsNhomHang() {
        return dsNhomHang;
    }
    public void setDsNhomHang(ArrayList<NhomHang> dsNhomHang) {
        this.dsNhomHang = dsNhomHang;
    }

    public void addNhomHang(NhomHang nhomHang){
        this.dsNhomHang.add(nhomHang);
    }

    //Hàm tìm kiếm nhóm hàng    
    public void timNhomHang(){
        Scanner sc = new Scanner(System.in);
        String maTimKiem = "";
        String confirm;
        do{
            int count = 0;
            System.out.println("Nhập mã tìm kiếm: ");
            maTimKiem = sc.nextLine();
            for(NhomHang nhomHang : dsNhomHang){
                if(maTimKiem.equals(nhomHang.getMaNhomHang())){
                    System.out.println(nhomHang.toString());
                    count++;
                }
            }
            if(count == 0){
                System.out.println("Nhóm hàng không tồn tại");
            }
            System.out.println("Tiếp tục tìm? Nhấn 'n' để thoát");
            confirm = sc.nextLine();
        }while(!confirm.equals("n"));
        sc.close();
    }
    public void output(){
        for(NhomHang nhomHang : dsNhomHang){
            nhomHang.output();
        }
    }
    public void inMaNhomHang(){
        for(NhomHang nhomHang : dsNhomHang){
            System.out.println(nhomHang.inMaNhomHang());
        }
    }
    
}
