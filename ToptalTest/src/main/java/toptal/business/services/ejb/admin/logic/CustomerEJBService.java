package toptal.business.services.ejb.admin.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import toptal.business.dto.CustomerDTO;
import toptal.business.persistence.nosql.dao.CustomerNoSQLDAO;
import toptal.business.persistence.sql.entities.CustomerSQL;
import toptal.business.services.ejb.admin.facade.CustomerLocalService;

@Stateless
public class CustomerEJBService implements CustomerLocalService {

	@EJB
	private CustomerNoSQLDAO customerDAO;
	
	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<CustomerSQL> customerList = customerDAO.getAllCustomer();
		
		List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
		
		for(CustomerSQL customer: customerList){
			customerDTOList.add(new CustomerDTO(customer));
		}
		
		return customerDTOList;
	}

}
