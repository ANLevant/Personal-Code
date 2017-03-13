package toptal.business.persistence.nosql.entities;

import java.util.HashSet;
import java.util.Set;

import toptal.business.persistence.facade.entities.Customer;
import toptal.business.persistence.facade.entities.CustomerOrder;
import toptal.business.persistence.facade.entities.Product;

public class CustomerNoSQL implements java.io.Serializable, Customer {

	private static final long serialVersionUID = 1L;
	
	private long customerId;
	private String name;
	private String email;
	private Set<CustomerOrder> customerOrders = new HashSet<CustomerOrder>(0);
	private Set<Product> products = new HashSet<Product>(0);

	public CustomerNoSQL() {
	}

	public CustomerNoSQL(long customerId, String name, String email) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
	}

	public CustomerNoSQL(long customerId, String name, String email, Set<CustomerOrder> customerOrders,
			Set<Product> products) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.customerOrders = customerOrders;
		this.products = products;
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<CustomerOrder> getCustomerOrders() {
		return this.customerOrders;
	}

	public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
