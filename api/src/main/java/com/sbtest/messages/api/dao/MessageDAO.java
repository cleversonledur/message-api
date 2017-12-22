package com.sbtest.messages.api.dao;

import com.sbtest.messages.api.dao.iface.IMessageDAO;
import com.sbtest.messages.api.exception.DAOException;
import com.sbtest.messages.api.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageDAO extends AbstractDAO {

    @Autowired
    private IMessageDAO messageDAO;

    private String entityName(){
        return Message.class.getName();
    }
    public void save(Message message) throws DAOException {
        try {
            mongoTemplate().insert(message,entityName());
        } catch (Exception e) {
            throw new DAOException("Error during message creation.", e);
        }
    }

    public void update(Message message) throws  DAOException{
        try {
            mongoTemplate().save(message);
        } catch (Exception e) {
            throw new DAOException("Error during message update.", e);
        }
    }

    public void delete(Message message) throws  DAOException{
        try {
            mongoTemplate().remove(message);
        } catch (Exception e) {
            throw new DAOException("Error during message update.", e);
        }
    }



}
