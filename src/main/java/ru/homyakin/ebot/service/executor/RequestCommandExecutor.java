package ru.homyakin.ebot.service.executor;

import org.springframework.stereotype.Component;
import ru.homyakin.ebot.config.TelegramBotConfig;
import ru.homyakin.ebot.model.Command;
import ru.homyakin.ebot.model.CommandType;
import ru.homyakin.ebot.model.Result;
import ru.homyakin.ebot.telegram.TelegramSender;
import ru.homyakin.ebot.utils.TelegramUtils;
import ru.homyakin.ebot.utils.TextUtils;

@Component
public class RequestCommandExecutor extends CommandExecutor {
    private final TelegramSender telegramSender;
    private final String adminId;

    public RequestCommandExecutor(TelegramSender telegramSender, TelegramBotConfig config) {
        this.telegramSender = telegramSender;
        adminId = config.adminId();
    }

    @Override
    public Result execute(Command command) {
        if (command.text().split(" ").length == 1) {
            return telegramSender.send(
                TelegramUtils.createSendMessageWithMaxLength(TextUtils.requestCommandError(), command.userId().toString())
            );
        }
        return telegramSender.send(TelegramUtils.createSendMessageWithMaxLength(command.text(), adminId));
    }

    @Override
    public CommandType commandType() {
        return CommandType.REQUEST;
    }
}
