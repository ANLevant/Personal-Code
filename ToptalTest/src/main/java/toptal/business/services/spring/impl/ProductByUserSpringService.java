package toptal.business.services.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toptal.business.dto.ProductByUserDTO;
import toptal.business.persistence.nosql.dao.ProductByUserNoSQLDAO;
import toptal.business.persistence.pk.ProductByUserPK;
import toptal.business.persistence.sql.entities.ProductByUserSQL;
import toptal.business.services.ejb.admin.facade.ProductByUserLocalService;

@Service("productByUserService")
public class ProductByUserSpringService implements ProductByUserLocalService {

	@Autowired
	private ProductByUserNoSQLDAO productByUserDAO;
	
	@Override
	public void addProductByCustomer(ProductByUserDTO productByUserDTO) {
		
		ProductByUserSQL productByUser = new ProductByUserSQL();
		productByUser.setProductByUserPK(new ProductByUserPK(productByUserDTO.getCustomerId(), productByUserDTO.getProductId()));

		productByUserDAO.registerCustomerProduct(productByUser);
	}

}
