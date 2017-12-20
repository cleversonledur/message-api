package com.sbtest.messages.api.controller;


import com.sbtest.messages.api.bo.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user-v1/")
public class UserServiceV1 {

    @Autowired
    UserBO userBO;


    @RequestMapping(method = RequestMethod.GET)
    Map<Object, Object> list() {
        return userBO.listUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    Object add(@RequestBody String name,
             @RequestBody String email,
             @RequestBody String password
             ){
        return userBO.addUser(name, email, password);
    }

}
