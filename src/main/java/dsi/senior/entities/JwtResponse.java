package dsi.senior.entities;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;

	 private String token;
	  private String type = "Bearer";
	  private int id;
	  private String name;
	  private String lastName;
	  private String username;
	  private String email;
	  private String fileId;
	  private List<String> roles;

	public JwtResponse(String accessToken, int id,String name,String lastName, String username, String email,String fileId, List<String> roles) {
	    this.token = accessToken;
	    this.id = id;
	    this.name=name;
	    this.lastName=lastName;
	    this.username = username;
	    this.email = email;
	    this.fileId=fileId;
	    this.roles = roles;
	  }


	public String getAccessToken() {
	    return token;
	  }

	  public void setAccessToken(String accessToken) {
	    this.token = accessToken;
	  }

	  public String getTokenType() {
	    return type;
	  }

	  public void setTokenType(String tokenType) {
	    this.type = tokenType;
	  }

	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	  public String getUsername() {
	    return username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	  public List<String> getRoles() {
	    return roles;
	  }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFileId() {
		return fileId;
	}


	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	  
	  
}