
public interface Database {

	public Boolean register(Book x);
	public Boolean update(Book x);
	public Book[] search();
	public Boolean isuser(String user, String password);
	
}
