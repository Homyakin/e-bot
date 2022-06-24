package ru.homyakin.ebot.utils;

public class TextUtils {
    public static String mainText() {
        return
            """
                Бот предоставляет информацию о пищевых добавках. Введите одно вещество или состав целиком, \
                или отправьте фотографию состава.
                """;
    }

    public static String tooMuchAdditives(int limit) {
        return "Вы указали слишком много элементов, возвращён результат по первым " + limit;
    }

    public static String requestCommandError() {
        return "Необходимо ввести название добавки после команды. Например: /request сорбат калия.";
    }

    public static String successRequest() {
        return "Запрос успешно отправлен.";
    }

    public static String errorRequest() {
        return "При отправлении запроса произошла ошибка, попробуйте позже.";
    }

    public static String errorText() {
        return "Произошла неизвестная ошибка, попробуйте позже.";
    }

    public static String notFoundAdditives() {
        return
            """
                По вашему запросу ничего не найдено. Если вы уверены, что в вашем запросе содержатся пищевые добавки, \
                то вы можете запросить их добавление с помощью команды /request и названия.
                 
                Например: /request сорбат калия.
                """;
    }

    public static String notAllFoundAdditives() {
        return
            """
                Если вам кажется, что по вашему запросу были найдены не все пищевые добавки, \
                то вы можете запросить их добавление с помощью команды /request и названия.
                            
                Например: /request сорбат калия.
                """;
    }

    public static String parsedText(String text) {
        return
            """
                Текст на вашей фотографии распознан следующим образом:
                %s
                """.formatted(text);
    }
}
