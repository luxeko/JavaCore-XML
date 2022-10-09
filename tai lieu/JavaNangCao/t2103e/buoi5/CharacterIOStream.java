package buoi5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CharacterIOStream {
	/*
	 * Doc ghi du lieu unicode
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// doc tu file 1 va ghi xuong file 2: copy
		String file1 = "filechar1.txt";
		String file2 = "filechar2.txt";
		try(
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file1), "UTF-8");
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file2), "UTF-8");
				){
			// doc ca mang byte
			char[] result = new char[1024];
			isr.read(result);
			// ghi mang byte
			osw.write(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Ket thuc");
	}

}
