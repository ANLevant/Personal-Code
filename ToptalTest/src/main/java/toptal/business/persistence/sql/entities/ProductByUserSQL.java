package toptal.business.persistence.sql.entities;

//Generated 19-mar-2016 17:09:32 by Hibernate Tools 4.3.1.Final

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import toptal.business.persistence.facade.entities.OrderDetail;
import toptal.business.persistence.facade.entities.ProductByUser;
import toptal.business.persistence.pk.ProductByUserPK;

/**
* Product generated by hbm2java
*/
@Entity
@Table(name = "PRODUCT_BY_USER")
public class ProductByUserSQL implements java.io.Serializable, ProductByUser{
	
	private static final long serialVersionUID = 1L;
	

	@EmbeddedId
	private ProductByUserPK productByUserPK;


	public ProductByUserPK getProductByUserPK() {
		return productByUserPK;
	}


	public void setProductByUserPK(ProductByUserPK productByUserPK) {
		this.productByUserPK = productByUserPK;
	}
}
