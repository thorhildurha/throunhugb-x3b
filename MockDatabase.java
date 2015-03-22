
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
	public Boolean isuser(String user, String password){
		if(password=="secret"){
			return true;
		}
		else{
			return false;
		}
	}
	public Book[] searchByUser(Owner user){
		Book gula = new Book("Litla gula hænan","Andrés Pétursson","02024");
		Book kukur = new Book("Litli kúkurinn","Þórhildur Hafsteinsdóttir","02025");
		gula.setOwner(user);
		kukur.setOwner(user);
		gula.setPrice("3000");
		kukur.setPrice("4000");
		Book[] somebooks = {gula,kukur};
		return somebooks;
	}
	
}
