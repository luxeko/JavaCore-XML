package java1.src.BaiThi;
import java.util.Scanner;
public class main {
    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Acount acc = new Acount();
        acc.input();
        acc.output();
        acc.askCustomer();
        sc.close();

    }
}



