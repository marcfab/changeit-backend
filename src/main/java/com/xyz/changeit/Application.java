package com.xyz.changeit;

import com.xyz.changeit.data.entity.Item;
import com.xyz.changeit.data.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Created by Marc on 10/01/2016.
 */
@SpringBootApplication(scanBasePackages = {"com.xyz.changeit.conf", "com.xyz.changeit.data",
        "com.xyz.changeit.service", "com.xyz.changeit.web"})
public class Application implements CommandLineRunner {

    @Autowired
    private ItemRepository itemRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        itemRepository.deleteAll();

        itemRepository.save(new Item("Item1", "The first item_" + System.currentTimeMillis()));

        List<Item> items = itemRepository.findByName("Item1");

        for (Item item : items) {
            System.out.println(item.getName());
        }
    }
}
