package dsi.senior.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.Menu;
import dsi.senior.repositories.MenuDao;

@Service
public class MenuServiceImpl  {
	
	@Autowired 
	MenuDao menurepository;
	
	
	
	public void addToMenu(Menu m) {
		menurepository.save(m);
		
	}
	
	public List<Menu> getMenus(){
		return (List<Menu>) menurepository.findAll();
	}
	public void deleteMenu (long id ) {
		menurepository.deleteById(id);
		
	}
	
	public void updateMenu(Menu m,long idMenu) {
		Menu menu= menurepository.findById(idMenu).get();
		 System.out.println("this is menu"+m.toString());
		menu.setBreakfastMenu(m.getBreakfastMenu());
		menurepository.save(menu);
		 
	
	}
	
	

}
