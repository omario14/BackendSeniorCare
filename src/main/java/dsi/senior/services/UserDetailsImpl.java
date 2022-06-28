package dsi.senior.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dsi.senior.entities.DAOUser;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private int id;
  
  private String name;
  private String lastName;
  

  private String username;

  private String email;

  private String fileId;
  
  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(int id,String name,String lastName, String username, String email,String fileId, String password,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.name=name;
    this.lastName=lastName;
    this.username = username;
    this.email = email;
    this.fileId=fileId;
    this.password = password;
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
		        user.getFileId(),
		        user.getPassword(), 
		        authorities));
		    return new UserDetailsImpl(
		    		user.getId(), 
			        user.getName(),
			        user.getLastName(),
			        user.getUsername(), 
			        user.getEmail(),
			        user.getFileId(),
			        user.getPassword(), 
		        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public int getId() {
    return id;
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
}
