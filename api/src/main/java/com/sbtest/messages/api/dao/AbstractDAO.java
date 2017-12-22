package com.sbtest.messages.api.dao;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;

public class AbstractDAO {
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }

    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "local");
    }
}
