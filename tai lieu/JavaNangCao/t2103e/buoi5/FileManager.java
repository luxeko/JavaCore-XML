package buoi5;

import java.io.File;

public class FileManager {
	// duyet file: hien thi tat ca cac thu muc, file trong 1 cha nao do
	public static void main(String[] args) {
		// lay thu muc goc cua chuong trinh dang chay
		String root = System.getProperty("user.dir");
		File fileRoot = new File(root);
		System.out.println("File root la thu muc?: "+ fileRoot.isDirectory());
		System.out.println("-----Duyet file trong thu muc: ----");
		travelDirectory(fileRoot, 0);
	}
	// ham de quy: thao tac de quy: goi chinh no
	// + dung de quy
	public static void travelDirectory(File parent, int level) {
		if (!parent.exists())
			return;
		StringBuilder sb = new StringBuilder();
		// tinh khoang trang truoc File
		for (int i=0; i< level; i++) {
			sb.append("   ");
		}
		// stop de quy
		// khi file: file chua du lieu
		System.out.println(sb.toString() + (parent.isDirectory()?"-":"+") 
				+ ((level == 0)?parent.getAbsolutePath():parent.getName()));
		if (parent.isDirectory()) {
			File[] dsFile = parent.listFiles();
			for(File f : dsFile) {
				// goi lai thao tac cua chinh no: de quy
				travelDirectory(f, level + 1);
			}
		} 
	}

}
