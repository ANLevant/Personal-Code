package toptal.business.services.facade;

import java.util.Date;
import java.util.List;

import toptal.business.dto.CustomerOrderDTO;
import toptal.business.persistence.facade.entities.CustomerOrder;

public interface ICustomerOrderService {

	public CustomerOrderDTO placeCustomerOrder(CustomerOrderDTO customerOrderDTO);

	public List<CustomerOrder> searchOrdersByDateRangeAndCustomer(long customerId, Date startDate, Date endDate);
	
}
