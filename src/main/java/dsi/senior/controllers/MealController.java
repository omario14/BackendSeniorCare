package dsi.senior.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.EMealType;
import dsi.senior.entities.Meal;
import dsi.senior.entities.MealType;
import dsi.senior.repositories.MealTypeDao;
import dsi.senior.services.IMealService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import request.mealRequest;

@RestController
public class MealController {

	@Autowired
	IMealService mealService;
	
	@Autowired
	MealTypeDao  mealTypeDao;
	
	//creating post mapping method that insert Meal into database
	 @PostMapping("/add-Meal")
	 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	 @ResponseBody
	 public void addMeal(@RequestBody mealRequest m) {
		Meal meal=new Meal(
				m.getLabel(),
				m.getDescription(),
				m.getImage());
		String typeM = m.getType();
		MealType type=new MealType();
		
		switch (typeM) {
		
		case "BREAKFAST":
			MealType mtype = mealTypeDao.findBylabel(EMealType.BREAKFAST);
			type=mtype;
			break;
		case "LUNCH":
			MealType mtype1 = mealTypeDao.findBylabel(EMealType.LUNCH);
			type=mtype1;
			break;
		default:
			MealType mtype3 = mealTypeDao.findBylabel(EMealType.DINNER);
			type=mtype3;
			break;
		}
		meal.setType(type);
		 mealService.addMeal(meal);

	}
	 
	//creating put mapping that updates the Meal detail  
	 @PutMapping("/update-Meal/{idMeal}")
	 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	 @ResponseBody
		public void updateMeal(
			@RequestBody Meal Meal,@PathVariable("idMeal")int idMeal) {
		 mealService.updateMeal(Meal,idMeal);
		    
			
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
