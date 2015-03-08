import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OwnerTest {
	
	private Owner user1, user2, user3;

	@Before
	public void setUp() throws Exception {
		user1 = new Owner("Þórhildur", "Reykjavík", "totan@gmail.com", "6666666", "totahotty");
		user2 = new Owner("Guðrún Erla", "Reykjavík", "guddan@gmail.com", "777777", "guddabeib");
		user3 = new Owner("Kolbrún", "Reykjavík", "kobba@gmail.com", "8888888", "");
	}

	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
		user3 = null;
	}

	@Test
	public void testGetUsername() {
		assertEquals("totahotty", user1.getUsername());
		assertEquals("guddabeib", user2.getUsername());
		assertEquals("", user3.getUsername());
	}

}
