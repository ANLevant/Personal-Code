package toptal.legacy.business.services.ejb.admin.logic;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import toptal.common.business.dto.OrderDetailDTO;
import toptal.common.business.persistence.pk.OrderDetailPK;
import toptal.legacy.business.persistence.sql.entities.OrderDetailSQL;
import toptal.legacy.business.services.ejb.admin.facade.OrderDetailLocalService;
import toptal.spring.business.persistence.nosql.dao.OrderDetailNoSQLDAO;

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
