package dsi.senior.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.Medication;
import dsi.senior.entities.Senior;
import dsi.senior.repositories.ArchiveMedsDao;
import dsi.senior.repositories.DoseTimeDao;
import dsi.senior.repositories.MedicationDao;
import dsi.senior.repositories.SeniorDao;

@Service
public class MedicationServiceImpl implements IMedicationService {
	
	@Autowired
	SeniorDao seniorDao;
	
	@Autowired
	MedicationDao medDao;
	
	@Autowired
	ArchiveMedsDao archiveMedDao;
	
	@Autowired
	DoseTimeDao doseTimeDao ;
	

	@Override
	public Medication newMedication(Medication m) {
		Medication ms= medDao.save(m);
		Long id= ms.getIdmed();
		
		Medication medic= medDao.findById(id).get();
		
		return medic;
	}
	
	@Override
	public Set<Medication> getAllMedication() {
		return (Set<Medication>) medDao.findAll();
	}

	@Override
	public Set<Medication> getMedicationBySenior(long idSenior) {
		Senior S = seniorDao.findById(idSenior).get();
		
		return medDao.findMedicationBySenior(S);
	}


	

	
	@Override
	public void deleteMedication(long idmed) {
		Medication med= medDao.findById(idmed).get();
		 archiveMedDao.deleteNombreEmployeJPQL(med);
		medDao.deleteById(idmed);
		
		
	}

}
