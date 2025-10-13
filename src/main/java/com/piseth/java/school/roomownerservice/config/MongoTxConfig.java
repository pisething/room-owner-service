package com.piseth.java.school.roomownerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.ReactiveMongoTransactionManager;

//@Configuration
public class MongoTxConfig {

    //@Bean
    public ReactiveMongoTransactionManager reactiveMongoTransactionManager(
            final ReactiveMongoDatabaseFactory factory) {
        return new ReactiveMongoTransactionManager(factory);
    }
}
