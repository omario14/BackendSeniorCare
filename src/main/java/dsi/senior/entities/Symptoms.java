package dsi.senior.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Symptoms implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String label;
	private boolean etat;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="illness_id",nullable = false)
	private Illnesses illnesses;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="body_id",nullable = false)
	private BodyParts bodyParts;
	
	
	public Symptoms() {
		
	}


	public Symptoms(long id, String label,boolean etat) {
		super();
		this.id = id;
		this.label = label;
		this.etat = etat;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public boolean isCondition() {
		return etat;
	}


	public void setCondition(boolean etat) {
		this.etat = etat;
	}


	public Illnesses getIllnesses() {
		return illnesses;
	}


	public void setIllnesses(Illnesses illnesses) {
		this.illnesses = illnesses;
	}
	
	
	
	
	
	
}