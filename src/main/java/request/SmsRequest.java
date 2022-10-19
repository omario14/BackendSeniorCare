package request;

import javax.validation.constraints.NotBlank;


public class SmsRequest {

	@NotBlank
	private final String phoneNumber; //destination
	
	@NotBlank
	private final String message;
	
	
	
	
	public SmsRequest(String phoneNumber,String message) {
		this.phoneNumber = phoneNumber;
		this.message = message;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return "smsRequest [phoneNumber=" + phoneNumber + ", message=" + message + "]";
	}
	
	
	
	
}
