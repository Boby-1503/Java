package com.example.hellocontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController
{
    @RequestMapping(method= RequestMethod.GET)
    public String Greeting()
    {
        return "Hello, Spring Boot!";
    }
}

