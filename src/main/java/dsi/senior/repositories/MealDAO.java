package dsi.senior.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.Meal;

@Repository
public interface MealDAO extends CrudRepository<Meal, Long> {
	
	@Query("SELECT m FROM Meal m WHERE m.label LIKE %?1%  OR m.description LIKE %?1% ")
	public List<Meal> findByKeyword (String keyword);
	

}
