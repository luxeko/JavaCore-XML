package Java2.src.Buoi5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteIOStream {
    //Doc, ghi file sử dụng dung lượng byte (dữ liệu ASCII)
    /**
     * 3 bước thao tác IO:
     * b1: tạo stream kết nối với nguồn
     * b2: thực thi (đọc/ghi)
     * b3: close stream
     */
    public static void main(String[] args) {
        String file = "luongbyte.txt";
        //ghi: o/output
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
        } catch (IOException e) {
            System.out.println("Lỗi trong việc ghi file");
        } finally{
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // doc: I/input
		// b3
		try(//b1
            InputStream iS = new BufferedInputStream(new FileInputStream(file))){
            // b2
            while(true) {
                int kytu = iS.read();
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
