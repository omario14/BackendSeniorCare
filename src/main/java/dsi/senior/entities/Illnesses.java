package dsi.senior.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	private long rate;
	private String description;
	private String treatment;
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY)
			@JoinTable(	name = "Ilness_Symps", 
			joinColumns = @JoinColumn(name = "Illness_id",nullable=false), 
			inverseJoinColumns = @JoinColumn(name = "Symptom_id",nullable=false))
	private Set<Symptoms> symptoms;

	
	public Illnesses() {
		
	}
	
	public Illnesses(String label, String category, Set<Symptoms> symptoms,long rate) {
		super();
		this.label = label;
		this.category = category;
		this.symptoms = symptoms;
		this.rate=rate;
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

	public long getRate() {
		return rate;
	}

	public void setRate(long rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	
	
	
	

	
}
