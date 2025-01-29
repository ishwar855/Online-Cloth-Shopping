package model;

public class OrderItem {
    private int itemId;
    private int orderId;
    private int productId;
    private int price;
    private int quantity;
    
    
	public OrderItem() {
		super();
	}


	public OrderItem(int itemId, int orderId, int productId, int price,int quantity) {
		super();
		this.itemId = itemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity= quantity;
		this.price = price;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return itemId + "  " + orderId + "  " + productId + "  "+ quantity + "  " + price;
	}
    
    
}
