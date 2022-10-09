package assignment.obj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import assignment.dao.impl.CustomerDaoImpl;

public class Customer {
	private int customerTableId;
	private String customerId;
	private String customerName;
	private String citizenIdentify;
	private String phoneNumber;
	private String email;
	private Date birthDay;
	private int gender;
	private String address;
	private int customerType;
	private Scanner sc = new Scanner(System.in);
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public int getCustomerTableId() {
		return customerTableId;
	}

	public void setCustomerTableId(int customerTableId) {
		this.customerTableId = customerTableId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCitizenIdentify() {
		return citizenIdentify;
	}

	public void setCitizenIdentify(String citizenIdentify) {
		this.citizenIdentify = citizenIdentify;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public String getBirthDay2() {
		return sdf.format(birthDay);
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCustomerType() {
		return customerType;
	}

	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}

	public Customer() {
		super();
	}

	public Customer(int customerTableId, String customerId, String customerName, String citizenIdentify,
			String phoneNumber, String email, Date birthDay, int gender, String address, int customerType) {
		super();
		this.customerTableId = customerTableId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.citizenIdentify = citizenIdentify;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthDay = birthDay;
		this.gender = gender;
		this.address = address;
		this.customerType = customerType;
	}

	@Override
	public String toString() {
		String sGender;
		if (this.gender == 0)
			sGender = "Female";
		else if (this.gender == 1)
			sGender = "Male";
		else
			sGender = "Other";
		String sCustomerType;
		if (this.customerType == 0)
			sCustomerType = "Regular";
		else
			sCustomerType = "Vip";
		return "\t" + "ID: " + this.customerTableId + "    " + "\t" 
				+ "Customer ID: " + this.customerId + "  " + "\t"
				+ "Customer Name: " + this.customerName + " " + "\t"
				+ "Citizen Identification number: " + this.citizenIdentify + "  " + "\t"
				+ "Phone number: " + this.phoneNumber + "  " + "\t"
				+ "Email: " + this.email + "  " + "\t" + "\t"
				+ "Birthday: " + sdf.format(this.birthDay) + "  " + "\t" 
				+ "Gender: " + sGender + "  " + "\t"
				+ "Address: " + this.address + "  " + "\t"
				+ "Customer type: " + sCustomerType + "\n";
	}

	public void input() {
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		List<Customer> customerList = customerDao.displayCustomerList();
		int count;
		while (true) {
			count = 0;
			System.out.print("Input customer ID: ");
			this.customerId = sc.nextLine();
			if (this.customerId.length() >= 3) {
				for (Customer o : customerList) {
					if (this.customerId.equalsIgnoreCase(o.getCustomerId()))
						count++;
				}
				if (count > 0)
					System.out.println("Customer ID already used");
				else
					break;
			} else
				System.out.println("Customer ID cannot be blank and must be greater or equal 3 characters");
		}
		// NAME
		while (true) {
			System.out.print("Input customer name: ");
			this.customerName = sc.nextLine();
			if (this.customerName.length() >= 3)
				break;
			else
				System.out.println("Customer name cannot be blank and must be greater or equal 3 characters");
		}
		// CITIZEN IDENTIFICATION
		double iCitizenIdentify;
		while (true) {
			count = 0;
			System.out.print("Input citizen identification number: ");
			this.citizenIdentify = sc.nextLine();
			try {
				iCitizenIdentify = Double.parseDouble(this.citizenIdentify);
				if (iCitizenIdentify > 0) {
					for (Customer o : customerList) {
						if (this.citizenIdentify.equalsIgnoreCase(o.getCitizenIdentify())
								&& !this.customerId.equalsIgnoreCase(o.getCustomerId()))
							count++;
					}
					if (count > 0)
						System.out.println("Citizen Identitication number already used");
					else
						break;
				} else
					System.out.println("Citizen identification number must be a number!");
			} catch (Exception e) {
				System.out.println("Citizen identification number must be a number!");
			}
		}
		// PHONE NUMBER
		int iPhoneNumber;
		while (true) {
			count = 0;
			System.out.print("Input phone number: ");
			this.phoneNumber = sc.nextLine();
			if (this.phoneNumber.startsWith("0") && this.phoneNumber.length() == 10) {
				try {
					iPhoneNumber = Integer.parseInt(this.phoneNumber);
					if (iPhoneNumber > 0) {
						for (Customer o : customerList) {
							if (this.phoneNumber.equalsIgnoreCase(o.getPhoneNumber())
									&& !this.customerId.equalsIgnoreCase(o.getCustomerId()))
								count++;
						}
						if (count > 0)
							System.out.println("Phone number already used");
						else
							break;
					} else
						System.out.println("Phone number must be 10 digit number and start with '0'");
				} catch (Exception e) {
					System.out.println("Phone number must be 10 digit number and start with '0'");
				}
			} else
				System.out.println("Phone number must be 10 digit number and start with '0'");
		}
		// EMAIL
		while (true) {
			count = 0;
			System.out.print("Input email: ");
			this.email = sc.nextLine();
			if (this.email.contains("@")) {
				for (Customer o : customerList) {
					if (this.email.equalsIgnoreCase(o.getEmail())
							&& !this.customerId.equalsIgnoreCase(o.getCustomerId()))
						count++;
				}
				if (count > 0)
					System.out.println("Email already used");
				else
					break;
			} else
				System.out.println("Email format must be: example@domain.com");
		}
		// BIRTHDAY
		String sBirthDay;
		while (true) {
			System.out.print("Input birthday: ");
			sBirthDay = sc.nextLine();
			try {
				this.birthDay = sdf.parse(sBirthDay);
				break;
			} catch (ParseException e) {
				System.out.println("Birthday must be 'dd/MM/yyyy'");
			}
		}
		// GENDER
		String sGender;
		while (true) {
			System.out.print("Input gender (0: Female /1: Male /2: Other): ");
			sGender = sc.nextLine();
			try {
				this.gender = Integer.parseInt(sGender);
				if (this.gender == 0 || this.gender == 1 || this.gender == 2)
					break;
				else
					System.out.println("Input 0: Female /1: Male /2: Other");
			} catch (Exception e) {
				System.out.println("Input 0: Female /1: Male /2: Other");
			}
		}
		// ADDRESS
		while (true) {
			System.out.print("Input address: ");
			this.address = sc.nextLine();
			if (this.address.length() >= 3)
				break;
			else
				System.out.println("Customer name cannot be blank and must be greater or equal 3 characters");
		}
		// CUSTOMER TYPE
		String sCustomerType;
		while (true) {
			System.out.print("Input customer type (0: Regular /1: Vip): ");
			sCustomerType = sc.nextLine();
			try {
				this.customerType = Integer.parseInt(sCustomerType);
				if (this.customerType == 0 || this.customerType == 1)
					break;
				else
					System.out.println("Input 0: Regular customer /1: Vip customer");
			} catch (Exception e) {
				System.out.println("Input 0: Regular customer /1: Vip customer");
			}
		}
	}

	public void inputUpdate() {
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		List<Customer> customerList = customerDao.displayCustomerList();
		String sCustomerId;
		int count = 0;
		System.out.print("Enter customer ID to update: ");
		sCustomerId = sc.nextLine();
		for (Customer o : customerList) {
			if (sCustomerId.equalsIgnoreCase(o.getCustomerId())) {
				System.out.println(o.toString());
				this.customerId = sCustomerId;
				count++;
			}
		}	
		if (count > 0) {
			// NAME
			while (true) {
				System.out.print("Input new customer name: ");
				this.customerName = sc.nextLine();
				if (this.customerName.length() >= 3)
					break;
				else
					System.out.println("Customer name cannot be blank and must be greater or equal 3 characters");
			}
			// CITIZEN IDENTIFICATION
			Double iCitizenIdentify;
			while (true) {
				count = 0;
				System.out.print("Input new citizen identification number: ");
				this.citizenIdentify = sc.nextLine();
				try {
					iCitizenIdentify = Double.parseDouble(this.citizenIdentify);
					if (iCitizenIdentify > 0) {
						for (Customer o : customerList) {
							if (this.citizenIdentify.equalsIgnoreCase(o.getCitizenIdentify())
									&& !this.customerId.equalsIgnoreCase(o.getCustomerId()))
								count++;
						}
						if (count > 0)
							System.out.println("Citizen Identitication number already used");
						else
							break;
					} else
						System.out.println("Citizen identification number must be a number!");
				} catch (Exception e) {
					System.out.println("Citizen identification number must be a number!");
				}
			}
			// PHONE NUMBER
			int iPhoneNumber;
			while (true) {
				count = 0;
				System.out.print("Input new phone number: ");
				this.phoneNumber = sc.nextLine();
				if (this.phoneNumber.startsWith("0") && this.phoneNumber.length() == 10) {
					try {
						iPhoneNumber = Integer.parseInt(this.phoneNumber);
						if (iPhoneNumber > 0) {
							for (Customer o : customerList) {
								if (this.phoneNumber.equalsIgnoreCase(o.getPhoneNumber())
										&& !this.customerId.equalsIgnoreCase(o.getCustomerId()))
									count++;
							}
							if (count > 0)
								System.out.println("Phone number already used");
							else
								break;
						} else
							System.out.println("Phone number must be 10 digit number and start with '0'");
					} catch (Exception e) {
						System.out.println("Phone number must be 10 digit number and start with '0'");
					}
				} else
					System.out.println("Phone number must be 10 digit number and start with '0'");
			}
			// EMAIL
			while (true) {
				count = 0;
				System.out.print("Input new email: ");
				this.email = sc.nextLine();
				if (this.email.contains("@")) {
					for (Customer o : customerList) {
						if (this.email.equalsIgnoreCase(o.getEmail())
								&& !this.customerId.equalsIgnoreCase(o.getCustomerId()))
							count++;
					}
					if (count > 0)
						System.out.println("Email already used");
					else
						break;
				} else
					System.out.println("Email format must be: example@domain.com");
			}
			// BIRTHDAY
			String sBirthDay;
			while (true) {
				System.out.print("Input new birthday: ");
				sBirthDay = sc.nextLine();
				try {
					this.birthDay = sdf.parse(sBirthDay);
					break;
				} catch (ParseException e) {
					System.out.println("Birthday must be 'dd/MM/yyyy'");
				}
			}
			// GENDER
			String sGender;
			while (true) {
				System.out.print("Input new gender (0: Female /1: Male /2: Other): ");
				sGender = sc.nextLine();
				try {
					this.gender = Integer.parseInt(sGender);
					if (this.gender == 0 || this.gender == 1 || this.gender == 2)
						break;
					else
						System.out.println("Input 0: Female /1: Male /2: Other");
				} catch (Exception e) {
					System.out.println("Input 0: Female /1: Male /2: Other");
				}
			}
			// ADDRESS
			while (true) {
				System.out.print("Input new address: ");
				this.address = sc.nextLine();
				if (this.address.length() >= 3)
					break;
				else
					System.out.println("Customer name cannot be blank and must be greater or equal 3 characters");
			}
			// CUSTOMER TYPE
			String sCustomerType;
			while (true) {
				System.out.print("Input new customer type (0: Regular /1: Vip): ");
				sCustomerType = sc.nextLine();
				try {
					this.customerType = Integer.parseInt(sCustomerType);
					if (this.customerType == 0 || this.customerType == 1)
						break;
					else
						System.out.println("Input 0: Regular customer /1: Vip customer");
				} catch (Exception e) {
					System.out.println("Input 0: Regular customer /1: Vip customer");
				}
			}
		} else
			System.out.println("Customer ID not found");
	}
}
