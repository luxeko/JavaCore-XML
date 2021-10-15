package Java2.src.Buoi5;

import java.io.File;

public class FileDescription {
    public static void main(String[] args) {
        // pathname: duong dan toi file/ hoac thu muc trong may tinh
        //tuyet doi: window C:/windows/ (dựa vào dấu : để phân phân biệt tuyệt đối), mac/linux (dựa vào dấu / )
        //tương đối: dựa vào 1 thư mục tuyệt tối nào đấy.
        //lấy thư mục gốc của chương trình đang chạy
        String root = System.getProperty("user.dir");
        System.out.println("Check........ " +root);
        String filePath = root + "\\Java2\\sinhvien.txt";

        File fileBt = new File("/Java2/sinhvien.txt");
        System.out.println("File tồn tại hay không? " + fileBt.exists());
        System.out.println("File có phải là file(chưa dữ liệu) hay không? " + fileBt.isFile()); //true thì là file còn false thì là 1 thư mục
        System.out.println("File có phải là thư mục? " + fileBt.isDirectory()); //true thì nó là thư mục còn false thì nó là file
        System.out.println("Đường dẫn của file: " + fileBt.getPath());
        System.out.println("Đường dẫn thư mục cha: " + fileBt.getParent());
        System.out.println("Dung lượng: " + fileBt.getFreeSpace());

        File fileRoot = new File(root);
        System.out.println("File root là thư mục hay không? " + fileRoot.isDirectory());
        // nếu root là thư mục thì hiển thị danh sách file/ thư mục con của thư mục root
        if(fileRoot.isDirectory()){
            File [] dsFile = fileRoot.listFiles();
            for(File f : dsFile){
                System.out.println(f.getName() + ": " + (f.isFile()?" File": " Dỉactory"));
            }
        }
    }
}
