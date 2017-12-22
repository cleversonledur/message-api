package com.sbtest.messages.api.bo;

import com.sbtest.messages.api.exception.DAOException;
import com.sbtest.messages.api.exception.GenericException;
import com.sbtest.messages.api.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.util.AssertionErrors.fail;

public class UserBOTest {

    @Autowired
    UserBO userBO;

    @Test
    public void addUser() {

        String name = "test user";
        String email = "test@user.com";
        String password = "password";
        try {
            userBO.addUser(name, email, password );
        } catch (DAOException e) {
            fail(e.getMessage());
        } catch (GenericException e) {
            fail(e.getMessage());
        }
        User user = null;
        try {
            user = userBO.getByEmail(email);
        } catch (DAOException e) {
            fail(e.getMessage());
        }

        if(user!=null){
            fail("User not created.");
        }
    }

    @Test
    public void listUsers() {
    }

    @Test
    public void findByEmail() {
    }

    @Test
    public void login() {
    }
}