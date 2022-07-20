package dsi.senior.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.Meal;
import dsi.senior.entities.Menu;
import dsi.senior.services.MenuServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class MenuController {

	
	@Autowired
	MenuServiceImpl menuservice;
	
			//creating post mapping method that insert Menu into database
				 @PostMapping("/add-Menu")
				 @Operation(security = {@SecurityRequirement(name = "bearer-key")})		
				 public List<Menu> addMenu (@RequestBody Menu m) {
					return menuservice.addToMenu(m);
				 }
		 
			//creating a get mapping that retrieves all the Menus details from the database   
				@GetMapping("/get-all-Menus")
				@Operation(security = {@SecurityRequirement(name = "bearer-key")})
				@ResponseBody
				public List<Menu>  getAllProduct() {
					return menuservice.getMenus();
				}
				
			//creating delete mapping method that delete Menu from database
			 @DeleteMapping("/remove-Menu/{idMenu}")
			 @Operation(security = {@SecurityRequirement(name = "bearer-key")})		
			 public void removeMenu (@PathVariable("idMenu")long idMenu) {
				 menuservice.deleteMenu(idMenu);
			 }
			 
			//creating put mapping that updates the Meal detail  
			 @PutMapping("/update-Menu/{idMenu}")
			 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
			 @ResponseBody
				public void updateMenu(
					@RequestBody Menu Menu,@PathVariable("idMenu")int idMenu) {
				 menuservice.updateMenu(idMenu,Menu);
				    
					
				}
}
