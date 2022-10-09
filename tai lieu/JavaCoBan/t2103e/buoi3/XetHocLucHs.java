package buoi3;

import java.util.Scanner;

public class XetHocLucHs {

	public static void main(String[] args) {
		// nhập điểm của 1 học sinh
		/*
		 * - Điểm ko hợp lệ < 0 || > 10: thông điểm không hợp lệ
		 * - điểm < 4: yếu
		 * - điểm trong [4, 6.5]: trung bình
		 * - điểm trong [6.5, 8.5]: khá
		 * - > 8.5: giỏi
		 * 
		 * */
		System.out.println("Chuong trinh xet hoc luc hs");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap diem cua hs: ");
		float diem = sc.nextFloat();
		if (diem >=0 && diem <= 10){
			// diem hop le
			if(diem < 4){
				System.out.printf("Diem %f: hoc luc yeu", diem);
			} else if(diem <= 6.5){
				System.out.printf("Diem %f: hoc trung binh", diem);
			} else if(diem <= 8.5){
				System.out.printf("Diem %f: hoc kha", diem);
			} else {
				System.out.printf("Diem %f: hoc gioi", diem);
			}
		} else {
			System.out.printf("Diem %f khong hop le%n", diem);
		}
		
	}

}
