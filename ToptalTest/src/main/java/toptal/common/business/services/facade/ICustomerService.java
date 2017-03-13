package toptal.common.business.services.facade;

import java.util.List;

import toptal.common.business.dto.CustomerDTO;

public interface ICustomerService {
	
	public List<CustomerDTO> getAllCustomers();

}
