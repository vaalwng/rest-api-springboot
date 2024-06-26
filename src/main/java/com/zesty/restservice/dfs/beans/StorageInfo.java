package com.zesty.restservice.dfs.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StorageInfo {

    String node;

    String state;

    @JsonProperty("storage-path")
    String storagePath;

    @JsonProperty("used-space")
    private Long usedSpace;

    @JsonProperty("total-space")
    private Long totalSpace;

    @JsonCreator
    public StorageInfo(
        @JsonProperty("node") String node,
        @JsonProperty("state") String state,
        @JsonProperty("storage-path") String storagePath,
        @JsonProperty("used-space") Long usedSpace,
        @JsonProperty("total-space") Long totalSpace
    ) {
        this.node = node;
        this.state = state;
        this.storagePath = storagePath;
        this.usedSpace = usedSpace;
        this.totalSpace = totalSpace;
    }

}
