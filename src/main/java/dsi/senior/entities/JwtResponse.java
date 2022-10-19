package dsi.senior.entities;

import java.io.Serializable;
import java.util.Set;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;

	 private String token;
	  private String type = "Bearer";
	  private int id;
	  private String name;
	  private String lastName;
	  private String username;
	  private String email;
	  private String mobile;
	  private String gender;
	  private String adress;
	  private String password;
	  private long expiresIn;
	  
	  private FileDB picture;
	  private Set<Role> roles;
	  private Boolean connected;

	public JwtResponse(long expiresIn ,String accessToken, int id,String name,String lastName, String username, String email,String mobile,String gender,String adress,FileDB picture, Set<Role> roles,Boolean connected,String password) {
	    this.expiresIn=expiresIn;
		this.token = accessToken;
	    this.id = id;
	    this.name=name;
	    this.lastName=lastName;
	    this.username = username;
	    this.email = email;
	    this.mobile=mobile;
	    this.gender=gender;
	    this.adress=adress;
	    this.picture=picture;
	    this.roles = roles;
	    this.connected=connected;
	    this.setPassword(password);
	  }


	
	
	public long getExpiresIn() {
		return expiresIn;
	}




	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
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

	  public Set<Role> getRoles() {
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


	public FileDB getPicture() {
		return picture;
	}


	public void setPicture(FileDB picture) {
		this.picture = picture;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}




	public Boolean getConnected() {
		return connected;
	}




	public void setConnected(Boolean connected) {
		this.connected = connected;
	}
	  
	  
}