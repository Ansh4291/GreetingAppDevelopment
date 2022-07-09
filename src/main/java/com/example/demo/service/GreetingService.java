package com.example.demo.service;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
    private GreetingRepository repository;
    public String greetingMessage(){
        return "Hello World!";
    }
    public String greetingWithUserName(String firstName, String lastName) {
        if(firstName.isEmpty() && lastName.isEmpty())
            return greetingMessage();
        else if (!(firstName.equals("")) && (lastName.equals(""))) {
            return "Hello & Welcome to the greeting app, "+firstName;
        }
        else if (!(lastName.equals("")) && (firstName.equals(""))) {
            return "Hello & Welcome to the greeting app, "+lastName;
        }
        else
            return "Hello & Welcome to the greeting app, "+firstName+" "+lastName+"!";
    }

    public Greeting saveGreetings(Greeting greeting){
       return repository.save(greeting);
    }
    public Greeting findGreetingById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
