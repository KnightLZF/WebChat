package model;

public class User {
	private String username;
	private String password;
	
	public User(){
		username="";
		password="";
	}
	public void setusername(String s){
		username=s;
	}
	
	public String getusername(){
		return username;
	}
	
	public void setpassword(String s){
		password=s;
	}
	
	public String getpassword(){
		return password;
	}
}
