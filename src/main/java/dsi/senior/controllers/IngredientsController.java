package dsi.senior.controllers;

import java.util.List;
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

import dsi.senior.entities.Ingredients;
import dsi.senior.services.IIngredientsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin
@RestController
public class IngredientsController {
	
	@Autowired
	IIngredientsService ingredientsServices;
	
	//creating post mapping method that insert ingredient into database
		 @PostMapping("/add-ingredient")
		 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
		 @ResponseBody
		 public void addIngredient(@RequestBody Ingredients ing) {
			    ingredientsServices.addIngredient(ing);
	
		}
		 
		//creating put mapping that updates the ingredient detail  
		 @PutMapping("/update-ingredient/{idIngredient}")
		 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
		 @ResponseBody
			public void updateIngredient(
				@RequestBody Ingredients ingredient,@PathVariable("idIngredient")int idIngredient) {
			    ingredientsServices.updateIngredient(ingredient,idIngredient);
			    
				
			}
		  //creating a delete mapping that delete data from database
			@DeleteMapping("/delete-ingredient/{idIngredient}")
			@Operation(security = {@SecurityRequirement(name = "bearer-key")})
			@ResponseBody
			public ResponseEntity<String>  deleteProduct(@PathVariable("idIngredient")long idIngredient) {
				ingredientsServices.deleteIngredient(idIngredient);
			    return new ResponseEntity<String>("Ingredient deleted successfully",HttpStatus.ACCEPTED);
				
			}
			//creating a get mapping that retrieves all the ingredient details from the database   
			@GetMapping("/get-all-ingredient")
			@Operation(security = {@SecurityRequirement(name = "bearer-key")})
			@ResponseBody
			public List<Ingredients>  getAllProduct() {
				
				return ingredientsServices.getAllIngredients();
			}
			
			
			//creating a get mapping that retrieves a specific ingredient by cat
			@GetMapping("/get-ingredientbyCategory/{category}")
			@Operation(security = {@SecurityRequirement(name = "bearer-key")})
			@ResponseBody
			public List<Ingredients> getIngredientByCat(@PathVariable("category")String categoryName) {
				
				return ingredientsServices.getIngredientsByCategory(categoryName);
			}

}
