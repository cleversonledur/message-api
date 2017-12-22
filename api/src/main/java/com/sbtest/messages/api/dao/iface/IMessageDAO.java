package com.sbtest.messages.api.dao.iface;

import com.sbtest.messages.api.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMessageDAO  extends MongoRepository<Message, String> {


}
