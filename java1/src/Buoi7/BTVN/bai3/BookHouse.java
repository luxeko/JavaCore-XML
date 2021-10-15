package java1.src.Buoi7.BTVN.bai3;

import java.util.ArrayList;

public class BookHouse {
	// ds cac ke sach trong nha sach
	private ArrayList<BookShelf> dsKeSach = new ArrayList<BookShelf>();
    BookShelf test = new BookShelf();
	//lambda
	// nhap ds ke sach
	public BookHouse(){

	}
	public BookHouse(ArrayList<BookShelf> dsKeSach) {
		this.dsKeSach = dsKeSach;
	}
	public void nhap1(){
		test.maKeSach();
		this.dsKeSach.add(test);
	}
	public void nhap2(){
		test.viTriSach();
		this.dsKeSach.add(test);
	}
	public void inSach(){
		test.xuat();
		this.dsKeSach.add(test);
	}
	
	
	
}

