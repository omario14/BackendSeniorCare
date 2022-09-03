package dsi.senior.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.BodyParts;
import dsi.senior.entities.Symptoms;
import dsi.senior.repositories.BodyPartsDao;
import dsi.senior.repositories.SymptomsDao;

@Service
public class SymptomServiceImpl implements ISymptomsService {

	@Autowired
	private SymptomsDao aa;
	@Autowired
	private BodyPartsDao bodypartsRepo;
	
	@Override
	public List<Symptoms> retreiveAllSymtoms() {
		
		return (List<Symptoms>) aa.findAll() ;
	}

	@Override
	public Symptoms retrieveSymptomById(long id) {
		Symptoms symp = aa.findById(id).get();
		return symp;
	}

	@Override
	public Symptoms findSymptomByLabel(String label) {
		Symptoms symp = aa.findSymptomByLabel(label);
		return symp;
	}

	

	@Override
	public BodyParts findBodyPartById(long body_id) {
		return  bodypartsRepo.findById(body_id).get();
	}

	@Override
	public List<Symptoms> findSymptomsByPartId(long body_id) {
		BodyParts bodyPart = bodypartsRepo.findById(body_id).get();
		return aa.findSymptomByBodyParts(bodyPart);
	}

	@Override
	public List<Symptoms> updateSymptoms(List<String> symptomsIDs) {
		List<Symptoms> allSymptoms= (List<Symptoms>) aa.findAll();
				allSymptoms.forEach(z->{
			z.setEtat(false);
		});
				
				symptomsIDs.forEach(symp->{
			Symptoms s = aa.findById(Long.parseLong(symp)).get();
			s.setEtat(true);
			aa.save(s);
		});
		
		
		
		return (List<Symptoms>) aa.findAll();
	}

}
