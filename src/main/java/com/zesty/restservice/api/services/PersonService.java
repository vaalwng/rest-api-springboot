package com.zesty.restservice.api.services;

import com.zesty.restservice.api.beans.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service @Slf4j
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public PersonService() {
    }

    public Person generate(String firstName, String lastName, int age) {
        return new Person(counter.incrementAndGet(), firstName, lastName, age);
    }
}
