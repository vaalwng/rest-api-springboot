package com.zesty.restservice.dfs.FileSystemMonitor;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import com.zesty.restservice.dfs.beans.StoredFile;
import lombok.extern.slf4j.Slf4j;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.devtools.filewatch.ChangedFile;
import org.springframework.boot.devtools.filewatch.ChangedFiles;
import org.springframework.boot.devtools.filewatch.FileSystemWatcher;
import org.springframework.stereotype.Component;

@Component @Slf4j
public class DFSFileSystemMonitor {

    // @Autowired DFSService dfsService;
    private FileSystemWatcher fileSystemWatcher;
    private String sourceDirectory = "/Users/alnwongvmacbook/Development/test-directory";

    @PostConstruct
    public void init() {
        log.info("Initializing DFSFileSystemMonitor with source directory: '{}'.", sourceDirectory);

        fileSystemWatcher = new FileSystemWatcher(
            true,
            Duration.ofMillis(1000L),
            Duration.ofMillis(500L)
        );

        fileSystemWatcher.addSourceDirectory(
            new File(sourceDirectory)
        );

        fileSystemWatcher.addListener(changeSet -> {

            HashMap<String, String> fileMap = new HashMap<>();

            for(ChangedFiles changedFiles : changeSet) {
//                log.info("ChangeFiles set: {}\n", changedFiles);

                for(ChangedFile changeFile : changedFiles.getFiles()) {
                    // ignore .swp files
                    if (changeFile.getFile().getName().endsWith(".swp")) {
                        continue;
                    }

                    // add path and change type of map
                    fileMap.put(changeFile.getRelativeName(), changeFile.getType().toString());
                }
            }

            log.info("fileMap: {}.\n", fileMap);

        });

        fileSystemWatcher.start();
    }

    @PreDestroy
    public void onDestroy() {
        fileSystemWatcher.stop();
        log.info("Shutting down DFSFileSystemMonitor.");
    }

}
