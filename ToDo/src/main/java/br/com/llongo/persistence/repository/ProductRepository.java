package br.com.llongo.persistence.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.llongo.persistence.entities.Products;


public interface ProductRepository extends JpaRepository<Products, Integer>{

	@Override
	@Query("SELECT x FROM Products x where  x.id = :id")
	public Products findOne(@Param("id") Integer id);

	@Override
	@Transactional
	public Products save(Products product);
	
	public List<Products> findByProductname(String productname);
	
}
