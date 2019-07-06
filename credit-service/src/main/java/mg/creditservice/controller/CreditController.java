package mg.creditservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mg.creditservice.entity.Credit;
import mg.creditservice.entity.Customer;
import mg.creditservice.entity.Product;
import mg.creditservice.service.CreditService;

@RestController
public class CreditController {

	@Autowired
	CreditService creditService;
	Credit credit = new Credit();
	Customer customer = new Customer();
	Product product = new Product();
	
	@RequestMapping(method=RequestMethod.POST, path="/createCredit/{customerName}"
			 									   +"/{customerSurname}/{personalId}/{productName}"
			 									   +"/{value}/{creditName}")
	public int createCredit(@PathVariable String customerName, @PathVariable String customerSurname,
							@PathVariable String personalId, @PathVariable String productName,
							@PathVariable double value, @PathVariable String creditName) {
		credit.setName(creditName);
		customer.setName(customerName);
		customer.setLastName(customerSurname);
		customer.setPersonalId(personalId);
		credit.setCustomer(customer);
		product.setName(productName);
		product.setValue(value);
		credit.setProduct(product);
		return creditService.createCredit(credit);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getCredits")
	public String getCredits() {
		return creditService.getAllCredits().toString();
	}
	
}
