package dsi.senior.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.EMealType;
import dsi.senior.entities.Ingredients;
import dsi.senior.entities.Meal;
import dsi.senior.entities.MealType;
import dsi.senior.repositories.IngredientsDAO;
import dsi.senior.repositories.MealDAO;
import dsi.senior.repositories.MealTypeDao;
import dsi.senior.services.IIngredientsService;
import dsi.senior.services.IMealService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import request.mealRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MealController {

	@Autowired
	IMealService mealService;
	
	@Autowired
	MealDAO mealrepository;
	@Autowired
	MealTypeDao  mealTypeDao;
	
	@Autowired
	IngredientsDAO ingredientsDao;
	
	@Autowired
	IIngredientsService ingredientsService;
	
	//creating post mapping method that insert Meal into database
	 @PostMapping("/add-Meal")
	 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	 @ResponseBody
	 public void addMeal(@RequestBody mealRequest m) {
		 Set<Long> ingredientsIds =  m.getIngredients();
		 Set<Ingredients> ingredients =  new HashSet<>();
		 
		 ingredientsIds.forEach(ingId-> {
		 Ingredients ingred = ingredientsService.getIngredientById(ingId);
		 ingredients.add(ingred);
		 });
		 
		Meal meal=new Meal(
				m.getLabel(),
				m.getDescription(),
				m.getImage(),
				ingredients);
		String typeM = m.getType();
		MealType type=new MealType();
		
		switch (typeM) {
		
		case "BREAKFAST":
			MealType mtype1 = mealTypeDao.findBylabel(EMealType.BREAKFAST);
			type=mtype1;
			break;
		case "DESSERTS":
			MealType mtype2 = mealTypeDao.findBylabel(EMealType.DESSERTS);
			type=mtype2;
			break;
		case "LUNCH":
			MealType mtype3 = mealTypeDao.findBylabel(EMealType.LUNCH);
			type=mtype3;
			break;
		case "DINNER":
			MealType mtype4 = mealTypeDao.findBylabel(EMealType.DINNER);
			type=mtype4;
			break;
		case "DRINKS":
			MealType mtype5 = mealTypeDao.findBylabel(EMealType.DRINKS);
			type=mtype5;
			break;
		default:
			MealType mtype = mealTypeDao.findBylabel(EMealType.OTHER);
			type=mtype;
			break;
		}
		meal.setType(type);
		 mealService.addMeal(meal);
		 ingredientsDao.mettreaZeroChecked();

	}
	 
	//creating put mapping that updates the Meal detail  
	 @PutMapping("/update-Meal/{idMeal}")
	 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	 @ResponseBody
		public void updateMeal(
			@RequestBody mealRequest m,@PathVariable("idMeal")long idMeal) {
		 Set<Long> ingredientsIds =  m.getIngredients();
		 Set<Ingredients> ingredients =  new HashSet<>();
		 
		 ingredientsIds.forEach(ingId-> {
		 Ingredients ingred = ingredientsService.getIngredientById(ingId);
		 ingredients.add(ingred);
		 });
		 
		Meal meal=new Meal(
				m.getLabel(),
				m.getDescription(),
				m.getImage(),
				ingredients);
		String typeM = m.getType();
		MealType type=new MealType();
		
		switch (typeM) {
		
		case "BREAKFAST":
			MealType mtype1 = mealTypeDao.findBylabel(EMealType.BREAKFAST);
			type=mtype1;
			break;
		case "DESSERTS":
			MealType mtype2 = mealTypeDao.findBylabel(EMealType.DESSERTS);
			type=mtype2;
			break;
		case "LUNCH":
			MealType mtype3 = mealTypeDao.findBylabel(EMealType.LUNCH);
			type=mtype3;
			break;
		case "DINNER":
			MealType mtype4 = mealTypeDao.findBylabel(EMealType.DINNER);
			type=mtype4;
			break;
		case "DRINKS":
			MealType mtype5 = mealTypeDao.findBylabel(EMealType.DRINKS);
			type=mtype5;
			break;
		default:
			MealType mtype = mealTypeDao.findBylabel(EMealType.OTHER);
			type=mtype;
			break;
		}
		meal.setType(type);
		 mealService.updateMeal(meal,idMeal);
		    
			
		}
		
	  //creating a delete mapping that delete data from database
		@DeleteMapping("/delete-Meal/{idMeal}")
		@Operation(security = {@SecurityRequirement(name = "bearer-key")})
		@ResponseBody
		public ResponseEntity<String>  deleteProduct(@PathVariable("idMeal")long idMeal) {
			mealService.deleteMeal(idMeal);
		    return new ResponseEntity<String>("Meal deleted successfully",HttpStatus.ACCEPTED);
			
		}
		//creating a get mapping that retrieves all the Meal details from the database   
		@GetMapping("/get-all-Meal")
		@Operation(security = {@SecurityRequirement(name = "bearer-key")})
		@ResponseBody
		public List<Meal>  getAllProduct() {
			return mealService.getAllMeals();
		}
		
}
