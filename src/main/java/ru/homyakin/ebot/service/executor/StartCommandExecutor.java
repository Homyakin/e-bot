package ru.homyakin.ebot.service.executor;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.homyakin.ebot.model.Command;
import ru.homyakin.ebot.model.CommandType;
import ru.homyakin.ebot.model.Result;
import ru.homyakin.ebot.telegram.TelegramSender;

@Component
public class StartCommandExecutor extends CommandExecutor {
    private final TelegramSender telegramSender;

    public StartCommandExecutor(TelegramSender telegramSender) {
        this.telegramSender = telegramSender;
    }

    @Override
    public Result execute(Command command) {
        try {
            telegramSender.execute(SendMessage.builder().text("Добро пожаловать").chatId(command.userId().toString()).build());
        } catch (TelegramApiException e) {

        }
        return new Result.Success();
    }

    @Override
    public CommandType commandType() {
        return CommandType.START;
    }
}
