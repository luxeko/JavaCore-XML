package Exam_Package;

import java.util.Scanner;

public class Student {
	private String StudentID;
	private String Name;
	private String Address;
	private String Phone;

	public String getStudentID() {
		return StudentID;
	}

	public void setStudentID(String studentID) {
		StudentID = studentID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	
	public Student() {
		super();
	}

	public Student(String studentID, String name, String address, String phone) {
		super();
		StudentID = studentID;
		Name = name;
		Address = address;
		Phone = phone;
	}
	public void addInfo() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Enter StudentId: ");
			this.StudentID = sc.nextLine();
			if(this.StudentID.length() == 7 && !this.StudentID.contains(" ")) {
			if(!StudentDao.listStu.containsKey(this.StudentID)) {
					break;
				}else {
					System.out.println(this.StudentID +" Is Already Exist! Please Enter A New StudentId");
				}				
			}else {
				System.out.println("Please Enter StudentId Have 7 Characters And Don't Contain Space");
			}
		}
		while(true) {
			System.out.print("Enter FullName: ");
			this.Name = sc.nextLine();
			if(this.Name.length() == 0) {
				System.out.println("Please Enter FullName");
			}else {
				break;
			}
		}
		while(true) {
			System.out.print("Enter Address: ");
			this.Address = sc.nextLine();
			if(this.Address.length() ==0 ) {
				System.out.println("Please Enter Address");
			}else {
				break;
			}
		}
		while(true) {
			System.out.print("Enter Phone: ");
			this.Phone = sc.nextLine();
			try {
				if(this.Phone.length() != 10) {
					System.out.println("Please Enter Phone Number Have 10 Digits");
				}else {
					Long obj = Long.parseLong(this.Phone);  									
					break;
				}
			}catch(Exception e) {
				System.out.println("Please Enter Phone Number Is Digits");
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.StudentID +"             "+this.Name+"             "+this.Address+"             "+this.Phone;
	}
	
}
