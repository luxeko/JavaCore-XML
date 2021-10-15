package java1.src.Buoi10.BaiTap;

import java.util.Scanner;

public class Phone implements IThaoTac{
	private String name;
	private String phoneNumber;
	
	public Phone() {
		super();
	}

	public Phone(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten: ");
		this.name = sc.nextLine();
		// sdt: 10 ky tu so va bat dau = 0
		while (true) {
			System.out.println("Nhap so dt: ");
			String sdt = sc.nextLine();
			// 10 ky tu
			if (sdt.length() != 10) {
				System.out.println("Phone Number phai 10 ky tu.");
			} else if (!sdt.startsWith("0")) {
				System.out.println("Phone Number phai bat dau bang 0.");
			} else {
				// 10 ky tu so:
				try {
					// chuyen doi 1 chuoi ve 1 so long
					//long l_sdt = Long.parseLong(sdt);
					this.phoneNumber = sdt;
				}catch (Exception e) {
					System.out.println("Phone Number phai co 10 ky tu so");
				}	
			}
			if (this.phoneNumber != null) {
				break;
			}
		}
		sc.close();
		
	}

	@Override
	public void xuat() {
		System.out.println("Name: "+ this.name + "; Phone Number: "+ this.phoneNumber);
	}
	public static void main(String[] args) {
		Phone p1 = new Phone();
		p1.nhap();
		p1.xuat();
	}
	
}
