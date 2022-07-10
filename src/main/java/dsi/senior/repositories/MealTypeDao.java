package dsi.senior.repositories;

import org.springframework.data.repository.CrudRepository;

import dsi.senior.entities.EMealType;
import dsi.senior.entities.MealType;

public interface MealTypeDao extends CrudRepository<MealType, Integer> {
	

	MealType findBylabel(EMealType name);

}
