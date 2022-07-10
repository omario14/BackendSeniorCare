package dsi.senior.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Meal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	@Column(name="label")
	private String label;
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "type")
	private MealType type;
	
	@OneToOne
	private FileDB image; 
	
	
	
	
	public Meal() {
		
	}




	public Meal(String label, String description, FileDB image) {
		super();
		this.label = label;
		this.description = description;
		this.image = image;
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




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public MealType getType() {
		return type;
	}




	public void setType(MealType type) {
		this.type = type;
	}




	public FileDB getImage() {
		return image;
	}




	public void setImage(FileDB image) {
		this.image = image;
	}




	@Override
	public String toString() {
		return "Meal [id=" + id + ", label=" + label + ", description=" + description + ", type=" + type + ", image="
				+ image + "]";
	}




	
	
	
	

}
