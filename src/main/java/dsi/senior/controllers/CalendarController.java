package dsi.senior.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.Calendar;
import dsi.senior.services.ICalendarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import request.EventRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CalendarController {

	@Autowired
	ICalendarService calendarService;
	
	 //creating a get mapping that retrieves all calendar events  from database.
  	@GetMapping("/getCalendar")
  	@ResponseBody
  	@Operation(security = { @SecurityRequirement(name = "bearer-key") })
  	public List<Calendar>  getCalendar() {
  		
  		return calendarService.getCalendar();
  	}
  	
  	
  	// http://localhost:8081/api/updateCalendar
  	@PutMapping("/updateCalendar")
  	@ResponseBody
	 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  	public ResponseEntity<String> updateCalendar(@RequestBody EventRequest event) {
  		calendarService.addToCalendar(event);
  		
  	    return new ResponseEntity<String>("Calendar updated successfully",HttpStatus.OK);
  		
  	}
  	
 // http://localhost:8081/api/deleteEvent
   	@DeleteMapping("/deleteEvent/{idEvent}")
   	@ResponseBody
 	 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
   	public ResponseEntity<String> deleteEvent (@PathVariable String idEvent) {
   		calendarService.removeEvent(idEvent);
   		
   	    return new ResponseEntity<String>("Calendar updated successfully",HttpStatus.OK);
   		
   	}
   	
   	
  //creating a get mapping that retrieves all seniors events from database.
  	@GetMapping("/getCalendar-bysenior/{idSenior}")
  	@ResponseBody
  	public List<Calendar>  getAllCalendarsSenior(@PathVariable("idSenior")long idSenior) {
  		
  		return calendarService.findCalendarBySenior(idSenior);
  	}
  	
  	
}
