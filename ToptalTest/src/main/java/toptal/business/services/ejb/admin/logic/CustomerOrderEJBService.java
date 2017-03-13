package toptal.business.services.ejb.admin.logic;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import toptal.business.dto.CustomerOrderDTO;
import toptal.business.persistence.sql.entities.CustomerSQL;
import toptal.business.persistence.nosql.dao.CustomerNoSQLDAO;
import toptal.business.persistence.nosql.dao.CustomerOrderNoSQLDAO;
import toptal.business.persistence.sql.entities.CustomerOrderSQL;
import toptal.business.services.ejb.admin.facade.CustomerOrderLocalService;

@Stateless
public class CustomerOrderEJBService implements CustomerOrderLocalService {

	@EJB
	private CustomerOrderNoSQLDAO customerOrderDAO;
	
	@EJB
	private CustomerNoSQLDAO customerDAO;
	
	@Override
	
	public CustomerOrderDTO placeCustomerOrder(CustomerOrderDTO customerOrderDTO) {
		
		CustomerOrderSQL customerOrder = new CustomerOrderSQL();
		
		CustomerSQL customer = customerDAO.getCustomerById(customerOrderDTO.getCustomerId());
		
		customerOrder.setDeliveryAddress(customerOrderDTO.getDeliveryAddress());
		customerOrder.setCustomer(customer);
		customerOrder.setPlacementDate(new Date());
		customerOrder.setPrice(customerOrderDTO.getPrice());
		customerOrder.setUsdChangeRate(customerOrderDTO.getUsdChangeRate());
		
		return new CustomerOrderDTO(customerOrderDAO.placeCustomerOrder(customerOrder));
		
	}

}
