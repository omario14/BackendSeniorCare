package dsi.senior.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ingredients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String label;
	private String description;
	
	@OneToOne
	private FileDB file;
	
	@ManyToOne
	private IngredientsCategories Category;
	
	
	
	public Ingredients() {
		
	}



	



	public Ingredients(long id, String label, String description, FileDB file, IngredientsCategories category) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
		this.file = file;
		this.Category = category;
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



	public IngredientsCategories getCategory() {
		return Category;
	}



	public void setCategory(IngredientsCategories category) {
		this.Category = category;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}







	public FileDB getFile() {
		return file;
	}







	public void setFile(FileDB file) {
		this.file = file;
	}
	
	
	
}
