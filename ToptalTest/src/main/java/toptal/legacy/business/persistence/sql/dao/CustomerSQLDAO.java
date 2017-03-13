package toptal.legacy.business.persistence.sql.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import toptal.common.business.persistence.facade.dao.CustomerDAO;
import toptal.common.business.persistence.facade.entities.Customer;
import toptal.legacy.business.persistence.sql.entities.CustomerSQL;

@Local
@Stateless
public class CustomerSQLDAO implements CustomerDAO{
	
	@PersistenceContext(unitName="BeitechPU")
	private EntityManager em;
	
	public void registerCustomer(CustomerSQL customer){
		em.persist(customer);
		em.flush();
	}
	
	@Override
	public List<Customer> getAllCustomer(){

		String querySt = "select c from Customer c";
		
		Query query = em.createQuery(querySt);
		
		@SuppressWarnings("unchecked")
		List<Customer> customerList = query.getResultList();
		
		return customerList;
	}
	
	@Override
	public CustomerSQL getCustomerById(long customerId){

		String querySt = "select c from Customer c where c.customerId =:customerId";
		
		Query query = em.createQuery(querySt);
		
		query.setParameter("customerId", customerId);
		
		CustomerSQL customer = (CustomerSQL)query.getSingleResult();
		
		return customer;
	}

	@Override
	public void registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}
