package ru.homyakin.ebot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Configuration
@ConfigurationProperties(prefix = "telegram-bot")
public class TelegramBotConfig {
    private String token;
    private String username;
    private String adminId;

    @Bean
    public DefaultBotOptions createBotOptions() {
        return new DefaultBotOptions();
    }

    public String token() {
        return token;
    }

    public String username() {
        return username;
    }

    public String adminId() {
        return adminId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
