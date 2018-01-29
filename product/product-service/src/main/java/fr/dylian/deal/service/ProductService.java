package fr.dylian.deal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dylian.deal.api.ProductApi;
import fr.dylian.deal.model.Product;
import fr.dylian.deal.repository.ProductRepository;

@Service	
public class ProductService implements ProductApi {
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(long productId) {
		return productRepository.findOne(productId);
	}

	public Product createProduct(Product product) throws Exception {
		validateProduct(product);
		
		return productRepository.save(product);
	}

	public void deleteProduct(long productId) {
		Product product = productRepository.findOne(productId);
		if (product != null) {
			productRepository.delete(product);
		}
	}

	private void validateProduct(Product product) throws Exception {
		if (product.getPrice() < 0 ) {
			throw new Exception();
		}
	}
}
