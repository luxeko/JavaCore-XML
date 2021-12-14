package Java2.src.Buoi5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ObjectIOStream {
	/*
	 * Doc/ghi kieu object
	 * */
	public static void main(String[] args) {
		String file = "objectstream.txt";
		// ghi
		try(
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))
				){
			SinhVien sv = new SinhVien("dung", 20);
			ArrayList<SinhVien> listSv = new ArrayList<SinhVien>();
			listSv.add(new SinhVien("dung", 20));
			listSv.add(new SinhVien("dung2", 21));
			listSv.add(new SinhVien("dung3", 22));
			//oos.writeObject(sv);
			oos.writeObject(listSv);
		}catch(Exception e) {
			e.printStackTrace();
		}
		// doc: 
		try (
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			){
			//SinhVien obj = (SinhVien)ois.readObject();
			// System.out.println(obj);
			ArrayList<SinhVien> listobj = (ArrayList<SinhVien>)ois.readObject();
			for (SinhVien ob : listobj)
				System.out.println(ob);	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
class SinhVien implements Serializable{
	private String name;
	private int age;
	public SinhVien(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		
		return "Name: "+ this.name + "; age: "+ this.age;
	}
}
