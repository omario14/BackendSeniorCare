package request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import dsi.senior.entities.FileDB;

public class SignupRequest {
	
	
	private String mobile;
	private String gender;
	private String adress;
	
	private String name;
	
	private String lastName;
	
	private FileDB picture;
	
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
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

@Override
public String toString() {
	return "SignupRequest [mobile=" + mobile + ", gender=" + gender + ", adress=" + adress + ", name=" + name
			+ ", lastName=" + lastName + ", picture=" + picture + ", username=" + username + ", email=" + email
			+ ", role=" + role + ", password=" + password + "]";
}


  
}