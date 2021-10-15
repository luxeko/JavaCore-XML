package java1.src.Buoi8.BTVN.Bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class Chuong{
    private int maChuong;
    ArrayList<Animal> chuong;

    public Chuong(){
        chuong = new ArrayList<Animal>();
    }

    public int getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(int maChuong) {
        this.maChuong = maChuong;
    }

    public ArrayList<Animal> getChuong() {
        return chuong;
    }
    public void setChuong(ArrayList<Animal> chuong) {
        this.chuong = chuong;
    }
    
    public void addAnimal(Animal a) {
        chuong.add(a);
    }
    public void addAnimal(){
        Animal animal = createAnimal();
        chuong.add(animal);
    }

    public void removeAnimal(String ten){
        for(int i=0; i<chuong.size(); i++){
            if(chuong.get(i).getTen().equalsIgnoreCase(ten)) {
                chuong.remove(i);
                //1, 2, 3, 4, 5, 6: length = 6, index = 0 -> 5
                //Xoa di index = 2 (gia tri 3)-> Vi du xu ly dong 50
                //1, 2, 4, 5, 6: Length = 5, index = 0 -> 4
                //index = 2 (gia tri 3 truoc) -> index = 2 (gia tri 4)
                i--;
            }
        }
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma chuong: ");
        maChuong = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap so dong vat: ");
        int n = Integer.parseInt(sc.nextLine());

        for(int i=0; i<n; i++){
            Animal animal = createAnimal();
            chuong.add(animal);
        }
        sc.close();
    }
    public void xuat() {
        System.out.println("Ma Chuong: " + maChuong + "\n");
        for (Animal animal : chuong) {
            animal.xuat();
            animal.tiengKeu();
        }
    }
    public Animal createAnimal(){
        Scanner scan = new Scanner(System.in);
        Animal animal;
        System.out.println("1. Them Tiger");
        System.out.println("2. Them Dog");
        System.out.println("3. Them Cat");
        System.out.println("Chon: ");
        int choose = Integer.parseInt(scan.nextLine());
        switch(choose) {
            case 1:
                animal = new Tiger();
                break;
            case 2:
                animal = new Dog();
                break;
            default:
                animal = new Cat();
                break;
        }
        animal.nhap();
        scan.close();
        return animal;
    }
}

   
    

    


