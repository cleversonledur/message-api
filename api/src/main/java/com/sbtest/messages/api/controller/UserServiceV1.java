package com.sbtest.messages.api.controller;


import com.sbtest.messages.api.bo.UserBO;
import com.sbtest.messages.api.exception.DAOException;
import com.sbtest.messages.api.exception.GenericException;
import com.sbtest.messages.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-v1/")
public class UserServiceV1 {

    @Autowired(required=false)
    UserBO userBO;


    @RequestMapping(method = RequestMethod.GET)
    List<User> list() {
        return userBO.listUsers();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    Object add(@RequestParam String name,
             @RequestParam String email,
             @RequestParam String password
             ) throws DAOException, GenericException {
        return userBO.addUser(name, email, password);
    }

}
