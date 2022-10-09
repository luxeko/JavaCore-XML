package assignment.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignment.obj.Account;
import assignment.obj.Customer;
import assignment.util.ConnectionDb;

public class AccountDaoImpl {
	private Scanner sc = new Scanner(System.in);
	// CREATE ACCOUNT
	public void createAccount(Account account) {
		account.input();
		Connection con = ConnectionDb.getInstance().getConnection();
		if (con == null)
			System.out.println("Connection failed");
		String sql = "insert into Account (customerTableId, accountId, accountType, accountStatus, dateCreate, amount, lineOfCredit) values (?, ?, ?, ?, convert(date, ?, 103), ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, account.getCustomerTableId());
			ps.setString(2, account.getAccountId());
			ps.setInt(3, account.getAccountType());
			ps.setInt(4, account.getAccountStatus());
			ps.setString(5, account.getDateCreate2());
			ps.setInt(6, account.getAmount());
			ps.setDouble(7, account.getLineOfCredit());
			int result = ps.executeUpdate();
			if (result == 0)
				System.out.println("Create account failed");
			else
				System.out.println("Create successed");
		} catch (Exception e) {
			System.out.println("Create account failed");
		}
		ConnectionDb.getInstance().closeConnection(con);
	}

	// QUERY ACCOUNT
	public List<Account> displayAccountListFromDB() {
		List<Account> accountList = new ArrayList<Account>();
		Connection con = ConnectionDb.getInstance().getConnection();
		if (con == null)
			System.out.println("Connection failed");
		String sql = "select id, customerTableId, accountId, accountType, accountStatus, dateCreate, amount, lineOfCredit from Account";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			boolean flag = false;
			while (rs.next()) {
				flag = true;
				Account account = new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getDate(6), rs.getInt(7), rs.getInt(8));
				accountList.add(account);
			}
			if (flag == false)
				System.out.println("No data found");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountList;
	}

	// QUERY ACCOUNT BY ACCOUNT ID
	public List<Account> displayAccByAccId() {
		List<Account> accountList = new ArrayList<Account>();
		String accountId;
		System.out.print("Enter account ID to display: ");
		accountId = sc.nextLine();
		if (validateAccountId(accountId) == true) {
			Connection con = ConnectionDb.getInstance().getConnection();
			if (con == null)
				System.out.println("Connection failed");
			String sql = "select id, customerTableId, accountId, accountType, accountStatus, dateCreate, amount, lineOfCredit from Account where accountId = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, accountId);
				ResultSet rs = ps.executeQuery();
				boolean flag = false;
				while (rs.next()) {
					flag = true;
					Account account = new Account(
							rs.getInt(1), 
							rs.getInt(2), 
							rs.getString(3), 
							rs.getInt(4),
							rs.getInt(5), 
							rs.getDate(6), 
							rs.getInt(7), 
							rs.getInt(8));
					accountList.add(account);
				}
				if (flag == false)
					System.out.println("No data found");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Account ID doesn't exist");
		}
		return accountList;
	}
	
	// QUERY ACCOUNT BY CUSTOMER ID
		public List<Account> displayAccountByCustomerId() {
			List<Account> accountList = new ArrayList<Account>();
			CustomerDaoImpl customerDao = new CustomerDaoImpl();
			System.out.print("Enter customer ID to display: ");
			String customerId = sc.nextLine();
			int customerTableId = customerDao.selectCustomerTableIdByCustomerId(customerId);
			if (customerTableId != 0) {
				Connection con = ConnectionDb.getInstance().getConnection();
				if (con == null)
					System.out.println("Connection failed");
				String sql = "select id, customerTableId, accountId, accountType, accountStatus, dateCreate, amount, lineOfCredit from Account where customerTableId = ?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, customerTableId);
					ResultSet rs = ps.executeQuery();
					boolean flag = false;
					while (rs.next()) {
						flag = true;
						Account account = new Account(
								rs.getInt(1), 
								rs.getInt(2), 
								rs.getString(3), 
								rs.getInt(4),
								rs.getInt(5), 
								rs.getDate(6), 
								rs.getInt(7), 
								rs.getInt(8));
						accountList.add(account);
					}
					if (flag == false)
						System.out.println("No data found");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else
				System.out.println("Customer ID doesn't exist");
			return accountList;
		}

	// Account ton tai: true
	// Account khong ton tai: false
	public boolean validateAccountId(String accountId) {
		List<Account> accountList = displayAccountListFromDB();
		for (Account account : accountList) {
			if (accountId.equals(account.getAccountId()))
				return true;
		}
		return false;
	}

	/*
	 * CHECK ACCOUNT TYPE 0: debit 1: credit
	 */
	public int validateAccountType(String accountId) {
		List<Account> accountList = new ArrayList<Account>();
		Connection con = ConnectionDb.getInstance().getConnection();
		if (con == null)
			System.out.println("Connection failed");
		String sql = "select accountId, accountType, dateCreate from Account where accountId = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, accountId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account account = new Account(rs.getString("accountId"), rs.getInt("accountType"),
						rs.getDate("dateCreate"));
				accountList.add(account);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionDb.getInstance().closeConnection(con);
		for (Account acc : accountList) {
			if (acc.getAccountType() == 0)
				return 0;
		}
		return 1;
	}

	// PAYIN ACCOUNT
	public void payinAccount() {
		int payin;
		String sPayin;
		String accountId;
		int transactionType = 0; // set nap tien = 0
		TransactionDaoImpl transactionDao = new TransactionDaoImpl();
		System.out.print("Enter account ID to payin: ");
		accountId = sc.nextLine();
		int amount = queryAmountByAccountId(accountId);
		if (validateAccountId(accountId) == true) {
			System.out.println("Available amount: " + amount);
			if (validateAccountType(accountId) == 0) {
				System.out.print("Enter amount to payin: ");
				sPayin = sc.nextLine();
				try {
					payin = Integer.parseInt(sPayin);
					if (payin > 0) {
						amount += payin;
						// UPDATE NEU THOA MAN DIEU KIEN
						UpdateAmountByAccountId(accountId, amount);
						transactionDao.recordToLog(accountId, amount, transactionType);
					} else
						System.out.println("Amount payin must be greater than 0");
				} catch (Exception e) {
					System.out.println("Amount payin must be number");
				}
			} else
				System.out.println("Visa account cannot payin");
		} else
			System.out.println("Account ID doesn't exist");
	}

	// WITHDRAW ACCOUNT
	public void withDrawAccount() {
		int withDraw;
		String sWithDraw;
		String accountId;
		int transactionType = 1; // set rut tien = 1
		TransactionDaoImpl transactionDao = new TransactionDaoImpl();
		System.out.print("Enter account ID to payin: ");
		accountId = sc.nextLine();
		int amount = queryAmountByAccountId(accountId);
		if (validateAccountId(accountId) == true) {
			System.out.println("Available amount: " + amount);
			if (validateAccountType(accountId) == 0) {
				System.out.print("Enter amount to withdraw: ");
				sWithDraw = sc.nextLine();
				try {
					withDraw = Integer.parseInt(sWithDraw);
					if (withDraw > 0) {
						if (amount >= withDraw) {
							amount -= withDraw;
							// UPDATE NEU THOA MAN DIEU KIEN
							UpdateAmountByAccountId(accountId, amount);
							transactionDao.recordToLog(accountId, amount, transactionType);
						} else
							System.out.println("The amount in your account is not enough to withdraw");
					} else
						System.out.println("Amount to withdraw must be greater than 0");
				} catch (Exception e) {
					System.out.println("Amount to withdraw must be number");
				}
			} else {
				System.out.print("Enter amount to pay: ");
				sWithDraw = sc.nextLine();
				try {
					withDraw = Integer.parseInt(sWithDraw);
					if (withDraw > 0) {
						if (amount >= withDraw) {
							amount -= withDraw;
							// UPDATE NEU THOA MAN DIEU KIEN
							UpdateAmountByAccountId(accountId, amount);
							transactionDao.recordToLog(accountId, amount, transactionType);
						} else
							System.out.println("The amount in your account is not enough to pay");
					} else
						System.out.println("Amount to pay must be greater than 0");
				} catch (Exception e) {
					System.out.println("Amount to pay must be number");
				}
			}
		} else
			System.out.println("Account ID doesn't exist");
	}

	// SUBTABLE FROM DB RETURN ACCOUNT ID, ACCOUNT TYPE, DATECREAT, AMOUNT,
	// LINEOFCREDIT
	// LAY SO TIEN TRONG DB
	public int queryAmountByAccountId(String accountId) {
		Account account = new Account();
		Connection con = ConnectionDb.getInstance().getConnection();
		if (con == null)
			System.out.println("Connection failed");
		String sql = "select accountId, accountType, dateCreate, amount, lineOfCredit from Account where accountId = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, accountId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				account = new Account(rs.getString("accountId"), rs.getInt("accountType"), rs.getDate("dateCreate"),
						rs.getInt("amount"), rs.getInt("lineOfCredit"));
			}
		} catch (SQLException e) {
			System.out.println("Error: method queryAmountByAccountId");
		}
		ConnectionDb.getInstance().closeConnection(con);
		return account.getAmount();
	}

	// UPDATE AMOUNT BY ACCOUNT ID
	public void UpdateAmountByAccountId(String accountId, Integer amount) {
		Connection con = ConnectionDb.getInstance().getConnection();
		if (con == null)
			System.out.println("Connection failed");
		String sql = "exec spUpdateAmountByAccId ?, ?, ?, ?";
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, accountId);
			cs.setInt(2, amount);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.NVARCHAR);
			cs.executeUpdate();
			int code_res = cs.getInt(3);
			String mess_res = cs.getString(4);
			cs.close();
			if (code_res == 0)
				System.out.println(mess_res);
			else
				System.out.println(mess_res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionDb.getInstance().closeConnection(con);
		System.out.println("Amount after payin: " + amount);
	}
	
	// GET ACCOUNT ID BY CUSTOMER ID
	public void getAccountIdByCustomerId(String CustomerId) {
		List<Account> accountIdList = new ArrayList<Account>();
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		String accountId;
		int customerTableId = customerDao.selectCustomerTableIdByCustomerId(CustomerId);
		if (customerTableId != 0) {
			Connection con = ConnectionDb.getInstance().getConnection();
			if (con == null)
				System.out.println("Connection failed");
			String sql = "select accountId from Account where customerTableId = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, customerTableId);
				ResultSet rs = ps.executeQuery();
				boolean flag = false;
				while (rs.next()) {
					flag = true;
					Account account = new Account (rs.getString("accountId"));
					accountIdList.add(account);
				}
				for (Account o : accountIdList)
				if (flag == false)
					System.out.println("No data found");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			System.out.println("Customer ID doesn't exist");
		return accountList;
	}

}
