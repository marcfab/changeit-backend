package com.xyz.changeit.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.xyz.changeit.data.entity.User;

/**
 * Created by mcosta on 11/01/16.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}
