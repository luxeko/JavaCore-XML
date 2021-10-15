package Java2.src.BaiThi;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String Name;
    private String Phone;
    private String Adress;
    public Student() {
    }
    public Student(String studentId, String name, String phone, String adress) {
        this.studentId = studentId;
        Name = name;
        Phone = phone;
        Adress = adress;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getAdress() {
        return Adress;
    }
    public void setAdress(String adress) {
        Adress = adress;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
   
    public void input(){
        Scanner sc = new Scanner(System.in); 
        while(true) {
			System.out.print("Enter StudentId: ");
			this.studentId = sc.nextLine();
			if(!this.studentId.contains(" ")) {
			    if(!quanLySv.danhSachSv.contains(this.studentId)) {
					break;
				}else {
					System.out.println(this.studentId +" Is Already Exist! Please Enter A New StudentId");
				}				
			}else {
				System.out.println("ID can't be blank");
			}
		}
        while(true){
            System.out.println("Enter student'name: ");
            this.Name = sc.nextLine();
            if(this.Name.trim().equals("")){
                System.out.println("Name can't be blank!");
            }else{
                break;
            }
        }
        while(true){
            System.out.println("Enter student'adress: ");
            this.Adress = sc.nextLine();
            if(this.Adress.trim().equals("")){
                System.out.println("Adress can't be blank!");
            }else{
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
        return "Student [StudentID = " + this.studentId + ", Name = " + this.Name + ", Adress = " + this.Adress + ", Phone = " + this.Phone + "]";
    }
    

    
}
