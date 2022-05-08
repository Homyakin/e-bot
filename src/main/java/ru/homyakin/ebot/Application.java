package ru.homyakin.ebot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.homyakin.ebot.telegram.TelegramUpdateReceiver;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private final TelegramUpdateReceiver telegramUpdateReceiver;

    public Application(TelegramUpdateReceiver telegramUpdateReceiver) {
        this.telegramUpdateReceiver = telegramUpdateReceiver;
    }

    @Override
    public void run(String... args) throws Exception {
        final var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(telegramUpdateReceiver);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

