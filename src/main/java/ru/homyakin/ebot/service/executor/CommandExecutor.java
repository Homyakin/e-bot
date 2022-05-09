package ru.homyakin.ebot.service.executor;

import ru.homyakin.ebot.model.Command;
import ru.homyakin.ebot.model.CommandType;
import ru.homyakin.ebot.model.Result;

public abstract class CommandExecutor {
    abstract public Result execute(Command command);
    abstract public CommandType commandType();
}
