package toptal.business.persistence.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ORDER_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private long orderId;
	
	@Column(name = "PRODUCT_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private long productId;
	
	public OrderDetailPK() {
	}
	
	public OrderDetailPK(long customerId, long productId) {
		this.orderId = customerId;
		this.productId = productId;
	}
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + (int) (productId ^ (productId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object productByUserPK) {
		if (productByUserPK instanceof OrderDetailPK && this.getOrderId() == ((OrderDetailPK) productByUserPK).getOrderId() && this.getProductId() == ((OrderDetailPK) productByUserPK).getProductId()){
			return true;
		}
		else{
			return false;
		}
	}

}
