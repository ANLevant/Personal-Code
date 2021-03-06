package toptal.common.rest.controller.facade;

import java.util.Date;
import java.util.List;

import javax.ws.rs.PathParam;

import toptal.common.business.dto.CustomerOrderDTO;
import toptal.common.util.DateFormat;

public interface CustomerOrderRestController {

	public List<CustomerOrderDTO> responseMsg( @PathParam("customerId") long customerId, @PathParam("startDate")  @DateFormat("MM-dd-yyyy")  Date startDate, @PathParam("endDate")  @DateFormat("MM-dd-yyyy")  Date endDate);
}
