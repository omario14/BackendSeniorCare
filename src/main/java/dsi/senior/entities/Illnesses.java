package dsi.senior.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Illnesses implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long illness_id ;//12
	private String label;//Airborne Allergens
	private String category;// Allergie
	
	@JsonManagedReference
	@OneToMany(mappedBy="illnesses")
	private Set<Symptoms> symptoms;

	
	public Illnesses() {
		
	}
	
	public Illnesses(String label, String category, Set<Symptoms> symptoms) {
		super();
		this.label = label;
		this.category = category;
		this.symptoms = symptoms;
	}

	public long getId() {
		return illness_id;
	}

	public void setId(long id) {
		this.illness_id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<Symptoms> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Set<Symptoms> symptoms) {
		this.symptoms = symptoms;
	}
	
	
	
	

	
}
