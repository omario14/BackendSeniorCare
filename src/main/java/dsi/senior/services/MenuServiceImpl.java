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
	
	
	
	public List<Menu> addToMenu(Menu m) {
		menurepository.save(m);
		return getMenus();
	}
	
	public List<Menu> getMenus(){
		return (List<Menu>) menurepository.findAll();
	}
	public void deleteMenu (long id ) {
		menurepository.deleteById(id);
		
	}
	
	public void updateMenu(long id,Menu m) {
		Menu menu = menurepository.findById(id).get();
		
		
		menu.setBreakfastMenu(m.getBreakfastMenu());
		
		menurepository.save(menu);
		
		
	}
	
	

}
