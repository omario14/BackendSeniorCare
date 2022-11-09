package dsi.senior.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.Notification;
import dsi.senior.services.INotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class NotificationController {

	@Autowired
	INotificationService notifService;

	// http://localhost:8081/api/addNotif
	@PostMapping("/addnotif")
	@ResponseBody
	@Operation(security = { @SecurityRequirement(name = "bearer-key") })
	public ResponseEntity<String> addNotification(@RequestBody Notification notif) {
		notifService.addNotification(notif);

		return new ResponseEntity<String>("Notification added successfully", HttpStatus.OK);

	}

	// creating a get mapping that retrieves all Notifications from database.
	@GetMapping("/getall-Notifications")
	@ResponseBody
	@Operation(security = { @SecurityRequirement(name = "bearer-key") })
	public Set<Notification> getAllNotifications() {

		return notifService.getNotifications();
	}

	// creating a get mapping that getNotifByUser from database.
	@GetMapping("/getnotif-byuser/{user}")
	@ResponseBody
	public Set<Notification> getNotifByUser(@PathVariable("user") String user) {

		return notifService.getNotifByUser(user);
	}

	//creating a delete mapping that delete data from database
	@DeleteMapping("/delete-notification/{id}")
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@ResponseBody
	public ResponseEntity<String>  deleteNotif(@PathVariable("id")long id) {
		notifService.deleteNotification(id);
	    return new ResponseEntity<String>("Notification deleted successfully",HttpStatus.ACCEPTED);
		
	}
}
