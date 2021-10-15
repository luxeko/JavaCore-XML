package java1.src.Buoi10.BTVN.Bai1;

import java.util.Scanner;

public class Triangle implements IShape, IContent{
    double a,b,c;

    public Triangle(){
    }
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public double area() {
        //cong thuc heron tinh dien tich tam giac
        return Math.sqrt( ((a+b+c)/2)*(((a+b+c)/2)-a)*(((a+b+c)/2)-b)*(((a+b+c)/2)-c) );
    }
    @Override
    public double perimeter() {
        return a+b+c;
    }
    @Override
    public String descript() {
        return "Co 3 goc va tong 3 goc = 180 do ";
    }
    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap canh a: ");
        this.a = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap canh b: ");
        this.b = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap canh c: ");
        this.c = Integer.parseInt(sc.nextLine());sc.close();
    }

    @Override
    public void xuat() {
        System.out.println("--- Thong tin hinh tam giac ---");
        System.out.println("Canh a: " + this.a);
        System.out.println("Canh b: " + this.b);
        System.out.println("Canh c: " + this.c);
        System.out.println("Dien tich tam giac: " + this.area());
        System.out.println("Chu vi tam giac: " + this.perimeter());
        System.out.println("Mo ta: " + this.descript() + "\n");
    }
    
}
