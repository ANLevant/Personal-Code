package toptal.common.business.persistence.facade.dao;

import java.util.Date;
import java.util.List;

import toptal.common.business.persistence.facade.entities.CustomerOrder;

public interface CustomerOrderDAO {

	public CustomerOrder placeCustomerOrder(CustomerOrder customerOrder);
	
	public List<CustomerOrder> searchOrdersByDateRangeAndCustomer(long customerId, Date startDate, Date endDate);
}
