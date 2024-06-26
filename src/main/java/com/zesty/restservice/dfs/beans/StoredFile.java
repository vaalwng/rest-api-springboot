package com.zesty.restservice.dfs.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class StoredFile extends StoredEntry {

    String path;
    String name;
    @JsonIgnore EntryCategory category;

    @JsonCreator
    public StoredFile(
        String path,
        String name,
        EntryCategory category
    ) {
        this.path = path;
        this.name = name;
        this.category = category;
    }

    boolean isSoftDeleted() {
        // check if .deleted suffix is part of name
        return name.endsWith(".deleted");
    }

    boolean isQuarantined() {
        // check if .quarantined suffix is part of name
        return name.endsWith(".quarantined");
    }

}
