package toptal.business.persistence.facade.dao;

import java.util.List;

import toptal.business.persistence.facade.entities.Customer;

public interface CustomerDAO{
		
	public void registerCustomer(Customer customer);
	
	public List<Customer> getAllCustomer();
	
	public Customer getCustomerById(long customerId);

}
