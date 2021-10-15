package java1.src.Buoi10.BTVN.Bai1;
import java.util.Scanner;
public class main {
    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int functionID;
        boolean flag = true;
        ShapeManager sm = new ShapeManager();
        do{
            showMenu();
            System.out.print("Choose: ");
            functionID = sc.nextInt();
            sc.nextLine();
            switch(functionID){
                case 1:
                    Triangle tri = new Triangle();
                    tri.nhap();
                    sm.addTri(tri);
                    break;
                case 2:
                    Square sq = new Square();
                    sq.nhap();
                    sm.addSq(sq);
                    break;
                case 3:
                    Rectangle rec = new Rectangle();
                    rec.nhap();
                    sm.addRec(rec);
                    break;
                case 4:
                    Circle cir = new Circle();
                    cir.nhap();
                    sm.addCir(cir);
                    break;
                case 5: 
                    sm.timLoai();
                    break;
                case 6: 
                    sm.xoaLoai();
                    break;
                case 7: 
                    sm.xuat();
                    break;
                case 8:
                    System.out.println("Ket thuc!");
                    System.exit(1);
                default:
                    System.out.println("Nhap khong dung lua chon");

            }
            if(functionID == 8) flag = false;
        }while(flag == true);
        
        sc.close();

    }

    public static void showMenu() {
        System.out.println("======= Shape Manage =======");
        System.out.println("1. Them hinh tam giac");
        System.out.println("2. Them hinh vuong");
        System.out.println("3. Them hinh chu nhat");
        System.out.println("4. Them hinh tron");
        System.out.println("5. Tim danh sach hinh theo loai");     
        System.out.println("6. Xoa danh sach hinh theo loai");   
        System.out.println("7. Hien thi danh sach thong tin");   
        System.out.println("8. Thoat");      
    }
}
