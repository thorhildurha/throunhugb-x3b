import java.util.ArrayList;
import java.util.Arrays;


public class MockDatabase implements Database {

	public MockDatabase(){
	}
	public boolean register(Book x){
		return true;
	}
	public boolean update(Book x){
		return true;
	}
	public ArrayList<Book> search(Book searchforbook){
		Book gula = new Book("Litla gula hænan","Andrés Pétursson","02024");
		Book gula2 = new Book("Litla gula hænan","Andrés Pétursson","02024");
		Book gula3 = new Book("Litla gula hænan","Andrés Pétursson","02024");

		Book bleikur= new Book("Bleiki fíllinn", "Jón Jónsson","02026");
		Book gamli = new Book("Hundraåringen", "Jonas Jonasson", "02030");
		bleikur.setPrice("5000");
		gula.setPrice("3000");
		gula2.setPrice("2000");
		gula3.setPrice("5000");
		
		gamli.setPrice("2200");
		ArrayList<Book> somebooks=new ArrayList<Book>();
		if(searchforbook.getName().equals("Litla gula hænan")){
			somebooks.add(gula);
			somebooks.add(gula2);
			somebooks.add(gula3);
		}
		else if(searchforbook.getName().equals("Bleiki fíllinn")){
			somebooks.add(bleikur);
		}
		return somebooks;
	}
	public boolean isuser(String user, char[] password){
		if(user.equals("Gudrun")&&Arrays.equals(password,new char[]{'s','e'})){
			return true;
		}
		else{
			return false;
		}
	}
	public Book[] searchByUser(Owner user){
		Book gula = new Book("Litla gula hænan","Andrés Pétursson","02024");
		Book bleikur= new Book("Bleiki fíllinn", "Jón Jónsson","02026");
		Book gamli = new Book("Hundraåringen", "Jonas Jonasson", "02030");
		gamli.setOwner(user);
		gula.setOwner(user);
		bleikur.setOwner(user);
		gula.setPrice("3000");
		bleikur.setPrice("4000");
		gamli.setPrice("1100");
		Book[] somebooks = {gula,bleikur,gamli};
		return somebooks;
	}
	
}
