package toptal.business.persistence.facade.entities;

import toptal.business.persistence.pk.ProductByUserPK;

public interface ProductByUser{
	
	public ProductByUserPK getProductByUserPK();
	
	public void setProductByUserPK(ProductByUserPK productByUserPK);
}
