package dsi.senior.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.Symptoms;
import dsi.senior.services.ISymptomsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class SymptomController {

	@Autowired
	private ISymptomsService iSymptomsService;

	// http://localhost:8081/api/getAllSymptoms
	@GetMapping("/retrieveAllSymptoms")
	@ResponseBody
	@Operation(security = { @SecurityRequirement(name = "bearer-key") })
	public List<Symptoms> retrieveAllSymptoms() {
		List<Symptoms> symp = new ArrayList<>();
		for (Symptoms s : iSymptomsService.retreiveAllSymtoms()) {
			symp.add(s);

		}

		return symp;
	}

	// http://localhost:8081/api/findSymptomById
	@GetMapping("/findSymptomById/{idSymptom}")
	@ResponseBody
	@Operation(security = { @SecurityRequirement(name = "bearer-key") })
	public Symptoms findSymptomById(@PathVariable("idSymptom") int idSymptom) {
		return iSymptomsService.retrieveSymptomById(idSymptom);
	}

	// http://localhost:8081/api/findSymptomByLabel
	@GetMapping("/findSymptomByLabel/{label}")
	@ResponseBody
	@Operation(security = { @SecurityRequirement(name = "bearer-key") })
	public Symptoms findSymptomByLabel(@PathVariable("label") String label) {
		return iSymptomsService.findSymptomByLabel(label);
	}

	// http://localhost:8081/api/findSymptomBybodyPart
	@GetMapping("/findSymptomByBodyPart/{body_id}")
	@ResponseBody
	@Operation(security = { @SecurityRequirement(name = "bearer-key") })
	public List<Symptoms> findSymptomByBodyParts(@PathVariable("body_id") long body_id) {
		return iSymptomsService.findSymptomsByPartId(body_id);
	}

	// http://localhost:8081/api/updateSenior
	@PutMapping("/updateSymptoms/{symptomsIDs}")
	@ResponseBody
	public List<Symptoms> updateSymptoms(@PathVariable("symptomsIDs") List<String> symptomsIDs) {
		System.out.println("Symptomsiii"+symptomsIDs);
		return iSymptomsService.updateSymptoms(symptomsIDs);

	}

}
