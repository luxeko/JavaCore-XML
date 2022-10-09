package Exam_Package;

import java.util.Scanner;

public class Main_Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String confirm ="";
		Boolean flag = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("====== Manager Student ======");
			System.out.println("-----------------------------");
			System.out.println("1: Add New Student To ListStudent");
			System.out.println("2: Display All Students In A List");
			System.out.println("3: Save List Student Into DB");
			System.out.println("4: Exit");
			System.out.print("Enter Choose: ");
			try {
				int choose = sc.nextInt();
				sc.nextLine();
				switch(choose) {
				case 1:
					StudentDao.addStuList();
					break;
				case 2:
					StudentDao.showStuList();
					break;
				case 3:
					StudentDao.addListStu();
					break;
				case 4:
					System.out.println("Thanks");
					flag = true;
					break;
				default:
					System.out.println("Please Enter Choose Follow By Instruction");
					break;
				}
				if(!flag) {
					System.out.print("Do You Want To Continue Work With Program(n:Exit): ");
					confirm = sc.nextLine();
				}
			}catch(Exception e) {
				System.out.println("Error Found "+e.getMessage());
			}
			sc.nextLine();
		}while(!confirm.equalsIgnoreCase("n") && !flag)
;	}

}
