package request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


public class ArchiveSeniorRequest {
	
	private String idArch;
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	private String date;
	private boolean checkedBreakfast;
	private boolean checkedLunch;
	private boolean checkedDinner;
	private long senior;
	public String getIdArch() {
		return idArch;
	}
	public void setIdArch(String idArch) {
		this.idArch = idArch;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public long getSenior() {
		return senior;
	}
	public void setSenior(long senior) {
		this.senior = senior;
	}

	
	
	
	
}
