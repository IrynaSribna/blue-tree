package com.ira;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

public class FileTreeWalk {

    public static final int MAX_DEPTH = 5;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("usage FileTreeWalk directoryPath");
            System.exit(-1);
        }

        Path path = Paths.get(args[0]);
        EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        try {
            Files.walkFileTree(path, opts, MAX_DEPTH, new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
