package mg.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.productservice.dao.ProductDao;
import mg.productservice.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;

	public Product getProductById(int creditId) {
		return productDao.getProductById(creditId);

	}

	public void createProduct(Product product) {
		productDao.add(product);
	}

}
