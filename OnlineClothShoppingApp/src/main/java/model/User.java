package model;

public class User {
   private int id;
   private String first_name;
   private String last_name;
   private long mobile;
   private String email;
   private String password;

   
   
   public User() {
	
   	}



   	public User(int id, String first_name, String last_name, long mobile, String email, String password) {
	super();
	this.id = id;
	this.first_name = first_name;
	this.last_name = last_name;
	this.mobile = mobile;
	this.email = email;
	this.password = password;
   	
   	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public long getMobile() {
		return mobile;
	}



	public void setMobile(long mobile) {
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "User" + id + "first_name" + first_name + "last_name" + last_name + "mobile" + mobile
				+ "email" + email + "password" + password;
	}
   
   	
   	
   
   
	
}
