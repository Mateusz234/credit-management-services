package mg.creditservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mg.creditservice.dao.CreditDao;
import mg.creditservice.entity.Credit;
import mg.creditservice.entity.Customer;
import mg.creditservice.entity.Product;

@Service
public class CreditService {

	@Autowired
	CreditDao creditDao;
	@Autowired
	RestTemplate restTemplate;
	List<Credit> creditList = new ArrayList<>();
	
	public List<Credit> getAllCredits() {
		creditList = creditDao.getAll();
		for(Credit c : creditList ) {
			//TODO change that hardcoded method for discovery
			c.setCustomer(restTemplate.getForObject("http://localhost:8083/getCustomer/" + c.getCreditId(), Customer.class));
			c.setProduct(restTemplate.getForObject("http://localhost:8082/getProduct/" + c.getCreditId(), Product.class));
		}
		return creditList;
	}

}
