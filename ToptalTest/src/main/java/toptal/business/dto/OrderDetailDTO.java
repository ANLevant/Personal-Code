package toptal.business.dto;

import toptal.business.persistence.pk.OrderDetailPK;
import toptal.business.persistence.sql.entities.OrderDetailSQL;

public class OrderDetailDTO{

	private long orderId;
	private long productId;
	private float price;
	private String productDescription;

	public OrderDetailDTO() {
	}

	public OrderDetailDTO(OrderDetailSQL orderDetail) {
		
		OrderDetailPK orderDetailPK = orderDetail.getOrderDetailPK();
		
		this.price = orderDetail.getPrice();
		this.productDescription = orderDetail.getProductDescription();
		
		if(orderDetailPK != null){
			this.orderId = orderDetailPK.getOrderId();
			this.productId = orderDetailPK.getProductId();
		}
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

}