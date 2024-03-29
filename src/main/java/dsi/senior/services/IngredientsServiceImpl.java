package dsi.senior.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.Ingredients;
import dsi.senior.repositories.IngredientsDAO;

@Service
public class IngredientsServiceImpl implements IIngredientsService {

	@Autowired
	IngredientsDAO ingRepository;
	
	@Override
	public void addIngredient(Ingredients ing) {
		ingRepository.save(ing);
	}

	@Override
	public void updateIngredient(Ingredients ing, long idIngredient) {
		Ingredients ingredient = ingRepository.findById(idIngredient).get();
		ingredient.setLabel(ing.getLabel());
		ingredient.setChecked(ing.isChecked());
		ingredient.setDescription(ing.getDescription());
		ingredient.setCategory(ing.getCategory());
		ingRepository.save(ingredient);
		
	}

	@Override
	public void deleteIngredient(long idIngredient) {
		 ingRepository.deleteById(idIngredient);
	}

	@Override
	public List<Ingredients> getAllIngredients() {
		
		return (List<Ingredients>)ingRepository.findAll();
	}

	@Override
	public Ingredients getIngredientById(long id) {
		return ingRepository.findById(id).get();
	}

	@Override
	public List<Ingredients> getIngredientsByCategory(String categoryName) {
		List<Ingredients> ingredientsList = new ArrayList<>();
		List<Ingredients> getIngredients = (List<Ingredients>) ingRepository.findAll();
		for(Ingredients ing : getIngredients) {
			if(ing.getCategory().getLabel().equals(categoryName)) {
				ingredientsList.add(ing);
			}
		}
		return ingredientsList;
		
	}



}
