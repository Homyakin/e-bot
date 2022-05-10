package ru.homyakin.ebot.utils;

public class TextUtils {
    public static String mainText() {
        return "Бот предоставляет информацию о пищевых добавках. Введите одно вещество или состав целиком";
    }

    public static String tooMuchAdditives(int limit) {
        return "Вы указали слишком много элементов, возвращён результат по первым " + limit;
    }
}
