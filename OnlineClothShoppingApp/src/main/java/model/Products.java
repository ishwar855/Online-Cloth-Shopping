package model;

public class Products {
    private int product_id;
    private int type_id;
    private String name;
    private String description;
    private int price;
    private String img_path;
    private float ratings;
    
    
    
    
	public Products() {
		
	}


	public Products(int product_id, int type_id, String name, String description, int price, String img_path,
			float ratings) {
		super();
		this.product_id = product_id;
		this.type_id = type_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.img_path = img_path;
		this.ratings = ratings;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public int getType_id() {
		return type_id;
	}


	public void setType_id(int type_id) {
		this.type_id = type_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getImg_path() {
		return img_path;
	}


	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}


	public float getRatings() {
		return ratings;
	}


	public void setRatings(float ratings) {
		this.ratings = ratings;
	}


	@Override
	public String toString() {
		return "product_id=" + product_id + "type_id=" + type_id + "name=" + name + "description="
				+ description + "price=" + price + "img_path=" + img_path + "ratings=" + ratings;
	}
    
	
	
   
    
}
