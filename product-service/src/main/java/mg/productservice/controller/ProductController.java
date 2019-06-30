package mg.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mg.productservice.entity.Product;
import mg.productservice.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(method=RequestMethod.POST, value="/createProduct")
	public void createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		// TODO make it return value to say succes or not
//		return 10;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getProduct/{creditId}")
	public Product getProduct(@PathVariable("creditId") int creditId) {
		return productService.getProductById(creditId);
	}
	
}
