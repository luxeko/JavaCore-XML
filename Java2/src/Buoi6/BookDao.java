package Java2.src.Buoi6;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	// them 1 quyen sach
	public void createBook(Book book) throws CustomException {
		// b1: tao ket noi
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CustomException("Inconnect successfully!");
		}
		// b2: thuc thi lenh
		String sql = "insert into book (code, name, price) values (?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// bind tham so truyen vao lenh sql
			ps.setString(1, book.getCode());
			ps.setString(2, book.getName());
			ps.setDouble(3, book.getPrice());
			int result = ps.executeUpdate();
			ps.close();
			// b3: xu ly ket qua
			// khong them moi 1 ban ghi vao bang
			if (result == 0) {
				throw new CustomException("No data execute");
			}
		} catch (SQLException e) {
			throw new CustomException("Insert Error: "+ e.getMessage());
		}
		// b4: dong ket noi
		ConnectionDB.closeConnection(con);
	}
	// cap nhat 1 quyen sach 
	public void updateBook(Book book) throws CustomException, SQLException {
		// b1: tao connection
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CustomException("Inconnect successfully!");
		}
		// b2: thuc thi lenh
		String sql = "exec updateBook ?, ?, ?, ?, ?";
		CallableStatement cs = con.prepareCall(sql);
		// bind param
		// tham so in:
		cs.setString(1, book.getCode());
		cs.setString(2, book.getName());
		cs.setDouble(3, book.getPrice());
		// tham so out
		cs.registerOutParameter(4, Types.INTEGER);
		cs.registerOutParameter(5, Types.NVARCHAR);
		
		cs.executeUpdate();
		
		// b3: xu ly ket qua
		int response_code = cs.getInt(4);
		String response_message = cs.getString(5);
		cs.close();
		if (response_code != 1) {
			throw new CustomException(response_message);
		}
		// b4 dong connection
		ConnectionDB.closeConnection(con);
	}
	// xoa 1 quyen sach
	
	// lay ra danh sach quyen sach
	public List<Book> getList(){
		List<Book> result = new ArrayList<Book>();
		// b1: tao ket noi
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			return result;
		}
		// b2: thuc thi lenh
		String sql = "select code, name, price from book";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// b3: xu ly ket qua
			while (rs.next()) {
				Book book = new Book();
				book.setCode(rs.getString("code"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				result.add(book);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		// b4: dong ket noi
		ConnectionDB.closeConnection(con);
		return result;
	}
	// them 1 list quyen sach
	// sql theo batch ( insert, update, delete)
	public void createListBook(List<Book> listBook) throws CustomException, SQLException {
		// b1: tao ket noi
		Connection con = ConnectionDB.getConnection();
		if (con == null) {
			throw new CustomException("Inconnect successfully!");
		}
		// set trang thai giao dich -> commit false
		con.setAutoCommit(false);
		// b2: thuc thi lenh
		String sql = "insert into book (code, name, price) values (?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// bind tham so truyen vao lenh sql
			for (Book book : listBook) {
				// lenh sql
				ps.setString(1, book.getCode());
				ps.setString(2, book.getName());
				ps.setDouble(3, book.getPrice());
				ps.addBatch();
			}
			// int[] result = ps.executeBatch();
			ps.close();
			// b3: xu ly ket qua
			
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			throw new CustomException("Insert Error: "+ e.getMessage());
			
		}
		// b4: dong ket noi
		ConnectionDB.closeConnection(con);
	}
}
