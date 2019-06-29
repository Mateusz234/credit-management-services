package mg.creditservice;

import static org.junit.Assert.*;

import org.junit.Test;

import mg.creditservice.entity.Credit;

public class CreditTest {

	private Credit newCredit = new Credit();
	private int exampleCreditId = 1;

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
	
	// TODO add tests for not nulls for product and customer
}
