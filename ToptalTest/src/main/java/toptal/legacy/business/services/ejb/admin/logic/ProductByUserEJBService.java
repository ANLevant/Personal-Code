package toptal.legacy.business.services.ejb.admin.logic;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import toptal.common.business.dto.ProductByUserDTO;
import toptal.common.business.persistence.pk.ProductByUserPK;
import toptal.legacy.business.persistence.sql.entities.ProductByUserSQL;
import toptal.legacy.business.services.ejb.admin.facade.ProductByUserLocalService;
import toptal.spring.business.persistence.nosql.dao.ProductByUserNoSQLDAO;

@Stateless
public class ProductByUserEJBService implements ProductByUserLocalService {

	@EJB
	private ProductByUserNoSQLDAO productByUserDAO;
	
	@Override
	public void addProductByCustomer(ProductByUserDTO productByUserDTO) {
		
		ProductByUserSQL productByUser = new ProductByUserSQL();
		productByUser.setProductByUserPK(new ProductByUserPK(productByUserDTO.getCustomerId(), productByUserDTO.getProductId()));

		productByUserDAO.registerCustomerProduct(productByUser);
	}

}
