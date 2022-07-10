package dsi.senior.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.Meal;
import dsi.senior.repositories.MealDAO;

@Service
public class MealServiceImpl implements IMealService {
	
	@Autowired
	MealDAO mealRepository;

	@Override
	public void addMeal(Meal m) {
		mealRepository.save(m);
		
	}

	@Override
	public void updateMeal(Meal m, long idMeal) {
		Meal meal = mealRepository.findById(idMeal).get();
		meal.setLabel(m.getLabel());
		meal.setDescription(m.getDescription());
		meal.setType(m.getType());
		meal.setImage(m.getImage());
		mealRepository.save(meal);
		
	}

	@Override
	public long deleteMeal(long idMeal) {
		mealRepository.deleteById(idMeal);
		return idMeal;
	}

	@Override
	public List<Meal> getAllMeals() {
		
		return (List<Meal>)mealRepository.findAll();
	}

	@Override
	public Meal getMealById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meal> getMealsByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

}
