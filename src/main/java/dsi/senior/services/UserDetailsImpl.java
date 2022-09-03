package dsi.senior.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dsi.senior.entities.DAOUser;
import dsi.senior.entities.FileDB;
import dsi.senior.entities.Role;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private int id;
  
  private String name;
  private String lastName;
  

  private String username;

  private String email;
  private String mobile;
  private String gender;
  
  private String adress;
  private FileDB picture;
  private Set<Role> roles;
  private Boolean connected;
  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(int id,String name,String lastName, String username, String email,String mobile,String gender,String adress,FileDB picture,Boolean connected, String password,Set<Role> roles,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.name=name;
    this.lastName=lastName;
    this.username = username;
    this.email = email;
    this.mobile=mobile;
    this.gender=gender;
    this.adress=adress;
    this.picture=picture;
    this.connected=connected;
    this.password = password;
    this.roles=roles;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(DAOUser user) {
	  List<GrantedAuthority> authorities = user.getRoles().stream()
		        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
		        .collect(Collectors.toList());
System.out.println("TEST 1"+new UserDetailsImpl(
		        user.getId(), 
		        user.getName(),
		        user.getLastName(),
		        user.getUsername(), 
		        user.getEmail(),
		        user.getMobile(),
		        user.getGender(),
		        user.getAdress(),
		        user.getPicture(),
		        user.getConnected(),
		        user.getPassword(), 
		        user.getRoles(),
		        authorities));
		    return new UserDetailsImpl(
		    		user.getId(), 
			        user.getName(),
			        user.getLastName(),
			        user.getUsername(), 
			        user.getEmail(),
			        user.getMobile(),
			        user.getGender(),
			        user.getAdress(),
			        user.getPicture(),
			        user.getConnected(),
			        user.getPassword(), 
			        user.getRoles(),
		        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public int getId() {
    return id;
  }
  
  

  public Set<Role> getRoles() {
	return roles;
}

public void setRoles(Set<Role> roles) {
	this.roles = roles;
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

public void setId(int id) {
	this.id = id;
}

public void setUsername(String username) {
	this.username = username;
}

public void setEmail(String email) {
	this.email = email;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }
  
  

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }

public Boolean getConnected() {
	return connected;
}

public void setConnected(Boolean connected) {
	this.connected = connected;
}
}
