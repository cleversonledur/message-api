package com.sbtest.messages.api.dao;

import com.sbtest.messages.api.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class MessageDAO implements IMessageDAO {

    private static final String KEY = "Message";

    private RedisTemplate<String, Message> redisTemplate;
    private HashOperations hashOps;

    @Autowired
    public MessageDAO(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }

    public void saveMessage(Message message) {
        hashOps.put(KEY, message.getId(), message);
    }

    public void deleteMessage(String id) {
        hashOps.delete(KEY, id);
    }


    public Message findMessage(String id) {
        return (Message) hashOps.get(KEY, id);
    }

    public Map<Object, Object> findAllMessages() {
        return hashOps.entries(KEY);
    }



}
