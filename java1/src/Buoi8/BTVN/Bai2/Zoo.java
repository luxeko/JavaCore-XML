package java1.src.Buoi8.BTVN.Bai2;

import java.util.ArrayList;
import java.util.Scanner;
public class Zoo {
    ArrayList<Chuong> dsChuong;  

    public Zoo() {
        dsChuong = new ArrayList<>();
    }
    public void addChuong(Chuong c){
        dsChuong.add(c);
    }
    public void removeChuong(int maChuong){
        for(int i=0; i< dsChuong.size(); i++){
            if(dsChuong.get(i).getMaChuong() == maChuong){
                dsChuong.remove(i);
                i--;
            }
        }
    }
    public void addAnimal(int maChuong, Animal animal){
        for(Chuong chuong : dsChuong){
            if(chuong.getMaChuong() == maChuong){
                chuong.addAnimal(animal);
            }
        }
    }
    public void addAnimal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma chuong can them dong vat: ");
        int maChuong = Integer.parseInt(sc.nextLine());
        for(Chuong chuong : dsChuong){
            if(chuong.getMaChuong() == maChuong){
                chuong.addAnimal();
            }
        }sc.close();
    }
    public void removeAnimal(int maChuong, String ten){
        for(Chuong chuong : dsChuong){
            if(chuong.getMaChuong() == maChuong){
                chuong.removeAnimal(ten);
            }
        }
    }
    public void removeAnimal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma chuong can xoa dong vat: ");
        int maChuong = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten dong vat can xoa: ");
        String ten = sc.nextLine();
        removeAnimal(maChuong, ten);
        sc.close();
    }
    public void xuat(){
        for(Chuong chuong : dsChuong){
            chuong.xuat();
        }
    }
}
