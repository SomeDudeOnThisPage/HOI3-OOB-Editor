package buhlmann.me.oob.util;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;

@SuppressWarnings("unused")
public final class StringUtils {

    public static String load(String file) {
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource(file);
            return Files.readString(Path.of(resource.toURI()), StandardCharsets.US_ASCII);
        } catch (Exception ignored) {
            System.err.println("you don goofed");
        }
        return "";
    }

    public static String key(String str) throws ParseException {
        // line rep is <field> = <value>
        final int index = str.indexOf("=");
        if (index != -1) {
            return str.substring(0, index).trim();
        }

        throw new ParseException(
            String.format("Failed to parse line '%s': indexOf(=) == -1 - line does not represent a key-value pair", str),
            -1
        );
    }

    public static String value(String str) throws ParseException {
        // line rep is <field> = <value>
        final int index = str.indexOf("=");
        if (index != -1) {
            final String substr = str.substring(index + 1);
            final int trailing = substr.indexOf("#");

            if (trailing != -1) {
                return substr.substring(0, substr.indexOf("#") - 1).trim(); // strip trailing comments
            }

            return substr.trim();
        }

        throw new ParseException(
            String.format("Failed to parse line '%s': indexOf(=) == -1 - line does not represent a key-value pair", str),
            -1
        );
    }

    public static boolean parseParadoxBoolean(String str) {
        return str.equals("yes");
    }

    public static String unparseParadoxBoolean(boolean b) {
        return b ? "yes" : "no";
    }

    public static boolean isNullOrEmpty(String... str) {
        for (String s : str) {
            if (s == null || s.isBlank() /*|| s.isEmpty()*/) {
                return true;
            }
        }

        return false;
    }

}
