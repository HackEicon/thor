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

import br.com.llongo.persistence.entities.Categorys;
import br.com.llongo.persistence.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class Category {

	private CategoryRepository categoryRepository;

	@Autowired
	public Category(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<Categorys> getAllCategorys() {
		List<Categorys> findAll = categoryRepository.findAll();
		return findAll;
	}

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Categorys getCategoryById(@PathVariable Integer id) {
    	Categorys one = categoryRepository.findOne(id);
    	return one;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/bycategory/{name}")
    public List<Categorys> getCategoryByName(@PathVariable String name) {
    	List<Categorys> one = categoryRepository.findByCategoryname(name);
    	return one;
    }
	
	@RequestMapping(value="/create",method = RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Categorys> creatCategory(@RequestBody Categorys category, UriComponentsBuilder builder){
		Categorys save = categoryRepository.save(category);
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(
                builder.path("/aggregators/orders/{id}")
                        .buildAndExpand(save.getId().toString()).toUri());
        return new ResponseEntity<Categorys>(save, headers, HttpStatus.CREATED);
	}
}
