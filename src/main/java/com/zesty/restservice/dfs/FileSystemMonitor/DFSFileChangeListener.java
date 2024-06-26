//package com.zesty.restservice.dfs.FileSystemMonitor;
//
//import java.util.Set;
//import org.springframework.boot.devtools.filewatch.ChangedFile;
//import org.springframework.boot.devtools.filewatch.ChangedFiles;
//import org.springframework.boot.devtools.filewatch.FileChangeListener;
//
//public class DFSFileChangeListener implements FileChangeListener {
//
//    @Override
//    public void onChange(Set<ChangedFiles> changeSet) {
//        // loop through the changed file set
//        for(ChangedFiles changedFiles : changeSet) {
//            System.out.println("ChangeFiles Set: " + changedFiles + "\n");
//
//            // loop through each file in the set
//            for(ChangedFile changeFile : changedFiles.getFiles()) {
//                System.out.println("File Name: " + changeFile.getFile().getName());
//                System.out.println("Change Type: " + changeFile.getType());
//            }
//         }
//    }
//
//}
