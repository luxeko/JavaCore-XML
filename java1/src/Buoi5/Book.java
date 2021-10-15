package java1.src.Buoi5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Book {
    //1. fields - thuộc tính
    private String tenSach;
    private Author tacGia;
    private double price;
    private Date thoigianXB;
    private String loaiSach;
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //2. constructor: public
    public Book(){

    }
    public Book(String tenSach, Author tacGia, double price, Date thoigianXB, String loaiSach){
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.price = price;
        this.thoigianXB = thoigianXB;
        this.loaiSach = loaiSach;
    }

    //3. set(gán giá trị cho thuộc tính)/get: lấy giá trị cho thuộc tính
    public String getLoaiSach() {
        return loaiSach;
    }
    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }
     public String getTenSach() {
        return tenSach;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    //4. method nghiệp vụ: public
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        //ten sach
        System.out.println("=================");
        System.out.println("Nhap ten sach: ");
        this.tenSach = sc.nextLine();
        System.out.println("=================");

        //gia sach
        while(true){
            System.out.println("Gia sach: ");
            this.price = sc.nextDouble();
            sc.nextLine();
            if(this.price > 0){
                break;
            }else {
                System.out.println("Gia sach phai lon hon 0");
            }
            System.out.println("=================");
        }

        //thoi gian xuat ban
        do{
            System.out.println("=================");
            System.out.println("Thoi gian xuat ban: ");
            String nhapDate = sc.nextLine();
            // su dung sdf de chuyen doi string sang date
            try {
                this.thoigianXB = sdf.parse(nhapDate);
            } catch (ParseException e) {
                    e.printStackTrace();
            }
            System.out.println("=================");
        }while(this.thoigianXB == null);

        //loai sach
        System.out.println("The loai sach");
        System.out.println("1: VH");
        System.out.println("2: TT");
        System.out.println("3: DL");
        System.out.println("4: KH");
        System.out.println("5: NT");
        System.out.println("-----------------");
        System.out.printf("Lua chon: ");
        int choose = sc.nextInt();
        switch(choose){
            case 1:
                this.loaiSach = "VH";
                System.out.println("=================");
                break;
            case 2:
                this.loaiSach = "TT";
                System.out.println("=================");
                break;
            case 3:
                this.loaiSach = "DL";
                System.out.println("=================");
                break;
            case 4:
                this.loaiSach = "KH";
                System.out.println("=================");
                break;
            case 5:
                this.loaiSach = "NT";
                System.out.println("=================");
                break;
            default: 
                System.out.println("Vui long nhap loai sach!");
                System.out.println("=================");
        }

        //tac gia
        System.out.println("Thong tin tac gia");
        this.tacGia = new Author();
        this.tacGia.nhap(); 
        System.out.println("=================");
        sc.close();
    }
    
    public void xuat(){
        System.out.println("--- Thong tin sach ---");
        System.out.println("Ten sach: " + this.tenSach);
        System.out.println("Gia sach: " + this.price);
        System.out.println("Thoi gian xuat ban: " + sdf.format(this.thoigianXB));
        System.out.println("Loai sach: " + this.loaiSach);
        // System.out.println("--- Thong tin tac gia ---\n" + this.tacGia.xuat());
    }
    public void goBack(){
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ban co muon thuc hien lai?");
            System.out.println("(1: Có)");
            System.out.println("(2: Không)");
			int conti = sc.nextInt();
            if(conti == 1) {
                this.nhap();
                this.xuat();
            }	
            else{
                System.out.println("Thank You");
                break;
            }
            sc.close();
        }
    }
    

}
