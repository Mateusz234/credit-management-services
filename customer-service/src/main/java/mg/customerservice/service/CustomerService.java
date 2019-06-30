package mg.customerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.customerservice.dao.CustomerDao;
import mg.customerservice.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	public Customer getCustomerById(int creditId) {
		return customerDao.getCustomerById(creditId);
	}
	
	public void createCustomer(Customer customer) {
		customerDao.add(customer);
		//TODO make it return 1 if created fine or -1 if there is trouble.
	}
	
}
