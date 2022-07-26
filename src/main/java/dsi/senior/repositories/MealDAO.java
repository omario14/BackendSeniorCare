package dsi.senior.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.Meal;

@Repository
public interface MealDAO extends CrudRepository<Meal, Long> {
	
	@Query("SELECT m FROM Meal m WHERE m.label LIKE %?1%  OR m.description LIKE %?1% ")
	public List<Meal> findByKeyword (String keyword);
	
	@Transactional
	@Modifying
	@Query("UPDATE Meal m SET m.checkedBreakfast=0 , m.checkedLunch=0 , m.checkedDinner=0 ")
	public void mettreaZeroChecked ();
	
	

}
