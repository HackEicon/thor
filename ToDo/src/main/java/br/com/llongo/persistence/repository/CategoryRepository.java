package br.com.llongo.persistence.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.llongo.persistence.entities.Categorys;

public interface  CategoryRepository extends JpaRepository<Categorys, Integer>{
	@Override
	@Query("SELECT x FROM Categorys x where  x.id = :id")
	public Categorys findOne(@Param("id") Integer id);

	@Override
	@Transactional
	public Categorys save(Categorys category);
	
	public List<Categorys> findByCategoryname(String categoryname);
}
