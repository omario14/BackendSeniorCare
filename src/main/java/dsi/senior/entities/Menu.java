package dsi.senior.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date date;
	@OneToMany
	private Set<Meal> breakfastMenu;
	@OneToMany
	private Set<Meal> lunchMenu;
	@OneToMany
	private Set<Meal> dinnerMenu;
	
	public Menu() {
	}
	
	

	public Menu(Date date, Set<Meal> breakfastMenu, Set<Meal> lunchMenu, Set<Meal> dinnerMenu) {
		super();
		this.date = date;
		this.breakfastMenu = breakfastMenu;
		this.lunchMenu = lunchMenu;
		this.dinnerMenu = dinnerMenu;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Set<Meal> getBreakfastMenu() {
		return breakfastMenu;
	}



	public void setBreakfastMenu(Set<Meal> breakfastMenu) {
		this.breakfastMenu = breakfastMenu;
	}



	public Set<Meal> getLunchMenu() {
		return lunchMenu;
	}



	public void setLunchMenu(Set<Meal> lunchMenu) {
		this.lunchMenu = lunchMenu;
	}



	public Set<Meal> getDinnerMenu() {
		return dinnerMenu;
	}



	public void setDinnerMenu(Set<Meal> dinnerMenu) {
		this.dinnerMenu = dinnerMenu;
	}
	
	
	
	
	
	

}



