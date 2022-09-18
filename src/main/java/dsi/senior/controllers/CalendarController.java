package dsi.senior.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.Calendar;
import dsi.senior.services.ICalendarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

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
  	
}
