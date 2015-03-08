import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class LoginOwnerTest {
	
	private Owner user;
	private Login login;
	private Database database;
	@Before
	
	public void setUp() throws Exception {
		user=new Owner(null,null,null,null,null);
		database= new MockDatabase();
		login=new Login(user,database);
		
	}

	@After
	public void tearDown() throws Exception {
		user=null;
		login=null;
	}

	@Test
	public void test() {
		login.authenticate("dude", "test");
		assertEquals("dude",user.getUsername());
	}

}
