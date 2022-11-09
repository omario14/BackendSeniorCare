package dsi.senior.services;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.ArchiveSenior;
import dsi.senior.entities.Medication;
import dsi.senior.entities.archmedPK;
import dsi.senior.entities.ArchiveMedication;
import dsi.senior.repositories.ArchiveDao;
import dsi.senior.repositories.ArchiveMedsDao;
import dsi.senior.repositories.MedicationDao;

@Service
public class ArchiveMedServiceImpl {
	
	@Autowired
	ArchiveMedsDao archiveMedDao;
	@Autowired
	ArchiveDao archDao;
	@Autowired
	MedicationDao medDao;
	
	public void ajouterArchiveMedic(String idArch,long idMed,boolean done){
		
		ArchiveSenior archive = archDao.findById(idArch).get();
		Medication medic = medDao.findById(idMed).get();
		archmedPK archmedpk = new archmedPK();
		archmedpk.setIdArch(idArch);
		archmedpk.setIdmed(idMed);
		
		ArchiveMedication t = new ArchiveMedication();
		t.setArchmedpk(archmedpk);
		t.setArchive(archive);
		t.setMeds(medic);
		t.setDone(done);
		archiveMedDao.save(t);
	} 
	
	public void deleteArchMeds(long idMed){
		Medication med= medDao.findById(idMed).get();
		 archiveMedDao.deleteNombreEmployeJPQL(med);

	}
	
	public Set<ArchiveMedication> getAllMedsByArchive (String idArch){
		ArchiveSenior archive = archDao.findById(idArch).get();
		return archiveMedDao.getarchMedsByIdArch(archive);
	}
	
	
	public void deleteArchMedsBymedAndArch(long idMed,String idArch){
		Medication med= medDao.findById(idMed).get();
		ArchiveSenior archive = archDao.findById(idArch).get();
		 archiveMedDao.deleteArchiveMedicationBymeds(med,archive);

	}
	
	
	

}
