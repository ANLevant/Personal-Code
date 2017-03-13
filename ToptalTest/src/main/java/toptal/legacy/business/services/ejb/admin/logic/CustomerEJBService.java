package toptal.legacy.business.services.ejb.admin.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;

import toptal.common.business.dto.CustomerDTO;
import toptal.common.business.persistence.facade.entities.Customer;
import toptal.legacy.business.services.ejb.admin.facade.CustomerLocalService;
import toptal.spring.business.persistence.nosql.dao.CustomerNoSQLDAO;

@Stateless
public class CustomerEJBService implements CustomerLocalService {

	@EJB
	private CustomerNoSQLDAO customerDAO;
	
	@Autowired
	public CustomerEJBService(){
	}
	
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
