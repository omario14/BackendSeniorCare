package dsi.senior.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	private String date;
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	@JoinTable(
			  name = "breakfastMenu", 
			  joinColumns = @JoinColumn(name = "menu_id"), 
			  inverseJoinColumns = @JoinColumn(name = "meal_id"))
	private Set<Meal> breakfastMenu;
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	@JoinTable(
			  name = "lunchMenu", 
			  joinColumns = @JoinColumn(name = "menu_id"), 
			  inverseJoinColumns = @JoinColumn(name = "meal_id"))
	private Set<Meal> lunchMenu;
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	@JoinTable(
			  name = "dinnerMenu", 
			  joinColumns = @JoinColumn(name = "menu_id"), 
			  inverseJoinColumns = @JoinColumn(name = "meal_id"))
	private Set<Meal> dinnerMenu;
	
	public Menu() {
	}
	
	

	public Menu(String date, Set<Meal> breakfastMenu, Set<Meal> lunchMenu, Set<Meal> dinnerMenu) {
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



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
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



