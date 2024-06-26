package com.zesty.restservice.api.services;

import com.zesty.restservice.dfs.beans.EntryCategory;
import com.zesty.restservice.dfs.beans.StorageInfo;
import com.zesty.restservice.dfs.beans.StoredDirectory;
import com.zesty.restservice.dfs.beans.StoredEntry;
import com.zesty.restservice.dfs.beans.StoredFile;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class DFSService {
    
    public List<StoredEntry> list() {
        List<StoredEntry> entries = new ArrayList<>();
        
        // create root level files
        StoredFile file1 = new StoredFile("/rootDirectory/file1", "file1", EntryCategory.LOCAL);
        StoredFile file2 = new StoredFile("/rootDirectory/file2", "file2", EntryCategory.LOCAL);

        // create subdirectory level files
        StoredFile file3 = new StoredFile("/rootDirectory/dir1/file3", "file3", EntryCategory.DISTRIBUTED);
        StoredFile file4 = new StoredFile("/rootDirectory/dir1/file4", "file4", EntryCategory.DISTRIBUTED);
        List<StoredEntry> dir1Entries = new ArrayList<>();
        dir1Entries.add(file3);
        dir1Entries.add(file4);

        // add files to subdirectory
        StoredDirectory dir1 = new StoredDirectory("/rootDirectory/dir1", "dir1", dir1Entries);

        // add files to root directory
        entries.add(file1);
        entries.add(file2);
        entries.add(dir1);

        return entries;
    }

    public List<StorageInfo> info(boolean isLocal) {
        List<StorageInfo> storageInfo = new ArrayList<>();
        if (isLocal) {
            storageInfo.add(
                new StorageInfo(
                    "nodehost:nodeport",
                    "online",
                    "/storage/root",
                    11111L,
                    8675309L
                )
            );
        } else {
            storageInfo.add(
                new StorageInfo(
                    "nodehost1:nodeport1",
                    "online",
                    "/storage/root",
                    11111L,
                    8675309L
                )
            );
            storageInfo.add(
                new StorageInfo(
                    "nodehost2:nodeport2",
                    "offline",
                    "/storage/root",
                    11111L,
                    8675309L
                )
            );
            storageInfo.add(
                new StorageInfo(
                    "nodehost3:nodeport3",
                    "online",
                    "/storage/root",
                    11111L,
                    8675309L
                )
            );
        }

        return storageInfo;
    }

}
