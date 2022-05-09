package ru.homyakin.ebot.utils;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramUtils {
    public static boolean isProcessingUpdate(Update update) {
        return update.hasMessage() && update.getMessage().isUserMessage() && update.getMessage().hasText();
    }

    public static String getTextForLog(Message message) {
        return "(userId: %d; firstName: %s, lastName: %s, username: %s, text: %s)".formatted(
            message.getFrom().getId(),
            message.getFrom().getFirstName(),
            message.getFrom().getLastName(),
            message.getFrom().getUserName(),
            message.getText()
        );
    }
}
