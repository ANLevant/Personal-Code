package toptal.legacy.business.services.ejb.admin.logic;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import toptal.common.business.dto.CustomerOrderDTO;
import toptal.common.business.persistence.facade.entities.Customer;
import toptal.common.business.persistence.facade.entities.CustomerOrder;
import toptal.legacy.business.persistence.sql.entities.CustomerOrderSQL;
import toptal.legacy.business.services.ejb.admin.facade.CustomerOrderLocalService;
import toptal.spring.business.persistence.nosql.dao.CustomerNoSQLDAO;
import toptal.spring.business.persistence.nosql.dao.CustomerOrderNoSQLDAO;

@Stateless
public class CustomerOrderEJBService implements CustomerOrderLocalService {

	@EJB
	private CustomerOrderNoSQLDAO customerOrderDAO;
	
	@EJB
	private CustomerNoSQLDAO customerDAO;
	
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
		// TODO Auto-generated method stub
		return null;
	}

}
