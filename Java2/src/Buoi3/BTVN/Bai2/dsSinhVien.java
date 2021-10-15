package Java2.src.Buoi3.BTVN.Bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class dsSinhVien {
    ArrayList<sinhVien> dsSinhVien;
    Scanner sc = new Scanner(System.in);
    public dsSinhVien(){
        dsSinhVien = new ArrayList<sinhVien>();
    }
    public dsSinhVien(ArrayList<sinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }
    public ArrayList<sinhVien> getDsSinhVien() {
        return dsSinhVien;
    }

    public void setDsSinhVien(ArrayList<sinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }

    public void addSV(sinhVien sv){
        dsSinhVien.add(sv);
    }
    public void printSV(){
        List<sinhVien> listSinhVien = new ArrayList<sinhVien>();
        listSinhVien.addAll(dsSinhVien);
        Collections.sort(listSinhVien);
        Iterator<sinhVien> ite = listSinhVien.iterator();
        while(ite.hasNext()){
            sinhVien obj = ite.next();
            System.err.println(obj.toString());
        }
    }
    public void tenSvKhongTrung(){
        Set<sinhVien> setSinhVien = new HashSet<sinhVien>();
        setSinhVien.addAll(dsSinhVien);
        Iterator<sinhVien> ite = setSinhVien.iterator();
        while(ite.hasNext()){
            sinhVien obj = ite.next();
            System.out.println(obj.toString());
        }
    }
    public void timSV(String ten, String maNganh){
        int cout = 0;
        for(sinhVien sv : dsSinhVien){
            if(ten.equals(sv.getName()) && maNganh.equals(sv.getMaNganh())){
                System.out.println(sv.toString()); 
                cout++;
                break;
            }
        }if(cout == 0){
            System.out.println("Tên sv hoặc mã ngành không hợp lệ");
        }
    }
    public void xoaSV(String ten, String maNganh){
        int cout = 0;
        for(sinhVien sv : dsSinhVien){
            if(ten.equals(sv.getName()) && maNganh.equals(sv.getMaNganh())){
                dsSinhVien.remove(sv);
                System.out.println("Xoá thành công. Mời bạn kiểm tra lại danh sách");
                cout++;
                break;
            }
        }if(cout == 0){
            System.out.println("Tên sv hoặc mã ngành không hợp lệ");
        }
    }
    public void tinhTuoi(){
        System.out.println("----- Danh sách sinh viên dưới 18 tuổi -----");
        for(sinhVien sv : dsSinhVien){
            Date now = new Date();
            long timeBetween = now.getTime() - sv.getNgaySinh().getTime();
            double yearsBetween = timeBetween / 3.15576e+10;
            int tuoi = (int) Math.floor(yearsBetween);
            if(tuoi < 18){
                System.out.println(sv.maSinhVien() + " với độ tuổi là: " + tuoi);
            }
        }
        System.out.println("----- Danh sách sinh viên dưới 23 tuổi ----- ");
        for(sinhVien sv : dsSinhVien){
            Date now = new Date();
            long timeBetween = now.getTime() - sv.getNgaySinh().getTime();
            double yearsBetween = timeBetween / 3.15576e+10;
            int tuoi = (int) Math.floor(yearsBetween);
            if(tuoi <= 22 && tuoi >=18){
                System.out.println(sv.maSinhVien() + " với độ tuổi là: " + tuoi);
            } 
        }
        System.out.println("----- Danh sách sinh viên trên 22 tuổi -----");
        for(sinhVien sv : dsSinhVien){
            Date now = new Date();
            long timeBetween = now.getTime() - sv.getNgaySinh().getTime();
            double yearsBetween = timeBetween / 3.15576e+10;
            int tuoi = (int) Math.floor(yearsBetween);
            if(tuoi > 22){
                System.out.println(sv.maSinhVien() + " với độ tuổi là: " + tuoi);
            }
        }
    }    
}

