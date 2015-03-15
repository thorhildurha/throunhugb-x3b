import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class IsLoggedInTest {
	private Owner loggedin;
	private Search search;
	@Before
	public void setUp() throws Exception {
		search=new Search(loggedin);
	}

	@After
	public void tearDown() throws Exception {
		loggedin=null;
		search=null;
	}

	@Test
	public void test() {
		//If no owner exists we do not want to be able to register
		assertFalse(search.isloggedin());
		loggedin=new Owner();
		search=new Search(loggedin);
		//However if someone is logged in, an owner exists and we want to be able to register
		assertTrue(search.isloggedin());
	}

}
