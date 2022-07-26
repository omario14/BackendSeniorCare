package dsi.senior.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.Ingredients;

@Repository
public interface IngredientsDAO extends CrudRepository<Ingredients, Long> {

	@Query("SELECT i FROM Ingredients i WHERE i.label LIKE %?1%  OR i.description LIKE %?1% ")
	public List<Ingredients> findAll (String keyword);
	
	@Transactional
	@Modifying
	@Query("UPDATE Ingredients i SET i.checked=0 ")
	public void mettreaZeroChecked ();
}
