package toptal.spring.business.persistence.nosql.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import toptal.common.business.persistence.facade.dao.ProductByUserDAO;
import toptal.common.business.persistence.facade.entities.ProductByUser;

public class ProductByUserNoSQLDAO extends MongoDaoFacade<ProductByUser> implements ProductByUserDAO{
	
	public ProductByUserNoSQLDAO(MongoTemplate mongo) {
		super(mongo);
	}

	public void registerCustomerProduct(ProductByUser productByUser){
		this.save(productByUser);
	}
	
	public List<ProductByUser> getProductsByCustomer(long customerId){
		return findManyByFieldName("customerId", customerId);
	}

	@Override
	protected String getCollectionName() {
		return null;
	}

	@Override
	protected Class<ProductByUser> getCollectionClass() {
		return null;
	}
}
