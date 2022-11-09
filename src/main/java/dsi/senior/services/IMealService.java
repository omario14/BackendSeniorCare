package dsi.senior.services;

import java.util.List;

import dsi.senior.entities.Meal;

public interface IMealService {
	
	/**********************Creating add method that insert Meal into database***************/
	void addMeal(Meal m);

	/****************Creating update method that upgrade Meal from database*****************/
	void updateMeal(Meal m, long idMeal);


	/***************Creating getAll method that retrieve all Meal from database **************/
	List<Meal> getAllMeals();

	/**************Creating getByid method that retrieve Meal detail from database************/
	Meal getMealById(long id);

	/***************Creating getAll Meal by category method from database **************/
	List<Meal> getMealsByCategory(String categoryName);

}
