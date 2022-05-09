package ru.homyakin.ebot.utils;

import com.vdurmont.emoji.EmojiParser;
import java.util.List;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramUtils {
    private final static int MAX_TELEGRAM_MESSAGE = 4000;

    public static boolean isProcessingUpdate(Update update) {
        return update.hasMessage() && update.getMessage().isUserMessage() && update.getMessage().hasText();
    }

    public static SendMessage createSendMessage(List<String> strings, String chatId) {
        StringBuilder text = new StringBuilder();
        for (final var string: strings) {
            text.append(string).append("\n\n");
        }
        return createSendMessage(text.toString(), chatId);
    }

    public static SendMessage createSendMessage(String text, String chatId) {
        return SendMessage
            .builder()
            .chatId(chatId)
            .text(substringToTelegramLength(EmojiParser.parseToUnicode(text)))
            .disableWebPagePreview(true)
            .parseMode(ParseMode.HTML)
            .build();
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

    private static String substringToTelegramLength(String s) {
        return s.substring(0, Math.min(s.length(), MAX_TELEGRAM_MESSAGE));
    }
}
