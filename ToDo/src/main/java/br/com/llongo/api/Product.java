package br.com.llongo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.llongo.persistence.entities.Products;
import br.com.llongo.persistence.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class Product {

	private ProductRepository productsRepository;

	@Autowired
	public Product(ProductRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	@RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<Products> getAllProducts() {
		List<Products> findAll = productsRepository.findAll();
		return findAll;
	}

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Products getProductById(@PathVariable Integer id) {
    	Products one = productsRepository.findOne(id);
    	return one;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/byproduct/{name}")
    public List<Products> getProductByName(@PathVariable String name) {
    	List<Products> one = productsRepository.findByProductname(name);
    	return one;
    }
	
	@RequestMapping(value="/create",method = RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Products> creatProduct(@RequestBody Products product, UriComponentsBuilder builder){
		Products save = productsRepository.save(product);
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(
                builder.path("/aggregators/orders/{id}")
                        .buildAndExpand(save.getId().toString()).toUri());
        return new ResponseEntity<Products>(save, headers, HttpStatus.CREATED);
	}
}
