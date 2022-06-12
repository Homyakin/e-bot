package ru.homyakin.ebot.telegram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.homyakin.ebot.config.TelegramBotConfig;
import ru.homyakin.ebot.model.Result;
import ru.homyakin.ebot.utils.CommonUtils;

@Component
public class TelegramSender extends DefaultAbsSender {
    private static final Logger logger = LoggerFactory.getLogger(TelegramSender.class);
    private final String token;

    protected TelegramSender(TelegramBotConfig botConfig, DefaultBotOptions options) {
        super(options);
        this.token = botConfig.token();
    }

    public Result send(SendMessage sendMessage) {
        try {
            logger.info("Sending message to " + sendMessage.getChatId());
            execute(sendMessage);
            return new Result.Success();
        } catch (TelegramApiException e) {
            logger.error("Error during sending message", e);
            return new Result.Error("Can't send telegram message. " + CommonUtils.getStringStackTrace(e));
        }
    }

    public Optional<InputStream> downloadFileById(String fileId) {
        try {
            final var file = execute(GetFile.builder().fileId(fileId).build());
            return Optional.of(downloadFileAsStream(file));
        } catch (TelegramApiException e) {
            logger.error("Error during downloading file", e);
            return Optional.empty();
        }
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
