package java1.src.Buoi2;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập tiền Đô: ");
        int b = nhap.nextInt(); //USD
        int a;
        a = (int)b*20;
        System.out.println(b + " USD = " + a + " k VND");
        nhap.close();
    }
   
}
