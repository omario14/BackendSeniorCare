package dsi.senior.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "bodyparts")
public class BodyParts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long body_id ;//12
	private String label;//Head
	
	
	@JsonManagedReference
	@OneToMany(mappedBy="bodyParts")
	private Set<Symptoms> symptoms;

	
	public BodyParts() {
		
	}
	
	

	public BodyParts(long body_id, String label, Set<Symptoms> symptoms) {
		super();
		this.body_id = body_id;
		this.label = label;
		this.symptoms = symptoms;
	}

	


	public long getBody_id() {
		return body_id;
	}



	public void setBody_id(long body_id) {
		this.body_id = body_id;
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public Set<Symptoms> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Set<Symptoms> symptoms) {
		this.symptoms = symptoms;
	}
	
	
	
	

	
}
