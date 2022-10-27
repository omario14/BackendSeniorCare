package request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


public class MedicationRequest {
	
	private String label;
	private int dose;
	private String doseType;
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	private String startDate;
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	private String endDate;
	private long senior;


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
	public long getSenior() {
		return senior;
	}
	public void setSenior(long senior) {
		this.senior = senior;
	}
	
	
	

}
