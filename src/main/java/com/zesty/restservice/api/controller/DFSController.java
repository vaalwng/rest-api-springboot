package com.zesty.restservice.api.controller;

import com.zesty.restservice.api.services.DFSService;
import com.zesty.restservice.dfs.beans.StorageInfo;
import com.zesty.restservice.dfs.beans.StoredEntry;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController @Slf4j
@RequestMapping(path = "/dfs/api", produces = APPLICATION_JSON_VALUE)
public class DFSController {

    @Autowired private DFSService dfsService;

//    @PostMapping(path = "/**/{directories}/{filename}", produces = APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> store(
//        @PathVariable("directories") String directories,
//        @PathVariable("filename") String filename,
//        HttpServletRequest request
//    ) {
//        log.info("/dfs/api/store called.");
//
//        log.info("directories: {}, filename: {}", directories, filename);
//        log.info("Request URI: {}", request.getRequestURI());
//
//        return new ResponseEntity<>(
//            "store",
//            HttpStatus.OK
//        );
//    }

    @PostMapping(path = "/**/{filename}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> store(
        @PathVariable("filename") String filename,
        HttpServletRequest request
    ) {
        log.info("/dfs/api/store called.");
        log.info("filename: {}", filename);

        String fullPath = request.getRequestURI();
        log.info("Request URI: {}", fullPath);


        log.info("Extracted directory: {}", getDirectoryPathFromURI(fullPath));
        log.info("Extracted filename: {}\n\n", getFilenameFromURI(fullPath));

        return new ResponseEntity<>(
            "store",
            HttpStatus.OK
        );
    }

    @GetMapping(path = "/**/{filename-pattern}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StoredEntry>> list(
        @PathVariable("filename-pattern") String filenamePattern,
        HttpServletRequest request
    ) {
        log.info("/dfs/api/list called.");
        log.info("filename-pattern: {}", filenamePattern);

        String fullPath = request.getRequestURI();
        log.info("Request URI: {}", request.getRequestURI());

        log.info("Extracted directory pattern: {}", getDirectoryPathFromURI(fullPath));
        log.info("Extracted filename pattern: {}\n\n", getFilenameFromURI(fullPath));

        return new ResponseEntity<>(
            dfsService.list(),
            HttpStatus.OK
        );
    }

    @GetMapping(path = "/fetch/**/{filename}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> fetch(
        @PathVariable("filename") String filename,
        HttpServletRequest request
    ) {
        log.info("/dfs/api/fetch called.");
        log.info("filename: {}", filename);

        String fullPath = request.getRequestURI();
        log.info("Request URI: {}", request.getRequestURI());

        log.info("Extracted directory: {}", getDirectoryPathFromURI(fullPath));
        log.info("Extracted filename: {}\n\n", getFilenameFromURI(fullPath));

        return new ResponseEntity<>(
            "fetch",
            HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/**/{filename}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(
        @PathVariable("filename") String filename,
        HttpServletRequest request
    ) {
        log.info("/dfs/api/delete called.");
        log.info("filename: {}", filename);

        String fullPath = request.getRequestURI();
        log.info("Request URI: {}", request.getRequestURI());

        log.info("Extracted directory: {}", getDirectoryPathFromURI(fullPath));
        log.info("Extracted filename: {}\n\n", getFilenameFromURI(fullPath));

        return new ResponseEntity<>(
            "delete",
            HttpStatus.OK
        );
    }

    @GetMapping(path = "/info", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StorageInfo>> info() {
        log.info("/dfs/api/info called.\n");

        return new ResponseEntity<>(
            dfsService.info(false),
            HttpStatus.OK
        );
    }

    @GetMapping(path = "/info/self", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StorageInfo>> infoSelf() {
        log.info("/dfs/api/info/self called.\n");

        return new ResponseEntity<>(
            dfsService.info(true),
            HttpStatus.OK
        );
    }

    private String getDirectoryPathFromURI(String uri) {
        return uri.substring(
            0, uri.lastIndexOf('/')
        ).replaceFirst("/zesty/dfs/api", "");
    }

    private String getFilenameFromURI(String uri) {
        return uri.substring(uri.lastIndexOf('/') + 1);
    }

}
