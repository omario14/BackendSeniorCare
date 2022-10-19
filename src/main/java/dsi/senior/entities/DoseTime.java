package dsi.senior.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DoseTime { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String time;
	@ManyToOne
	private ArchiveSenior arch;
	@ManyToOne
	private Medication med;
	private int rdose;
	public boolean isDone;
	
	public DoseTime() {
		
	}
	
	public DoseTime(String time,Medication med, ArchiveSenior arch,int rdose,boolean isDone) {
		super();
		this.time = time;
		this.med = med;
		this.arch = arch;
		this.rdose = rdose;
		this.isDone = isDone;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	

	
	public int getRdose() {
		return rdose;
	}

	public void setRdose(int rdose) {
		this.rdose = rdose;
	}

	public ArchiveSenior getArch() {
		return arch;
	}

	public void setArch(ArchiveSenior arch) {
		this.arch = arch;
	}

	public Medication getMed() {
		return med;
	}

	public void setMed(Medication med) {
		this.med = med;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	
	

	
	
	
	
	

}
