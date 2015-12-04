package mds.java.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @NotNull
    @Size(max = 255)
    String login;
    @NotNull
    @Size(max = 255)
    String password;

    public User() {
    }

    public String getLogin() {
	return this.login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}
