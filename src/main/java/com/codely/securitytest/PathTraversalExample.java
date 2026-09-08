package com.codely.securitytest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * INTENTIONALLY VULNERABLE TEST CASE.
 * Do not use this pattern in production code.
 */
public final class PathTraversalExample {

    private PathTraversalExample() {
    }

    public static String readDocument(Path baseDirectory, String filename) throws IOException {
        // INTENTIONAL: filename is controlled by the caller and is not validated.
        Path requestedFile = baseDirectory.resolve(filename);
        return Files.readString(requestedFile);
    }
}
