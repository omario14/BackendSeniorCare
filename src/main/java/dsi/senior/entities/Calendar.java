package dsi.senior.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "calendar")
public class Calendar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -80150591707256688L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String name;
	private String color;
	private String type;
	private String date;

	@ManyToOne 
	private Senior senior;
	
	public Calendar() {

	}

	public Calendar(String id,String name, String color, String type, String date,Senior senior) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.type = type;
		this.date = date;
		this.senior = senior;
	}
	
	public Calendar(String name, String color, String type, String date,Senior senior) {
		super();
		this.name = name;
		this.color = color;
		this.type = type;
		this.date = date;
		this.senior = senior;
	}
	public Calendar(String id,String name, String color, String type, String date) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.type = type;
		this.date = date;
	}
	public Calendar(String name, String color, String type, String date) {
		super();
		this.name = name;
		this.color = color;
		this.type = type;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Senior getSenior() {
		return senior;
	}

	public void setSenior(Senior senior) {
		this.senior = senior;
	}
	
	
	
	

}
