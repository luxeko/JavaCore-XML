package java1.src.Buoi4;

import java.util.Scanner;

public class Caculator {

	int num1, num2;
	
	public Caculator(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
    public Caculator(){
       
    }
    void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhập num1: ");
        this.num1 = input.nextInt();
        System.out.printf("Nhập num2: ");
        this.num2 = input.nextInt();
        input.close();
    }
	String xuat(){
        return "Số thứ nhất: "+ this.num1 + "\n" + "Số thứ hai: " + this.num2; 
    }
	int cong(){
        return this.num1 + this.num2;
    }
    int tru(){
        return this.num1 - this.num2;
    }
    int nhan(){
        return this.num1 * this.num2;
    }
    float chia(){
        return (float)this.num1 / (float)this.num2;
    }
    float luythua(){
        float sum = 1;
        for( int i = 0; i < this.num2; i++){
            sum *= this.num1;
        }
        return sum;
    }

    String checkUoc(){
        if(this.num1 % this.num2 == 0){
            return this.num2 + " là ước của " + this.num1;
        }else{
            return this.num2 + " không phải ước của " + this.num1;
        }
    }
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Caculator bai1 = new Caculator();
        while(true){
            boolean next = false;
            System.out.println("--- Máy tính đơn giản ---");
            System.out.println("-------------------------");
            bai1.nhap();
            System.out.println(bai1.xuat());
            System.out.println("Nhập Phép Tinh: ");
		    System.out.println("1: Cộng");
		    System.out.println("2: Trừ");
		    System.out.println("3: Nhân");
		    System.out.println("4: Chia");
		    System.out.println("5: Luỹ thừa của " + bai1.num1);
		    System.out.println("6: Kiểm tra " + bai1.num2 + " có phải ước của " + bai1.num1 +  " không?");

            int control = input.nextInt();
            switch(control){
                case 1:
                    System.out.println("Tổng của " + bai1.num1 + " và "+ bai1.num2 + " là: " + bai1.cong());
                    next = true;
                    break;
                case 2:
                    System.out.println("Hiệu của " + bai1.num1 + " và "+ bai1.num2 + " là: " + bai1.tru());
                    next = true;
                    break;
                case 3:
                    System.out.println("Nhân " + bai1.num1 + " với "+ bai1.num2 + " bằng: " + bai1.nhan());
                    next = true;
                    break;
                case 4:
                    System.out.println("Chia " + bai1.num1 + " cho "+ bai1.num2 + " bằng: " + bai1.chia());
                    next = true;
                    break;
                case 5:
                    System.out.println("Luỹ thừa của " + bai1.num1 + " và "+ bai1.num2 + " là: " + bai1.luythua());
                    next = true;
                    break;
                case 6:
                    System.out.println(bai1.checkUoc());
                    next = true;
                    break;
                default:
                    System.out.println("Phép tính không hợp lệ");
                    next = true;
            }
            if(next){
                System.out.println("Bạn có muốn thực hiện lại phép tính?");
                System.out.println("(1: Có)");
                System.out.println("(2: Không)");
			    int continuecal = input.nextInt();
			    if(continuecal == 2) {
				    break;
			    }		
            }
        }
        input.close();
	}

}
