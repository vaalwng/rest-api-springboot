package com.zesty.restservice.dfs.beans;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.util.stream.Stream.of;
import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE) @Getter
public enum EntryCategory {

    LOCAL("local"),
    DISTRIBUTED("distributed");

    private final String category;

    public static EntryCategory fromString(String category) {
        return of(EntryCategory.values())
            .filter(fc -> fc.category.equalsIgnoreCase(category))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Unknown category: " + category));
    }

    @JsonValue
    public String toString() {
        return category;
    }

}
