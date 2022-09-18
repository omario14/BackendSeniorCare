package dsi.senior.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.ArchiveSenior;
import dsi.senior.entities.Calendar;
import dsi.senior.services.ArchiveMedServiceImpl;
import dsi.senior.services.IArchiveSeniorService;
import dsi.senior.services.ICalendarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class ArchiveController {

	@Autowired
	IArchiveSeniorService archiveServices;
	@Autowired
	ArchiveMedServiceImpl archmedService;
	@Autowired
	ICalendarService calendarService;
		
		// http://localhost:8081/api/updateArchive
	  	@PutMapping("/updateArchive")
	  	@ResponseBody
		 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	  	public ResponseEntity<String> updateArchive(
	  		@RequestBody ArchiveSenior sa) {
	  		archiveServices.updateArchive(sa);
	  		Calendar calendar = new Calendar("food","#00bcd4","food",sa.getDate(),sa.getSenior());
	  		calendarService.addToCalendar(calendar);
	  	    return new ResponseEntity<String>("Archive updated successfully",HttpStatus.OK);
	  		
	  	}
	 
	  	
	  	
	  	
	  //creating a get mapping that retrieves all categories from database.
	  	@GetMapping("/getarchives-bysenior/{idSenior}")
	  	@ResponseBody
	  	public Set<ArchiveSenior>  getAllArchivesSenior(@PathVariable("idSenior")long idSenior) {
	  		System.out.println(idSenior);
	  		
	  		return archiveServices.getArchiveSeniorBySenior(idSenior);
	  	}
	  	
	  	
	  	
	 
}
