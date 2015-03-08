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
	public void testGet() {
		assertEquals("totahotty", user1.getUsername());
		assertEquals("guddabeib", user2.getUsername());
		assertEquals("", user3.getUsername());
		assertEquals("Reykjavík", user1.getLocation());
		assertEquals("guddan@gmail.com", user2.getEmail());
		assertEquals("8888888", user3.getPhone());
		
	}
	
	@Test
	public void testSetandGet() {
		user1.setName("Birta");
		assertEquals("Birta", user1.getName());
		user2.setUsername("Nonni");
		assertEquals("Nonni", user2.getUsername());
		user3.setUsername("Kobban");
		assertEquals("Kobban",user3.getUsername());
		user2.setPhone("5689999");
		assertEquals("5689999",user2.getPhone());
	}

}
