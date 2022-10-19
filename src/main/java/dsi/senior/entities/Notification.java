package dsi.senior.entities;

public class Notification {

	 private String senderName;
	    private String receiverName;
	    private String message;
	    private String date;
	    
	    public Notification() {
	    	
	    }
	    
    public Notification(String senderName, String receiverName, String message, String date) {
			super();
			this.senderName = senderName;
			this.receiverName = receiverName;
			this.message = message;
			this.date = date;
		}

    
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	

}