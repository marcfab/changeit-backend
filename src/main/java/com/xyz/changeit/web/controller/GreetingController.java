package com.xyz.changeit.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Marc on 09/01/2016.
 */
@RestController
public class GreetingController {

    static class Gretting {

        private String greeting;

        public Gretting(String greeting) {
            this.greeting = greeting;
        }

        public String getGreeting() {
            return greeting;
        }

    }


    @RequestMapping("/greeting")
    public Gretting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Gretting("Hello " + name);
    }
}
