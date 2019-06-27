package mg.productservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mg.productservice.entity.Product;

@RestController
public class ProductController {

	@RequestMapping(method=RequestMethod.POST, value="/createProduct")
	public int createProduct() {
		return 10;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getProduct")
	public Product getProduct() {
		return new Product();
	}
	
}
