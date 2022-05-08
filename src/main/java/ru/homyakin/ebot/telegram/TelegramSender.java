package ru.homyakin.ebot.telegram;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import ru.homyakin.ebot.config.TelegramBotConfig;

@Component
public class TelegramSender extends DefaultAbsSender {
    private final String token;
    protected TelegramSender(TelegramBotConfig botConfig, DefaultBotOptions options) {
        super(options);
        this.token = botConfig.token();
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
