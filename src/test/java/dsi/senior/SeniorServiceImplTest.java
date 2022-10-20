package dsi.senior;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import dsi.senior.entities.Meal;
import dsi.senior.entities.Senior;
import dsi.senior.repositories.ArchiveDao;
import dsi.senior.repositories.MealDAO;
import dsi.senior.repositories.SeniorDao;
import dsi.senior.services.ArchiveMedServiceImpl;
import dsi.senior.services.IArchiveSeniorService;
import dsi.senior.services.IMealService;
import dsi.senior.services.IMedicationService;
import dsi.senior.services.ISeniorServiceImpl;
import dsi.senior.services.IngredientsCategoriesServiceImpl;

@DataJpaTest
public class SeniorServiceImplTest {
	@Autowired
	private ISeniorServiceImpl seniorServiceImpl;
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
	@MockBean
	MealDAO mealDao;
	
	
	
	private static final Logger l = LogManager.getLogger(SeniorServiceImplTest.class);

	
	Senior senior1,senior2,senior3;
	Meal meal;
	
			
			
			@Before
		    public void setUp() throws Exception {
				 senior1 = new Senior("Hamdi","mzoughi","1997-05-3","male","09632455","51236987",
							"houmet saboun","single","reading","",76,180);
					
					 senior2 = new Senior("Chaima","mzoughi","1930-04-3","female","09632355","21236987",
							"Centre D'accueil Gammath","single","reading","",66,170);
					
					 senior3 = new Senior("Bilel","Nafati","1933-04-3","male","09732355","51116987",
							"Centre D'accueil Gammath","single","watching","",86,185);
					 
					 senior3.setId(2022);
					 
					 meal = new Meal();
					 meal.setId(2022);
					 meal.setLabel("Ma9rounna");
					 meal.setDescription("This is the best ma9rouna in the whole world .");
		    }
			@Test
			public void testFindByResidance() {
				
				
				List<Senior> seniors = seniorServiceImpl.findByResidance("Centre D'accueil Gammath");
				Assertions.assertTrue((seniors.size())>0,"seniors residance not founded");
				if (seniors.size()>0) {
					 
					 l.info("seniors residance founded"); } else { l.warn("warning check your method");

			}
			}

}
