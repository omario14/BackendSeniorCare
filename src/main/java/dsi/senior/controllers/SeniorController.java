package dsi.senior.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import dsi.senior.entities.Senior;
import dsi.senior.repositories.SeniorDao;
import dsi.senior.services.ISeniorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
public class SeniorController {
	
	@Autowired
	ISeniorServiceImpl seniorServiceImpl;
	@Autowired
	SeniorDao seniorDao;
	
	// http://localhost:8081/api/addSenior
		@PostMapping("/addSenior")
		@ResponseBody
		 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
		public Senior addSenior(@RequestBody Senior s) throws Exception{
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
 		 
 		@DeleteMapping("/deleteSeniorsByIds/{ids}")
		@ResponseBody
		 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
 		public ResponseEntity<?> deleteByIds(@PathVariable("ids") List<String> ids){
 			 ids.forEach(d->{
 				 if(seniorServiceImpl.existByid(Long.parseLong(d))){
 					seniorServiceImpl.deleteSenior(Long.parseLong(d));
 				 }
 			 });
 			 return ResponseEntity.ok().body("Customers has been removed");
 		}
 		
 	// http://localhost:8081/api/removeSenior
 			@DeleteMapping("/removeAllSeniors")
 			@ResponseBody
 			 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
 			public void deleteAllSeniors() {
 				seniorServiceImpl.deleteAllSenior();
 			}
 			
 		
 		// http://localhost:8081/api/updateSenior
 		  	@PutMapping("/addMenuSenior/{idsenior}")
 		  	@ResponseBody
 			 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
 		  	public ResponseEntity<String> addMenuSenior(@PathVariable("idsenior")long idSenior) {
 		  		seniorServiceImpl.addMenuSenior(idSenior);
 		  	    return new ResponseEntity<String>("Senior updated successfully",HttpStatus.OK);
 		  		
 		  	}
  	
 			@GetMapping(value = "/senior-numbers")
 			@Operation(security = {@SecurityRequirement(name = "bearer-key")})
 			@ResponseBody
 			public long seniorNumber() {
 				return seniorDao.seniors();
 			}
 			
 			@GetMapping(value = "/calcul-bmi/{weight}/{height}")
 			@Operation(security = {@SecurityRequirement(name = "bearer-key")})
 			@ResponseBody
 			public double calculBMI(@PathVariable("weight")double weight,@PathVariable("height")double height) {
 				return seniorServiceImpl.calculBMI(weight,height);
 			}
 			
 			@GetMapping(value = "/count-interests")
 			@Operation(security = {@SecurityRequirement(name = "bearer-key")})
 			@ResponseBody
 			public Map<String, Long> centreDinteret() {
 				return seniorServiceImpl.centreDinteret();
 			}
	

}
