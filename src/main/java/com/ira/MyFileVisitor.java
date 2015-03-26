package com.ira;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Iryna on 3/26/15.
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {
    private int depth = 1;

    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        for (int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        System.out.println("|---" + path.getFileName());

        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
        for (int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        System.out.print("|---");

        System.out.println(path.getFileName());
        depth++;
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult postVisitDirectory(Path path, IOException ioe) {
        depth--;
        return FileVisitResult.CONTINUE;
    }


}
