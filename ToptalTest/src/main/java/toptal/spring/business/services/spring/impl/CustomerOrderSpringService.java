package toptal.spring.business.services.spring.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toptal.common.business.dto.CustomerOrderDTO;
import toptal.common.business.persistence.facade.dao.CustomerDAO;
import toptal.common.business.persistence.facade.dao.CustomerOrderDAO;
import toptal.common.business.persistence.facade.entities.Customer;
import toptal.common.business.persistence.facade.entities.CustomerOrder;
import toptal.legacy.business.persistence.sql.entities.CustomerOrderSQL;
import toptal.legacy.business.services.ejb.admin.facade.CustomerOrderLocalService;

@Service("customerOrderService")
public class CustomerOrderSpringService implements CustomerOrderLocalService {

	@Autowired
	private CustomerOrderDAO customerOrderDAO;
	
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	public CustomerOrderSpringService(){
	}
	
	@Override	
	public CustomerOrderDTO placeCustomerOrder(CustomerOrderDTO customerOrderDTO) {
		
		CustomerOrder customerOrder = new CustomerOrderSQL();
		
		Customer customer = customerDAO.getCustomerById(customerOrderDTO.getCustomerId());
		
		customerOrder.setDeliveryAddress(customerOrderDTO.getDeliveryAddress());
		customerOrder.setCustomer(customer);
		customerOrder.setPlacementDate(new Date());
		customerOrder.setPrice(customerOrderDTO.getPrice());
		customerOrder.setUsdChangeRate(customerOrderDTO.getUsdChangeRate());
		
		return new CustomerOrderDTO(customerOrderDAO.placeCustomerOrder(customerOrder));
		
	}
	
	@Override
	public List<CustomerOrder> searchOrdersByDateRangeAndCustomer(long customerId, Date startDate, Date endDate) {
		return customerOrderDAO.searchOrdersByDateRangeAndCustomer(customerId, startDate, endDate);
	}

}
