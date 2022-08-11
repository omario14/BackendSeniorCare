package dsi.senior.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class archmedPK  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4787211806218634033L;
	
	private String idArchive;
	private long idMedication;
	
	
	public archmedPK() {
		super();
	}


	public archmedPK(String idArchive, long idMedication) {
		super();
		this.idArchive = idArchive;
		this.idMedication = idMedication;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idArchive, idMedication);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		archmedPK other = (archmedPK) obj;
		return idArchive == other.idArchive && idMedication == other.idMedication;
	}


	public String getIdArch() {
		return idArchive;
	}


	public void setIdArch(String idArchive) {
		this.idArchive = idArchive;
	}


	public long getIdmed() {
		return idMedication;
	}


	public void setIdmed(long idMedication) {
		this.idMedication = idMedication;
	}
	
	

}
