package dsi.senior.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ArchiveMedication implements Serializable {
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -4686320969282534005L;

		@EmbeddedId
		private archmedPK archmedpk;
		
	//idMission est a la fois primary key et foreign key
		@ManyToOne
	    @JoinColumn(name = "idArchive", referencedColumnName = "idArch", insertable=false, updatable=false)
		private ArchiveSenior archive;
		
		//idEmploye est a la fois primary key et foreign key
		
		@ManyToOne
	    @JoinColumn(name = "idMedication", referencedColumnName = "idmed", insertable=false, updatable=false)
		private Medication meds;
		
		public boolean isDone;
		
		
		

		public ArchiveMedication() {
			
		}

		public ArchiveMedication(ArchiveSenior archive, Medication meds) {
			super();
			this.archive = archive;
			this.meds = meds;
		}
		
		
		
		

		public ArchiveMedication(archmedPK archmedpk, ArchiveSenior archive, Medication meds, boolean isDone) {
			super();
			this.archmedpk = archmedpk;
			this.archive = archive;
			this.meds = meds;
			this.isDone = isDone;
		}

		public ArchiveMedication(archmedPK archmedpk, boolean isDone) {
			super();
			this.archmedpk = archmedpk;
			this.isDone = isDone;
		}

		public archmedPK getArchmedpk() {
			return archmedpk;
		}

		public void setArchmedpk(archmedPK archmedpk) {
			this.archmedpk = archmedpk;
		}

		public ArchiveSenior getArchive() {
			return archive;
		}

		public void setArchive(ArchiveSenior archive) {
			this.archive = archive;
		}

		public Medication getMeds() {
			return meds;
		}

		public void setMeds(Medication meds) {
			this.meds = meds;
		}

		public boolean isDone() {
			return isDone;
		}

		public void setDone(boolean isDone) {
			this.isDone = isDone;
		}
		
		
		
		


}
