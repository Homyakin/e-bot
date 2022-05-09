package ru.homyakin.ebot.service;

import java.util.Objects;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.homyakin.ebot.model.Command;
import ru.homyakin.ebot.model.CommandType;

@Service
public class CommandParser {
    public Command getCommandFromMessage(Message message) {
        Objects.requireNonNull(message);
        final var text = message.getText();
        final CommandType commandType;
        if (text.startsWith("/start")) {
            commandType = CommandType.START;
        } else {
            commandType = CommandType.FIND_ADDITIVES_BY_TEXT;
        }
        return new Command(message.getChatId(), text, commandType);
    }
}
