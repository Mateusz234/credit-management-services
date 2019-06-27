package mg.clientservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mg.clientservice.entity.Client;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceApplicationTests {

	Client example = new Client("Jan", "Nowak", "94121200000");
	
	@Test
	public void contextLoads() {
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetEmptyName() {
		Client client = new Client("", "Kowalski", "94121200000");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToSetNullName() {
		Client client = new Client(null, "Kowalski", "94121200000");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowToUseSpecialSignsAndNumbersInName() {
		Client client = new Client("J1%A!N", "Kowalski", "94121200000");
		// string to char array and check whole name for chars with value out of range for small and
		// big letters
	}

}
