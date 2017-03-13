package toptal.business.persistence.sql.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import toptal.business.persistence.facade.dao.CustomerDAO;
import toptal.business.persistence.sql.entities.CustomerSQL;

@LocalBean
@Stateless
public class CustomerSQLDAO implements CustomerDAO{
	
	@PersistenceContext(unitName="BeitechPU")
	private EntityManager em;
	
	public void registerCustomer(CustomerSQL customer){
		em.persist(customer);
		em.flush();
	}
	
	public List<CustomerSQL> getAllCustomer(){

		String querySt = "select c from Customer c";
		
		Query query = em.createQuery(querySt);
		
		@SuppressWarnings("unchecked")
		List<CustomerSQL> customerList = query.getResultList();
		
		return customerList;
	}
	
	public CustomerSQL getCustomerById(long customerId){

		String querySt = "select c from Customer c where c.customerId =:customerId";
		
		Query query = em.createQuery(querySt);
		
		query.setParameter("customerId", customerId);
		
		CustomerSQL customer = (CustomerSQL)query.getSingleResult();
		
		return customer;
	}

}
