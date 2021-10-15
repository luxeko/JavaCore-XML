package Java2.src.Buoi6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) {
		// b1: thiet lap ket noi
		// url cho sqlserver
		final String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=t2103e";
		final String userDb = "DucAnh";
		final String passworDb = "Khongnoiduoc1";
		try {
			Connection con = DriverManager.getConnection(url, userDb, passworDb);
			System.out.println("Connect successful");
			// b2: thuc thi sql thong qua connect
			// DML: insert, update, delete -> tac dong vao dataa
			// DQL: select, where, order, group by, having, join, inner join, 
			// -> lay data ra ( table, du lieu don)
			// DCL: create, alter
			// - tao bang: book (code nvarchar(5) primary key, name nvarchar(100), price number);
			// -> create table book (code nvarchar(5) primary key, name nvarchar(100), price number);
			Statement st = con.createStatement();
			String sql_create = "create table book (code nvarchar(5) primary key, name nvarchar(100), price numeric)";
			try {
				st.execute(sql_create);
				System.out.println("Create table successfully");
			}catch(Exception e) {
				System.out.println("sql loi: "+ e.getMessage());
			}
			// yc nhap tu ban phim
			String code1 = "001";
			String name1 = "drop database aaaa";
			long price1 = 10000;
			try {
				// - insert book
				// -> insert into book(code, name, price) values ('001', 'Cuon theo chieu gio', 10000);
				String sql_insert = "insert into book(code, name, price)"
						+" values ('"+code1+"', '"+name1+"', "+price1+")";
				// sql injection
				System.out.println("Insert table: "+ st.executeUpdate(sql_insert));
			} catch (Exception e) {
				System.out.println("sql loi: "+ e.getMessage());
			}
			// - select code, name, price from book where 1 = 1
			String sql_select = " select code, name, price from book where 1 = 1";
			ResultSet rs = st.executeQuery(sql_select);
			// duyet resultset -> duyet theo hang:
			while (rs.next()) {
				// lay cot
				// c1: thong qua index cua cot (1 -> n)
				String code = rs.getString(1);
				// c2: thong qua ten cot
				String name = rs.getString("name");
				double price= rs.getDouble(3);
				System.out.println("Code: "+ code + "; name= "+ name + "; price="+ price);
			}
			rs.close();
			st.close();
			
			// b4
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
