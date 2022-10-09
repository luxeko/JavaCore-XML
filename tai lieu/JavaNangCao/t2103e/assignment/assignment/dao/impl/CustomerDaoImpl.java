package assignment.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignment.dao.ICustomerDao;
import assignment.obj.Account;
import assignment.obj.Customer;
import assignment.util.ConnectionDb;

public class CustomerDaoImpl implements ICustomerDao {
	private Scanner sc = new Scanner(System.in);
	private SimpleDateFormat sdf_sql = new SimpleDateFormat("yyyy-MM-dd");
	// CREATE CUSTOMER FROM DATABASE
	@Override
	public void createCustomer(Customer customer) {
		customer.input();
		Connection con = ConnectionDb.getInstance().getConnection();
		if (con == null)
			System.out.println("Connection failed");
		String sql = "insert into Customer (customerId, customerName, citizenIdentifyNumber, phoneNumber, email, birthday, gender, address, customerType) values (?, ?, ?, ?, ?, convert(date, ?, 103), ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, customer.getCustomerId());
			ps.setString(2, customer.getCustomerName());
			ps.setString(3, customer.getCitizenIdentify());
			ps.setString(4, customer.getPhoneNumber());
			ps.setString(5, customer.getEmail());
			ps.setString(6, customer.getBirthDay2());
			ps.setInt(7, customer.getGender());
			ps.setString(8, customer.getAddress());
			ps.setInt(9, customer.getCustomerType());
			int result = ps.executeUpdate();
			ps.close();
			if (result == 0)
				System.out.println("Insert new customer failed");
			else
				System.out.println("Insert new customer successed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionDb.getInstance().closeConnection(con);
	}

	// UPDATE CUSTOMER FROM DATABASE
	@Override
	public void updateCustomer(Customer customer) {
		customer.inputUpdate();
		Connection con = ConnectionDb.getInstance().getConnection();
		if (con == null)
			System.out.println("Connection failed");
		String sql = "exec spCustomerUpdate ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
		try {
			Date date_sql = Date.valueOf(sdf_sql.format(customer.getBirthDay()));
			CallableStatement cs = con.prepareCall(sql);
			// BIND PARAM
			// PARAM IN:
			cs.setString(1, customer.getCustomerId());
			cs.setString(2, customer.getCustomerName());
			cs.setString(3, customer.getCitizenIdentify());
			cs.setString(4, customer.getPhoneNumber());
			cs.setString(5, customer.getEmail());
			cs.setDate(6, date_sql);
			cs.setInt(7, customer.getGender());
			cs.setString(8, customer.getAddress());
			cs.setInt(9, customer.getCustomerType());
			// PARAM OUT:
			cs.registerOutParameter(10, Types.INTEGER);
			cs.registerOutParameter(11, Types.NVARCHAR);
			cs.executeUpdate();
			int code_res = cs.getInt(10);
			String mess_res = cs.getString(11);
			cs.close();
			if (code_res == 1)
				System.out.println(mess_res);
			else
				System.out.println(mess_res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Update failed");
			e.printStackTrace();
		}
		ConnectionDb.getInstance().closeConnection(con);
	}

	// DELETE CUSTOMER FROM DATABASE
	/* int = 1: ton tai trong bang customer + co tai khoan => khong duoc xoa
	 * int = 0: ton tai trong bang customer + khong co tai khoan => duoc xoa
	 * int = -1: khong ton tai trong bang customer
	 * */
	@Override
	public void deleteCustomer() {
		String sCustomerIdDel;
		System.out.print("Enter customer ID to delete: ");
		sCustomerIdDel = sc.nextLine();
		int flag = checkAccountExitsByCustomerId(sCustomerIdDel);
		if (flag == -1)
			System.out.println("Customer ID doesn't exist");
		else if (flag == 1)
			System.out.println("Customers who already have account cannot be deleted");
		else {
			Connection con = ConnectionDb.getInstance().getConnection();
			if (con == null)
				System.out.println("Connection failed");
			String sql = "delete from Customer where customerId = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, sCustomerIdDel);
				int result = ps.executeUpdate();
				ps.close();
				if (result > 0)
					System.out.println("Delete successed");
				else
					System.out.println("Delete failed: Customer ID doesn't exist");
			} catch (SQLException e1) {
				System.out.println("Error");
			}
			ConnectionDb.getInstance().closeConnection(con);
		}
	}
	
	/* THUA
	// VALIDATE CUSTOMER ID ON CUSTOMER TABLE
	public boolean validateCustomerId(String customerId) {
		List<Customer> customerList = displayCustomerList();
		for (Customer customer : customerList) {
			if (customerId.equalsIgnoreCase(customer.getCustomerId()))
				return true;
		}
		return false;
	}
	*/
	
	// SELECT CUSTOMER TABLE ID BY CUSTOMER ID
	public int selectCustomerTableIdByCustomerId(String customerId) {
		Connection con = ConnectionDb.getInstance().getConnection();
		int iCustomerId;
		if (con == null)
			System.out.println("Connection failed");
		String sql = "select id from Customer where customerId = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, customerId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				iCustomerId = rs.getInt("id");
				return iCustomerId;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//CHECK 
	/* int = 1: ton tai trong bang customer + co tai khoan => khong duoc xoa
	 * int = 0: ton tai trong bang customer + khong co tai khoan => duoc xoa
	 * int = -1: khong ton tai trong bang customer
	 * */
	public int checkAccountExitsByCustomerId(String str) {
		int iCustomerTableId = 0;
		int count = 0;
		List<Customer> customerList = displayCustomerList();
		AccountDaoImpl accountDao = new AccountDaoImpl();
		List<Account> accountList = accountDao.displayAccountListFromDB();
		// check ton tai trong customer:
		boolean flag = false;
		for (Customer customer : customerList) {
			if (str.equalsIgnoreCase(customer.getCustomerId())) {
				iCustomerTableId = customer.getCustomerTableId();
				flag = true;
			}
		}
		if (flag == false)
			return -1;
		if (flag == true) {
			for (Account account : accountList) {
				if (iCustomerTableId == account.getCustomerTableId())
					count++;
			}
		}
		// TON TAI ID CUSTOMER + CHUA CO TK:
		if (count == 0)
			return 0;
		// TON TAI ID CUSTOMER + DA CO TK
		else
			return 1;
	}
	
	// DISPLAY CUSTOMER LIST FROM DB
	@Override
	public List<Customer> displayCustomerList() {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection con = ConnectionDb.getInstance().getConnection();
		if (con == null)
			System.out.println("Connection failed");
		String sql = "select id, customerId, customerName, citizenIdentifyNumber, phoneNumber, email, birthday, gender, address, customerType from Customer";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			boolean flag = false;
			while (rs.next()) {
				flag = true;
				Customer customer = new Customer();
				customer.setCustomerTableId(rs.getInt("id"));
				customer.setCustomerId(rs.getString("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setCitizenIdentify(rs.getString("citizenIdentifyNumber"));
				customer.setPhoneNumber(rs.getString("phoneNumber"));
				customer.setEmail(rs.getString("email"));
				customer.setBirthDay(rs.getDate("birthday"));
				customer.setGender(rs.getInt("gender"));
				customer.setAddress(rs.getString("address"));
				customer.setCustomerType(rs.getInt("customerType"));
				customerList.add(customer);
			}
			rs.close();
			ps.close();
			if (flag == false)
				System.out.println("Data not found");
			/* C2:
			while (rs.next()) {
				Customer customer = new Customer(
						rs.getInt("id"),
						rs.getString("customerId"),
						rs.getString("customerName"),
						rs.getString("citizenIdentifyNumber"),
						rs.getString("phoneNumber"),
						rs.getString("email"),
						rs.getDate("birthday"),
						rs.getInt("gender"),
						rs.getString("address"),
						rs.getInt("id"));
				customerList.add(customer);
			}
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionDb.getInstance().closeConnection(con);
		return customerList;
	}
	
}
