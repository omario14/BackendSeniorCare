package dsi.senior;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.ArgumentMatchers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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

@RunWith(MockitoJUnitRunner.class)
public class SeniorCareApplicationTests {

	@InjectMocks
	ISeniorServiceImpl seniorServiceImpl;
	@InjectMocks
	IArchiveSeniorService archSeniorService;
	@InjectMocks
	IMedicationService medicationService;
	@InjectMocks
	IMealService mealService;

	@InjectMocks
	ArchiveMedServiceImpl archiveMedServiceImpl;
	@InjectMocks
	IngredientsCategoriesServiceImpl ingCategoryImpl;

	@Mock
	SeniorDao seniorDao;
	@Mock
	ArchiveDao archiveDao;

	private static final Logger l = LogManager.getLogger(SeniorCareApplicationTests.class);

	Senior senior1,senior2,senior3;
    @Before
    public void setUp() throws Exception {
	 senior1 = new Senior("Hamdi", "mzoughi", "1997-05-3", "male", "09632455", "51236987", "houmet saboun",
			"single", "reading", "1ce79e29-11bd-4ca1-a268-ad094f711ecf", 76, 180);

	senior2 = new Senior("Chaima", "mzoughi", "1930-04-3", "female", "09632355", "21236987",
			"Centre D'accueil Gammath", "single", "reading", "", 66, 170);

	senior3 = new Senior("Bilel", "rafii", "1933-04-3", "male", "09732355", "51116987",
			"Centre D'accueil Gammath", "single", "watching", "1ce79e29-11bd-4ca1-a268-ad094f711ecf", 86, 185);
	}
	
	@Test
	void testaddSenior() {
		Senior s = seniorServiceImpl.addSenior(senior3);
		when(seniorServiceImpl.addSenior(ArgumentMatchers.any(Senior.class))).thenReturn(senior3);
		l.info("Senior added");
		assertThat(seniorDao.findById(s.getId()).isPresent());
	}
/*
	@Test
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
	void testdeleteSenior() {
		Senior s = seniorServiceImpl.addSenior(senior2);
		l.info("Senior added");
		assertTrue("ADD SENIOR FAILED !", seniorDao.findById(s.getId()).isPresent());
		seniorServiceImpl.deleteSenior(s.getId());
		l.info("Senior deleted");
		assertFalse("DELETE SENIOR FAILED !", seniorDao.findById(s.getId()).isPresent());

	}

	@Test
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
*/
	/*********************** CHEF TESTS **************************/
/*
	@Test
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

*/
}
