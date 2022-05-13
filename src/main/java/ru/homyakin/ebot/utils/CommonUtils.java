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

    public static String standardizeText(String text) {
        return text
            .toLowerCase()
            .replace("ё", "е")
            .replaceAll("[ ]?\\(([i]*)\\)", "$1");
    }

    public static Set<String> splitTextByDelimiters(String text) {
        return Arrays.stream(text.split(delimiterRegexp))
            .filter(it -> !it.isBlank())
            .map(String::trim)
            .collect(Collectors.toSet());
    }

    public static String uniteListInString(List<String> strings) {
        StringBuilder text = new StringBuilder();
        for (final var string : strings) {
            text.append(string).append("\n\n");
        }
        return text.toString();
    }

    private static String delimiterRegexp = String.join(
        "|",
        ":",
        ",",
        "\\.",
        "\\(",
        "\\)",
        ";",
        "\n",
        " - ",
        " – ",
        "антиокислитель",
        "окислитель",
        "усилитель вкуса и аромата",
        "усилитель вкуса",
        "фиксатор окраски",
        "загуститель",
        "консервант",
        "эмульгатор",
        "состав",
        " и ",
        "краситель"
    );
}
