package ru.homyakin.ebot.service.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;
import ru.homyakin.ebot.dao.AdditiveDao;
import ru.homyakin.ebot.model.Additive;
import ru.homyakin.ebot.model.Command;
import ru.homyakin.ebot.model.CommandType;
import ru.homyakin.ebot.model.Result;
import ru.homyakin.ebot.telegram.TelegramSender;
import ru.homyakin.ebot.utils.CommonUtils;
import ru.homyakin.ebot.utils.TelegramUtils;
import ru.homyakin.ebot.utils.TextUtils;

@Component
public class FindAdditivesByTextCommandExecutor extends CommandExecutor {
    private static final int MAX_ITEMS = 16;
    private final AdditiveDao additiveDao;
    private final TelegramSender telegramSender;

    public FindAdditivesByTextCommandExecutor(AdditiveDao additiveDao, TelegramSender telegramSender) {
        this.additiveDao = additiveDao;
        this.telegramSender = telegramSender;
    }

    @Override
    public Result execute(Command command) {
        final var names = CommonUtils.splitTextByDelimiters(command.text());
        final var additives = additiveDao.getAdditivesByName(names, MAX_ITEMS);
        return TelegramUtils.createSendMessages(createTextFromAdditives(additives, names), command.userId().toString())
            .stream()
            .map(telegramSender::send)
            .filter(result -> !(result instanceof Result.Success))
            .findFirst()
            .orElseGet(Result.Success::new);
    }

    @Override
    public CommandType commandType() {
        return CommandType.FIND_ADDITIVES_BY_TEXT;
    }

    private String createTextFromAdditives(List<Additive> additives, Set<String> names) {
        final var telegramTexts = new ArrayList<String>();
        final var size = Math.min(additives.size(), MAX_ITEMS - 1);
        for (int i = 0; i < size; ++i) {
            final var namesFromUser = new ArrayList<String>();
            for (final var name: names) {
                if (additives.get(i).names().contains(name)) {
                    namesFromUser.add(name);
                }
            }
            telegramTexts.add(additives.get(i).toTelegramText(namesFromUser));
        }
        var text = "";
        if (additives.size() == MAX_ITEMS) {
            text = TextUtils.tooMuchAdditives(MAX_ITEMS - 1) + "\n\n";
        }
        return text + CommonUtils.uniteListInString(telegramTexts);
    }
}
