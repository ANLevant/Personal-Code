package toptal.rest.controller.resteasy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import toptal.business.dto.CustomerOrderDTO;
import toptal.business.persistence.facade.entities.CustomerOrder;
import toptal.business.persistence.nosql.dao.CustomerOrderNoSQLDAO;
import toptal.business.services.facade.ICustomerService;
import toptal.rest.controller.facade.CustomerOrderRestController;

@Path("/CustomerOrder")
public class CustomerOrderRestEasyController implements CustomerOrderRestController {

	@Autowired
	private ICustomerService customerService;

	public CustomerOrderRestEasyController() throws NamingException 
	{
	}
	
	@GET
	@Path("/getOrder/{customerId}/{startDate}/{endDate}")
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public List<CustomerOrderDTO> responseMsg(long customerId, Date startDate, Date endDate) {

		List<CustomerOrder> customerOrders = customerService.searchOrdersByDateRangeAndCustomer(customerId, startDate, endDate);
		List<CustomerOrderDTO> customerOrdersDTO = new ArrayList<CustomerOrderDTO>();
		
		for(CustomerOrder customerOrder : customerOrders){
			customerOrdersDTO.add(new CustomerOrderDTO(customerOrder));
		}

		return customerOrdersDTO;
	}
}
