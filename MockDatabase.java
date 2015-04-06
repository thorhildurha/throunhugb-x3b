
public class MockDatabase implements Database {

	public MockDatabase(){
	}
	public Boolean register(Book x){
		return true;
	}
	public Boolean update(Book x){
		return true;
	}
	public Book[] search(Book searchforbook){
		Book gula = new Book("Litla gula h�nan","Andr�s P�tursson","02024");
		Book kukur = new Book("Litli k�kurinn","��rhildur Hafsteinsd�ttir","02025");
		Book bleikur= new Book("Bleiki f�llinn", "J�n J�nsson","02026");
		Book gamli = new Book("Hundra�ringen", "Jonas Jonasson", "02030");
		bleikur.setPrice("5000");
		gula.setPrice("3000");
		kukur.setPrice("4000");
		gamli.setPrice("2200");
		Book[] somebooks = {gula,bleikur,kukur, gamli};
		return somebooks;
	}
	public Boolean isuser(String user, String password){
		return true;
	}
	public Book[] searchByUser(Owner user){
		Book gula = new Book("Litla gula h�nan","Andr�s P�tursson","02024");
		Book kukur = new Book("Litli k�kurinn","��rhildur Hafsteinsd�ttir","02025");
		Book gamli = new Book("Hundra�ringen", "Jonas Jonasson", "02030");
		gamli.setOwner(user);
		gula.setOwner(user);
		kukur.setOwner(user);
		gula.setPrice("3000");
		kukur.setPrice("4000");
		gamli.setPrice("1100");
		Book[] somebooks = {gula,kukur,gamli};
		return somebooks;
	}
	
}
