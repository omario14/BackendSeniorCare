package request;


public class IngredientRequest {

	private long id;
	private String label;
	private String description;
	private boolean checked;
	private String file;
	private long Category;
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
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public long getCategory() {
		return Category;
	}
	public void setCategory(long category) {
		Category = category;
	}
	
	
	
	
}
