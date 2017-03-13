package toptal.common.business.persistence.facade.entities;
// Generated 19-mar-2016 17:09:32 by Hibernate Tools 4.3.1.Final

import java.util.Set;

public interface Product {

	public long getProductId();

	public void setProductId(long productId);

	public String getName();

	public void setName(String name);

	public float getPrice();

	public void setPrice(float price);

	public Set<Customer> getCustomers();

	public void setCustomers(Set<Customer> customers);

}
