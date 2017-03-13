package toptal.business.persistence.facade.dao;

import java.util.List;

import toptal.business.persistence.facade.entities.Product;

public interface ProductDAO {
	
	public void addProduct(Product product);
	
	public Product getProductById(long productId);	

	public List<Product> getAllProducts();
}
