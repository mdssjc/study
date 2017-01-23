package com.github.mdssjc.tarefas.persistence;

import com.github.mdssjc.tarefas.entity.User;

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
