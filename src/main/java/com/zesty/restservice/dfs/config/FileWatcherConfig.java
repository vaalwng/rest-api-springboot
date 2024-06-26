//package com.zesty.restservice.dfs.config;
//
//import com.zesty.restservice.dfs.FileSystemMonitor.DFSFileChangeListener;
//import jakarta.annotation.PreDestroy;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.devtools.filewatch.FileSystemWatcher;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import java.io.File;
//import java.time.Duration;
//
//@Configuration @Slf4j
//public class FileWatcherConfig {
//
//    @Bean
//    public FileSystemWatcher fileSystemWatcher() {
//        log.info("Initializing FileSystemWatcher bean.");
//
//        FileSystemWatcher fileSystemWatcher = new FileSystemWatcher(
//            true,
//            Duration.ofMillis(1000L),
//            Duration.ofMillis(500L)
//        );
//        fileSystemWatcher.addSourceDirectory(
//            new File("/Users/alnwongvmacbook/Development/test-directory")
//        );
//        fileSystemWatcher.addListener(new DFSFileChangeListener());
//        fileSystemWatcher.start();
//
//        return fileSystemWatcher;
//    }
//
//    @PreDestroy
//    public void onDestroy() {
//        fileSystemWatcher().stop();
//
//        log.info("Shutting down FileSystemWatcher bean.");
//    }
//
//}
