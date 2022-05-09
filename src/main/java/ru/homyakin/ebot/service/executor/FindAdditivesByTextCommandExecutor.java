package ru.homyakin.ebot.service.executor;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import ru.homyakin.ebot.dao.AdditiveDao;
import ru.homyakin.ebot.model.Command;
import ru.homyakin.ebot.model.CommandType;
import ru.homyakin.ebot.model.Result;
import ru.homyakin.ebot.telegram.TelegramSender;
import ru.homyakin.ebot.utils.CommonUtils;
import ru.homyakin.ebot.utils.TelegramUtils;

@Component
public class FindAdditivesByTextCommandExecutor extends CommandExecutor {
    private final AdditiveDao additiveDao;
    private final TelegramSender telegramSender;

    public FindAdditivesByTextCommandExecutor(AdditiveDao additiveDao, TelegramSender telegramSender) {
        this.additiveDao = additiveDao;
        this.telegramSender = telegramSender;
    }

    @Override
    public Result execute(Command command) {
        final var names = CommonUtils.splitTextByDelimiters(command.text());
        final var additives = additiveDao.getAdditivesByName(names);
        final var telegramTexts = new ArrayList<String>();
        for (final var name: names) {
            for (final var additive: additives) {
                if (additive.names().contains(name)) {
                    telegramTexts.add(additive.toTelegramText(name));
                    break;
                }
            }
        }
        telegramSender.send(TelegramUtils.createSendMessage(telegramTexts, command.userId().toString()));
        return new Result.Success();
    }

    @Override
    public CommandType commandType() {
        return CommandType.FIND_ADDITIVES_BY_TEXT;
    }
}
