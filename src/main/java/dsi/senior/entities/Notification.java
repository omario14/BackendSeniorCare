package dsi.senior.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = -1085259957493505843L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
	 	private String senderName;
	    private String receiverName;
	    private String message;
	    private String date;
	    private String type;
	    
	    public Notification() {
	    	
	    }
	    
    public Notification(String senderName, String message, String date, String type) {
			super();
			this.senderName = senderName;
			this.message = message;
			this.date = date;
			this.setType(type);
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}