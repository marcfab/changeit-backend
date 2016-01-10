package com.xyz.changeit.data.repository;

import com.xyz.changeit.data.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Marc on 10/01/2016.
 */
@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    List<Item> findByName(String name);
}
