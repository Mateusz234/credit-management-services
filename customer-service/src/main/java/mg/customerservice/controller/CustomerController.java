package mg.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mg.customerservice.entity.Customer;
import mg.customerservice.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(method=RequestMethod.POST, value="/createCustomer")
	public int createCustomer() {
		return 10;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getCustomer/{creditId}")
	public Customer getCustomer(@PathVariable("creditId") int creditId) {
		return customerService.getCustomerById(creditId);
	}
	
}
