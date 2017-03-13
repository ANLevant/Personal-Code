package toptal.spring.business.services.spring.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toptal.common.business.dto.CustomerDTO;
import toptal.common.business.persistence.facade.dao.CustomerDAO;
import toptal.common.business.persistence.facade.entities.Customer;
import toptal.legacy.business.services.ejb.admin.facade.CustomerLocalService;

@Service("customerService")
public class CustomerSpringService implements CustomerLocalService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customerList = customerDAO.getAllCustomer();
		
		List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
		
		for(Customer customer: customerList){
			customerDTOList.add(new CustomerDTO(customer));
		}
		
		return customerDTOList;
	}

}
