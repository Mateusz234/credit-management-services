package mg.productservice;

import static org.junit.Assert.*;

import org.junit.Test;

import mg.productservice.entity.Product;


public class ProductTest {

	private Product newProduct = new Product();
	private int exampleCreditId = 1;
	private String exampleName = "Kredyt hipoteczny";
	private double exampleValue = 25.16;
	private double precisionLoss = 0.0001;

	// ** Credit ID tests **//
	
	@Test
	public void shouldAllowToSetCreditId() {
		newProduct.setCreditId(exampleCreditId);
		assertEquals(newProduct.getCreditId(), exampleCreditId);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNegativeCreditId() {
		newProduct.setCreditId(-5);
	}
	
	// ** Name tests **//

	@Test
	public void shouldAllowToSetName() {
		newProduct.setName(exampleName);
		assertEquals(newProduct.getName(), exampleName);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetEmptyName() {
		newProduct.setName("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNullName() {
		newProduct.setName(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToUseSpecialSignsAndNumbersInName() {
		newProduct.setName("Kr@d1yt");
	}

	// ** Value tests **//

	@Test
	public void shouldAllowToSetValue() {
		newProduct.setValue(exampleValue);
		assertEquals(exampleValue, newProduct.getValue(), precisionLoss);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNegativeValue() {
		newProduct.setValue(-5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetValueWithValueZero() {
		newProduct.setValue(0);
	}
	

}
