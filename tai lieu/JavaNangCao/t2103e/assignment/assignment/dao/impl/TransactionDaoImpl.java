package assignment.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignment.obj.Transaction;
import assignment.util.ConnectionDb;

public class TransactionDaoImpl {
	private SimpleDateFormat sdf_sql = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Scanner sc = new Scanner(System.in);
	public void recordToLog(String accountId, int amount, int transactionType) {
		java.util.Date date_java = new java.util.Date();
		Connection con = ConnectionDb.getInstance().getConnection();
		if (con == null)
			System.out.println("Connection failed");
		String sql = "insert into Transactions (accountId, transactionType, amount, dateCreate, transactionPlace) values (?, ?, ?, convert(date, ?, 103), ?)";
		try {
			Date transactionDateSql = Date.valueOf(sdf_sql.format(date_java)); 
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, accountId);
			ps.setInt(2, transactionType);
			ps.setInt(3, amount);
			ps.setDate(4, transactionDateSql);
			ps.setString(5, "X Bank - branch Ha Noi");
			int result = ps.executeUpdate();
			if (result == 0)
				System.out.println("Record to log failed");
			else
				System.out.println("Record to log successed");
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionDb.getInstance().closeConnection(con);
	}
	
	public void displayTransactionLogByAccountId() {
		List<Transaction> transactionList = new ArrayList<Transaction>(); 
		AccountDaoImpl accountDao = new AccountDaoImpl();
		String accountId;
		String dateStart;
		String dateEnd;
		System.out.print("Enter account ID: ");
		accountId = sc.nextLine();
		if (accountDao.validateAccountId(accountId) == true) {
			while (true) {
				System.out.print("Enter date start: ");
				dateStart = sc.nextLine();
				try {
					sdf.parse(dateStart);
					if (dateStart != null)
						break;
				} catch (Exception e) {
					System.out.println("Date format must be 'dd/MM/yyyy'");
				}
			}
			while (true) {
				System.out.print("Enter date end: ");
				dateEnd = sc.nextLine();
				try {
					sdf.parse(dateEnd);
					if (dateEnd != null)
						break;
				} catch (Exception e) {
					System.out.println("Date format must be 'dd/MM/yyyy'");
				}
			}
			Connection con = ConnectionDb.getInstance().getConnection();
			if (con == null)
				System.out.println("Connection failed");
			String sql = "select * from Transactions where dateCreate between convert(date, ?, 103) and convert(date, ?, 103) and accountId = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dateStart);
				ps.setString(2, dateEnd);
				ps.setString(3, accountId);
				ResultSet rs = ps.executeQuery();
				boolean flag = false;
				while (rs.next()) {
					flag = true;
					Transaction transaction = new Transaction(
							rs.getInt("id"),
							rs.getString("accountId"),
							rs.getInt("transactionType"),
							rs.getInt("amount"),
							rs.getDate("dateCreate"),
							rs.getString("transactionPlace"));
					transactionList.add(transaction);
				}
				for (Transaction o : transactionList) {
					System.out.println(o.toString());
				}
				if (flag == false)
					System.out.println("Data not found");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ConnectionDb.getInstance().closeConnection(con);
		} else
			System.out.println("Account ID doesn't exist");
	}
	/* check tk ton tai
	 * lay gia tri account ID theo 
	 * */

}
