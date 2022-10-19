package dsi.senior;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

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

@SpringBootTest
@Transactional
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
	
	@Autowired
	SeniorDao seniorDao;
	@Autowired
	ArchiveDao archiveDao;
	
	private static final Logger l = LogManager.getLogger(SeniorCareApplicationTests.class);

	Senior senior1 = new Senior("Hamdi","mzoughi","1997-05-3","male","09632455","51236987",
			"houmet saboun","single","reading","1ce79e29-11bd-4ca1-a268-ad094f711ecf",76,180);
	
	Senior senior2 = new Senior("Chaima","mzoughi","1930-04-3","female","09632355","21236987",
			"Centre D'accueil Gammath","single","reading","",66,170);
	
	Senior senior3 = new Senior("Bilel","rafii","1933-04-3","male","09732355","51116987",
			"Centre D'accueil Gammath","single","watching","1ce79e29-11bd-4ca1-a268-ad094f711ecf",86,185);
	@Test
	@Rollback(true)
	public void testAddSenior() {
		Senior s = seniorServiceImpl.addSenior(senior3);
		l.info("Senior added");
		assertTrue( "ADD SENIOR FAILED !", seniorDao.findById(s.getId()).isPresent());
	}

	@Test
	public void testFindByResidance() {
		
		
		List<Senior> seniors = seniorServiceImpl.findByResidance("Centre D'accueil Gammath");
		assertTrue( "seniors residance not founded", seniors.size()>0);
		if (seniors.size()>0) {
			 
			 l.info("seniors residance founded"); } else { l.warn("warning check your method");

	}
	}
	
}
