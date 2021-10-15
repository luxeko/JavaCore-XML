package java1.src.Buoi5;

import java.util.Scanner;

public class Author {
    //1. fields - thuộc tính
    String tenTacGia;
    String email;
    int namSinh;
    String gioiTinh;

    //2. constructor: public
    public Author(){

    }
    public Author(String tenTacGia, String email, int namSinh, String gioiTinh) {
        this.tenTacGia = tenTacGia;
        this.email = email;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
    }

    //3. set(gán giá trị cho thuộc tính)/get: lấy giá trị cho thuộc tính
    
    //4. method nghiệp vụ: public
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        //ten tac gia
        System.out.println("Ten tac gia: ");
        this.tenTacGia = sc.nextLine();
        //email
        System.out.println("Email: ");
        this.email = sc.nextLine();
        //nam sinh
        System.out.println("Nam sinh: ");
        this.namSinh = sc.nextInt();
        while(true){
            System.out.println("Gioi tinh: ");
            System.out.println("1. Male");
            System.out.println("2. Famale");
            System.out.println("3. 0");
            System.out.println("-----------------");
            int chonGioiTinh = sc.nextInt();
            if(chonGioiTinh >= 1 && chonGioiTinh <= 3){
                if(chonGioiTinh == 1){
                    this.gioiTinh = "Male";
                    System.out.println("Gioi tinh: Male");
                    break;
                }else if (chonGioiTinh == 2){
                    this.gioiTinh = "Famale";
                    System.out.println("Gioi tinh: Famale");
                    break;
                }else{
                    this.gioiTinh = "0";
                    System.out.println("Gioi tinh: 0");
                    break;
                }
            }else{
                System.out.println("Gioi tinh nhap khong hop le!");
            }
        }
        sc.close();
    }
    public String xuat(){
        return "Ten tac gia: " + this.tenTacGia + "\n" +
                "Email: " + this.email + "\n" +
                "Nam sinh: " + this.namSinh + "\n" +
                "Gioi tinh: " + this.gioiTinh;
        
    }

}
