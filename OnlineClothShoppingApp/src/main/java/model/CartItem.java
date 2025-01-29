package model;

public class CartItem {
   private int itemId;
   private int typeId;
   private String productName;
   private int price;
   private int quantity;
   private String imageUrl;
   
   public CartItem() {
       super();
   }

   public CartItem(int itemId, int typeId, String productName, int price, int quantity) {
       super();
       this.itemId = itemId;
       this.typeId = typeId;
       this.productName = productName;
       this.price = price;
       this.quantity = quantity;
   }

   public CartItem(int itemId, int typeId, String productName, int price, int quantity, String imageUrl) {
       this(itemId, typeId, productName, price, quantity);
       this.imageUrl = imageUrl;
   }

   public int getItemId() {
       return itemId;
   }

   public void setItemId(int itemId) {
       this.itemId = itemId;
   }

   public int getTypeId() {
       return typeId;
   }

   public void setTypeId(int typeId) {
       this.typeId = typeId;
   }

   public String getProductName() {
       return productName;
   }

   public void setProductName(String productName) {
       this.productName = productName;
   }

   public int getPrice() {
       return price;
   }

   public void setPrice(int price) {
       this.price = price;
   }

   public int getQuantity() {
       return quantity;
   }

   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }

   public String getImageUrl() {
       return imageUrl;
   }

   public void setImageUrl(String imageUrl) {
       this.imageUrl = imageUrl;
   }

   @Override
   public String toString() {
       return itemId + "  " + typeId + "  " + productName + "  " + price + "  " + quantity + "  " + imageUrl;
   } 
}

