package dsi.senior.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MealType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private EMealType label;
	
	
	public MealType() {
		
	}


	public MealType(int id, EMealType name) {
		super();
		this.id = id;
		this.label = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public EMealType getName() {
		return label;
	}


	public void setName(EMealType name) {
		this.label = name;
	}
	
	

}
