package com.zesty.restservice.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zesty.restservice.api.beans.Person;
import com.zesty.restservice.api.services.PersonService;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@WebMvcTest(controllers = PersonController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {

    private static final String BASE_URL = "/person";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
        personService = new PersonService();
        mockMvc = standaloneSetup(new PersonController(personService)).build();
    }

    @Test @DisplayName("create person - default value")
    void createPersonDefault() throws Exception {
        val url = BASE_URL + "/create";

        Person person = new Person(1L, "John", "Doe", 32);
        val output = objectMapper.writeValueAsString(person);
        mockMvc.perform(get(url)
            .contentType(APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_VALUE))
            .andExpect(content().json(output));
    }

    @Test @DisplayName("create person - non-default value")
    void createPersonParam() throws Exception {
        val url = BASE_URL + "/create";

        Person person = new Person(1L, "Timmy", "Turner", 23);
        val output = objectMapper.writeValueAsString(person);
        mockMvc.perform(get(url)
                .contentType(APPLICATION_JSON_VALUE)
                .param("firstName", "Timmy")
                .param("lastName", "Turner")
                .param("age", "23"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_VALUE))
            .andExpect(content().json(output));
    }

}