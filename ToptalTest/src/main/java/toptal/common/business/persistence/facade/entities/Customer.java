package toptal.common.business.persistence.facade.entities;

import java.util.Set;

public interface Customer {

		public long getCustomerId();

		public void setCustomerId(long customerId) ;

		public String getName();

		public void setName(String name);

		public String getEmail();

		public void setEmail(String email);

		public Set<CustomerOrder> getCustomerOrders();

		public void setCustomerOrders(Set<CustomerOrder> customerOrders);

		public Set<Product> getProducts();

		public void setProducts(Set<Product> products);
	
}
