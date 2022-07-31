package request;

import java.util.Set;



public class MenuRequest {


	private String date;
	private Set<Long> breakfastMenu;
	private Set<Long> lunchMenu;
	private Set<Long> dinnerMenu;
	
	public MenuRequest() {
		
	}
	
	public MenuRequest(String date, Set<Long> breakfastMenu, Set<Long> lunchMenu, Set<Long> dinnerMenu) {
		super();
		this.date = date;
		this.breakfastMenu = breakfastMenu;
		this.lunchMenu = lunchMenu;
		this.dinnerMenu = dinnerMenu;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Set<Long> getBreakfastMenu() {
		return breakfastMenu;
	}


	public void setBreakfastMenu(Set<Long> breakfastMenu) {
		this.breakfastMenu = breakfastMenu;
	}


	public Set<Long> getLunchMenu() {
		return lunchMenu;
	}


	public void setLunchMenu(Set<Long> lunchMenu) {
		this.lunchMenu = lunchMenu;
	}


	public Set<Long> getDinnerMenu() {
		return dinnerMenu;
	}


	public void setDinnerMenu(Set<Long> dinnerMenu) {
		this.dinnerMenu = dinnerMenu;
	}
	
	
	
}
