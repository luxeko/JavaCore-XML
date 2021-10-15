package java1.src.Buoi10.BTVN.Bai1;

import java.util.Scanner;

public class Rectangle implements IShape, IContent{
    double chieuDai, chieuRong;
    
    
    public Rectangle(){
    }
    public Rectangle(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    @Override
    public double area() {  
        return chieuDai * chieuRong;
    }

    @Override
    public double perimeter() {
        return (chieuDai + chieuRong)*2;
    }

    @Override
    public String descript() {
        return "Co 4 goc vuong va cac canh doi song song voi nhau ";
    }
   
    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chieu dai: ");
        this.chieuDai = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap chieu rong: ");
        this.chieuRong = Integer.parseInt(sc.nextLine());
        sc.close();
    }
    @Override
    public void xuat() {
        System.out.println("--- Thong tin HCN ---");
        System.out.println("Chieu dai: " + this.chieuDai);
        System.out.println("Chieu rong: " + this.chieuRong);
        System.out.println("Dien tich HCN: " + this.area());
        System.out.println("Chu vi HCN: " + this.perimeter());
        System.out.println("Mo ta: " + this.descript()+ "\n");
    }
    
    
}
