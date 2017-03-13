package toptal.business.dto;

import toptal.business.persistence.facade.entities.Customer;

public class CustomerDTO{

	private long customerId;
	private String name;
	private String email;

	public CustomerDTO() {
	}

	public CustomerDTO(Customer customer) {
		this.customerId = customer.getCustomerId();
		this.name = customer.getName();
		this.email = customer.getEmail();
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
}
