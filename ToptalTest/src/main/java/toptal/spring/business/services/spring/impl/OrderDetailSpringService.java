package toptal.spring.business.services.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toptal.common.business.dto.OrderDetailDTO;
import toptal.common.business.persistence.facade.dao.OrderDetailDAO;
import toptal.common.business.persistence.facade.entities.OrderDetail;
import toptal.common.business.persistence.pk.OrderDetailPK;
import toptal.legacy.business.persistence.sql.entities.OrderDetailSQL;
import toptal.legacy.business.services.ejb.admin.facade.OrderDetailLocalService;

@Service("orderDetailService")
public class OrderDetailSpringService implements OrderDetailLocalService {

	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	public void addOrderDetail(OrderDetailDTO orderDetailDTO) {
		
		OrderDetail orderDetail = new OrderDetailSQL();
		
		OrderDetailPK orderDetailPK = new OrderDetailPK();
		
		orderDetailPK.setOrderId(orderDetailDTO.getOrderId());
		orderDetailPK.setProductId(orderDetailDTO.getProductId());
		
		orderDetail.setPrice(orderDetailDTO.getPrice());
		orderDetail.setProductDescription(orderDetailDTO.getProductDescription());
		orderDetail.setOrderDetailPK(orderDetailPK);
		
		orderDetailDAO.addOrderDetail(orderDetail);

	}

}
