package request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class SeniorRequest {

	
	
	private String name;
	private String lastname;
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	private String dateOfBirth;
	private String sex;
	private String cin;
	private String telephone;
	private String adress;
	private String famillySituation;
	private String centerOfInterest;
	private String fileId;
	private double weight;
	private double height;
	private double bmi;
	private boolean checkedBreakfast;
	private boolean checkedLunch;
	private boolean checkedDinner;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getFamillySituation() {
		return famillySituation;
	}
	public void setFamillySituation(String famillySituation) {
		this.famillySituation = famillySituation;
	}
	public String getCenterOfInterest() {
		return centerOfInterest;
	}
	public void setCenterOfInterest(String centerOfInterest) {
		this.centerOfInterest = centerOfInterest;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public boolean isCheckedBreakfast() {
		return checkedBreakfast;
	}
	public void setCheckedBreakfast(boolean checkedBreakfast) {
		this.checkedBreakfast = checkedBreakfast;
	}
	public boolean isCheckedLunch() {
		return checkedLunch;
	}
	public void setCheckedLunch(boolean checkedLunch) {
		this.checkedLunch = checkedLunch;
	}
	public boolean isCheckedDinner() {
		return checkedDinner;
	}
	public void setCheckedDinner(boolean checkedDinner) {
		this.checkedDinner = checkedDinner;
	}

	
	
}
