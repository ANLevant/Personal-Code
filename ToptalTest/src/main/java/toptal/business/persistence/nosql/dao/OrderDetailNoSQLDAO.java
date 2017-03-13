package toptal.business.persistence.nosql.dao;

import org.springframework.data.mongodb.core.MongoTemplate;

import toptal.business.persistence.facade.dao.OrderDetailDAO;
import toptal.business.persistence.facade.entities.OrderDetail;

public class OrderDetailNoSQLDAO extends MongoDaoFacade<OrderDetail> implements OrderDetailDAO{
	
	public OrderDetailNoSQLDAO(MongoTemplate mongo) {
		super(mongo);
	}

	public void addOrderDetail(OrderDetail orderDetail){
		this.save(orderDetail);
	}

	@Override
	protected String getCollectionName() {
		return "OrderDetail";
	}

	@Override
	protected Class<OrderDetail> getCollectionClass() {
		return OrderDetail.class;
	}

}
