package toptal.common.business.persistence.facade.entities;

import java.util.Date;

public interface CustomerOrder{

	public Date getPlacementDate();

	public void setPlacementDate(Date placementDate);

	public long getOrderId();

	public void setOrderId(long orderId);

	public Customer getCustomer();

	public void setCustomer(Customer customer);

	public Long getDeliveryAddress();

	public void setDeliveryAddress(Long deliveryAddress);

	public float getPrice();

	public void setPrice(float price);

	public float getUsdChangeRate();

	public void setUsdChangeRate(float usdChangeRate);

}
