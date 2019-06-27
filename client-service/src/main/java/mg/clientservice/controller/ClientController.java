package mg.clientservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mg.clientservice.entity.Client;

@RestController
public class ClientController {

	@RequestMapping(method=RequestMethod.POST, value="/createClient")
	public int createClient() {
		return 10;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getClient")
	public Client getClient() {
		return new Client();
	}
	
}
