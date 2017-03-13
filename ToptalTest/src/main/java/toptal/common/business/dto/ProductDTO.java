package toptal.common.business.dto;

import toptal.common.business.persistence.facade.entities.Product;

public class ProductDTO{

	private long productId;
	private String name;
	private float price;
	private float usdChangeRate;

	public ProductDTO() {
	}

	public ProductDTO(Product product) {
		this.productId = product.getProductId();
		this.name = product.getName();
		this.price = product.getPrice();
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getUsdChangeRate() {
		return usdChangeRate;
	}

	public void setUsdChangeRate(float usdChangeRate) {
		this.usdChangeRate = usdChangeRate;
	}

}
