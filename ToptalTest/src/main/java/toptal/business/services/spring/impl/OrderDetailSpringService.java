package toptal.business.services.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toptal.business.dto.OrderDetailDTO;
import toptal.business.persistence.facade.dao.OrderDetailDAO;
import toptal.business.persistence.facade.entities.OrderDetail;
import toptal.business.persistence.pk.OrderDetailPK;
import toptal.business.persistence.sql.entities.OrderDetailSQL;
import toptal.business.services.ejb.admin.facade.OrderDetailLocalService;

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
