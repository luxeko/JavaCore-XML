package Java2.src.Buoi8.Baitap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class ServerSide {

    public static void main(String[] args) throws IOException {
        final String url ="jdbc:sqlserver://127.0.0.1:1433;databaseName=khachhang";
        final String userDb = "DucAnh";
        final String passwordDb = "Khongnoiduoc1";
        System.out.println("Server start");
        //tao ra 1 doi tuong quan ly cac socket dai dien cho ung dung
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server connecting...");

        //khi co yeu cau tu client len, server chap nhan -> tao 1 socket phuc vu rieng socket client
        while(true){
            try{
                Connection con = DriverManager.getConnection(url, userDb, passwordDb);
                System.out.println("Connect successful");
    
                Statement khachHang = con.createStatement();
                Statement dichVu = con.createStatement();
                Statement dichVu_khachHang = con.createStatement();
                String sql_khachHang = "create table khachhang (idKhachHang varchar(6) primary key,tenKhachHang nvarchar(50), soDT numeric(12),email nvarchar(250))";
                String sql_dichVu = "create table dichvu (idService varchar(6) primary key,code nvarchar(50),price numeric,goiService varchar)";
                String sql_quanLyDichVu = "create table customer_service(id_customer_service varchar(6) primary key,idKhachHang varchar(6),idService varchar(6),start_Date date,end_Date date,status_service int,foreign key (idService) references dichvu(idService),foreign key (idKhachHang) references khachhang(idKhachHang),)";
                try {
                    //tao bang khach hang
                    khachHang.execute(sql_khachHang);
                    //tao bang dich vu
                    dichVu.execute(sql_dichVu);
                    //tao bang dich vu da dang ky
                    dichVu_khachHang.execute(sql_quanLyDichVu);
                } catch (Exception e) {
                    System.out.println("sql lỗi: " + e.getMessage());
                }
    
                String sql_insert_khachHang = "insert into khachhang (idKhachHang, tenKhachHang, soDT, email) values ('001', 'DucAnh', 0123456, 'a@gmail.com'), ('002', 'Minh', 0222222, 'b@gmail.com'), ('003', 'Hoang', 03123412, 'c@gmail.com')";
                String sql_insert_dichvu = "insert into dichvu (idService, code, price, goiService) values ('s001', 'day', 2000, 'goiNgay'), ('s002', 'month', 50000, 'goiThang'), ('s003', 'year', 500000, 'goiNam')";
                String sql_insert_quanLyDichVU = "insert into customer_service (id_customer_service, idKhachHang, idService, start_Date, end_Date, status_service) values ()";
                try {
                    khachHang.execute(sql_insert_khachHang);
                    dichVu.execute(sql_insert_dichvu);
                    dichVu_khachHang.execute(sql_insert_quanLyDichVU);
                } catch (Exception e) {
                    System.out.println("sql lỗi: " + e.getMessage());
                }
                
    
                khachHang.close();
                dichVu.close();
                dichVu_khachHang.close();
                con.close();
            }catch (Exception e){
                System.out.println("sql lỗi 123: " + e.getMessage());
            }
            
            Socket server = serverSocket.accept();
            System.out.println("Server connected");
            try (
                //stream read
                BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream(), "UTF-8"));

                //stream write
                PrintWriter pw = new PrintWriter(server.getOutputStream());
                Scanner sc = new Scanner(System.in)
            ){
                while(true){
                    // 1. server nhan du lieu tu client gui -> server : read/input
                    char[] chs = new char[1024];
                    int read = br.read(chs);
                    if(read > -1){
                        String receiver = new String(chs);
                        receiver = receiver.trim();
                        //check chuoi dang ky goi dich vu dung hay chua (receiver = Dk + sdt + madichvu)?
                        if(receiver.toLowerCase().startsWith("dk")){
                            //gan dung cu phap dang ky
                            //b1. split receiver theo khoang trang -> dk, sdt, madichvu
                            //b2. check sdt ton tai trong customer theo phoneNumber
                            /**
                             * -> khong ton tai -> thong bao so dien thoai khong dung
                             */
                            //b3. check madichvu trong bang service ton tai,
                            //-> ko ton tai dich vu -> thong bao ma dich vu khong dung
                            //neu dung: lay duoc thong tin customer, gia han goi tin -> gui yeu cau confirm
                            String message = "Ban chac chan muon mua goi cuoc hay khong? <Y> de dong y.";
                            pw.write(message);
                            pw.flush();
                        }else if(receiver.toLowerCase().equals("y")){
                            String message = "Bye. Ban da dang ky thanh cong goi cuoc nay. Xin cam on.";
                            pw.write(message);
                            pw.flush();
                            //dang ky thanh cong thi thoat qua trinh xu ly
                            break;
                        }
                        else{
                            String message = "Sai cu phap. Vui long nhap dung theo: Dk sdt madichvu";
                            pw.write(message);
                            pw.flush();

                        }
                        System.out.println("Receiver from Client: " + receiver);
                    }
                    // 2. server gui du lieu cho client -> server: write/output
                }  
            } catch (Exception e) {
            e.printStackTrace();
            }
            server.close();
            serverSocket.close();
            System.out.println("Server end!");
            
        }
        
    }
}
