
public class MockDatabase implements Database {

	public MockDatabase(){
	}
	public Boolean register(Book x){
		return true;
	}
	public Boolean update(Book x){
		return true;
	}
	public Book[] search(){
		Book[] searchfor={};
		return searchfor;
	}
	public Boolean ispassword(String user, String password){
		if(password=="secret"){
			return true;
		}
		else{
			return false;
		}
	}
	
}
