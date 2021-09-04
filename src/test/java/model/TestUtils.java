package model;

import org.junit.jupiter.api.Assertions;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class TestUtils {
    public static String load(String file) {
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource(file);
            Assertions.assertNotNull(resource);
            return Files.readString(Path.of(resource.toURI()), StandardCharsets.US_ASCII);
        } catch (Exception ignored) {
            System.err.println("you don goofed");
            Assertions.fail("you don goofed");
        }
        return "";
    }
}
