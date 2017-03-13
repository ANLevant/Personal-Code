package toptal.legacy.business.persistence.sql.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import toptal.legacy.business.persistence.sql.entities.OrderDetailSQL;

@Local
@Stateless
public class OrderDetailSQLDAO{
	
	@PersistenceContext(unitName="BeitechPU")
	private EntityManager em;
	
	public void addOrderDetail(OrderDetailSQL orderDetail){
		em.persist(orderDetail);
		em.flush();
	}

}
