package com.example.demo.controller;

import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

//    @RequestMapping("/hello")
//    public String Hello(){
//        return "hello From Bridgelabz";
//    }
//
//    @RequestMapping ("/query/{name}")
//    public String sayHello(@PathVariable String name) {
//        return "Hello " + name + "!";
//    }
//
//    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
//    public String sayHelloParam(@RequestParam(value = "name") String name)
//    {
//        return "Hello " + name + "!";
//    }
public static final String template = "Hello & Welcome to the greeting app, %s";
    public final AtomicLong counter = new AtomicLong();
    @Autowired
    public GreetingService service;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @RequestMapping("/welcome")
    public String displayMessage(){
        return service.greetingMessage();
    }
}
