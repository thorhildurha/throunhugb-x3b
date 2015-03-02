public class Book {
	public String Name; //same as prototype, available search input
	public String Author; //same as prototype, available search input
	public String ISBN; //same as prototype, available search input
	public int price; //controlled by owner 
	public String condition; //controlled by owner
	public String course; //same as prototype, available search input
	public Owner owner; //logged in user (location, name, email, phone number)
	
	public Book(String name, String author, String isbn){//search 
		this.Name=name;
		this.Author=author;
		this.ISBN=isbn;
	}
	
	public Boolean register(){ //Returns true if no Error in registration method
		return true; 
	}
	
	public Book[] search(){ //Returns an array of Books that match our current object of Book
		Book[] results=null;
		return results;
	}
	public Boolean update(){ //Returns true if no Error in update method, only possible to update if Owner?
		return true;
	}
}
