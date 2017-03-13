package toptal.business.persistence.sql.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.springframework.data.mongodb.core.query.Query;

import toptal.business.persistence.facade.dao.CustomerOrderDAO;
import toptal.business.persistence.facade.entities.CustomerOrder;
import toptal.business.persistence.sql.entities.CustomerOrderSQL;

@LocalBean
@Stateless
public class CustomerOrderSQLDAO implements CustomerOrderDAO{

	@PersistenceContext(unitName = "BeitechPU")
	private EntityManager em;

	public CustomerOrderSQL placeCustomerOrder(CustomerOrderSQL customerOrder) {
		em.persist(customerOrder);
		em.flush();

		return customerOrder;
	}

	public List<CustomerOrder> searchOrdersByDateRangeAndCustomer(long customerId, Date startDate, Date endDate) {

		String querySt = "select c from CustomerOrder c where c.customer.customerId = :customerId AND c.placementDate BETWEEN :startDate AND :endDate";

		Query query = em.createQuery(querySt);
		query.setParameter("customerId", customerId);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);

		@SuppressWarnings("unchecked")
		List<CustomerOrderSQL> customerOrderList = query.getResultList();

		return customerOrderList;
	}
}
