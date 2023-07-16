package ru.homyakin.ebot.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CommonUtils {
    public static String getStringStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        throwable.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    public static String standardizeText(String text) {
        var temp = text
            .toLowerCase()
            .replace("ё", "е")
                // стандартизруем паттерн с i (например e331(iii) -> е331iii)
            .replaceAll(" ?\\((i*)\\)", "$1")
                // заменяем в ешках кириллическую 'e' на латиницу
            .replaceAll("[%s|%s](\\d+)".formatted(LATIN_E, CYRILLIC_E), LATIN_E + "$1")
                // заменяем в ешках кириллическую 'с' на латиницу
            .replaceAll("(e\\d+)[%s|%s]".formatted(LATIN_C, CYRILLIC_C), "$1" + LATIN_C);
        // заменяем букву 'з' в ешках на 3
        final var matcher = threePattern.matcher(temp);
        while (matcher.find()) {
            temp = temp.replaceAll(matcher.group(0), matcher.group(1) + "3".repeat(matcher.group(2).length()) + matcher.group(3));
        }
        return temp
            .replaceAll("(e\\d+[i|c]*)", ",$1,"); // выделяем ешки напрямую запятыми
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

    private static final String delimiterRegexp = String.join(
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

    private static final Pattern threePattern = Pattern.compile("([e|е]\\d*)(з+)(\\d+)");
    private static final String LATIN_C = "c";
    private static final String LATIN_E = "e";
    private static final String CYRILLIC_C = "с";
    private static final String CYRILLIC_E = "е";
}
