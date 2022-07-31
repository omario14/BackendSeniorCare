package dsi.senior.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.Menu;
import dsi.senior.entities.Senior;
import dsi.senior.repositories.MenuDao;
import dsi.senior.repositories.SeniorDao;

@Service
public class SeniorServiceImpl implements ISeniorServiceImpl{
	
	@Autowired
	SeniorDao seniorDao;
	@Autowired
	MenuDao menuDao;
	
	/********************** ADD method that insert Senior into database***************/
	@Override
	public long addSenior(Senior s) {
		Senior senior =new Senior(
					s.getName(),
					s.getLastname(),
					s.getDateOfBirth(),
					s.getSex(),
					s.getCin(),
					s.getTelephone(),
					s.getResidance(),
					s.getFamillySituation(),
					s.getCenterOfInterest(),
					s.getFile());
		seniorDao.save(senior);
		return senior.getId();
	}
	/********************** DELETE method that delete Senior from database***************/
	@Override
	public void deleteSenior(long id) {
		seniorDao.deleteById(id);
		
	}
	
	

	/********************** UPDATE method that updates Senior***************/
	@Override
	public void updateSenior(Senior s, long idSenior) {
		Senior sa = seniorDao.findById(idSenior).get();
		
		Date currentUtilDate = new Date();
	    String strDateFormat = "yyyy-MM-dd";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(currentUtilDate);
	    
	
		Menu men = menuDao.findMenuByDate(formattedDate);
		System.out.println(s.getMenus());
		if (s.isCheckedBreakfast()&&s.isCheckedDinner()&&s.isCheckedLunch()) {
			Set<Menu> menusList = s.getMenus();
			menusList.add(men);
			sa.setMenus(menusList);
			
		}else {
			sa.setMenus(s.getMenus());
		}
		
		
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
		
		seniorDao.save(sa);
		
	}

	/********************** FIND method that retrieve All Seniors***************/
	@Override
	public List<Senior> retrieveAllSenior() {
		
		return (List<Senior>) seniorDao.findAll();
	}
	

	/********************** FINDBYID method that find Senior by id***************/
	@Override
	public Senior retrieveSeniorById(long id) {
		Senior sa = seniorDao.findById(id).get();
		return sa;
	}

	/********************** FINDBYNAME method that find Senior by NAME***************/
	@Override
	public Senior findSeniorByName(String name) {
		Senior sa = seniorDao.findSeniorByName(name);
		return sa;
	}
	/********************** FINDBYRESIDANCE method that find Senior by RESIDANCE***************/
	@Override
	public List<Senior> findByResidance(String place_resid) {
		List<Senior> seniors = seniorDao.findSeniorsByResidance(place_resid);
		return seniors;
	}
	@Override
	public Boolean existByid(Long id){
		return seniorDao.existsById(id);
	}
	
	
	/********************** DELETE method that delete All Senior from database***************/
	@Override
	public void deleteAllSenior() {
		seniorDao.deleteAll();
		
	}
	@Override
	public void addMenuSenior(long idSenior) {
			Date currentUtilDate = new Date();
		    String strDateFormat = "yyyy-MM-dd";
		    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    String formattedDate= dateFormat.format(currentUtilDate);
		    
		System.out.println("Date of today"+formattedDate);
		
		Senior s = seniorDao.findById(idSenior).get();
		Menu men = menuDao.findMenuByDate(formattedDate);
		System.out.println("menu of today"+men);
		Set<Menu> menusList = s.getMenus();
		menusList.add(men);
		s.setMenus(menusList);
		seniorDao.save(s);
		
	}

}
