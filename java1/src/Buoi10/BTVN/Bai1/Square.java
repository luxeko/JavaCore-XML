package java1.src.Buoi10.BTVN.Bai1;

import java.util.Scanner;

public class Square extends ShapeManager implements IShape, IContent{
    double canh;
    
    public Square(){
    }
    public Square(double canh) {
        this.canh = canh;
    }
    @Override
    public double area() {
        return canh*canh;
    }

    @Override
    public double perimeter() {
        return 4*canh;
    }
    @Override
    public String descript() {
        return "4 canh bang nhau va 4 goc = 90 do ";
    }
    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Nhap canh hinh vuong: ");
        this.canh = Integer.parseInt(sc.nextLine());sc.close();
    }

    @Override
    public void xuat() {
        System.out.println("--- Thong tin hinh vuong ---");
        System.out.println("Canh hinh vuong: " + this.canh);
        System.out.println("Dien tich HV: " + this.area());
        System.out.println("Chu vi HV: " + this.perimeter());
        System.out.println("Mo ta: " + this.descript() + "\n");
    }


    
}
