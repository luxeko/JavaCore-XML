package Java2.src.Buoi6.BTVN.BaiTapJDBC2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int functionID;
        boolean flag = true;
        do{
            showMenu();
            System.out.print("Choose: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1:
                   
                    break;
                case 2:
                    
                    break;
                case 3:
                    DMdsMonHoc.showMenu();
                    break;
                case 4:
                    
                    break;
                case 5:
                    System.out.println("Kết thúc!");
                    System.exit(1);
                default:
                    System.out.println("Nhập sai!. Vui lòng nhập lại");
            }
            if(functionID == 5) flag = false;
        }while(flag == true);
        sc.close();
    }

    public static void showMenu(){
        System.out.println("====== Quản lý điểm sv ======");
        System.out.println("1. CRUB Khoa");
        System.out.println("2. CRUB Sinh viên");
        System.out.println("3. CRUB Môn học");
        System.out.println("4. CRUB Kết quả");    
        System.out.println("5. Thoát");
    }

}



