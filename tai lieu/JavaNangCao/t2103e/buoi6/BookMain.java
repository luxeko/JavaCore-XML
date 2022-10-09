package buoi6;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookMain {

	public static void main(String[] args) {
		Book book = new Book();
		//book.nhap();
		BookDao dao = new BookDao();
		// them 
		try {
			dao.createBook(book);
			System.out.println("Thuc thi thanh cong.");
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		List<Book> listInsert = new ArrayList<Book>();
		listInsert.add(new Book("002","Tom", 1000));
		listInsert.add(new Book("003","Tom 3", 1000));
		listInsert.add(new Book("004","Tom 4", 1000));
		try {
			dao.createListBook(listInsert);
			System.out.println("Insert list thanh cong");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// update
		Book updateBook = new Book("222", "met", 2200);
		try {
			dao.updateBook(updateBook);
		} catch (Exception e) {
			System.out.println("Update: "+ e);
		} 
		
		List<Book> listBook = dao.getList();
		for (Book b : listBook) {
			System.out.println(b);
		}
		
	}

}
