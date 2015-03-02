
public class Owner {
	private String name; 
	private String location;
	private String email;
	private String phone;
	
	public Owner(){
		
	}
	
	public String[] getinfo(){
		String[] results = {this.name, this.location, this.email, this.phone};
		return results;
	}

}
