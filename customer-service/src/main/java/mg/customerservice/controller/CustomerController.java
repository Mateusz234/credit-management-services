package mg.customerservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mg.customerservice.entity.Customer;

@RestController
public class CustomerController {

	@RequestMapping(method=RequestMethod.POST, value="/createCustomer")
	public int createCustomer() {
		return 10;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getCustomer")
	public Customer getCustomer() {
		return new Customer();
	}
	
}
