
public class Owner {
	private String name; 
	private String location;
	private String email;
	private String phone;
	
	public Owner(){
		
	}
	//Use: String[] info=owner.getinfo();
	//Before: nothing
	//After: info contains owners information [name, location, email, phone]
	public String[] getinfo(){
		String[] results = {this.name, this.location, this.email, this.phone};
		return results;
	}

}
