package dsi.senior.entities;

import java.io.Serializable;

public class UserDTO implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String email ;
    


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

}