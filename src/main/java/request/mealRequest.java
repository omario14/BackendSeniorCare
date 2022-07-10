package request;

import dsi.senior.entities.FileDB;

public class mealRequest {
	
	
	private String label;
	private String description;
	private FileDB image;
	private String type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public FileDB getImage() {
		return image;
	}
	public void setImage(FileDB image) {
		this.image = image;
	}
	
	
	

}
