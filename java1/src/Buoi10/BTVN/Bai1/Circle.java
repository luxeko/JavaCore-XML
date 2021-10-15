package java1.src.Buoi10.BTVN.Bai1;

import java.util.Scanner;

public class Circle implements IShape, IContent{
    double banKinh;
    double pi = 3.14;
    public Circle(){
    }
    public Circle(double banKinh, double pi) {
        this.banKinh = banKinh;
        this.pi = pi;
    }

    @Override
    public double area() {
        return banKinh*banKinh*pi;
    }

    @Override
    public double perimeter() {
        return 2*banKinh*pi;
    }

    @Override
    public String descript() {
        return "Khoang cach tu tam den cac diem tren duong tron bang nhau";
    }
    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ban kinh: ");
        this.banKinh = Double.parseDouble(sc.nextLine());
        sc.close();
    }

    @Override
    public void xuat() {
        System.out.println("--- Thong tin hinh tron ---");
        System.out.println("Ban kinh: " + this.banKinh);
        System.out.println("Dien tich hinh tron: " + this.area());
        System.out.println("Chu vi hinh tron: " + this.perimeter());
        System.out.println("Mo ta: " + this.descript() + "\n");
    }
    
}
    

