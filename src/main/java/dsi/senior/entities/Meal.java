package dsi.senior.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private boolean checkedBreakfast;
	private boolean checkedLunch;
	private boolean checkedDinner;
	@ManyToOne
	@JoinColumn(name = "type")
	private MealType type;
	
	@OneToOne
	private FileDB image; 
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "meal_ingredients", 
				joinColumns = @JoinColumn(name = "meal_id",nullable=false), 
				inverseJoinColumns = @JoinColumn(name = "ingredient_id",nullable=false))
	private Set<Ingredients> ingredients = new HashSet<>();
	
	
	
	
	public Meal() {
		
	}




	public Meal(String label, String description, FileDB image,Set<Ingredients> ingredients) {
		super();
		this.label = label;
		this.description = description;
		this.image = image;
		this.ingredients = ingredients;
	}
	
	





	public Meal(String label, String description, boolean checkedBreakfast, boolean checkedLunch, boolean checkedDinner,
			 FileDB image, Set<Ingredients> ingredients) {
		super();
		this.label = label;
		this.description = description;
		this.checkedBreakfast = checkedBreakfast;
		this.checkedLunch = checkedLunch;
		this.checkedDinner = checkedDinner;
		this.image = image;
		this.ingredients = ingredients;
	}

	public Meal(String label, String description, boolean checkedBreakfast,
			 FileDB image, Set<Ingredients> ingredients) {
		super();
		this.label = label;
		this.description = description;
		this.checkedBreakfast = checkedBreakfast;
		this.image = image;
		this.ingredients = ingredients;
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

	
	



	public Set<Ingredients> getIngredients() {
		return ingredients;
	}




	public void setIngredients(Set<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}




	@Override
	public String toString() {
		return "Meal [id=" + id + ", label=" + label + ", description=" + description + ", type=" + type + ", image="
				+ image + "]";
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
