package com.zesty.restservice.dfs.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import java.util.List;

@Data
public class StoredDirectory extends StoredEntry {

    String path;
    String name;
    List<StoredEntry> entries;

    @JsonCreator
    public StoredDirectory(String path, String name, List<StoredEntry> entries) {
        this.path = path;
        this.name = name;
        this.entries = entries;
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
