package dsi.senior;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import dsi.senior.entities.ArchiveMedication;
import dsi.senior.entities.ArchiveSenior;
import dsi.senior.entities.IngredientsCategories;
import dsi.senior.entities.Meal;
import dsi.senior.entities.Medication;
import dsi.senior.entities.Senior;
import dsi.senior.repositories.ArchiveDao;
import dsi.senior.repositories.SeniorDao;
import dsi.senior.services.ArchiveMedServiceImpl;
import dsi.senior.services.IArchiveSeniorService;
import dsi.senior.services.IMealService;
import dsi.senior.services.IMedicationService;
import dsi.senior.services.ISeniorServiceImpl;
import dsi.senior.services.IngredientsCategoriesServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SeniorCareApplicationTests {


	@Autowired
	ISeniorServiceImpl seniorServiceImpl;
	@Autowired
	IArchiveSeniorService archSeniorService;
	@Autowired
	IMedicationService medicationService;
	@Autowired
	IMealService mealService;
	
	@Autowired
	ArchiveMedServiceImpl archiveMedServiceImpl;
	@Autowired
	IngredientsCategoriesServiceImpl ingCategoryImpl;
	
	@MockBean
	SeniorDao seniorDao;
	@MockBean
	ArchiveDao archiveDao;
	
	private static final Logger l = LogManager.getLogger(SeniorCareApplicationTests.class);

	Senior senior1 = new Senior("Hamdi","mzoughi","1997-05-3","male","09632455","51236987",
			"houmet saboun","single","reading","",76,180);
	
	Senior senior2 = new Senior("Chaima","mzoughi","1930-04-3","female","09632355","21236987",
			"Centre D'accueil Gammath","single","reading","",66,170);
	
	Senior senior3 = new Senior("Bilel","Nafati","1933-04-3","male","09732355","51116987",
			"Centre D'accueil Gammath","single","watching","",86,185);
	
	@Test
	public void retrieveAllSeniorTest() {
		when(seniorDao.findAll()).thenReturn(Stream
				.of(senior2,senior3).collect(Collectors.toList()));
		assertEquals(2,seniorServiceImpl.retrieveAllSenior().size());
	}
	
	
	
	/*
	@Test
	public void testAddSenior() {
		Senior s = seniorServiceImpl.addSenior(senior3);
		l.info("Senior added");
		Assertions.assertTrue(  seniorDao.findById(s.getId()).isPresent(),"ADD SENIOR FAILED !");
	}

	@Test
	public void testFindByResidance() {
		
		
		List<Senior> seniors = seniorServiceImpl.findByResidance("Centre D'accueil Gammath");
		Assertions.assertTrue((seniors.size())>0,"seniors residance not founded");
		if (seniors.size()>0) {
			 
			 l.info("seniors residance founded"); } else { l.warn("warning check your method");

	}
	}
	
	@Test
	public void testDeleteSenior() {
		Senior s = seniorServiceImpl.addSenior(senior2);
		l.info("Senior added");
		Assertions.assertTrue(  seniorDao.findById(s.getId()).isPresent(),"ADD SENIOR FAILED !");
		seniorServiceImpl.deleteSenior(s.getId());
		l.info("Senior deleted");
		Assertions.assertFalse(  seniorDao.findById(s.getId()).isPresent(),"DELETE SENIOR FAILED !");
	
	}

	@Test
	public void testajouterMedicToArchive() {
		Senior s1 = seniorServiceImpl.addSenior(senior1);
		l.info("Senior added with id :  " + s1.getId());
		LocalDate dateObj = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = dateObj.format(formatter);
		String idA = "arch-" + s1.getId() + "-" + date;
		ArchiveSenior archSenior = new ArchiveSenior(idA, date, false, false, false, s1);
		archSeniorService.updateArchive(archSenior);
		l.info("Senior archive added with id :  " + idA);
		Medication medic = new Medication("Medic1", 3, "pills", date, date, s1);
		medicationService.newMedication(medic);
		l.info("Senior archive added with id :  " + idA);
		archiveMedServiceImpl.ajouterArchiveMedic(idA, medic.getIdmed(), false);
		l.info("Senior med affected to his archive ");
		Set<ArchiveMedication> archMeds = archiveMedServiceImpl.getAllMedsByArchive(idA);
		Assertions.assertTrue( archMeds.size() > 0,"assignment Med to archive fail");
		if (archMeds.size() > 0) {
			l.info("Medication found in Archive");
		} else {
			l.warn("warning check your method : AjouterMedicToArchive");
		}
	}
*/
	/*********************** CHEF TESTS **************************/
/*
	@Test
	public void testgetAllCategories() {
		List<IngredientsCategories> ingCatList = ingCategoryImpl.getAllCategories();
		assertEquals(8, ingCatList.size());
		if (ingCatList.size() == 8) {
			l.info("Ingredients Category is 8");
		} else {
			l.warn("warning check your method : getAllCategories");
		}
	}
	@Test
	@Rollback(true)
	public void testupdateMeal() {
		Meal meal = mealService.getMealById(7);
		meal.setDescription("new Description Test");
		mealService.updateMeal(meal, meal.getId());
		Meal updatedMeal = mealService.getMealById(7);
		Assertions.assertTrue((updatedMeal.getDescription())==("new Description Test"));
		if (updatedMeal.getDescription() == "new Description Test") {
			l.info("Meal updated succesfully");
		} else {
			l.warn("warning check your method : updateMeal");
		}
	}
*/
}
