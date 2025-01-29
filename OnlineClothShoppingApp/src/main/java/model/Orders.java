package model;

import java.sql.Timestamp;

public class Orders {
     private int orderId;
     private int userId;
     private int typeId;
     private Timestamp order_date;
     private int totalAmount;
     private String status;
     private String paymentMode;
     
	public Orders() {
		super();
	}

	public Orders(int orderId, int userId, int typeId, Timestamp order_date, int totalAmount, String status,
			String paymentMode) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.typeId = typeId;
		this.order_date = order_date;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public Timestamp getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return orderId + "  " + userId + "  " + typeId + "  " + order_date+ " " 
	+ totalAmount + "  " + status + "  " + paymentMode ;
	}
     
     
}
