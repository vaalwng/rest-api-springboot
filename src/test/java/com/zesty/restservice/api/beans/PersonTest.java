package com.zesty.restservice.api.beans;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.zesty.restservice.utils.TestUtils.verifyToString;
import static com.zesty.restservice.utils.TestUtils.verifyEqualsAndHashCode;
import static com.zesty.restservice.utils.TestUtils.verifySerdes;
import static com.zesty.restservice.utils.TestUtils.verifyJsonString;

public class PersonTest {

    protected static Person createPerson() {
        return new Person(1, "John", "Doe", 32);
    }

    @Test
    @DisplayName("getter")
    void get() {
        val person = createPerson();
        assertEquals(1, person.getId());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals(32, person.getAge());
    }

    @Test
    @DisplayName("toString")
    void string() {
        verifyToString("Person(id=1, firstName=John, lastName=Doe, age=32)", createPerson());
    }

    @Test
    @DisplayName("equals and hash")
    void equalsAndHash() {
        verifyEqualsAndHashCode(createPerson(), createPerson());
    }

    @Test
    @DisplayName("serdes")
    void serdes() throws IOException {
        verifySerdes(createPerson(),
            "{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":32}");
    }

    @Test
    @DisplayName("jsonToString")
    void jsonString() throws IOException {
        verifyJsonString("/beans/person.json", createPerson());
    }

}
