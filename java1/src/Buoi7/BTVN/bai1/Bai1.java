package java1.src.Buoi7.BTVN.bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;


public class Bai1 {
    ArrayList<Integer> nhapN = new ArrayList<>();
    ArrayList<Integer> arrTemp = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Bai1(ArrayList<Integer> nhapN, ArrayList<Integer> arrTemp) {
        this.nhapN = nhapN;
        this.arrTemp = arrTemp;
    }
    
    public Bai1() {
    }

    public ArrayList<Integer> getNhapN() {
        return nhapN;
    }
    public void setNhapN(ArrayList<Integer> nhapN) {
        this.nhapN = nhapN;
    }
    public ArrayList<Integer> getArrTemp() {
        return arrTemp;
    }
    public void setArrTemp(ArrayList<Integer> arrTemp) {
        this.arrTemp = arrTemp;
    }


    public void nhap(){
        for (int i = 0; i < 10; i++) {
            System.out.print("Nhap phan tu thu " + i + ": ");
			nhapN.add(sc.nextInt());
		}
    }
    public void duyet(){
        System.out.println("");
        System.out.println("====================");
        System.out.println("Duyet mang cach 1: ");
		for (int i = 0; i < nhapN.size(); i++) {
			System.out.print(nhapN.get(i) + " ");
		}
        System.out.println("");
        System.out.println("====================");
        System.out.println("Duyet mang cach 2: ");
        for (Object obj: nhapN){
            System.out.print(obj + " ");
        }
        System.out.println("");
        System.out.println("====================");
        System.out.println("Duyet mang cach 3: ");
        Iterator<Integer> ite = nhapN.iterator();
        while(ite.hasNext()){
            Object obj = ite.next();
            System.out.print(obj + " ");
        }
        System.out.println("");
        System.out.println("====================");
        System.out.println("Duyet mang cach 4: ");
        ListIterator<Integer> listIte = nhapN.listIterator();
        while(listIte.hasNext()){
            Object obj = listIte.next();
            System.out.print(obj + " ");
        }
    }

    //loai bo cac phan tu trung nhau
    public void loaiCacPhanTuTrung(){
         
        for (int i = 0; i < nhapN.size(); i++) {
            if(!arrTemp.contains(nhapN.get(i))) {
                arrTemp.add(nhapN.get(i));
            }
        }
        nhapN.clear();
        System.out.println("");
        System.out.println("====================");
        System.out.println("List cac phan tu khong trung nhau : ");
        System.out.println(arrTemp);
    }
    
    //Hien thi so lan xuat hien cua cac phan tu trong list
    public void demSo(){

    }

    //Hien thi chi so(index cua phan tu trong mang)
    public void showInfo(){
        System.out.println("Nhap phan tu: ");
        int index = sc.nextInt();
        for(int i = 0; i < nhapN.size(); i++){
            if(index == nhapN.get(i)){
                System.out.println(index + " o vi tri: " +(nhapN.size()-1));
                break;
            }
        }
    }

    //Dao nguoc va xao tron mang
    public void daoNguoc(){
        ListIterator<Integer> li = nhapN.listIterator(nhapN.size());
        System.out.println("Dao nguoc cac phan tu: ");
        while(li.hasPrevious()) {
            System.out.print(li.previous() + " ");
        }

        Collections.shuffle(nhapN);
        System.out.println("");
        System.out.println("Xao tron cac phan tu: " + nhapN);
    }
            
}

