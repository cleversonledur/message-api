package com.sbtest.messages.api.dao;

import com.sbtest.messages.api.dao.iface.IMessageDAO;
import com.sbtest.messages.api.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageDAO extends AbstractDAO {

    @Autowired
    private IMessageDAO messageDAO;

    public void save(Message message){
        this.messageDAO.save(message);
    }



}
