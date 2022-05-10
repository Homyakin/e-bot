package ru.homyakin.ebot.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonUtils {
    public static String getStringStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        throwable.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    public static Set<String> splitTextByDelimiters(String text) {
        return Arrays.stream(text.split(":|,|\\.|\\(|\\)|;|\n"))
            .filter(it -> !it.isBlank())
            .map(String::toLowerCase)
            .map(String::trim)
            .collect(Collectors.toSet());
    }

    public static String uniteListInString(List<String> strings) {
        StringBuilder text = new StringBuilder();
        for (final var string: strings) {
            text.append(string).append("\n\n");
        }
        return text.toString();
    }
}
