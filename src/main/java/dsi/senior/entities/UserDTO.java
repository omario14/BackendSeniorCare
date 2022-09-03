package dsi.senior.entities;

import java.io.Serializable;

public class UserDTO implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String lastName;
    private String username;
    private String password;
    private String email ;
    private String fileId;
    
    private Boolean connected;


    public String getEmail() {
            return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }



    public static long getSerialversionuid() {
            return serialVersionUID;
    }

    public String getUsername() {
            return username;
    }

    public void setUsername(String username) {
            this.username = username;
    }

    public String getPassword() {
            return password;
    }

    public void setPassword(String password) {
            this.password = password;
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

	public Boolean getConnected() {
		return connected;
	}

	public void setConnected(Boolean connected) {
		this.connected = connected;
	}
    
    

}