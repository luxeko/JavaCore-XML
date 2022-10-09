package assignment;

import java.util.Scanner;

import assignment.dao.impl.AccountDaoImpl;
import assignment.dao.impl.CustomerDaoImpl;
import assignment.dao.impl.TransactionDaoImpl;
import assignment.obj.Account;
import assignment.obj.Customer;

public class BankManagementMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// FIELD HERE
		Customer customer = new Customer();
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		Account account = new Account();
		AccountDaoImpl accountDao = new AccountDaoImpl();
		TransactionDaoImpl transactionDao = new TransactionDaoImpl();
		while (true) {
			String choose1 = "";
			String choose2 = "";
			System.out.println("=====BANK MANAGEMENT=====");
			System.out.println("1. CRUD CUSTOMER");
			System.out.println("2. CRUD ACCOUNT");
			System.out.println("3. CRUD REPORT");
			System.out.println("0. EXIT");
			System.out.print("ENTER YOUR CHOICE: ");
			choose1 = sc.nextLine();
			switch (choose1) {
			case "1":
				while (true) {
					System.out.println("1. CREATE NEW CUSTOMER TO DATABASE");
					System.out.println("2. UPDATE CUSTOMER BY CUSTOMER ID");
					System.out.println("3. DELETE CUSTOMER BY CUSTOMER ID");
					System.out.println("4. DISPLAY CUSTOMER DATABASE");
					System.out.println("0. BACK TO MAIN MENU");
					System.out.print("ENTER YOUR CHOICE: ");
					choose2 = sc.nextLine();
					switch (choose2) {
					case "1":
						customerDao.createCustomer(customer);
						break;
					case "2":
						customerDao.updateCustomer(customer);
						break;
					case "3":
						customerDao.deleteCustomer();
						break;
					case "4":
						System.out.println(customerDao.displayCustomerList());
						break;
					case "0":
						break;
					default:
						System.out.println("YOUR CHOICE DOESN'T EXIST!");
					}
					if (choose2.equalsIgnoreCase("0"))
					break;
				}
				break;
			case "2":
				while (true) {
					System.out.println("1. CREATE NEW ACCOUNT BY CUSTOMER ID");
					System.out.println("2. PAYIN TO ACCOUNT");
					System.out.println("3. WITHDRAR FROM ACCOUNT");
					System.out.println("4. DISPLAY ACCOUNT INFORMATION BY ACCOUNT ID");
					System.out.println("5. DISPLAY ACCOUNT INFORMATION BY CUSTOMER ID");
					System.out.println("0. BACK TO MAIN MENU");
					System.out.print("ENTER YOUR CHOICE: ");
					choose2 = sc.nextLine();
					switch (choose2) {
					case "1":
						accountDao.createAccount(account);
						break;
					case "2":
						accountDao.payinAccount();
						break;
					case "3":
						accountDao.withDrawAccount();
						break;
					case "4":
						System.out.println(accountDao.displayAccByAccId());
						break;
					case "5":
						System.out.println(accountDao.displayAccountByCustomerId());
						break;
					case "0":
						break;
					default:
						System.out.println("YOUR CHOICE DOESN'T EXIST!");
					}
					if (choose2.equalsIgnoreCase("0"))
					break;
				}
				break;
			case "3":
				while (true) {
					System.out.println("1. DISPLAY TRANSACTION LOG BY ACCOUNT ID");
					System.out.println("2. DISPLAY TRANSACTION LOG BY CUSTOMER ID");
					System.out.println("3. EXPORT TRANSACTION LOG BY MONTH");
					System.out.println("0. BACK TO MAIN MENU");
					System.out.print("ENTER YOUR CHOICE: ");
					choose2 = sc.nextLine();
					switch (choose2) {
					case "1":
						transactionDao.displayTransactionLogByAccountId();
						break;
					case "2":
						// code here
						break;
					case "3":

						break;
					case "0":
						break;
					default:
						System.out.println("YOUR CHOICE DOESN'T EXIST!");
					}
					if (choose2.equalsIgnoreCase("0"))
					break;
				}
				break;
			case "0":
				System.out.println("END PROGRAM!");
				System.exit(0);
			default:
				System.out.println("YOUR CHOICE DOESN'T EXIST!");
			}	
		}
	}
}
