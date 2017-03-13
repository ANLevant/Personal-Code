package toptal.legacy.rest.controller.resteasy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import toptal.common.business.dto.CustomerOrderDTO;
import toptal.common.business.persistence.facade.entities.CustomerOrder;
import toptal.common.business.services.facade.ICustomerOrderService;
import toptal.common.rest.controller.facade.CustomerOrderRestController;

@Path("/CustomerOrder")
public class CustomerOrderRestEasyController implements CustomerOrderRestController {

	@Autowired
	private ICustomerOrderService customerOrderService;

	public CustomerOrderRestEasyController() throws NamingException 
	{
	}
	
	@GET
	@Path("/getOrder/{customerId}/{startDate}/{endDate}")
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public List<CustomerOrderDTO> responseMsg(long customerId, Date startDate, Date endDate) {

		List<CustomerOrder> customerOrders = customerOrderService.searchOrdersByDateRangeAndCustomer(customerId, startDate, endDate);
		List<CustomerOrderDTO> customerOrdersDTO = new ArrayList<CustomerOrderDTO>();
		
		for(CustomerOrder customerOrder : customerOrders){
			customerOrdersDTO.add(new CustomerOrderDTO(customerOrder));
		}

		return customerOrdersDTO;
	}
}
