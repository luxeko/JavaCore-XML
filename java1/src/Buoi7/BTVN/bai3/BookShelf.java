package java1.src.Buoi7.BTVN.bai3;

import java.util.ArrayList;
import java.util.Scanner;

import java1.src.Buoi5.Book;

public class BookShelf {
    private String idMaKe ;
    private int viTri;
    private ArrayList<Book> dsSachTrenKe = new ArrayList<Book>();
    Scanner sc = new Scanner(System.in);
	public BookShelf(){
    }
	public BookShelf(String idMaKe, int viTri, ArrayList<Book> dsSachTrenKe) {
        this.idMaKe = idMaKe;
        this.viTri = viTri;
        this.dsSachTrenKe = dsSachTrenKe;
    }
    public String getIdMaKe() {
        return idMaKe;
    }
    public void setIdMaKe(String idMaKe) {
        this.idMaKe = idMaKe;
    }
    public int getViTri() {
        return viTri;
    }
    public void setViTri(int viTri) {
        this.viTri = viTri;
    }
    public ArrayList<Book> getDsSachTrenKe() {
        return dsSachTrenKe;
    }
    public void setDsSachTrenKe(ArrayList<Book> dsSachTrenKe) {
        this.dsSachTrenKe = dsSachTrenKe;
    }
    Book test = new Book();
	public void maKeSach() {
		System.out.println("Nhap ma ke: ");
        this.idMaKe = sc.nextLine();
        test.nhap();
        this.dsSachTrenKe.add(test);
        
	}
    public void viTriSach(){
        System.out.println("Nhap vi tri: ");
        this.viTri = sc.nextInt();
        sc.nextLine();
        test.nhap();
        this.dsSachTrenKe.add(test);
	}
    public void timSach(){

    }
    public void xuat(){
        System.out.println("Thong tin nha sach: ");
        for(int i = 0; i < this.dsSachTrenKe.size(); i++){
            System.out.println(this.dsSachTrenKe.get(i));
        }
    }
    
    

}
