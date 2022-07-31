package dsi.senior.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import dsi.senior.entities.Medication;
import dsi.senior.entities.Senior;
import dsi.senior.repositories.MedicationDao;
import dsi.senior.repositories.SeniorDao;

@Service
public class MedicationServiceImpl implements IMedicationService {
	
	@Autowired
	SeniorDao seniorDao;
	
	@Autowired
	MedicationDao medDao;
	

	@Override
	public Medication newMedication(Medication m) {
		Medication ms= medDao.save(m);
		Long id= ms.getIdmed();
		System.out.println("ms"+id);
		Medication medic= medDao.findById(id).get();
		System.out.println("mssss"+medic.toString());
		return medic;
	}

	@Override
	public Set<Medication> getAllMedication() {
		return (Set<Medication>) medDao.findAll();
	}

	@Override
	public Set<Medication> getMedicationBySenior(long idSenior) {
		Senior S = seniorDao.findById(idSenior).get();
		System.out.println("senior"+medDao.findMedicationBySenior(S));
		return medDao.findMedicationBySenior(S);
	}

	@Override
	public void deleteMedication(long idmed) {
		medDao.deleteById(idmed);
		
	}

}
