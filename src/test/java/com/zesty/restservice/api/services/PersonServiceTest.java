package com.zesty.restservice.api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zesty.restservice.api.beans.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private PersonService service;

    @BeforeEach
    void setUp() {
        service = new PersonService();
    }

    @Test
    void generate() {
        Person p1 = new Person(1, "John", "Doe", 32);
        Person p2 = new Person(2, "Jack", "Joe", 36);
        assertEquals(p1, service.generate("John", "Doe", 32));
        assertEquals(p2, service.generate("Jack", "Joe", 36));
    }
}
