package dsi.senior.services;

import java.util.List;

import dsi.senior.entities.Ingredients;


public interface IIngredientsService  {
	
	/**********************Creating add method that insert Ingredient into database***************/
	void addIngredient(Ingredients ing);

	/****************Creating update method that upgrade Ingredient from database*****************/
	void updateIngredient(Ingredients ing, long idIngredient);

	/*******************Creating deleting method that remove Ingredient by id  from database*********/
	void deleteIngredient(long idIngredient);
	
	/***************Creating getAll method that retrieve all Ingredient from database **************/
	List<Ingredients> getAllIngredients();

	/**************Creating getByid method that retrieve Ingredient detail from database************/
	Ingredients getIngredientById(long id);

	/***************Creating getAll Ingredient by category method from database **************/
	List<Ingredients> getIngredientsByCategory(String categoryName);
	
	int checkExpirationDate(Ingredients p) ;

	/***************Creating getAll method that retrieve all Ingredient from database **************/
	List<Ingredients> getAllIngredients(int pageNo, int pageSize);
	
	public int findCategoryByIngredient(int idp);
	
	List<Ingredients> getAllIngredientsByPopularity();

	boolean checkBarCode(String s);

}
