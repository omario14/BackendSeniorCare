package dsi.senior.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.Illnesses;
import dsi.senior.entities.Symptoms;
import dsi.senior.repositories.IllnessDao;
import dsi.senior.repositories.SymptomsDao;

@Service
public class IllnessServiceImpl implements IIllnessService{

	@Autowired
	private IllnessDao illnessDao;
	@Autowired
	private SymptomsDao sympDao;
	
	@Override
	public List<Illnesses> retreiveAllIllnesses() {

		return (List<Illnesses>) illnessDao.findAll() ;
	}

	@Override
	public Illnesses retrieveIllnessById(long id) {
		Illnesses illness = illnessDao.findById(id).get();
		return illness;
	}

	@Override
	public Illnesses findIllnessByLabel(String label) {
		Illnesses illness = illnessDao.findIllnessByLabel(label);
		return illness;
	}

	
	public List<Illnesses> findIllnessBySymptoms(Symptoms symptom) {
		return illnessDao.getIllnessesBySymptoms(symptom);
		
	}
	@Override
	public List<Illnesses> checkerSymptom () {
		List<Symptoms> symptoms = sympDao.findSymptomByEtat();
		
		symptoms.forEach(s->{
			List<Illnesses> illnessProb = findIllnessBySymptoms(s);
			illnessProb.forEach(i->{
				i.setRate(i.getRate()+1);
				illnessDao.save(i);
			});
		});
		return (List<Illnesses>) illnessDao.findAll();
		
		
	}

}
