package toptal.common.business.persistence.facade.dao;

import java.util.List;

import toptal.common.business.persistence.facade.entities.ProductByUser;

public interface ProductByUserDAO{
	
	public void registerCustomerProduct(ProductByUser productByUser);
	
	public List<ProductByUser> getProductsByCustomer(long customerId);
}
