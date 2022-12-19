package com.zesty.restservice.api.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode @Getter @ToString
@SuppressWarnings("ClassCanBeRecord")
public class Person {

    @JsonProperty("id")
    private final long id;
    @JsonProperty("firstName")
    private final String firstName;
    @JsonProperty("lastName")
    private final String lastName;
    @JsonProperty("age")
    private final int age;

    @JsonCreator
    public Person(@JsonProperty("id") final long id,
                  @JsonProperty("firstName") final String firstName,
                  @JsonProperty("lastName") final String lastName,
                  @JsonProperty("age") final int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}