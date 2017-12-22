package com.sbtest.messages.api.bo;

import com.sbtest.messages.api.dao.UserDAO;
import com.sbtest.messages.api.exception.DAOException;
import com.sbtest.messages.api.exception.GenericException;
import com.sbtest.messages.api.model.User;
import com.sbtest.messages.api.utils.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserBO {

    @Autowired
    UserDAO userDAO;

    public List<User> listUsers() {
        return userDAO.listAll();
    }

    public Object addUser(String name, String email, String password) throws DAOException, GenericException {

        User user = userDAO.findByEmail(email);

        if(user!= null){
            throw new GenericException("This user already exists.");
        }

        user = new User();
        user.setEmail(email);
        user.setName(name);

        String saltedPassword = Hash.SALT + password;
        String hashedPassword = Hash.generateHash(saltedPassword);

        user.setPassword(hashedPassword);

        userDAO.save(user);
        return user;

    }

    public User getByEmail(String email) throws DAOException {
        return userDAO.findByEmail(email);

    }

    public UserDetails findByEmail(String email) throws DAOException {
        return userDAO.findByEmail(email);
    }

    public Boolean login(String email, String password) throws DAOException {

        Boolean isAuthenticated = false;

        String saltedPassword = Hash.SALT + password;
        String hashedPassword = Hash.generateHash(saltedPassword);

        String storedPasswordHash = userDAO.findByEmail(email).getPassword();
        if(hashedPassword.equals(storedPasswordHash)){
            isAuthenticated = true;
        }else{
            isAuthenticated = false;
        }
        return isAuthenticated;
    }
}
