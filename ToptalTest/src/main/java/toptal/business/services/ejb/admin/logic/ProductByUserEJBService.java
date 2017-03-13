package toptal.business.services.ejb.admin.logic;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import toptal.business.dto.ProductByUserDTO;
import toptal.business.persistence.nosql.dao.ProductByUserNoSQLDAO;
import toptal.business.persistence.pk.ProductByUserPK;
import toptal.business.persistence.sql.entities.ProductByUserSQL;
import toptal.business.services.ejb.admin.facade.ProductByUserLocalService;

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
