package ru.homyakin.ebot.service;

import java.util.Comparator;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import ru.homyakin.ebot.model.Command;
import ru.homyakin.ebot.model.CommandType;

@Service
public class CommandParser {
    public Command getCommandFromMessage(Message message) {
        Objects.requireNonNull(message);
        final var text = getTextFromMessage(message);
        final CommandType commandType;
        if (text.startsWith("/start")) {
            commandType = CommandType.START;
        } else if (text.startsWith("/request")) {
            commandType = CommandType.REQUEST;
        } else if (message.hasPhoto()) {
            commandType = CommandType.PARSE_PHOTO_TEXT;
        } else {
            commandType = CommandType.FIND_ADDITIVES_BY_TEXT;
        }
        return new Command(message.getChatId(), text, commandType);
    }

    private String getTextFromMessage(Message message) {
        if (message.hasText()) {
            return message.getText();
        } else {
            return message
                .getPhoto()
                .stream()
                .max(Comparator.comparing(PhotoSize::getFileSize))
                .orElseThrow()
                .getFileId();
        }
    }
}
