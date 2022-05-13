package ru.homyakin.ebot.utils;

import com.vdurmont.emoji.EmojiParser;
import java.util.ArrayList;
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

    public static List<SendMessage> createSendMessages(String text, String chatId) {
        final var messages = new ArrayList<SendMessage>();
        for (int i = 0; i < text.length(); i += MAX_TELEGRAM_MESSAGE) {
            messages.add(
                createSendMessageWithMaxLength(
                    text.substring(i, Math.min(text.length(), i + MAX_TELEGRAM_MESSAGE)), chatId
                )
            );
        }
        return messages;
    }

    public static SendMessage createSendMessageWithMaxLength(String text, String chatId) {
        return createSendMessageWithMaxLength(text, chatId, ParseMode.HTML);
    }

    public static SendMessage createSendMessageWithMaxLength(String text, String chatId, String parseMode) {
        return SendMessage
            .builder()
            .chatId(chatId)
            .text(substringToTelegramLength(EmojiParser.parseToUnicode(text)))
            .disableWebPagePreview(true)
            .parseMode(parseMode)
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
