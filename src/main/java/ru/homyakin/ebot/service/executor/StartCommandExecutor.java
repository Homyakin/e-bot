package ru.homyakin.ebot.service.executor;

import org.springframework.stereotype.Component;
import ru.homyakin.ebot.model.Command;
import ru.homyakin.ebot.model.CommandType;
import ru.homyakin.ebot.model.Result;
import ru.homyakin.ebot.telegram.TelegramSender;
import ru.homyakin.ebot.utils.TelegramUtils;
import ru.homyakin.ebot.utils.TextUtils;

@Component
public class StartCommandExecutor extends CommandExecutor {
    private final TelegramSender telegramSender;

    public StartCommandExecutor(TelegramSender telegramSender) {
        this.telegramSender = telegramSender;
    }

    @Override
    public Result execute(Command command) {
        return telegramSender.send(
            TelegramUtils.createSendMessageWithMaxLength(TextUtils.mainText(), command.userId().toString())
        );
    }

    @Override
    public CommandType commandType() {
        return CommandType.START;
    }
}
