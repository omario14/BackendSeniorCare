package dsi.senior.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dsi.senior.entities.ArchiveSenior;
import dsi.senior.entities.Senior;
import dsi.senior.repositories.ArchiveDao;
import dsi.senior.repositories.ArchiveMedsDao;
import dsi.senior.repositories.DoseTimeDao;
import dsi.senior.repositories.MedicationDao;
import dsi.senior.repositories.MenuDao;
import dsi.senior.repositories.SeniorDao;

@Service
public class SeniorServiceImpl implements ISeniorServiceImpl {

	@Autowired
	SeniorDao seniorDao;
	@Autowired
	MenuDao menuDao;
	@Autowired
	ArchiveDao archDao;
	@Autowired
	DoseTimeDao doseTimeDao;
	@Autowired
	MedicationDao medicationDao;
	@Autowired
	FileStorageService fileDao;
	@Autowired
	ArchiveMedsDao archmedsDao;

	/**********************
	 * ADD method that insert Senior into database
	 ***************/
	@Override
	public Senior addSenior(Senior s) {

		Senior senior = new Senior(s.getName(), s.getLastname(), s.getDateOfBirth(), s.getSex(), s.getCin(),
				s.getTelephone(), s.getAdress(), s.getFamillySituation(), s.getCenterOfInterest(), s.getFile(),
				s.getWeight(), s.getHeight());

		senior.setBmi(calculBMI(s.getWeight(), s.getHeight()));
		seniorDao.save(senior);

		return senior;
	}

	/**********************
	 * DELETE method that delete Senior from database
	 ***************/
	@Override
	public void deleteSenior(long id) {
		Senior senior = seniorDao.findById(id).get();

		Set<ArchiveSenior> archives = archDao.findArchivesBySenior(senior);

		archives.forEach(d -> {
			archmedsDao.deleteArchiveMedicationByArchive(d);
			medicationDao.deleteMedicationBySenior(d.getSenior());
			doseTimeDao.deleteDoseTimeByArch(d);
			archDao.deleteById(d.getIdArch());
		});
		if(!senior.getFile().isEmpty()|| senior.getFile()!=null) {
			fileDao.deleteFile(senior.getFile());
		}
		
		seniorDao.deleteById(id);

	}

	/********************** UPDATE method that updates Senior ***************/
	@Override
	public void updateSenior(Senior s, long idSenior) {
		Senior sa = seniorDao.findById(idSenior).get();



		sa.setName(s.getName());
		sa.setLastname(s.getLastname());
		sa.setDateOfBirth(s.getDateOfBirth());
		sa.setSex(s.getSex());
		sa.setCin(s.getCin());
		sa.setTelephone(s.getTelephone());
		sa.setFile(s.getFile());
		sa.setCheckedBreakfast(s.isCheckedBreakfast());
		sa.setCheckedLunch(s.isCheckedLunch());
		sa.setCheckedDinner(s.isCheckedDinner());
		sa.setHeight(s.getHeight());
		sa.setWeight(s.getWeight());
		sa.setBmi(calculBMI(s.getWeight(), s.getHeight()));
		seniorDao.save(sa);

	}

	/********************** FIND method that retrieve All Seniors ***************/
	@Override
	public List<Senior> retrieveAllSenior() {
		bmiEnFncDage();
		return (List<Senior>) seniorDao.findAll();
	}

	/********************** FINDBYID method that find Senior by id ***************/
	@Override
	public Senior retrieveSeniorById(long id) {
		Senior sa = seniorDao.findById(id).get();
		return sa;
	}

	/**********************
	 * FINDBYNAME method that find Senior by NAME
	 ***************/
	@Override
	public Senior findSeniorByName(String name) {
		Senior sa = seniorDao.findSeniorByName(name);
		return sa;
	}

	/**********************
	 * FINDBYRESIDANCE method that find Senior by RESIDANCE
	 ***************/
	@Override
	public List<Senior> findByResidance(String place_resid) {
		List<Senior> seniors = seniorDao.findSeniorsByResidance(place_resid);
		return seniors;
	}

	@Override
	public Boolean existByid(Long id) {
		return seniorDao.existsById(id);
	}

	/**********************
	 * DELETE method that delete All Senior from database
	 ***************/
	@Override
	public void deleteAllSenior() {
		seniorDao.deleteAll();

	}

	

	@Override
	public double calculBMI(double weight, double height) {

		return ((weight / height / height) * 10000);
	}

	@Override
	public Map<String, Long> centreDinteret() {
		List<String> list = seniorDao.centreDinteretseniors();

		Map<String, Long> frequencyMap = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return frequencyMap;
	}

	public int calculateAge(String d) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// convert String to LocalDate
		LocalDate birthDate = LocalDate.parse(d, formatter);
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth());

		Period period = Period.between(birthday, today);

		
		
		return period.getYears();

	}

	@Override
	public Map<Integer, Long> bmiEnFncDage() {

		List<String> list = seniorDao.birthDateSeniors();

		List<Integer> listAge = new ArrayList<Integer>();

		list.forEach(d -> {
			listAge.add(calculateAge(d));
			
		});
		
		Map<Integer, Long> frequencyMap = listAge.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return frequencyMap;

	}

}
