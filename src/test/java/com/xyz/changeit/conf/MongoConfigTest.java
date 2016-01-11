package com.xyz.changeit.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;

/**
 * Created by mcosta on 11/01/16.
 */
@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "com.xyz.changeit.data")
public class MongoConfigTest extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "testdb";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new EmbeddedMongoBuilder().version("3.2.0")
            .bindIp("127.0.0.1").port(12345).build();
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.xyz.changeit.data";
    }
}
