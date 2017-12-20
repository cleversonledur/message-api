package com.sbtest.messages.api.bo;

import com.sbtest.messages.api.dao.UserDAO;
import com.sbtest.messages.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserBO {

    @Autowired
    UserDAO userDAO;

    public Map<Object,Object> listUsers() {
        return userDAO.findAllUsers();
    }

    public Object addUser(String name, String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);

        userDAO.saveUser(user);
        return user;

    }
}
