package toptal.common.business.persistence.facade.entities;
// Generated 19-mar-2016 17:09:32 by Hibernate Tools 4.3.1.Final

import toptal.common.business.persistence.pk.OrderDetailPK;

public interface OrderDetail{

	public Object getOrderDetailPK();

	public void setOrderDetailPK(OrderDetailPK orderDetailPK);

	public float getPrice();

	public void setPrice(float f);

	public String getProductDescription();

	public void setProductDescription(String productDescription);

}
