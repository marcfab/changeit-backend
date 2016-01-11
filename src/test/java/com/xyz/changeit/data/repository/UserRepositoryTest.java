package com.xyz.changeit.data.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyz.changeit.conf.MongoConfigTest;
import com.xyz.changeit.data.entity.User;

/**
 * Created by mcosta on 11/01/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoConfigTest.class })
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void findUserByEmail() {

        repository
            .save(new User("Marc", "Costa Fabré", "marcfab87@gmail.com"));

        User user = repository.findByEmail("marcfab87@gmail.com");

        Assert.assertNotNull(user);
    }
}
