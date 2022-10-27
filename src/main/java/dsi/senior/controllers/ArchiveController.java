package dsi.senior.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dsi.senior.entities.ArchiveSenior;
import dsi.senior.entities.DoseTime;
import dsi.senior.repositories.ArchiveDao;
import dsi.senior.repositories.MedicationDao;
import dsi.senior.repositories.SeniorDao;
import dsi.senior.services.ArchiveMedServiceImpl;
import dsi.senior.services.IArchiveSeniorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import request.ArchiveSeniorRequest;
import request.DoseTimeRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ArchiveController {

	@Autowired
	IArchiveSeniorService archiveServices;
	@Autowired
	ArchiveMedServiceImpl archmedService;
	@Autowired
	ArchiveDao archiveDao;
	@Autowired
	MedicationDao medDao;
	@Autowired
	SeniorDao  seniorDao;
		
		// http://localhost:8081/api/updateArchive
	  	@PutMapping("/updateArchive")
	  	@ResponseBody
		 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	  	public ResponseEntity<String> updateArchive(
	  		@RequestBody ArchiveSeniorRequest sa) {
	  		ArchiveSenior archive = new ArchiveSenior(
	  				sa.getIdArch(),
	  				sa.getDate(),
	  				sa.isCheckedBreakfast(),
	  				sa.isCheckedLunch(),
	  				sa.isCheckedDinner(),
	  				seniorDao.findById(sa.getSenior()).get());
	  		archiveServices.updateArchive(archive);
	  		 
	        
	  	    return new ResponseEntity<String>("Archive updated successfully",HttpStatus.OK);
	  		
	  	}
	 
	  	
	  	
	  	
	  //creating a get mapping that retrieves all categories from database.
	  	@GetMapping("/getarchives-bysenior/{idSenior}")
	  	@ResponseBody
	  	public Set<ArchiveSenior>  getAllArchivesSenior(@PathVariable("idSenior")long idSenior) {
	  		
	  		
	  		return archiveServices.getArchiveSeniorBySenior(idSenior);
	  	}
	  	
	  	
	  //creating a get mapping that retrieves all doseTime from database.
	  	@GetMapping("/getall-doseTime")
	  	@ResponseBody
	  	 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	  	public List<DoseTime>  getallDoseTime() {
	  		
	  		
	  		return archiveServices.getAllDoseTime();
	  	}
	  	
	  	@PostMapping("/addDoseTime")
		@ResponseBody
		 @Operation(security = {@SecurityRequirement(name = "bearer-key")})
		public void addMedicationDose(@RequestBody DoseTimeRequest doseTime) throws Exception{
	  		DoseTime  doseT = new DoseTime(doseTime.getTime(),medDao.findById(doseTime.getMed()).get(),
	  				archiveDao.findById(doseTime.getArch()).get(),
	  				doseTime.getRdose(),
	  				doseTime.isDone());
			  archiveServices.newDoseTime(doseT);
			
		}
	  	
	  	 // http://localhost:8081/api/getDoseTimeByArch
	  	@GetMapping("/getDoseTimeByArch/{idarch}/{idmed}")
	  	@ResponseBody
	  	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	  	public Set<DoseTime>  getDoseTimeByArch(@PathVariable("idarch") String idarch,@PathVariable("idmed") long idmed) {
	  		return archiveServices.getDoseTimeByArchive(idarch,idmed);
	  	}
	  	
	  	@PutMapping("/doseTimeDone/{idDose}/{done}")
	  	@ResponseBody
	  	public ResponseEntity<String> doseTimeDone(@PathVariable("idDose")long idDose,@PathVariable("done") boolean done) {
			
	  		archiveServices.doseTimeDone(idDose,done);
	  	    return new ResponseEntity<String>("Take Dose",HttpStatus.OK);
	  		
	  	}
	  	
	  	
	  	@PutMapping("/reminderDose/{idDose}/{remind}")
	  	@ResponseBody
	  	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	  	public ResponseEntity<String> reminderDose(@PathVariable("idDose")long idDose,@PathVariable("remind") boolean remind) {
			
	  		archiveServices.reminderDose(idDose,remind);
	  	    return new ResponseEntity<String>("This dose is Reminded",HttpStatus.OK);
	  		
	  	}
	  	
	 
}
