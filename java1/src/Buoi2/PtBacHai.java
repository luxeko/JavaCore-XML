package java1.src.Buoi2;

import java.util.Scanner;

public class PtBacHai {
	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
			System.out.printf("Nhập a = ");
			int a = nhap.nextInt();
			System.out.printf("Nhập b = ");
			int b = nhap.nextInt();
			System.out.printf("Nhập c = ");
			int c = nhap.nextInt();
			double delta = b*b - 4*a*c;
			double x1= (((float)-b) + Math.sqrt(delta)) / 2 * a;
			double x2= (((float)-b) - Math.sqrt(delta)) / 2 * a;
			System.out.println("Phương trình bậc hai: "+ "ax^2 + bx + c = 0 <=> " + a + "x^2 + " + b + "x + " + c + " = 0");
			System.out.println("=> Delta = "+ "b^2 - 4ac = " + b + "^2" + " - " + "4" + "x" + a + "x" + c + " = " + (int)delta);
			System.out.println( (delta == 0)? String.format("Delta = 0 nên phương trình có nghiệm là: " +  "x1 = x2 = %.2f", (float)-b/(float)a*1/2):( delta > 0? String.format("Delta > 0 nên phương trình có 2 nghiệm là: %n" + "x1 = %f%n" + "x2 = %f" , x1 , x2):("Delta < 0 nên phương trình vô nghiệm") ) );
            nhap.close();			
	}
}