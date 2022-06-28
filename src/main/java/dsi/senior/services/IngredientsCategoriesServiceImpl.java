package dsi.senior.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.IngredientsCategories;
import dsi.senior.repositories.IngredientsCategoriesDAO;

@Service
public class IngredientsCategoriesServiceImpl {

	@Autowired
	IngredientsCategoriesDAO ingcatDao;
	
	
	public void addIngredientCategory (IngredientsCategories cat) {
		
		ingcatDao.save(cat);
	}
	
	public List<IngredientsCategories> getAllCategories(){
		List<IngredientsCategories> categories = (List<IngredientsCategories>) ingcatDao.findAll();
		return categories;
	}
	
	
}
