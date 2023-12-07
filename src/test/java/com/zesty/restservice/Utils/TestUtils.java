package com.zesty.restservice.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

import static com.zesty.restservice.Utils.ResourceUtils.resourceToString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public interface TestUtils {

    ObjectMapper objectMapper = new ObjectMapper();

    static void verifySerdes(ObjectMapper mapper, Object object, String json) throws IOException {
        String serialized = mapper.writeValueAsString(object);
        Assertions.assertEquals(json, serialized);
        Object deserialized = mapper.readValue(serialized, object.getClass());
        Assertions.assertEquals(object, deserialized);
    }

    static void verifySerdes(Object object, String json) throws IOException {
        verifySerdes(new ObjectMapper(), object, json);
    }

    static void verifyEqualsAndHashCode(Object instanceA, Object instanceB) {
        MatcherAssert.assertThat(instanceA, Matchers.equalTo(instanceA));
        MatcherAssert.assertThat(instanceB, Matchers.equalTo(instanceB));
        MatcherAssert.assertThat(instanceA, Matchers.equalTo(instanceB));
        MatcherAssert.assertThat(instanceB, Matchers.equalTo(instanceA));
        MatcherAssert.assertThat(instanceA.hashCode(), Matchers.equalTo(instanceA.hashCode()));
        MatcherAssert.assertThat(instanceB.hashCode(), Matchers.equalTo(instanceB.hashCode()));
        MatcherAssert.assertThat(instanceA.hashCode(), Matchers.equalTo(instanceB.hashCode()));
        MatcherAssert.assertThat(instanceB.hashCode(), Matchers.equalTo(instanceA.hashCode()));
    }

    static void verifySerialization(Object object, String expectedJson) throws IOException {
        verifySerialization(new ObjectMapper(), object, expectedJson);
    }

    static void verifySerialization(ObjectMapper mapper, Object object, String expectedJson) throws IOException {
        Assertions.assertEquals(expectedJson, mapper.writeValueAsString(object));
    }

    static void verifyDeserialization(String json, Object expectedObject) throws IOException {
        verifyDeserialization(new ObjectMapper(), json, expectedObject);
    }

    static void verifyDeserialization(ObjectMapper mapper, String json, Object expectedObject) throws IOException {
        Assertions.assertEquals(expectedObject, mapper.readValue(json, expectedObject.getClass()));
    }

    static void verifyToString(String expected, Object obj) {
        Assertions.assertEquals(expected, obj.toString());
    }

    static void verifyJsonString(String filePath, Object actual) throws IOException {
        assertEquals(
            objectMapper.writeValueAsString(actual),
            objectMapper.writeValueAsString(
                objectMapper.readTree(resourceToString(filePath))
            )
        );
    }

}
