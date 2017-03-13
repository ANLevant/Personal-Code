package toptal.common.business.persistence.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductByUserPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "CUSTOMER_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private long customerId;
	
	@Column(name = "PRODUCT_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private long productId;
	
	public ProductByUserPK() {
	}
	
	public ProductByUserPK(long customerId, long productId) {
		this.customerId = customerId;
		this.productId = productId;
	}
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + (int) (productId ^ (productId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object productByUserPK) {
		if (productByUserPK instanceof ProductByUserPK && this.getCustomerId() == ((ProductByUserPK) productByUserPK).getCustomerId() && this.getProductId() == ((ProductByUserPK) productByUserPK).getProductId()){
			return true;
		}
		else{
			return false;
		}
	}

}
