package toptal.spring.business.persistence.nosql.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import toptal.common.business.persistence.facade.dao.CustomerOrderDAO;
import toptal.common.business.persistence.facade.entities.CustomerOrder;

@Component
public class CustomerOrderNoSQLDAO extends MongoDaoFacade<CustomerOrder> implements CustomerOrderDAO{

	public CustomerOrderNoSQLDAO(MongoTemplate mongo) {
		super(mongo);
	}

	public CustomerOrder placeCustomerOrder(CustomerOrder customerOrder) {
		this.save(customerOrder);
		return customerOrder;
	}

	public List<CustomerOrder> searchOrdersByDateRangeAndCustomer(long customerId, Date startDate, Date endDate) {

		List<String> fieldNames = new ArrayList<>();
		List<Object> values = new ArrayList<>();
		
		fieldNames.add("customerId");
		fieldNames.add("startDate");
		fieldNames.add("endDate");
		
		values.add(customerId);
		values.add(startDate);
		values.add(endDate);
		
		return this.findManyByMultipleFieldName(values, fieldNames);
	}

	@Override
	protected String getCollectionName() {
		return "CustomerOrder";
	}

	@Override
	protected Class<CustomerOrder> getCollectionClass() {
		return CustomerOrder.class;
	}
}
