package toptal.business.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import toptal.business.persistence.facade.entities.CustomerOrder;

@XmlRootElement(name = "Order")
public class CustomerOrderDTO{

	private long orderId;
	private long customerId;
	private long deliveryAddress;
	private float price;
	private float usdChangeRate;
	private Date placementDate;

	public CustomerOrderDTO() {
	}

	public CustomerOrderDTO(long orderId, long customerId, long deliveryAddress, Date placementDate) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.deliveryAddress = deliveryAddress;
		this.placementDate = placementDate;
	}

	public CustomerOrderDTO(CustomerOrder customerOrder) {
		this.orderId = customerOrder.getOrderId();
		this.customerId = customerOrder.getCustomer().getCustomerId();
		this.deliveryAddress = customerOrder.getDeliveryAddress();
		this.placementDate = customerOrder.getPlacementDate();
		this.price = customerOrder.getPrice();
		this.usdChangeRate = customerOrder.getUsdChangeRate();
	}

	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(long deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Date getPlacementDate() {
		return placementDate;
	}

	public void setPlacementDate(Date placementDate) {
		this.placementDate = placementDate;
	}

	public float getPrice() {
		return price;
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
