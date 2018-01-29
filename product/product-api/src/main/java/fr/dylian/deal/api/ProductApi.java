package fr.dylian.deal.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.dylian.deal.model.Product;

@RestController
@RequestMapping(value="/products")
public interface ProductApi {

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> getProducts();

	@RequestMapping(method = RequestMethod.GET, value = "/{productId}")
	public Product getProduct(@PathVariable long productId);

	@RequestMapping(method = RequestMethod.POST)
	public Product createProduct(@Valid @RequestBody Product product) throws Exception;

	@RequestMapping(method = RequestMethod.DELETE, value = "/{productId}")
	public void deleteProduct(@PathVariable long productId);
}
