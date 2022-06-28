package dsi.senior.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "INGCategories")
public class IngredientsCategories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private String label;
	
	@OneToMany(mappedBy="Category")
	private List<Ingredients> ingredient;
	@OneToOne
	private FileDB categoryimage;
	
	
	public IngredientsCategories() {
		
	}


	

	public IngredientsCategories(long id, String label, FileDB categoryimage) {
		super();
		this.id = id;
		this.label = label;
		this.categoryimage = categoryimage;
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




	public FileDB getIngCategoryImage() {
		return categoryimage;
	}




	public void setIngCategoryImage(FileDB categoryimage) {
		this.categoryimage = categoryimage;
	}
	
	
	
	

}
