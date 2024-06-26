package com.zesty.restservice.dfs.beans;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = StoredFile.class, name = "file"),
    @JsonSubTypes.Type(value = StoredDirectory.class, name = "directory")
})
public abstract class StoredEntry {

    String path;
    String name;

    boolean isSoftDeleted;
    boolean isQuarantined;
}
