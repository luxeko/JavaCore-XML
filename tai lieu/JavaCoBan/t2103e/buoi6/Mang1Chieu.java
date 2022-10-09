package buoi6;

import java.util.Scanner;

public class Mang1Chieu {

	public static void main(String[] args) {
		// khai báo biến mảng:
		int[] nums;
		int num1 = 10;
		
		// gan gia tri bien mang
		nums = new int[5];
		System.out.println("Kich thuoc cua mang: "+ nums.length);
		System.out.println("nums[0] = " + nums[0]);
		nums[0] = 10;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap cac phan tu cua mang: ");
		int i = 0;
		/*
		do {
			System.out.print("nums["+ i + "]=");
			nums[i++] = sc.nextInt();
		}while (i < nums.length);
		sc.next();
		*/
		// duyet mang:
		System.out.println("Duyet mang c1 for/ while/ do while: ");
		for(i = 0; i< nums.length; i++) {
			System.out.printf("%d  ", nums[i]);
		}
		System.out.println("\nDuyet mang c2 foreach: ");
		for(int temp : nums) {
			System.out.printf("%d  ", temp);
		}
		System.out.println();
		String[] names = new String[16];
		System.out.println("Kich thuoc cua mang 2: "+ names.length);
		System.out.println("names[0] = " + names[0]);
		
		//nhap cac ten hv trong names, chon tiep tuc thi nhap phan tu tiep theo
		// in danh sach ten cac hv (!= null ) trong lop
		int j = 0;
		String confirm = "";
		do {
			System.out.print("names["+ j + "]=");
			names[j++] = sc.nextLine();
			System.out.println("Ban co dung nhap hay khong (n: dung)");
			confirm = sc.nextLine();
		}while (j < names.length && !confirm.equalsIgnoreCase("n"));
		System.out.println("\nDuyet tenhs foreach: ");
		for(String ten : names) {
			if (ten != null)
				System.out.printf("%s  ", ten);	
		}
		System.out.println("\nDuyet cac phan tu != null:");
		for(int k = 0; k< j; k++) {
			System.out.printf("%s  ", names[k]);
		}
		float[] points = {10, 5.5f, 7, 8.5f};
		System.out.println("Kich thuoc cua mang 3: "+ points.length);
		System.out.println("points[0] = " + points[0]);
		
		int[] nums2 = nums;
		
	}

}
