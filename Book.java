public class Book {
	private String Name;
	private String Author;
	private String ISBN;
	private int price;
	private String condition;
	private Owner owner;
	
	public Book(String name, String author, String isbn){
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
