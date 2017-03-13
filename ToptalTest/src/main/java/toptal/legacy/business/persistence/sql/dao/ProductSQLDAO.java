package toptal.legacy.business.persistence.sql.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import toptal.legacy.business.persistence.sql.entities.ProductSQL;

@Local
@Stateless
public class ProductSQLDAO {
	
	@PersistenceContext(unitName="BeitechPU")
	private EntityManager em;
	
	public void addProduct(ProductSQL product){
		em.persist(product);
		em.flush();
	}
	
	public ProductSQL getProductById(long productId){

		String querySt = "select p from Product p where p.productId = :productId";
		
		Query query = em.createQuery(querySt);
		query.setParameter("productId", productId);
		
		ProductSQL product = (ProductSQL) query.getSingleResult();
		
		return product;
	}
	
	public List<ProductSQL> getAllProducts(){

		String querySt = "select p from Product p";
		
		Query query = em.createQuery(querySt);
		
		@SuppressWarnings("unchecked")
		List<ProductSQL> productList = query.getResultList();
		
		return productList;
	}
}
