package mg.customerservice;

import static org.junit.Assert.*;

import org.junit.Test;

import mg.customerservice.entity.Customer;

public class CustomerTest {

	private Customer newCustomer = new Customer();
	private int exampleCreditId = 1;
	private String exampleName = "Jan";
	private String exampleLastName = "Kowalski";
	private String examplePersonalId = "94121200000";

	// ** Credit ID tests **//
	
	@Test
	public void shouldAllowToSetCreditId() {
		newCustomer.setCreditId(exampleCreditId);
		assertEquals(newCustomer.getCreditId(), exampleCreditId);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNegativeCreditId() {
		newCustomer.setCreditId(-5);
	}
	
	// ** Name tests **//

	@Test
	public void shouldAllowToSetName() {
		newCustomer.setName(exampleName);
		assertEquals(newCustomer.getName(), exampleName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetEmptyName() {
		newCustomer.setName("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNullName() {
		newCustomer.setName(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToUseSpecialSignsAndNumbersInName() {
		newCustomer.setName("J0AnN!");
	}

	// ** Last name tests **//

	@Test
	public void shouldAllowToSetLastName() {
		newCustomer.setLastName(exampleLastName);
		assertEquals(newCustomer.getLastName(), exampleLastName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetEmptyLastName() {
		newCustomer.setLastName("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNullLastName() {
		newCustomer.setLastName(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToUseSpecialSignsAndNumbersInLastName() {
		newCustomer.setLastName("/N0wak");
	}

	// ** Personal ID tests **//

	@Test
	public void shouldAllowToSetPersonalId() {
		newCustomer.setPersonalId(examplePersonalId);
		assertEquals(newCustomer.getPersonalId(), examplePersonalId);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetEmptyPersonalId() {
		newCustomer.setPersonalId("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNullPersonalId() {
		newCustomer.setPersonalId(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToUseLettersInPersonalId() {
		newCustomer.setPersonalId("9412x200000");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToUseSpecialSignsInPersonalId() {
		newCustomer.setPersonalId("9412-200000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void personalIdShouldNotHaveMoreThan11Numbers() {
		newCustomer.setPersonalId("941272000067");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void personalIdShouldNotHaveLessThan11Numbers() {
		newCustomer.setPersonalId("94127200");
	}

}
