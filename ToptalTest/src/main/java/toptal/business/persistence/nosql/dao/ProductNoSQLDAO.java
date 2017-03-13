package toptal.business.persistence.nosql.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import toptal.business.persistence.facade.dao.ProductDAO;
import toptal.business.persistence.facade.entities.Product;

public class ProductNoSQLDAO extends MongoDaoFacade<Product> implements ProductDAO{
		
	public ProductNoSQLDAO(MongoTemplate mongo) {
		super(mongo);
	}
	

	@Override
	public void addProduct(Product product) {
		this.save(product);
	}

	public Product getProductById(long productId){
		
		return this.findById(productId);
	}
	
	public List<Product> getAllProducts(){

		return this.findAll();
	}

	@Override
	protected String getCollectionName() {
		return "Propuct";
	}

	@Override
	protected Class<Product> getCollectionClass() {
		return Product.class;
	}
}
