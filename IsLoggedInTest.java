import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class IsLoggedInTest {
	private Owner loggedin;
	private Search search;
	private Database database;
	private JFrame frame;
	@Before
	public void setUp() throws Exception {
		database=new MockDatabase();
		loggedin=new Owner();
		search=new Search(loggedin, database, frame);
	}

	@After
	public void tearDown() throws Exception {
		loggedin=null;
		search=null;
	}
	
	/* This test checks if the method isloggedin returns false, as it should,
	 * if there is no user logged in. This method is used to check if a user should be able
	 * to register.
	 */
	@Test
	public void testwrong() {
		assertFalse(search.isloggedin());
	}
	/*This test checks if the method returns true, as it should, 
	 * if there is a logged in user. This method is used to check if a user should be able
	 * to register.
	 */
	@Test
	public void testcorrect(){
		loggedin.setloggedin(true);
		//However if someone is logged in, an owner exists and we want to be able to register
		assertTrue(search.isloggedin());
		
	}

}
