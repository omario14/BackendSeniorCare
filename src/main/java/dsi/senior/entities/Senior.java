package dsi.senior.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="senior")
public class Senior implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String lastname;
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	@Column(name="date_birth")
	private String dateOfBirth;
	private String sex;
	private String cin;
	private String telephone;
	private String adress;
	@Column(name="fam_situation")
	private String famillySituation;
	@Column(name="interests")
	@JsonProperty("centerOfInterest")
	private String centerOfInterest;
	private String fileId;
	private double weight;
	private double height;
	private double bmi;
	private boolean checkedBreakfast;
	private boolean checkedLunch;
	private boolean checkedDinner;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "senior_menus", 
				joinColumns = @JoinColumn(name = "senior_id",nullable=false), 
				inverseJoinColumns = @JoinColumn(name = "menu_id",nullable=false))
	private Set<Menu> menus = new HashSet<>();
	
	@OneToMany(mappedBy="senior", cascade=CascadeType.ALL)
	private Set<Calendar> calendar;
	
	
	
	public Senior() {
		
	}
	
	




	public Senior(String name, String lastname, String dateOfBirth, String sex, String cin, String telephone,
			String adress, String famillySituation, String centerOfInterest ,String fileid,double weight,double height) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.cin = cin;
		this.telephone = telephone;
		this.adress = adress;
		this.famillySituation = famillySituation;
		this.centerOfInterest = centerOfInterest;
		this.fileId = fileid;
		this.weight = weight;
		this.height = height;
	}




	public Senior(Set<Menu> menus) {
		super();
		this.menus = menus;
	}
	






	public Senior(String name, String lastname, String dateOfBirth, String sex, String cin, String telephone,
			 String fileId, boolean checkedBreakfast,
			boolean checkedLunch, boolean checkedDinner) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.cin = cin;
		this.telephone = telephone;
		this.fileId = fileId;
		this.checkedBreakfast = checkedBreakfast;
		this.checkedLunch = checkedLunch;
		this.checkedDinner = checkedDinner;
	}


	




	public Senior(long id, String name, String lastname, String dateOfBirth, String sex, String cin, String telephone,
			String adress, String famillySituation, String centerOfInterest, String fileId, boolean checkedBreakfast,
			boolean checkedLunch, boolean checkedDinner, Set<Menu> menus) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.cin = cin;
		this.telephone = telephone;
		this.adress = adress;
		this.famillySituation = famillySituation;
		this.centerOfInterest = centerOfInterest;
		this.fileId = fileId;
		this.checkedBreakfast = checkedBreakfast;
		this.checkedLunch = checkedLunch;
		this.checkedDinner = checkedDinner;
		this.menus = menus;
		
	}






	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


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




	public String getFile() {
		return fileId;
	}




	public void setFile(String fileId) {
		this.fileId = fileId;
	}






	






	public Set<Menu> getMenus() {
		return menus;
	}






	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
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














	
	
	
	


}