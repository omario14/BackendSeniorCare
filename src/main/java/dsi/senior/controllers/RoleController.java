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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.Role;
import dsi.senior.services.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@CrossOrigin
@RestController

public class RoleController {
	
    @Autowired
    private RoleService roleService;
    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
    
    
    @CrossOrigin(origins ="http://localhost:4200" ,methods = {RequestMethod.GET} )
	@GetMapping(value = "/retrieves-all-role")
	@ResponseBody
	public List<Role> getallrole() {
		List<Role> list = roleService.retreiveAllrole();
		return list;
	}
	  //creating a put  mapping that upgrade rent annonce
	@PutMapping("/update-role/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updateRentAnnonce(
  		@RequestBody Role role,@PathVariable("id")Integer id) {
  		roleService.updateRole(role,id);
  		return new ResponseEntity<String>("Piece updated successfully",HttpStatus.OK);
  		
  	}
  	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
 
	@DeleteMapping("/delete-role/{id}")
  	@ResponseBody
  	public ResponseEntity<String>  deleteRenting(@PathVariable("id")Integer id) {
		roleService.Deleterole(id);
  	    return new ResponseEntity<String>("Piece deleted successfully",HttpStatus.ACCEPTED);
  		
  	}
	
}