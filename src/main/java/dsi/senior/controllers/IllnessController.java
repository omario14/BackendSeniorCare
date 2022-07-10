package dsi.senior.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.Illnesses;
import dsi.senior.services.IIllnessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class IllnessController {
	
	@Autowired
	private IIllnessService iIllnessService;
	
	// http://localhost:8081/api/getAllSymptoms
  	@GetMapping("/retrieveAllIllnesses")
  	@ResponseBody
  	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
  	public List<Illnesses>  retrieveAllIllnesses() {
  		List<Illnesses> illness = new ArrayList<>();
  		for(Illnesses ill : iIllnessService.retreiveAllIllnesses()) {
  			illness.add(ill);
  			
  		}
  		
  		return illness;
  	}
  	
  	// http://localhost:8081/api/findIllnessById
  	 @GetMapping("/findIllnessById/{idIllness}")
  	@ResponseBody
 	 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  		public Illnesses findIllnessById(@PathVariable("idIllness")int idIllness) {
  			return iIllnessService.retrieveIllnessById(idIllness);
  		}
  	 
  	 // http://localhost:8081/api/findSymptomByLabel
		 @GetMapping("/findIllnessByLabel/{label}")
		@ResponseBody
	 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
			public Illnesses findIllnessByLabel(@PathVariable("label")String label) {
				return iIllnessService.findIllnessByLabel(label);
			}
		 

}
