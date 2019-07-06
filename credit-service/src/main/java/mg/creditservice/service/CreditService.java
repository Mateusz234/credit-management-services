package mg.creditservice.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	int newId;

	public List<Credit> getAllCredits() {
		creditList = creditDao.getAll();
		for (Credit c : creditList) {
			c.setCustomer(
					restTemplate.getForObject("http://customer-service:8083/getCustomer/" + c.getCreditId(), Customer.class));
//					restTemplate.getForObject("http://localhost:8083/getCustomer/" + c.getCreditId(), Customer.class));
			c.setProduct(
					restTemplate.getForObject("http://product-service:8082/getProduct/" + c.getCreditId(), Product.class));
//					restTemplate.getForObject("http://localhost:8082/getProduct/" + c.getCreditId(), Product.class));
		}
		return creditList;
	}

	public int createCredit(Credit credit) {
		newId = generateNewId();
		credit.setCreditId(newId);
		// set credit ID so it can be foreign key in customer and product DB
		credit.getCustomer().setCreditId(newId);
		credit.getProduct().setCreditId(newId);
		creditDao.add(credit);
		restTemplate.postForObject("http://product-service:8082/createProduct/", credit.getProduct(), Product.class);
		restTemplate.postForObject("http://customer-service:8083/createCustomer/", credit.getCustomer(), Customer.class);
//		restTemplate.postForObject("http://localhost:8082/createProduct/", credit.getProduct(), Product.class);
//		restTemplate.postForObject("http://localhost:8083/createCustomer/", credit.getCustomer(), Customer.class);

		return credit.getCreditId();
	}

	/**
	 * Get all credits, find max, create new ID with value max++
	 * 
	 * @return new ID for credit
	 */
	private int generateNewId() {
		creditList = creditDao.getAll();
		if (creditList.isEmpty())
			return 1;
		else
			return Collections.max(creditList, Comparator.comparing(c -> c.getCreditId())).getCreditId() + 1;
	}

}
