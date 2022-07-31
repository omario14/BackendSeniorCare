package dsi.senior.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Medication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idmed;
	private String label;
	private int dose;
	private String doseType;

	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	private String startDate;

	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	private String endDate;
	@ManyToOne
	private Senior senior;
	
	
	public Medication() {
		
	}


	public Medication(String label, int dose, String doseType, String startDate, String endDate,Senior senior) {
		super();
		this.label = label;
		this.dose = dose;
		this.doseType = doseType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.senior =  senior;
	}


	public long getIdmed() {
		return idmed;
	}


	public void setIdmed(long idmed) {
		this.idmed = idmed;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public int getDose() {
		return dose;
	}


	public void setDose(int dose) {
		this.dose = dose;
	}


	public String getDoseType() {
		return doseType;
	}


	public void setDoseType(String doseType) {
		this.doseType = doseType;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public Senior getSenior() {
		return senior;
	}


	public void setSenior(Senior senior) {
		this.senior = senior;
	}


	@Override
	public String toString() {
		return "Medication [idmed=" + idmed + ", label=" + label + ", dose=" + dose + ", doseType=" + doseType
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", senior=" + senior + "]";
	}
	
	
	
	
	

}
