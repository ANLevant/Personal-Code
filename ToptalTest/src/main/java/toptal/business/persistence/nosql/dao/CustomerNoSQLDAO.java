package toptal.business.persistence.nosql.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import toptal.business.persistence.facade.dao.CustomerDAO;
import toptal.business.persistence.facade.entities.Customer;

@Component
public class CustomerNoSQLDAO extends MongoDaoFacade<Customer> implements CustomerDAO{

	public CustomerNoSQLDAO(MongoTemplate mongo) {
		super(mongo);
	}

	public void registerCustomer(Customer customer){
		this.save(customer);
	}
	
	public List<Customer> getAllCustomer(){
		return this.findAll();
	}
	
	public Customer getCustomerById(long customerId){

		return this.findById(customerId);
	}

	@Override
	protected String getCollectionName() {
		return "Customers";
	}

	@Override
	protected Class<Customer> getCollectionClass() {
		return Customer.class;
	}

}
