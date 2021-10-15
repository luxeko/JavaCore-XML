package Java2.src.Buoi6.BTVN.BaiTapJDBC1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JdbcSinhVien {
    public static void main(String[] args) {
        final String url ="jdbc:sqlserver://127.0.0.1:1433;databaseName=t2103e";
        final String userDb = "DucAnh";
        final String passwordDb = "Khongnoiduoc1";
        try{
            Connection con = DriverManager.getConnection(url, userDb, passwordDb);
            System.out.println("Connect successful");

            Statement Khoa = con.createStatement();
            Statement DMSV = con.createStatement();
            String sql_Khoa = "create table Khoa (maKhoa varchar(6) primary key,tenKhoa nvarchar(50))";
            String sql_DMSV = "create table DMSV (MaSV varchar(3) not null primary key,	HoSV nvarchar(15) not null,TenSV nvarchar(15) not null,Phai nchar(7),NgaySinh datetime not null,NoiSinh nvarchar(20),MaKhoa varchar(6),HocBong float,foreign key (MaKhoa) references Khoa)";
            try {
                Khoa.execute(sql_Khoa);
                System.out.println("Create table Khoa succesfully");
            } catch (Exception e) {
                System.out.println("sql lỗi: " + e.getMessage());
            }
            try {
                DMSV.execute(sql_DMSV);
                System.out.println("Create table DMSV succesfully");
            } catch (Exception e) {
                System.out.println("sql lỗi: " + e.getMessage());
            }

            String sql_insert_khoa = "insert into Khoa(maKhoa, tenKhoa) values ('001', 'CNTT'), ('002', 'QTKD'), ('003', 'Marketing')";
            String sql_insert_dmsv = "insert into DMSV(MaSV, HoSV, TenSV, Phai, NgaySinh, NoiSinh, MaKhoa, HocBong) values ('001', 'LeKha', 'DucAnh', 'Nam', '1999-02-28 12:00:00', 'ThanhHoa', '001', '9.9'), ('002', 'Hoang', 'PhuongLinh', 'Nu', '1999-02-28 12:00:00', 'ThanhHoa', '003', '8.8'), ('003', 'Nguyen', 'MaiTrang', 'Nu', '1999-02-28 12:00:00', 'HaNoi', '002', '9.8')";

            try {
                Khoa.execute(sql_insert_khoa);
                System.out.println("Insert table Khoa succesfully " );
            } catch (Exception e) {
                System.out.println("sql lỗi: " + e.getMessage());
            }
            try {
                DMSV.execute(sql_insert_dmsv);
                System.out.println("Insert table DMSV succesfully " );
            } catch (Exception e) {
                System.out.println("sql lỗi: " + e.getMessage());
            }

            String sql_select_khoa = "select * from Khoa where 1 = 1";
            ResultSet rs_Khoa = Khoa.executeQuery(sql_select_khoa);
            while(rs_Khoa.next()){
                String maKhoa = rs_Khoa.getString(1);
                String tenKhoa = rs_Khoa.getString(2);
                System.out.println("maKhoa: " + maKhoa + " tenKhoa: " + tenKhoa);
            }
            String sql_select_dmsv = "select * from DMSV where 1 = 1";
            ResultSet rs_DMSV = DMSV.executeQuery(sql_select_dmsv);
            while(rs_DMSV.next()){
                String MaSV = rs_DMSV.getString(1);
                String HoSV = rs_DMSV.getString(2);
                String TenSV = rs_DMSV.getString(3);
                String Phai = rs_DMSV.getString(4);
                String NgaySinh = rs_DMSV.getString(5);
                String NoiSinh = rs_DMSV.getString(6);
                String MaKhoa = rs_DMSV.getString("maKhoa");
                String HocBong = rs_DMSV.getString(8);
                
               
                System.out.println("MaSV: " + MaSV + " HoSV: " + HoSV + " TenSV: " + TenSV + " Phai: " + Phai + " NgaySinh: " + NgaySinh + " NoiSinh: " + NoiSinh + " MaKhoa: " + MaKhoa + " HocBong: " + HocBong);
            }
            Khoa.close();
            DMSV.close();
            rs_Khoa.close();
            rs_DMSV.close();
            con.close();
        }catch (Exception e){
            System.out.println("sql lỗi 123: " + e.getMessage());
        }

    }
}
