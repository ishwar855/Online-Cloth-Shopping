package model;

public class ClothTypes {

    private int id;
    private String name;
    private String description;
    private String imgUrl;
    

    // Default constructor
    public ClothTypes() {
    	super();
    }
     

    public ClothTypes(int id, String name, String description, String imgUrl) {
    	this.id = id;
    	this.name = name;
    	this.description = description;
    	this.imgUrl = imgUrl;
    }
    
	// Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for imgUrl
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    @Override
    public String toString() {
        return  id + name + description + imgUrl ;
    }
}
