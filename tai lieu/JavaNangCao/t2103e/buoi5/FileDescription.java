package buoi5;

import java.io.File;

public class FileDescription {

	public static void main(String[] args) {
		// pathname: duong dan toi file/ thu muc trong may tinh
		// tuyet doi: window C:/Windows (:), mac/linus: /
		// tuong doi: dua vao 1 thu muc tuyet doi nao day
		//String root = "D:\\WORK\\fpt\\T2103Ewsp\\T2103E_java2";
		// lay thu muc goc cua chuong trinh dang chay
		String root = System.getProperty("user.dir");
		System.out.println(root);
		String filepath = root + "\\dung\\sinhvien.txt";
		
		File fileBt = new File("/dung/sinhvien.txt");
		System.out.println("File ton tai hay khong? "+ fileBt.exists());
		System.out.println("File co phai file ( chua du lieu) hay khong?" + fileBt.isFile());
		System.out.println("File co phai la thu muc ?: " + fileBt.isDirectory());
		System.out.println("Duong dan file: "+ fileBt.getPath());
		System.out.println("Duong dan thu muc cha: " + fileBt.getParent());
		System.out.println("Freespace: "+ fileBt.getFreeSpace());
		
		File fileRoot = new File(root);
		System.out.println("File root la thu muc?: "+ fileRoot.isDirectory());
		// neu root la thu muc: thi hien thi danh sach file / thu muc con cua thu muc root
		if (fileRoot.isDirectory()) {
			File[] dsFile = fileRoot.listFiles();
			for(File f : dsFile) {
				System.out.println(f.getName() + ": "+ (f.isFile()?" File": " Directory"));
			}
		}
		
	}

}
