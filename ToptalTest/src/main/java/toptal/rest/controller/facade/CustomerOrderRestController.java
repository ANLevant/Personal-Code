package toptal.rest.controller.facade;

import java.util.Date;
import java.util.List;

import javax.ws.rs.PathParam;

import toptal.business.dto.CustomerOrderDTO;
import toptal.util.DateFormat;

public interface CustomerOrderRestController {

	public List<CustomerOrderDTO> responseMsg( @PathParam("customerId") long customerId, @PathParam("startDate")  @DateFormat("MM-dd-yyyy")  Date startDate, @PathParam("endDate")  @DateFormat("MM-dd-yyyy")  Date endDate);
}
