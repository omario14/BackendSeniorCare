package dsi.senior.controllers;



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.ArchiveMedication;
import dsi.senior.services.ArchiveMedServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
public class ArchiveMedController {
	
	@Autowired
	ArchiveMedServiceImpl archmedService;
	
 	@PutMapping("/addabc/{idArch}/{idMed}/{done}")
  	@ResponseBody
  	public ResponseEntity<String> addArchMed(@PathVariable("idArch")String idArch,@PathVariable("idMed")long idMed,@PathVariable("done")boolean done) {
		System.out.println("----------------------"+idMed);
  		archmedService.ajouterArchiveMedic(idArch,idMed,done);
  	    return new ResponseEntity<String>("add Medication to archive updated successfully",HttpStatus.OK);
  		
  	}
  	 //creating a get mapping that retrieves all categories from database.
  	@GetMapping("/deleteMeds-byArch/{idMed}")
  	@ResponseBody
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
  	public ResponseEntity<String>   deleteMedsByArch(@PathVariable("idMed") long idMed) {
  		
  		 archmedService.deleteArchMeds(idMed);
  		return new ResponseEntity<String>("addabc updated successfully",HttpStatus.OK);
  	}
  	
  	
  	 //creating a get mapping that retrieves all MedsByArch from database.
  	@GetMapping("/getMedications-byArch/{idArch}")
  	@ResponseBody
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
  	public Set<ArchiveMedication>   getMedsFromArchive(@PathVariable("idArch") String idArch) {
  		
  		return  archmedService.getAllMedsByArchive(idArch);
  		
  	}
}
