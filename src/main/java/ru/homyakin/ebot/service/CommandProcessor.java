package ru.homyakin.ebot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ru.homyakin.ebot.model.Command;
import ru.homyakin.ebot.model.CommandType;
import ru.homyakin.ebot.service.executor.CommandExecutor;

@Service
public class CommandProcessor {
    private final Map<CommandType, CommandExecutor> executorMap;

    public CommandProcessor(List<CommandExecutor> executors) {
        executorMap = new HashMap<>();
        for (final var executor: executors) {
            executorMap.put(executor.commandType(), executor);
        }
    }

    public void processCommand(Command command) {
        Optional.ofNullable(executorMap.get(command.commandType()))
            .ifPresent(commandExecutor -> commandExecutor.execute(command));
        //TODO unknown command
    }
}
