package java1.src.Buoi2;
import java.util.Random;
import java.util.Scanner;
public class DamLaKheo {
    public static void main(String[] args) {
        System.out.println("Đấm, Lá, Kéo");
        while(true){
            Scanner user = new Scanner(System.in);
            System.out.println("----------");
            System.out.printf("Người Chọn: ");
            String input = user.nextLine();
            int Awer = 0;
            Random computer = new Random();
            int random = computer.nextInt(3)+1;
            System.out.println(random);
            if (random == 1){
                System.out.println("Máy chọn: Kéo");
            }else if(random == 2){
                System.out.println("Máy chọn: Bao");
            }else if(random == 3){
                System.out.println("Máy chọn: Đấm");
            }
            System.out.println("----------");

            switch (input){
                case "Keo":
                    Awer = 1;
                    break;
                case "Bao":
                    Awer = 2;
                    break;
                case "Dam":
                    Awer = 3;
                    break;
            }
            if(Awer == random){
                 System.out.println("Kết Quả: Hoà");
            }
            else{
                if(Awer == 1){
                    if(random == 2){
                        System.out.println("Kết Quả: Thua");
                    }else{
                         System.out.println("Kết Quả: Thắng");
                    }
                   
                }
                else if(Awer == 2){
                    if(random == 0){
                        System.out.println("Kết Quả: Thua");
                    }else{
                         System.out.println("Kết Quả: Thắng");
                    }
                   
                }
                else if(Awer == 3){
                    if(random == 1){
                        System.out.println("Kết Quả: Thua");
                    }else{
                         System.out.println("Kết Quả: Thắng");
                    }
                }
                else{
                    System.out.println("Nhập sai!");
                }
            }user.close();
        }
    }
}
