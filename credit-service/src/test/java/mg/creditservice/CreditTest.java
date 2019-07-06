package mg.creditservice;

import static org.junit.Assert.*;

import org.junit.Test;

import mg.creditservice.entity.Credit;

public class CreditTest {

	private Credit newCredit = new Credit();
	private int exampleCreditId = 1;
	private String exampleName = "Kredyt hipoteczny";

	// ** Credit ID tests **//
	
	@Test
	public void shouldAllowToSetCreditId() {
		newCredit.setCreditId(exampleCreditId);
		assertEquals(newCredit.getCreditId(), exampleCreditId);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNegativeCreditId() {
		newCredit.setCreditId(-5);
	}
	
	// ** Name tests **//

	@Test
	public void shouldAllowToSetName() {
		newCredit.setName(exampleName);
		assertEquals(newCredit.getName(), exampleName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetEmptyName() {
		newCredit.setName("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNullName() {
		newCredit.setName(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToUseSpecialSignsAndNumbersInName() {
		newCredit.setName("Kr@d1yt");
	}

}
