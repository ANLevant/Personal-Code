package toptal.spring.business.persistence.nosql.entities;

import java.util.HashSet;
import java.util.Set;

import toptal.common.business.persistence.facade.entities.Customer;
import toptal.common.business.persistence.facade.entities.Product;

public class ProductNoSQL implements java.io.Serializable, Product {

	private static final long serialVersionUID = 1L;
	
	private long productId;
	private String name;
	private float price;
	private Set<Customer> customers = new HashSet<Customer>(0);

	public ProductNoSQL() {
	}

	public ProductNoSQL(long productId, String name, long price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public ProductNoSQL(long productId, String name, long price, Set<Customer> customers) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.customers = customers;
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

	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

}
