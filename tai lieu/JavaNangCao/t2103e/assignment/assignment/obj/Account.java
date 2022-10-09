package assignment.obj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

import assignment.dao.impl.AccountDaoImpl;
import assignment.dao.impl.CustomerDaoImpl;

public class Account {
	private int accountTableId;
	private int customerTableId;
	private String accountId;
	private int accountType;
	private int accountStatus;
	private Date dateCreate;
	private int amount;
	private int lineOfCredit;
	private Scanner sc = new Scanner(System.in);
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public int getAccountTableId() {
		return accountTableId;
	}

	public void setAccountTableId(int accountTableId) {
		this.accountTableId = accountTableId;
	}

	public int getCustomerTableId() {
		return customerTableId;
	}

	public void setCustomerTableId(int customerTableId) {
		this.customerTableId = customerTableId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public int getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public String getDateCreate2() {
		return sdf.format(dateCreate);
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getLineOfCredit() {
		return lineOfCredit;
	}

	public void setLineOfCredit(int lineOfCredit) {
		this.lineOfCredit = lineOfCredit;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	
	public Account() {
		super();
	}

	public Account(String accountId, int accountType, Date dateCreate) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.dateCreate = dateCreate;
	}

	public Account(String accountId) {
		super();
		this.accountId = accountId;
	}

	public Account(String accountId, int accountType, Date dateCreate, int amount,
			int lineOfCredit) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.dateCreate = dateCreate;
		this.amount = amount;
		this.lineOfCredit = lineOfCredit;
	}

	public Account(int accountTableId, int customerTableId, String accountId, int accountType, int accountStatus,
			Date dateCreate, int amount, int lineOfCredit) {
		super();
		this.accountTableId = accountTableId;
		this.customerTableId = customerTableId;
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.dateCreate = dateCreate;
		this.amount = amount;
		this.lineOfCredit = lineOfCredit;
	}

	public void input() {
		/*
		 * nhap makh, neu trung thi cho tao moi tai khoan sai nhap lai hoac neu chua co
		 * thi tao kh moi
		 * 
		 * 
		 * 
		 */
		String sCustomerAcc;
		String confirm;
		boolean flag1 = false;
		Customer customer = new Customer();
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		AccountDaoImpl accountDao = new AccountDaoImpl();
		List<Customer> customerList = customerDao.displayCustomerList();
		List<Account> accountList = accountDao.displayAccountListFromDB();

		/*
		 * TIM KIEM CUSTOMER ID TRONG DB CUSTOMER NEU TIM THAY GAN BIEN CUSTOMER TABLE
		 * ID BANG GIA TRI TIM DUOC LAY GIA TRI DO TIM KIEM TRONG BANG ACCOUT NEU TIM
		 * THAY => DA CO TAI KHOAN NEU KHONG TIM THAY => KHONG CO TAI KHOAN => TAO TAI
		 * KHOAN
		 */
		// TIM KIEM CUSTOMER ID TRONG DB CUSTOMER
		while (true) {
			System.out.print("Enter customer ID: ");
			sCustomerAcc = sc.nextLine();
			for (Customer o1 : customerList) {
				// CHECK CUSTOMER ID DA TON TAI CHUA
				if (sCustomerAcc.equals(o1.getCustomerId())) {
					// GAN BIEN CUSTOMER TABLE ID BANG GIA TRI TIM DUOC
					this.customerTableId = o1.getCustomerTableId();
					flag1 = true;
				}
			}
			// 
			if (flag1 == false) {
				System.out.println("Customer doens't exist!");
			}
			if (flag1 == true) {
				// CO TON TAI TAI KHOAN HAY KHONG
				int check = 0;
				for (Account o2 : accountList) {
					if (this.customerTableId == o2.getCustomerTableId())
						check++;
				}
				// CHUA CO TK
				if (check == 0) {
					inputGeneral();
					// TAO TK MAC DINH LA DEBIT
					this.accountType = 0;
				} else if (check == 1) {
					confirm = "";
					System.out.println("You already have debit account");
					System.out.println("Create new credit account: ");
					inputGeneral();
					// TK VISA GAN = 1
					this.accountType = 1;
					if (customer.getCustomerType() == 0) {
						this.lineOfCredit = 10000000;
						this.amount = 10000000;
					}
					else {
						this.lineOfCredit = 30000000;
						this.amount = 30000000;
					}
						
				} else {
					System.out.println("You already have 2 account, cannot create more!");
				}
				break;
			}
			
			/*
			if (flag1 == false) {
				confirm = "";
				System.out.print("Customer doens't exist, create new customer? (Y: create / other: Input other customer ID)");
				confirm = sc.nextLine();
				if ("y".equalsIgnoreCase(confirm)) {
					customerDao.createCustomer(customer);
					break;
				}
			}
			*/
		}
	}

	public void inputGeneral() {
		// ACCOUNT ID
		while (true) {
			AccountDaoImpl accountDao = new AccountDaoImpl();
			System.out.print("Input account ID: ");
			this.accountId = sc.nextLine();
			if (accountDao.validateAccountId(this.accountId) == false) {
				if (this.accountId.length() == 6)
					break;
				else
					System.out.println("Account ID must be 6 digits number");	
			} else
				System.out.println("Account ID already use");
		}
		String sAccountStatus;
		System.out.println("Account status is disable, active account? (press 'y' to active, press other to ignore)");
		sAccountStatus = sc.nextLine();
		if (sAccountStatus.equalsIgnoreCase("y"))
			this.accountStatus = 1;
		else
			this.accountStatus = 0;
		while (true) {
			String sDateCreate;
			System.out.print("Input date create (dd/MM/yyyy): ");
			sDateCreate = sc.nextLine();
			try {
				this.dateCreate = sdf.parse(sDateCreate);
				if (this.dateCreate != null)
					break;
				else
					System.out.println("Date format must be 'dd/MM/yyyy'");
			} catch (ParseException e) {
				System.out.println("Date format must be 'dd/MM/yyyy'");
			}
		}
		this.amount = 0;
	}

	@Override
	public String toString() {
		String sStringType;
		String sStringStatus;
		if (this.accountType == 0)
			sStringType = "Debit";
		else
			sStringType = "Credit";
		if (this.accountStatus == 0)
			sStringStatus = "Disable";
		else
			sStringStatus = "Active";
		return "\t" + "ID: " + this.accountTableId + "\t" 
				+ "Customer table ID: " + this.customerTableId + "\t" 
				+ "Account ID: " + this.accountId + "\t" 
				+ "Type: " + sStringType + "\t" 
				+ "Status: " + sStringStatus + "\t"
				+ "Date create: " + sdf.format(dateCreate) + "\t" 
				+ "Amount: " + this.amount + "   " + "\t"
				+ "Line of credit: " + this.lineOfCredit + "\n";
	}
}
