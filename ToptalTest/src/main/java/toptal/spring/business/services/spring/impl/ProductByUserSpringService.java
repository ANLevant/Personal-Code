package toptal.spring.business.services.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toptal.common.business.dto.ProductByUserDTO;
import toptal.common.business.persistence.pk.ProductByUserPK;
import toptal.legacy.business.persistence.sql.entities.ProductByUserSQL;
import toptal.legacy.business.services.ejb.admin.facade.ProductByUserLocalService;
import toptal.spring.business.persistence.nosql.dao.ProductByUserNoSQLDAO;

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
