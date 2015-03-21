import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class LoginOwnerTest {
	
	private Owner user; 
	private Login login;
	private Database database;

	@Before
	
	public void setUp() throws Exception {
		user=new Owner();											//The logged in user is no one at first 
		database= new MockDatabase(); 				//We use a mock database
		login=new Login(user,database);				//Create the new login form
		
	}

	@After
	public void tearDown() throws Exception {
		user=null;
		login=null;
	}
	
	//We want to test that if someone signs in with the correct username and pw
	//that the owner will in turn be the logged in user
	@Test
	public void testcorrect() {
		login.authenticate("dude", "secret");  
		assertEquals("dude",user.getUsername());	
	}
	
	//If someone tries to sign in with the wrong username or password
	//the logged in user, owner, will still be null, that is no one.
	@Test
	public void testwrong(){
		login.authenticate("dude","lol");
		assertNull(user.getUsername());
	}

}
