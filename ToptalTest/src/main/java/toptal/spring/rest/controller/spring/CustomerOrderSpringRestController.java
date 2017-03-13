package toptal.spring.rest.controller.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import toptal.common.business.dto.CustomerOrderDTO;
import toptal.common.business.persistence.facade.entities.CustomerOrder;
import toptal.common.business.services.facade.ICustomerOrderService;
import toptal.common.rest.controller.facade.CustomerOrderRestController;

@RestController
@RequestMapping("/customerOrder")
public class CustomerOrderSpringRestController implements CustomerOrderRestController {

	@Autowired
	private ICustomerOrderService customerOrderService;	
	
	@RequestMapping(path="/{customerOrder}/getWithDateRange")
	public List<CustomerOrderDTO> responseMsg(@PathVariable("customerId") long customerId, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {

		List<CustomerOrder> customerOrders = customerOrderService.searchOrdersByDateRangeAndCustomer(customerId, startDate, endDate);
		List<CustomerOrderDTO> customerOrdersDTO = new ArrayList<CustomerOrderDTO>();
		
		for(CustomerOrder customerOrder : customerOrders){
			customerOrdersDTO.add(new CustomerOrderDTO(customerOrder));
		}

		return customerOrdersDTO;
	}
}
