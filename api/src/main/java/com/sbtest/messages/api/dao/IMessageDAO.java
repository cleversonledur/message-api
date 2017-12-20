package com.sbtest.messages.api.dao;

import com.sbtest.messages.api.model.Message;

import java.util.Map;

public interface IMessageDAO {

    public void saveMessage(Message message);

    public void deleteMessage(String id);

    public Message findMessage(String id);

    public Map<Object, Object> findAllMessages();
}
