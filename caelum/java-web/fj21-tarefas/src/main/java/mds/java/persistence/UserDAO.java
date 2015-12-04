package mds.java.persistence;

import mds.java.entity.User;

public class UserDAO {

    public UserDAO() {
    }

    public boolean checkUser(User user) {
	if (user.getLogin().equals("user") && user.getPassword().equals("pass")) {
	    return true;
	}
	return false;
    }
}
