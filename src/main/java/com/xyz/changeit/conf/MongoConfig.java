package com.xyz.changeit.conf;

import com.mongodb.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Marc on 10/01/2016.
 */
@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "com.xyz.changeit.data")
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "mydb";
    }

    @Bean
    @Override
    public MongoClient mongo() throws Exception {
        MongoCredential mc = MongoCredential.createCredential("test", getDatabaseName(), "test".toCharArray());
        List<MongoCredential> mcList = new ArrayList<>();
        mcList.add(mc);
        ServerAddress address = new ServerAddress("localhost", 27017);
        return new MongoClient(address, mcList);
    }

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongo(), getDatabaseName());
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.xyz.changeit.data";
    }
}
