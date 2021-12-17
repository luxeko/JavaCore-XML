package java1.src.Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class DsSanPham {
    private ArrayList<SanPham> dsSanPham;
    public DsSanPham(){
        dsSanPham = new ArrayList<SanPham>();
    }
    
    public DsSanPham(ArrayList<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }

    public ArrayList<SanPham> getDsSanPham() {
        return dsSanPham;
    }
    public void setDsSanPham(ArrayList<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }

    public void addSanPham(SanPham sanPham){
        dsSanPham.add(sanPham);
    }
    public void timSanPham(){
        Scanner sc = new Scanner(System.in);
        String maTimKiem = "";
        String confirm;
        do{
            int count = 0;
            System.out.println("Nhập mã tìm kiếm: ");
            maTimKiem = sc.nextLine();
            for(SanPham sp : dsSanPham){
                if(maTimKiem.equals(sp.getMaSanPham())){
                    System.out.println(sp.toString());
                    count++;
                }
            }
            if(count == 0){
                System.out.println("Sản phẩm không tồn tại");
            }
            System.out.println("Tiếp tục tìm? Nhấn 'n' để thoát");
            confirm = sc.nextLine();
        }while(!confirm.equals("n"));
    }
    public void output(){
        for(SanPham sp : dsSanPham){
            System.out.println(sp.toString());
        }
    }
    public void inMaSanPham(){
        for(SanPham sp : dsSanPham){
            System.out.println(sp.inMaSanPham());
        }
    }
    public void capNhatSanPham(DsNhomHang dsNhomHang){
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String confirm;
        String maSanPham;
        do{
            System.out.println("Nhập mã sản phẩm muốn cập nhật: ");
            maSanPham = sc.nextLine();
            for(SanPham sp : dsSanPham){
                if(maSanPham.equals(sp.getMaSanPham())){
                    sp.input(dsNhomHang);
                    count++;
                }
            }
            if(count == 0){
                System.out.println("Sản phẩm không tồn tại");
            }
            System.out.println("Tiếp tục nhập? Nhấn 'n' để thoát");
            confirm = sc.nextLine();
        }while (!confirm.equals("n"));
    }

}
