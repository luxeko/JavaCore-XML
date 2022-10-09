package assignment.dao;

public interface IAccountDao {
	public void createAccount();
	public void payinAccount();
	public void withdrawAccount();
	public void updateAmount();
	public void recordToLog();
	public void displayAccountInfoByAccountId();
	public void displayAccountInfoByCustomerId(); // show visa and default account
}
