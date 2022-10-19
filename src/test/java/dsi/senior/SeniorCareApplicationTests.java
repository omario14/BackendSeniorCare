package dsi.senior;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class SeniorCareApplicationTests {

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

	@Autowired
	SeniorDao seniorDao;
	@Autowired
	ArchiveDao archiveDao;

	private static final Logger l = LogManager.getLogger(SeniorCareApplicationTests.class);

	Senior senior1 = new Senior("Hamdi", "mzoughi", "1997-05-3", "male", "09632455", "51236987", "houmet saboun",
			"single", "reading", "1ce79e29-11bd-4ca1-a268-ad094f711ecf", 76, 180);

	Senior senior2 = new Senior("Chaima", "mzoughi", "1930-04-3", "female", "09632355", "21236987",
			"Centre D'accueil Gammath", "single", "reading", "", 66, 170);

	Senior senior3 = new Senior("Bilel", "rafii", "1933-04-3", "male", "09732355", "51116987",
			"Centre D'accueil Gammath", "single", "watching", "1ce79e29-11bd-4ca1-a268-ad094f711ecf", 86, 185);

	@Test
	@Rollback(true)
	@Order(1)
	void testaddSenior() {
		Senior s = seniorServiceImpl.addSenior(senior3);
		l.info("Senior added");
		assertTrue("ADD SENIOR FAILED !", seniorDao.findById(s.getId()).isPresent());
	}

	@Test
	@Order(2)
	void testfindByResidance() {

		List<Senior> seniors = seniorServiceImpl.findByResidance("Centre D'accueil Gammath");
		assertThat(seniors.size()).isGreaterThan(0);
		if (seniors.size() > 0) {

			l.info("seniors residance founded");
		} else {
			l.warn("warning check your method");

		}
	}

	@Test
	@Order(3)
	void testdeleteSenior() {
		Senior s = seniorServiceImpl.addSenior(senior2);
		l.info("Senior added");
		assertTrue("ADD SENIOR FAILED !", seniorDao.findById(s.getId()).isPresent());
		seniorServiceImpl.deleteSenior(s.getId());
		l.info("Senior deleted");
		assertFalse("DELETE SENIOR FAILED !", seniorDao.findById(s.getId()).isPresent());

	}

	@Test
	@Rollback(true)
	@Order(4)
	void testajouterMedicToArchive() {
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
		assertTrue("assignment Med to archive fail", archMeds.size() > 0);

		if (archMeds.size() > 0) {
			l.info("Medication found in Archive");
		} else {
			l.warn("warning check your method : AjouterMedicToArchive");

		}

	}

	/*********************** CHEF TESTS **************************/

	@Test
	@Order(5)
	void testgetAllCategories() {
		List<IngredientsCategories> ingCatList = ingCategoryImpl.getAllCategories();
		assertEquals(8, ingCatList.size());

		if (ingCatList.size() == 8) {
			l.info("Ingredients Category is 8");
		} else {
			l.warn("warning check your method : getAllCategories");

		}

	}

	@Test
	@Order(6)
	void testupdateMeal() {
		Meal meal = mealService.getMealById(7);
		meal.setDescription("new Description Test");
		mealService.updateMeal(meal, meal.getId());
		Meal updatedMeal = mealService.getMealById(7);

		assertThat(updatedMeal.getDescription()).isEqualTo("new Description Test");

		if (updatedMeal.getDescription() == "new Description Test") {
			l.info("Meal updated succesfully");
		} else {
			l.warn("warning check your method : updateMeal");

		}

	}

}
