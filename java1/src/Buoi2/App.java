package java1.src.Buoi2;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        System.out.println("Vẽ tam giác đều và hình chữ nhật");
		while(true) {
			Scanner sc = new Scanner(System.in);
			int a; //chiều cao tam giác cân
			int b, c; //độ dài cạnh của hcn
			System.out.printf("Chiều cao tam giác đều: ");
			a = sc.nextInt();
			if(a > 0 ) {
				System.out.println("=> Tam giác đều: ");
				for(int i = 1; i <= a; i++) {
					for(int j = a - i; j > 0; j--) {
						System.out.printf(" ");
					}
					for (int k = 1; k <= i; k++) {
						System.out.printf("* ");
					}
					System.out.println();
					}
				while(true) {
					System.out.printf("Chiều dài HCN: ");
					b = sc.nextInt(); //Chiều dài HCN
					if(b > 0) {
						while(true) {
							System.out.printf("Chiều rộng HCN: ");
							c = sc.nextInt(); //Chiều rộng HCN
							if(c > 0) {
								if(b > c) {
									System.out.println("=> Hình chữ nhật:");
									for(int h = 1 ; h <= c; h++) {
										for (int m = 1; m <= b; m++) {
											System.out.printf("* ");
										}
										System.out.println();
										}break;
								}else {
									System.err.println("Chiều dài > chiều rộng!");
								}
							}else {
								System.err.println("Chiều rộng không đúng!");
							}
						}break;
					}else {
						System.err.println("Chiều dài không đúng!");
					}
				}break;
			}else {
				System.err.println("Chiều cao tam giác đều không đúng!");
			}
			sc.close();
		}
		
    }
}
