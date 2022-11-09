package dsi.senior.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.ArchiveSenior;
import dsi.senior.entities.Calendar;
import dsi.senior.entities.DoseTime;
import dsi.senior.entities.ERole;
import dsi.senior.entities.Medication;
import dsi.senior.entities.Senior;
import dsi.senior.repositories.ArchiveDao;
import dsi.senior.repositories.CalendarDao;
import dsi.senior.repositories.DoseTimeDao;
import dsi.senior.repositories.MedicationDao;
import dsi.senior.repositories.SeniorDao;
import dsi.senior.repositories.UserDao;
import request.MailRequest;

@Service
public class ArchiveSeniorServiceImpl implements IArchiveSeniorService {

	
	@Autowired
	ArchiveDao archDao;
	@Autowired
	SeniorDao seniorDao;
	@Autowired
	CalendarDao calendarDao;
	@Autowired
	DoseTimeDao doseTimeDao;
	@Autowired
	MedicationDao medDao;
	@Autowired
	UserDao userDao;
	@Autowired
	MailService mailservice;
	
	@Override
	public void addArchive(ArchiveSenior arch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArchive(ArchiveSenior arch) {
		
		 if ( !archDao.existsById(arch.getIdArch())) {
			 Calendar calendar = new Calendar("food","#565656","food",arch.getDate(),arch.getSenior());
		  		calendarDao.save(calendar);
		 }
		  		archDao.save(arch);

		
	}

	@Override
	public long deleteArchive(long idArch) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ArchiveSenior> getAllArchives() {
		return  (List<ArchiveSenior>) archDao.findAll();
	}

	@Override
	public Set<ArchiveSenior> getArchiveSeniorBySenior(long idSenior) {
		Senior s = seniorDao.findById(idSenior).get();
		LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        String idA="arch-"+idSenior+"-"+date;
        if ( !archDao.existsById(idA)) {
        	ArchiveSenior arch = new ArchiveSenior();
        	
        	arch.setIdArch("arch-"+idSenior+"-"+date);
        	arch.setDate(date);
        	arch.setSenior(s);
        	archDao.save(arch);
        	Calendar calendar = new Calendar("food","#565656","food",arch.getDate(),arch.getSenior());
	  		calendarDao.save(calendar);
        	
        }
        
		return archDao.findArchivesBySenior(s);
		 
	}

	@Override
	public ArchiveSenior getArchiveSeniorById(String id) {
		if (archiveSeniorExist(id)) {
			return archDao.findById(id).get();
		}else {
			ArchiveSenior arch = new ArchiveSenior();
			return arch;
		}
			}
	
	private  boolean archiveSeniorExist (String id) {
		
		return archDao.existsById(id);	}
	
	@Override
	public List<DoseTime> getAllDoseTime() {
		
		return (List<DoseTime>) doseTimeDao.findAll();
	}
	

	@Override
	public void newDoseTime(DoseTime dose) {
		dose.setReminded(false);
		doseTimeDao.save(dose);
	}

	@Override
	public Set<DoseTime> getDoseTimeByArchive(String idarch,long idmed) {
		ArchiveSenior archive = archDao.findById(idarch).get();
		Medication medic = medDao.findById(idmed).get(); 
		
		return doseTimeDao.findDoseTimeByArchAndMed(archive,medic);
	}
	
	@Override
	public void doseTimeDone(long idDose,boolean done) {
		DoseTime dose= doseTimeDao.findById(idDose).get();
		dose.setTaken(done);
		doseTimeDao.save(dose);
	}

	@Override
	public void reminderDose(long idDose,boolean remind) {
		DoseTime dose= doseTimeDao.findById(idDose).get();
		userDao.findAll().forEach(u->{
			u.getRoles().forEach(r->{
				
				if(r.getName()==ERole.ROLE_ACCOMPAGNANT && u.getEmail().substring(0,6)!="exemple") {
					MailRequest request = new MailRequest(u.getUsername(),u.getEmail(),"omar.benamor@esprit.tn","Alert Medication");
				    
				    Map<String, Object> model = new HashMap<>();
					
					model.put("body", dose.getRdose()+" of " +dose.getMed() +" "+dose.getTime());
					model.put("firstName", dose.getArch().getSenior().getName()+" "+dose.getArch().getSenior().getLastname());
					mailservice.sendEmailMedication(request, model);
					   
			
			//SmsRequest smsRequest = new SmsRequest("+21651589453","Medication Reminder for "+dose.getArch().getSenior().getName()+" "+dose.getArch().getSenior().getLastname());
			
			  
			//twilioService.sendSms(smsRequest);
				}
			});
		});
		
		dose.setReminded(remind);
		doseTimeDao.save(dose);
	}

	@Override
	public void deleteDoseTime(long idDose) {
		doseTimeDao.deleteById(idDose);
		
	}

	

}
