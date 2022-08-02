package dsi.senior.entities;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class ArchiveSenior {
	
	
	@Id
	private String idArch;
	
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	private String date;
	private boolean checkedBreakfast;
	private boolean checkedLunch;
	private boolean checkedDinner;
	
	@ManyToMany
	@JoinTable(
	  name = "arch_meds", 
	  joinColumns = @JoinColumn(name = "arch_id"), 
	  inverseJoinColumns = @JoinColumn(name = "med_id"))
		private Set<Medication> meds;
	
	@ManyToOne
	private Senior senior;
	
	 
	 public ArchiveSenior() {
		 
	 }
	public ArchiveSenior(String date, boolean checkedBreakfast, boolean checkedLunch, boolean checkedDinner ,Senior senior	) {
		super();
		this.date = date;
		this.checkedBreakfast = checkedBreakfast;
		this.checkedLunch = checkedLunch;
		this.checkedDinner = checkedDinner;
		this.senior=senior;
	}
	public ArchiveSenior(String idArch,String date, boolean checkedBreakfast, boolean checkedLunch, boolean checkedDinner ,Senior senior		) {
		super();
		this.idArch=idArch;
		this.date = date;
		this.checkedBreakfast = checkedBreakfast;
		this.checkedLunch = checkedLunch;
		this.checkedDinner = checkedDinner;
		this.senior=senior;
	}
	
	

	public ArchiveSenior(String idArch, String date, boolean checkedBreakfast, boolean checkedLunch,
			boolean checkedDinner, Set<Medication> meds, Senior senior) {
		super();
		this.idArch = idArch;
		this.date = date;
		this.checkedBreakfast = checkedBreakfast;
		this.checkedLunch = checkedLunch;
		this.checkedDinner = checkedDinner;
		this.meds = meds;
		this.senior = senior;
	}
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
	public Senior getSenior() {
		return senior;
	}
	public void setSenior(Senior senior) {
		this.senior=senior;
	}
	public Set<Medication> getMeds() {
		return meds;
	}
	public void setMeds(Set<Medication> meds) {
		this.meds = meds;
	}
	@Override
	public String toString() {
		return "ArchiveSenior [idArch=" + idArch + ", date=" + date + ", checkedBreakfast=" + checkedBreakfast
				+ ", checkedLunch=" + checkedLunch + ", checkedDinner=" + checkedDinner + ", meds=" + meds + ", senior="
				+ senior + "]";
	}
	
	

	

	 
	
	

}
