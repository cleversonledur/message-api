package com.sbtest.messages.api.dao;

import com.sbtest.messages.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class UserDAO {

    private static final String KEY = "User";

    private RedisTemplate<String, User> redisTemplate;
    private HashOperations hashOps;

    @Autowired
    public UserDAO(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }

    public void saveUser(User user) {
        hashOps.put(KEY, user.getId(), user);
    }

    public void deleteUser(String id) {
        hashOps.delete(KEY, id);
    }

    public User findUser(String id) {
        return (User) hashOps.get(KEY, id);
    }

    public Map<Object, Object> findAllUsers() {
        return hashOps.entries(KEY);
    }

}
