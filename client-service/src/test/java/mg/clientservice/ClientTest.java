package mg.clientservice;

import static org.junit.Assert.*;

import org.junit.Test;

import mg.clientservice.entity.Client;

public class ClientTest {

	private Client newClient = new Client();
	private String exampleName = "Jan";
	private String exampleLastName = "Kowalski";
	private String examplePersonalId = "94121200000";

	// ** Name tests **//

	@Test
	public void shouldAllowToSetName() {
		newClient.setName(exampleName);
		assertEquals(newClient.getName(), exampleName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetEmptyName() {
		newClient.setName("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNullName() {
		newClient.setName(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToUseSpecialSignsAndNumbersInName() {
		newClient.setName("J0AnN!");
	}

	// ** Last name tests **//

	@Test
	public void shouldAllowToSetLastName() {
		newClient.setLastName(exampleLastName);
		assertEquals(newClient.getLastName(), exampleLastName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetEmptyLastName() {
		newClient.setLastName("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNullLastName() {
		newClient.setLastName(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToUseSpecialSignsAndNumbersInLastName() {
		newClient.setLastName("/N0wak");
	}

	// ** Personal ID tests **//

	@Test
	public void shouldAllowToSetPersonalId() {
		newClient.setPersonalId(examplePersonalId);
		assertEquals(newClient.getPersonalId(), examplePersonalId);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetEmptyPersonalId() {
		newClient.setPersonalId("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNullPersonalId() {
		newClient.setPersonalId(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToUseLettersInPersonalId() {
		newClient.setPersonalId("9412x200000");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToUseSpecialSignsInPersonalId() {
		newClient.setPersonalId("9412-200000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void personalIdShouldNotHaveMoreThan11Numbers() {
		newClient.setPersonalId("941272000067");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void personalIdShouldNotHaveLessThan11Numbers() {
		newClient.setPersonalId("94127200");
	}

}
