package request;


public class DoseTimeRequest {

	
	
	private String time;
	private String arch;
	private long med;
	private int rdose;
	public boolean isDone;
	private boolean isReminded;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getArch() {
		return arch;
	}
	public void setArch(String arch) {
		this.arch = arch;
	}
	public long getMed() {
		return med;
	}
	public void setMed(long med) {
		this.med = med;
	}
	public int getRdose() {
		return rdose;
	}
	public void setRdose(int rdose) {
		this.rdose = rdose;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public boolean isReminded() {
		return isReminded;
	}
	public void setReminded(boolean isReminded) {
		this.isReminded = isReminded;
	}
	
	
	
}
