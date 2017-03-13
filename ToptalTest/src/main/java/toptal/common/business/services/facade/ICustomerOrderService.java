package toptal.common.business.services.facade;

import java.util.Date;
import java.util.List;

import toptal.common.business.dto.CustomerOrderDTO;
import toptal.common.business.persistence.facade.entities.CustomerOrder;

public interface ICustomerOrderService {

	public CustomerOrderDTO placeCustomerOrder(CustomerOrderDTO customerOrderDTO);

	public List<CustomerOrder> searchOrdersByDateRangeAndCustomer(long customerId, Date startDate, Date endDate);
	
}
