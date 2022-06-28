package dsi.senior.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.IngredientsCategories;

@Repository
public interface IngredientsCategoriesDAO extends CrudRepository<IngredientsCategories,Long>{
	

}
