package com.zesty.restservice.api.beans;

import com.zesty.restservice.TestUtils.TestUtils;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class PersonTest {
    protected static Person createPerson() {
        return new Person(1, "John", "Doe", 32);
    }

    @Test @DisplayName("getter")
    void get() {
        val person = createPerson();
        assertEquals(1, person.getId());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals(32, person.getAge());
    }

    @Test @DisplayName("toString")
    void string() {
        TestUtils.verifyToString("Person(id=1, firstName=John, lastName=Doe, age=32)", createPerson());
    }

    @Test @DisplayName("equals and hash")
    void equalsAndHash() {
        TestUtils.verifyEqualsAndHashCode(createPerson(), createPerson());
    }

    @Test @DisplayName("serdes")
    void serdes() throws IOException {
        TestUtils.verifySerdes(createPerson(),
            "{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":32}");
    }

}
