package com.bikash.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bikash Shah
 */
@RestController
public class TestController {

    @GetMapping(value = "/home")
    public String hello(){
        return "Bikas Shah";
    }
}
