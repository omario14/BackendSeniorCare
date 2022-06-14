package dsi.senior.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dsi.senior.entities.FileDB;
import dsi.senior.entities.Senior;
import dsi.senior.services.FileStorageService;
import dsi.senior.services.ISeniorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
public class SeniorController {
	
	@Autowired
	ISeniorServiceImpl seniorServiceImpl;
	
	 @Autowired
	  private FileStorageService storageService;
	
	// http://localhost:8081/api/addSenior
		@PostMapping("/addSenior")
		@ResponseBody
		 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
		public long addSenior(@RequestBody Senior s) throws Exception{
			
			 
		      
			return seniorServiceImpl.addSenior(s);
			
	}
		
		

	// http://localhost:8081/api/removeSenior
		@DeleteMapping("/removeSenior/{idSenior}")
		@ResponseBody
		 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
		public void deleteDel(@PathVariable ("idSenior") long id) {
			seniorServiceImpl.deleteSenior(id);
		}
		
		
	// http://localhost:8081/api/updateSenior
  	@PutMapping("/updateSenior/{idSenior}")
  	@ResponseBody
	 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  	public ResponseEntity<String> updateSenior(
  		@RequestBody Senior sa,@PathVariable("idSenior")int idSenior) {
  		seniorServiceImpl.updateSenior(sa,idSenior);
  	    return new ResponseEntity<String>("Ray updated successfully",HttpStatus.OK);
  		
  	}
	
  	
  	// http://localhost:8081/api/getAllSeniors
  	@GetMapping("/retrieveAllSeniors")
  	@ResponseBody
  	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
  	public List<Senior>  retrieveAllSeniors() {
  		List<Senior> seniors = new ArrayList<>();
  		for(Senior s : seniorServiceImpl.retrieveAllSenior()) {
  			seniors.add(s);
  			
  		}
  		
  		return seniors;
  	}
  	
  	
  	// http://localhost:8081/api/findSeniorById
 	 @GetMapping("/findSeniorById/{idSenior}")
 	@ResponseBody
	 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
 		public Senior findSeniorById(@PathVariable("idSenior")int idSenior) {
 			return seniorServiceImpl.retrieveSeniorById(idSenior);
 		}
 	 
 	// http://localhost:8081/api/findSeniorByName
 		 @GetMapping("/findSeniorByName/{name}")
 		@ResponseBody
		 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
 			public Senior findSeniorByName(@PathVariable("name")String name) {
 				return seniorServiceImpl.findSeniorByName(name);
 			}
 		 
 	// http://localhost:8081/api/findSeniorByResidance
 		 @GetMapping("/findSeniorByResidance/{resid}")
 		 @ResponseBody
 		 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
 			public List<Senior> findSeniorByResidance(@PathVariable("resid")String residance) {
 				return seniorServiceImpl.findByResidance(residance);
 			}
  	
	
	

}
