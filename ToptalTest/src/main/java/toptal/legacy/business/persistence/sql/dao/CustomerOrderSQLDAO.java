package toptal.legacy.business.persistence.sql.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import toptal.common.business.persistence.facade.dao.CustomerOrderDAO;
import toptal.common.business.persistence.facade.entities.CustomerOrder;
import toptal.legacy.business.persistence.sql.entities.CustomerOrderSQL;

@Local
@Stateless
public class CustomerOrderSQLDAO implements CustomerOrderDAO{

	@PersistenceContext(unitName = "BeitechPU")
	private EntityManager em;

	public CustomerOrderSQL placeCustomerOrder(CustomerOrderSQL customerOrder) {
		em.persist(customerOrder);
		em.flush();

		return customerOrder;
	}

	@Override
	public List<CustomerOrder> searchOrdersByDateRangeAndCustomer(long customerId, Date startDate, Date endDate) {

		String querySt = "select c from CustomerOrder c where c.customer.customerId = :customerId AND c.placementDate BETWEEN :startDate AND :endDate";

		Query query = em.createQuery(querySt);
		query.setParameter("customerId", customerId);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);

		@SuppressWarnings("unchecked")
		List<CustomerOrder> customerOrderList = query.getResultList();

		return customerOrderList;
	}

	@Override
	public CustomerOrder placeCustomerOrder(CustomerOrder customerOrder) {
		return null;
	}
}
