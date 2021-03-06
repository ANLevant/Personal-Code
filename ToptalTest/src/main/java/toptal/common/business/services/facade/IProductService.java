package toptal.common.business.services.facade;

import java.util.List;

import toptal.common.business.dto.ProductDTO;

public interface IProductService {
	
	public List<ProductDTO> getCustomerProducts(long customerId);
	
	public List<ProductDTO> getAllProducts();
	
	public ProductDTO getProductById(long productId);

}
