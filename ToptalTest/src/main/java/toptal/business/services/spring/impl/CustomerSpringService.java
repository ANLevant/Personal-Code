package toptal.business.services.spring.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toptal.business.dto.CustomerDTO;
import toptal.business.persistence.facade.dao.CustomerDAO;
import toptal.business.persistence.facade.entities.Customer;
import toptal.business.services.ejb.admin.facade.CustomerLocalService;

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
