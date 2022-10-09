package assignment.obj;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
	private int transactionId;
	private String accountId;
	private int transactionType;
	private int amount;
	private Date transactionDate;
	private String transactionPlace;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionPlace() {
		return transactionPlace;
	}

	public void setTransactionPlace(String transactionPlace) {
		this.transactionPlace = transactionPlace;
	}

	public Transaction() {
		super();
	}

	public Transaction(int transactionId, String accountId, int transactionType, int amount, Date transactionDate,
			String transactionPlace) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.transactionPlace = transactionPlace;
	}

	@Override
	public String toString() {
		String sTransactionType;
		if (this.transactionType == 0)
			sTransactionType = "payin";
		else
			sTransactionType = "withdraw";
		return "\t" + "Transaction ID: " + this.transactionId + "   " + "\t"
				+ "Account ID: " + this.accountId + "   " + "\t"
				+ "Transaction Type: " + sTransactionType + "   " + "\t"
				+ "Amount: " + this.amount + "   " + "\t"
				+ "Date create: " + sdf.format(this.transactionDate) + "   " + "\t"
				+ "Place: " + this.transactionPlace;
	}
	
	
	
}
