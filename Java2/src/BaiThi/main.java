package Java2.src.BaiThi;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      
        int functionid;
        boolean flag = true;
        do {
            try {
                showMenu();
                System.out.println("Enter choose: ");
                functionid = scan.nextInt();
                scan.nextLine();
                switch (functionid) {
                    case 1://thêm 1 student records
                        quanLySv.addSV();
                        break;
                    case 2://Display student records
                        quanLySv.showList();
                        break;
                    case 3://Svae
                        quanLySv.addAll();
                        break;
                    case 4:
                        System.out.println("End program!");
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Error choose! Please enter again");
                }
                if(functionid == 4) flag = false;
            } catch (Exception e) {
                System.out.println("Error Found "+e.getMessage());
            }
            
        } while (flag == true);
    }

    public static void showMenu(){
        System.out.println("====== Student Manager ======");
        System.out.println("1. Add student records");
        System.out.println("2. Display student records");
        System.out.println("3. Save student in DB");
        System.out.println("4. Exit!"); 
    }
    
}
