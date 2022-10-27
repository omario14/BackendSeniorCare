package dsi.senior.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.IngredientsCategories;
import dsi.senior.services.IngredientsCategoriesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin
@RestController
public class IngredientsCategoriesController {
	
	@Autowired
	IngredientsCategoriesServiceImpl categoryService;
	
	@PostMapping({"/createNewCategoryING"})
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
    public void createNewRole(@RequestBody IngredientsCategories cat) {
         categoryService.addIngredientCategory(cat);
    }
	
	@GetMapping(value = "/retrieves-all-ingredients-categories")
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@ResponseBody
	public List<IngredientsCategories> getallcat() {
		List<IngredientsCategories> list = categoryService.getAllCategories();
		return list;
	}

}
