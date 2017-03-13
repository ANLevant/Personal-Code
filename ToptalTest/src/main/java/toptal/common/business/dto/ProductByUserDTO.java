package toptal.common.business.dto;

import toptal.common.business.persistence.pk.ProductByUserPK;
import toptal.legacy.business.persistence.sql.entities.ProductByUserSQL;

public class ProductByUserDTO{
	
	private long customerId;
	private long productId;
	
	public ProductByUserDTO() {
	}
	
	public ProductByUserDTO(ProductByUserSQL productByUser) {
		
		ProductByUserPK productByUserPK = productByUser.getProductByUserPK();

		if(productByUserPK != null){
			this.customerId = productByUserPK.getCustomerId();
			this.productId = productByUserPK.getProductId();
		}
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
}
