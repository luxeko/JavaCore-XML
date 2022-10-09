package buoi5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteIOStream {
	// doc, ghi file su dung luong byte ( du lieu ASCII )
	/*
	 * 3 buoc thao tac IO:
	 * b1: tao stream ket noi voi nguon
	 * b2: thuc thi ( doc/ ghi )
	 * b3: close stream
	 * */
	public static void main(String[] args) {
		String file = "luongbyte.txt";
		// ghi: O/output
		OutputStream os = null;
		try {
			// b1
			os = new BufferedOutputStream(new FileOutputStream(file));
			// b2
			Integer num = 100;
			os.write(num.toString().getBytes());
			String str = "\ntoi hoc code\n";
			byte[] arr_bytes = str.getBytes();
			os.write(str.getBytes());
			// day mang byte tu stream -> datasource
			os.flush();
		} catch (IOException ex) {
			System.out.println("Loi trong viec ghi file");
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// doc: I/input
		// b3
		try(
				//b1
				InputStream is = new BufferedInputStream(new FileInputStream(file));
				){
			// b2
			while(true) {
				int kytu = is.read();
				System.out.print((char)kytu);
				if (kytu == -1) {
					break;
				}
			}
		}catch(IOException e) {
			System.out.println("Co loi xay ra trong qua trinh doc file");
		}
	}

}
