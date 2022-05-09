package ru.homyakin.ebot.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

public class CommonUtils {
    public static String getStringStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        throwable.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    public static List<String> splitTextByDelimiters(String text) {
        return Arrays.stream(text.split(":|,|\\.|\\(|\\)|;"))
            .filter(it -> !it.isBlank())
            .map(String::toLowerCase)
            .map(String::trim)
            .toList();
    }
}
