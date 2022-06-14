package dsi.senior.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String residance;
	@Column(name="fam_situation")
	private String famillySituation;
	@Column(name="interests")
	@JsonProperty("centerOfInterest")
	private String centerOfInterest;
	private String fileId;
	
	
	public Senior() {
		
	}
	
	




	public Senior(String name, String lastname, String dateOfBirth, String sex, String cin, String telephone,
			String residance, String famillySituation, String centerOfInterest ,String fileid) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.cin = cin;
		this.telephone = telephone;
		this.residance = residance;
		this.famillySituation = famillySituation;
		this.centerOfInterest = centerOfInterest;
		this.fileId = fileid;
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


	public String getResidance() {
		return residance;
	}


	public void setResidance(String residance) {
		this.residance = residance;
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
	


}
