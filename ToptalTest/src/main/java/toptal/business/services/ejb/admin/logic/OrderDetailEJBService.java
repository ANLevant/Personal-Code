package toptal.business.services.ejb.admin.logic;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import toptal.business.dto.OrderDetailDTO;
import toptal.business.persistence.nosql.dao.OrderDetailNoSQLDAO;
import toptal.business.persistence.pk.OrderDetailPK;
import toptal.business.persistence.sql.entities.OrderDetailSQL;
import toptal.business.services.ejb.admin.facade.OrderDetailLocalService;

@Stateless
public class OrderDetailEJBService implements OrderDetailLocalService {

	@EJB
	private OrderDetailNoSQLDAO orderDetailDAO;
	
	@Override
	public void addOrderDetail(OrderDetailDTO orderDetailDTO) {
		
		OrderDetailSQL orderDetail = new OrderDetailSQL();
		
		OrderDetailPK orderDetailPK = new OrderDetailPK();
		
		orderDetailPK.setOrderId(orderDetailDTO.getOrderId());
		orderDetailPK.setProductId(orderDetailDTO.getProductId());
		
		orderDetail.setPrice(orderDetailDTO.getPrice());
		orderDetail.setProductDescription(orderDetailDTO.getProductDescription());
		orderDetail.setOrderDetailPK(orderDetailPK);
		
		orderDetailDAO.addOrderDetail(orderDetail);

	}

}
