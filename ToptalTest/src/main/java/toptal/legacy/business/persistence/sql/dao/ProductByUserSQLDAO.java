package toptal.legacy.business.persistence.sql.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import toptal.legacy.business.persistence.sql.entities.ProductByUserSQL;

@Local
@Stateless
public class ProductByUserSQLDAO{
	
	@PersistenceContext(unitName="BeitechPU")
	private EntityManager em;
	
	public void registerCustomerProduct(ProductByUserSQL productByUser){
		em.persist(productByUser);
		em.flush();
	}
	
	public List<ProductByUserSQL> getProductsByCustomer(long customerId){

		String querySt = "select p from ProductByUser p where p.productByUserPK.customerId = :customerId";
		
		Query query = em.createQuery(querySt);
		query.setParameter("customerId", customerId);
		
		@SuppressWarnings("unchecked")
		List<ProductByUserSQL> productByUser = query.getResultList();
		
		return productByUser;
	}
}
