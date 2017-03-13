package toptal.common.business.persistence.facade.entities;

import toptal.common.business.persistence.pk.ProductByUserPK;

public interface ProductByUser{
	
	public ProductByUserPK getProductByUserPK();
	
	public void setProductByUserPK(ProductByUserPK productByUserPK);
}
