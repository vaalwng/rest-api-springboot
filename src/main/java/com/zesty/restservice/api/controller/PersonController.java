package com.zesty.restservice.api.controller;

import com.zesty.restservice.api.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zesty.restservice.api.beans.Person;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController @Slf4j
@RequestMapping(path = "/person", produces = APPLICATION_JSON_VALUE)
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    // sample: http://localhost:7777/zesty/person/create?firstName=Jackson&lastName=Jack&age=12
    @GetMapping(path = "/create", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> create(
        @RequestParam(value = "firstName", defaultValue = "John") final String firstName,
        @RequestParam(value = "lastName", defaultValue = "Doe") final String lastName,
        @RequestParam(value = "age", defaultValue = "32") final int age) {

        Person person = personService.generate(firstName, lastName, age);
        log.info("Creating Person({}, {}, {}, {})", person.getId(), firstName, lastName, age);

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

}
