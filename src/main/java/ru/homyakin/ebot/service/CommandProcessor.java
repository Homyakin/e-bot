package ru.homyakin.ebot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.homyakin.ebot.config.TelegramBotConfig;
import ru.homyakin.ebot.model.Command;
import ru.homyakin.ebot.model.CommandType;
import ru.homyakin.ebot.model.Result;
import ru.homyakin.ebot.service.executor.CommandExecutor;
import ru.homyakin.ebot.telegram.TelegramSender;
import ru.homyakin.ebot.utils.TelegramUtils;

@Service
public class CommandProcessor {
    private static final Logger logger = LoggerFactory.getLogger(CommandProcessor.class);
    private final Map<CommandType, CommandExecutor> executorMap;
    private final String adminId;
    private final TelegramSender telegramSender;

    public CommandProcessor(
        List<CommandExecutor> executors,
        TelegramBotConfig config,
        TelegramSender telegramSender
    ) {
        this.telegramSender = telegramSender;
        executorMap = new HashMap<>();
        for (final var executor: executors) {
            executorMap.put(executor.commandType(), executor);
        }
        adminId = config.adminId();
    }

    public void processCommand(Command command) {
        while (command != null) {
            final var executor = Optional.ofNullable(executorMap.get(command.commandType()));
            if (executor.isEmpty()) {
                logger.error("Unknown command");
                return;
            }
            final var result = executor.get().execute(command);
            command = null;
            if (result instanceof Result.Error error) {
                telegramSender.send(TelegramUtils.createSendMessageWithMaxLength(error.info(), adminId, null));
            } else if (result instanceof Result.NextCommand nextCommand) {
                command = nextCommand.command();
            }
        }
    }
}
