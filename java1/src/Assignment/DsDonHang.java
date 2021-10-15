package java1.src.Assignment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;


public class DsDonHang {
    private ArrayList<DonHang> dsDonHang;
    public DsDonHang(){
        this.dsDonHang = new ArrayList<DonHang>();
    }
    public DsDonHang(ArrayList<DonHang> dsDonHang) {
        this.dsDonHang = dsDonHang;
        
    }
    public ArrayList<DonHang> getDsDonHang() {
        return dsDonHang;
    }
    public void setDsDonHang(ArrayList<DonHang> dsDonHang) {
        this.dsDonHang = dsDonHang;
    }
    
    public void addDonHang(DonHang donHang){
        this.dsDonHang.add(donHang);
    }

    public void output(){
        if(this.dsDonHang.size() == 0) {
            System.out.println("Không có đơn hàng nào!");
        } else {
            for(DonHang donHang : dsDonHang){
                donHang.output();
            }
        }
    }
    
    public void tongTien(){
        double tongTien = 0;
        //tao arrlist chua cac san pham
        ArrayList<SanPham> dsTongSanPham = new ArrayList<>();
        ArrayList<SanPham> dsSpMoi = new ArrayList<>();
        for(DonHang dhd : this.dsDonHang) {
            dsTongSanPham.addAll(dhd.getDsSanPham());
        }
        for(SanPham sp : dsTongSanPham) {
            if(!dsSpMoi.contains(sp)) {
                dsSpMoi.add(sp);
            }
            tongTien += sp.getGiaBan();
        }
        System.out.println("Đã bán tất cả: " + dsTongSanPham.size() + " sản phẩm với tổng giá trị: " + tongTien);
    }

    public void timTopSanPham(){
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int soLuongSpTop = 3;
        int thang;
        int nam;
        SanPham ans = new SanPham();

        //Tao arraylist danh sach chua cac san pham theo nam. VD: 2020
        ArrayList<SanPham> listTopSp = new ArrayList<>();

        //Tao arraylist chua cac san pham theo thang
        ArrayList<SanPham> dsSpMoi = new ArrayList<>();
        System.out.println("Nhập năm cần tìm: ");
        try{ 
            nam = Integer.parseInt(sc.nextLine());
            if(nam > 0){
                for(DonHang dh : this.layDsDonHangTheoNam(nam)){
                    listTopSp.addAll(dh.getDsSanPham());
                    for(SanPham sp : listTopSp){
                        if(!dsSpMoi.contains(sp)){
                            dsSpMoi.add(sp);
                        }
                    } 
                    System.out.println("Nhập tháng trong năm " + nam +": ");
                    try {
                        thang = Integer.parseInt(sc.nextLine());

                        if(thang > 0 && thang < 12){
                           
                            for(DonHang dh2 : this.DsDonHangTheoNam(thang)){
                                if(dsSpMoi.size() < 3){
                                    soLuongSpTop = dsSpMoi.size();
                                }
                                for(int i = 0; i < soLuongSpTop; i++){
                                    for(SanPham sp : dsSpMoi){
                                        if(Collections.frequency(listTopSp, sp) > max){
                                            max = Collections.frequency(listTopSp, sp);
                                            ans = sp;
                                        }
                                    }
                                    System.out.println("Sản phẩm thứ " + (i+1) + ans.toString() +" với " + max +" sản phẩm ");
                                    listTopSp.removeAll(Collections.singleton(ans));
                                    dsSpMoi.remove(ans);
                                    max = 0;
                                }
                            }
                        }
                    } catch(InputMismatchException e){
                        System.out.println("Tháng phải là kiểu số!");
                    }    
                } 
            }else{
                System.out.println("Năm phải lớn hơn 0");
            }
        }catch(InputMismatchException e){
            System.out.println("Năm phải là kiểu số!");
        }
        sc.close();
    }

    public ArrayList<DonHang> layDsDonHangTheoNam(int nam){
        ArrayList<DonHang> DsDonHangTheoNam = new ArrayList<>();
        Boolean check = false;
        Calendar cal = Calendar.getInstance();
        do{
            for(DonHang dh : this.dsDonHang){
                cal.setTime(dh.getNgayMua());
                int namMuaHang = cal.get(Calendar.YEAR);
                if(namMuaHang == nam){
                    DsDonHangTheoNam.add(dh);
                    check = true;
                } 
            }if(check == false){
                System.out.println("Năm " + nam + " chưa có dữ liệu");
            }
        }while(check = false);
        return DsDonHangTheoNam;
    }

    public ArrayList<DonHang> DsDonHangTheoNam(int thang){
        ArrayList<DonHang> DsDonHangTheoThang = new ArrayList<>();
        Boolean check = false;
        Calendar cal = Calendar.getInstance();
        do{
            for(DonHang dh : this.dsDonHang){
                cal.setTime(dh.getNgayMua());
                int thangMuaHang = cal.get(Calendar.MONTH) + 1;
                if(thangMuaHang == thang){
                    DsDonHangTheoThang.add(dh);
                    check = true;
                } 
            }if(check == false){
                System.out.println("Tháng " + thang + " chưa có dữ liệu");
            }
        }while(check = false);
        return DsDonHangTheoThang;
    }
    



}
