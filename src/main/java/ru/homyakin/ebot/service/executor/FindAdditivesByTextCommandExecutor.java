package ru.homyakin.ebot.service.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(FindAdditivesByTextCommandExecutor.class);
    private final AdditiveDao additiveDao;
    private final TelegramSender telegramSender;

    public FindAdditivesByTextCommandExecutor(AdditiveDao additiveDao, TelegramSender telegramSender) {
        this.additiveDao = additiveDao;
        this.telegramSender = telegramSender;
    }

    @Override
    public Result execute(Command command) {
        final var names = CommonUtils.splitTextByDelimiters(CommonUtils.standardizeText(command.text()));
        logger.info("Searching by: " + names.toString());
        try {
            final var additives = additiveDao.getAdditivesByName(names, MAX_ITEMS);
            logger.info("Found " + additives.size() + " additives");
            return TelegramUtils.createSendMessages(createTextFromAdditives(additives, names), command.userId().toString())
                .stream()
                .map(telegramSender::send)
                .filter(result -> !(result instanceof Result.Success))
                .findFirst()
                .orElseGet(Result.Success::new);
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            telegramSender.send(TelegramUtils.createSendMessageWithMaxLength(TextUtils.errorText(), command.userId().toString()));
            return new Result.Error(CommonUtils.getStringStackTrace(e));
        }
    }

    @Override
    public CommandType commandType() {
        return CommandType.FIND_ADDITIVES_BY_TEXT;
    }

    private String createTextFromAdditives(List<Additive> additives, Set<String> names) {
        final var telegramTexts = new ArrayList<String>();
        final var size = Math.min(additives.size(), MAX_ITEMS - 1);
        int foundNames = 0;
        for (int i = 0; i < size; ++i) {
            final var namesFromUser = new ArrayList<String>();
            for (final var name: names) {
                if (additives.get(i).names().contains(name)) {
                    ++foundNames;
                    namesFromUser.add(name);
                }
            }
            telegramTexts.add(additives.get(i).toTelegramText(namesFromUser));
        }
        var requestText = "";
        if (names.size() > 0 && additives.size() == 0) {
            requestText = TextUtils.notFoundAdditives();
        } else if (foundNames < names.size()) {
            requestText = TextUtils.notAllFoundAdditives();
        }
        var text = "";
        if (additives.size() == MAX_ITEMS) {
            text = TextUtils.tooMuchAdditives(MAX_ITEMS - 1) + "\n\n";
        }
        return text + CommonUtils.uniteListInString(telegramTexts) + requestText;
    }
}
