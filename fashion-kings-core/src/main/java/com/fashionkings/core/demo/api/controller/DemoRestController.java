package com.fashionkings.core.demo.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class DemoRestController {


    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "The app works just fines";
    }

    @RequestMapping(value = "welcome", method = RequestMethod.POST)
    public String another() {
        return "Welcome to another page";
    }
}
