package toptal.business.persistence.sql.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import toptal.business.persistence.sql.entities.OrderDetailSQL;

@LocalBean
@Stateless
public class OrderDetailSQLDAO{
	
	@PersistenceContext(unitName="BeitechPU")
	private EntityManager em;
	
	public void addOrderDetail(OrderDetailSQL orderDetail){
		em.persist(orderDetail);
		em.flush();
	}

}
