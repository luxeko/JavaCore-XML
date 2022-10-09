package buoi3;

import java.util.Scanner;

public class Loop {

	public static void main(String[] args) {
		System.out.println("lenh lap: while, do while, for");
		Scanner sc = new Scanner (System.in);
		int num;
		/*
		 * 3 yeu to trong lenh lap:
		 - khoi tao
		 - dieu kien lap (*)
		 - thay doi gia tri lap
		 * */
		// nhap num > 0 tu ban phim, nhap sai yeu cau nhap lai -> phep lap
		// tinh tong va so luong cac so chia het cho 3 tu 1 -> num -> phep lap
		/*
		 // c1
		do {
			System.out.println("Nhap 1 so tu ban phim: ");
			// 3. thay doi gia tri lap
			num = sc.nextInt();
		} while (num <= 0); // 2.dk lap
		*/
		/*
		// c2
		// 1. khoi tao
		num = 0;
		// 2. dk lap
		while(num <= 0){
			System.out.println("Nhap 1 so tu ban phim: ");
			// 3. thay doi gia tri lap
			num = sc.nextInt();
		}
		*/
		//c3:
		/*
		while(true){
			System.out.println("Nhap 1 so tu ban phim: ");
			// 3. thay doi gia tri lap
			num = sc.nextInt();
			// 2. dk lap
			if (num > 0){
				break;
			}
		}
		*/
		// c4: for
		/*
		for (; ;){
			System.out.println("Nhap 1 so tu ban phim: ");
			// 3. thay doi gia tri lap
			num = sc.nextInt();
			// 2. dk lap
			if (num > 0){
				break;
			}
		}
		*/
		for (num = 0; num <= 0;){
			System.out.println("Nhap 1 so tu ban phim: ");
			// 3. thay doi gia tri lap
			num = sc.nextInt();
		}
		int sum = 0, count = 0, stt = 0;
		while (true){
			stt++;
			if (stt % 3 == 0){
				sum += stt;
				count++;
			}
			// 2. dk thoat lap
			if (stt >= num){
				break;
			}
		}
		System.out.printf("Tu 1 -> %d co %d so chia het cho 3 tong = %d", num, count, sum);
		
	}

}
