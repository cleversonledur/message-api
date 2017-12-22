package com.sbtest.messages.api.dao.iface;

import com.sbtest.messages.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserDAO extends MongoRepository<User, String> {


}
