package assignment.dao;

import java.util.List;
import assignment.obj.Customer;

public interface ICustomerDao {
	public void createCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer();
	public List<Customer> displayCustomerList();
}
