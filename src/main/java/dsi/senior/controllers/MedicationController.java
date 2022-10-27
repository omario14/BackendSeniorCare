package dsi.senior.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.Medication;
import dsi.senior.services.IMedicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MedicationController {
	
	@Autowired
	IMedicationService medicationService;
	
	
			// http://localhost:8081/api/addMedication
			@PostMapping("/addMedication")
			@ResponseBody
			 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
			public Medication addMedication(@RequestBody Medication medication) throws Exception{
				 return medicationService.newMedication(medication);
				
			}
			
			
			
			// http://localhost:8081/api/getAllMedications
		  	@GetMapping("/getAllMedications")
		  	@ResponseBody
		  	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
		  	public Set<Medication>  getAllMedications() {
		  		return medicationService.getAllMedication();
		  	}
		  	
		
		  	
		 // http://localhost:8081/api/getMedicationsBySenior
		  	@GetMapping("/getMedicationsBySenior/{idSenior}")
		  	@ResponseBody
		  	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
		  	public Set<Medication>  getMedicationsBySenior(@PathVariable("idSenior") long idSenior) {
		  		System.out.println("idSenior"+idSenior);
		  		return medicationService.getMedicationBySenior(idSenior);
		  	}
		  	
		  	
		  	@DeleteMapping("/deleteMedicationById/{idmed}")
			@ResponseBody
			 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	 		public ResponseEntity<?> deleteById(@PathVariable("idmed") long idmed){
	 			 
	 				 
	 				medicationService.deleteMedication(idmed);
	 			 return ResponseEntity.ok().body("Medication has been removed");
	 		}

}
