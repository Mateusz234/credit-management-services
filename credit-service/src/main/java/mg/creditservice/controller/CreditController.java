package mg.creditservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mg.creditservice.entity.Credit;

@RestController
public class CreditController {

	@RequestMapping(method=RequestMethod.POST, value="/createCredit")
	public int createCredit() {
		return 10;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getCredits")
	public Credit getCredits() {
		return new Credit();
	}
	
}
