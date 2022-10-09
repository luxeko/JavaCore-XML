package buoi7;

import java.util.Scanner;

public class Mang2Chieu {

	public static void main(String[] args) {
		// du lieu can nha trong toa chung cu
		//CanHo[][] chungt2 = new CanHo[10][5];
		String[][] chungt3 = new String[4][3];
		chungt3[1][1] = "202";
		chungt3[3][2] = "302";
		
		// 3 hang, 2 cot:
		String[][] chungt4 = {{"101", "102"}, {"201", "202"}, {"301", "302"}};
		System.out.println("Ds can ho chung cu: ");
		for(int i=0; i< 3; i++) {
			for(int j=0; j< 2; j++) {
				System.out.print(chungt4[i][j] +"  ");
			}
			System.out.println();
		}
		// du lieu can nha trong toa chung cu
		// chung cu co 10 tang, moi tang co 5 can ho
		final int SO_TANG = 10;
		final int SO_CAN = 5;
		CanHo[][] chungt2 = new CanHo[SO_TANG][SO_CAN];
		chungt2[2][4] = new CanHo("204", "Pham thi Dung");
		Scanner sc = new Scanner(System.in);
		//nhap thong tin cua can ho trong toa chung cu
		String confirm = "";
		do {
			// xu ly nghiep vu:
			int tang = 0;
			int can = 0;
			while(true) {
				System.out.println("Ban muon nhap can ho tai tang:");
				tang = sc.nextInt();
				if (tang >=0 && tang <SO_TANG) {
					break;
				}
			}
			do {
				System.out.println("Ban muon nhap can ho tai can thu:");
				can = sc.nextInt();
			} while(can < 0 || can > SO_CAN);
			
			if (chungt2[tang][can] == null) {
				/*
				chungt2[tang][can] = new CanHo((tang+1)+""+ (can+1));
				chungt2[tang][can].nhap();
				*/
				chungt2[tang][can] = new CanHo();
				chungt2[tang][can].nhap((tang+1)+""+ (can+1));
			} else {
				System.out.println("Can ho thu "+ (tang+1) + " va can thu: "+ (can+1) + " da co du lieu");
			}
			
			System.out.println("Ban co muon dung nhap hay (n: stop)");
			confirm = sc.nextLine();
		}while(confirm.equalsIgnoreCase("n"));
		int countExist = 0;
		// xuat du lieu can ho chung cu:
		for(int i=0; i< SO_TANG; i++) {
			for(int j=0; j< SO_CAN; j++) {
				if (chungt2[i][j] != null) {
					chungt2[i][j].xuat();
					countExist ++;
				} else {
					System.out.println("Can ho thu "+ (i+1) + " va can thu: "+ (j+1) + " chua co du lieu");
				}
			}
		}
		System.out.println("Chung cu co "+ countExist + " co du lieu va "+ (SO_TANG*SO_CAN - countExist) + " chua co du lieu");
		/*
		 * xay dung ham nhap va ham xuat cua Can ho
		 * nhap can ho moi vao chung cu ( macan duoc sinh ra tu dong tu so tang + so can: 11);
		 * xuat thong tin ds can ho trong chung cu
		 * xac dinh chung cu do co bn can ho da co du lieu va bn can ho chua co du lieu
		 * 
		 * */
	}

}
class CanHo{
	private String maCan;
	private String chuHo;
	
	public CanHo() {
		super();
	}
	
	public CanHo(String maCan) {
		super();
		this.maCan = maCan;
	}

	public CanHo(String maCan, String chuHo) {
		super();
		this.maCan = maCan;
		this.chuHo = chuHo;
	}
	public String getMaCan() {
		return maCan;
	}
	public void setMaCan(String maCan) {
		this.maCan = maCan;
	}
	public String getChuHo() {
		return chuHo;
	}
	public void setChuHo(String chuHo) {
		this.chuHo = chuHo;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		if (this.maCan == null) {
			System.out.println("Nhap ma can: ");
			this.maCan = sc.nextLine();
		}
		System.out.println("Chu ho: ");
		this.chuHo = sc.nextLine();
	}
	public void nhap(String macn) {
		Scanner sc = new Scanner(System.in);
		if (macn != null) {
			this.maCan = macn;
		}
		System.out.println("Chu ho: ");
		this.chuHo = sc.nextLine();
	}
	public void xuat() {
		System.out.println("Ma can: "+ this.maCan + "; chu ho: "+ this.chuHo);
	}
	
}