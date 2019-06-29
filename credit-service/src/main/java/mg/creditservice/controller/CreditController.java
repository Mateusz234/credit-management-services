package mg.creditservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import mg.creditservice.entity.Credit;
import mg.creditservice.entity.Customer;
import mg.creditservice.service.CreditService;

@RestController
public class CreditController {

	@Autowired
	CreditService creditService;

	
	@RequestMapping(method=RequestMethod.POST, value="/createCredit")
	public int createCredit() {
		return 10;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getCredits")
	public List<Credit> getCredits() {
		return creditService.getAllCredits();
	}
	
}
