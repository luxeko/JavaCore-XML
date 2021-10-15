package Java2.src.Buoi5;

import java.io.File;

//duyệtt file: hiển thị tất cả các thư mục, file trong 1 cha nào đó
public class FileManage {
    public static void main(String[] args) {
        //lấy thư mục gốc của chương trình đang chạy
        String root = System.getProperty("user.dir");
        File fileRoot = new File(root);
        System.out.println("File root là thư mục hay không? " + fileRoot.isDirectory());
        System.out.println("----- Duyệt file thư mục -----");
        travelDirectory(fileRoot, 0);
    }
    //hàm đệ quy: thao tác đệ quy: 1. gọi lại thao tác của chính nó
    // 2. dừng để quy để tránh thực hiện vô hạn
    public static void travelDirectory(File parent, int level){
        if(!parent.exists() )
            return;

        StringBuilder sb = new StringBuilder();
        //tính khoảng trắng trước file
        for(int i = 0; i < level; i++){
            sb.append("   ");
        }
        //dừng đệ quy
        //Khi file: flie chưa dữ liệu
        System.out.println(sb.toString() + (parent.isDirectory()?"-":"+") + ((level == 0)?parent.getAbsolutePath():parent.getName()));

        if(parent.isDirectory()){
            File [] dsFile = parent.listFiles();
            for(File f : dsFile){
                //gọi lại thao tác của chính nó
                travelDirectory(f, level + 1);
            }
        }
    }
}
