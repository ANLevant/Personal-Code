package toptal.business.persistence.nosql.entities;

import toptal.business.persistence.facade.entities.OrderDetail;
import toptal.business.persistence.pk.OrderDetailPK;

public class OrderDetailNoSQL implements java.io.Serializable, OrderDetail {

	private static final long serialVersionUID = 1L;
	
	private OrderDetailPK orderDetailPK;
	
	private float price;
	
	private String productDescription;

	public OrderDetailNoSQL() {
	}

	public OrderDetailNoSQL(OrderDetailPK orderDetailPK, long price, String productDescription) {
		this.orderDetailPK = orderDetailPK;
		this.price = price;
		this.productDescription = productDescription;
	}

	public OrderDetailPK getOrderDetailPK() {
		return this.orderDetailPK;
	}

	public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
		this.orderDetailPK = orderDetailPK;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float f) {
		this.price = f;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

}
