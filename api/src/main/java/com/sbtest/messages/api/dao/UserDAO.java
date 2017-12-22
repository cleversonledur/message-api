package com.sbtest.messages.api.dao;

import com.sbtest.messages.api.dao.iface.IUserDAO;
import com.sbtest.messages.api.exception.DAOException;
import com.sbtest.messages.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserDAO extends AbstractDAO{



    @Autowired
    private IUserDAO userDAO;

    private String entityName(){
        return User.class.getName();
    }

    public List<User> listAll() {
        return this.userDAO.findAll();
    }


    public User save(User user) throws DAOException {
        try {
            mongoTemplate().insert(user,entityName());
            return user;
        } catch (Exception e) {
            throw new DAOException("Ocorreu um problema ao inserir o usuário.");
        }
    }

    public User update(User user) {
        return this.userDAO.save(user);
    }

    public void remove(User user) {
        this.userDAO.delete(user);
    }

    public User findByEmail(String email) throws DAOException {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        try {
            return this.mongoTemplate().findOne(query,User.class);
        } catch (Exception e) {
            throw new DAOException("Ocorreu um erro ao consultar os dados no banco de dados.");
        }

    }


}
