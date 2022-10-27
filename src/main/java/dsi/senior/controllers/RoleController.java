package dsi.senior.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.Role;
import dsi.senior.services.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RoleController {
	
    @Autowired
    private RoleService roleService;
   
    
    
    @CrossOrigin(origins ="http://localhost:4200" ,methods = {RequestMethod.GET} )
	@GetMapping(value = "/retrieves-all-role")
	@ResponseBody
	public List<Role> getallrole() {
		List<Role> list = roleService.retreiveAllrole();
		return list;
	}
	
  	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
 
	@DeleteMapping("/delete-role/{id}")
  	@ResponseBody
  	public ResponseEntity<String>  deleteRenting(@PathVariable("id")Integer id) {
		roleService.Deleterole(id);
  	    return new ResponseEntity<String>("Piece deleted successfully",HttpStatus.ACCEPTED);
  		
  	}
	
}