package buoi3;

import java.util.Scanner;

public class PhepTinh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Xay dung menu may tinh: 1. phep cong 2. phep tru 3. phep chia 4: phep
		 * nhan 5: phep luy thua #: khong hop le
		 * 
		 * Yc nguoi dung nhap tu ban phim 2 so nguyen duong, nhap sai yc nhap
		 * lai hien thi menu, ng dung nhap cac lua chon, in ra ket qua
		 * 
		 * Sau day, hoi nguoi co muon tiep tuc chuong trinh hay khong, co thi
		 * lam lai
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		int confirm = 0;
		do {
			// in ra menu
			System.out.println("--Chuong trinh tinh toan--");
			
			int num1, num2;
			do{
				System.out.println("Nhap so 1: ");
				num1 = sc.nextInt();
			} while(num1 <= 0);
			do{
				System.out.println("Nhap so 2: ");
				num2 = sc.nextInt();
			} while(num2 <= 0);
			
			System.out.println("1. Phep cong");
			System.out.println("2. Phep tru");
			System.out.println("3. Phep nhan");
			System.out.println("4. Phep chia");
			System.out.println("5. Phep luy thua");
			System.out.println("Nhap lua chon: ");
			int choose = sc.nextInt();
			switch(choose){
				case 1: 
					System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
				case 2: 
					System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
				// cac phep tinh con lai
				// a mu n: a * a ... * a, n so a
				case 5:
					long result = 1;
					for (int i=0; i< num2; i++){
						result *= num1;
					}
					System.out.printf("%d ^ %d = %d", num1, num2, result);
				default:
					System.out.println("Phep tinh khong hop le");
			}
			
			// hoi nguoi dung tiep tuc hay khong
			System.out.println("Ban co muon tiep tuc chuong trinh hay khong (co: 1)");
			confirm = sc.nextInt();
		}while(confirm == 1);
		
	}

}
