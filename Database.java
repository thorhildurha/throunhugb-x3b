import java.util.ArrayList;


public interface Database {

	/* Before: Book x is a Book with the information we want to register
	 * After: returns true if the database registration was successful, 
	 * 		  false otherwise
	 */
	public Boolean register(Book x);
	
	/* Before: Book x is a Book with the information we want to update
	 * After: returns true if the database registration was successful,
	 * 		  false otherwise
	 */
	public Boolean update(Book x);
	
	/* Before: At least one of the strings, isbn, name, author, condtion is not 
	 * 		   the empty string. These are the strings we want to search after.
	 * After: returns an array of books which the input strings applied to.
	 */
	public ArrayList<Book> search(Book searchfor);
	
	/* Before: user, password are Strings
	 * After: returns true if there is a user with the given password in database,
	 * 		  false otherwise
	 */
	public Boolean isuser(String user, String password);
	
	public Book[] searchByUser(Owner user);
	
}
