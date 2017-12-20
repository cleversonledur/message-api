package com.sbtest.messages.api.dao;

import com.sbtest.messages.api.model.User;

import java.util.Map;

public interface IUserDAO {

    public void saveUser(User user);
    public void deleteUser(String id);
    public User findUser(String id);
    public Map<Object, Object> findAllUsers();

}
