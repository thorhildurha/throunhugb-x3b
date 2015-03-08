
public class Owner {
	private String name; 
	private String location;
	private String email;
	private String phone;
	private String username;
	
	public Owner(String name0, String location0, String email0, String phone0, String username0){
		name = name0;
		location = location0;
		email = email0;
		phone = phone0;
		username = username0;
	}
	
	//Use: String[] info=owner.getinfo();
	//Before: owner is an Owner
	//After: info contains owners information [name, location, email, phone]
	public String[] getinfo(){
		String[] results = {this.name, this.location, this.email, this.phone, this.username};
		return results;
	}
	
//	Use: x = a.getUsername()
//	Before: a is an Owner
//	After: x is a String and is the username of a
	public String getUsername() {
		return this.username;
	}

}
