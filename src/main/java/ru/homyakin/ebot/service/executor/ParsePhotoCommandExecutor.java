package ru.homyakin.ebot.service.executor;

import org.springframework.stereotype.Component;
import ru.homyakin.ebot.model.Command;
import ru.homyakin.ebot.model.CommandType;
import ru.homyakin.ebot.model.Result;
import ru.homyakin.ebot.telegram.TelegramSender;
import ru.homyakin.ebot.utils.TesseractUtils;
import ru.homyakin.ebot.utils.TelegramUtils;
import ru.homyakin.ebot.utils.TextUtils;

@Component
public class ParsePhotoCommandExecutor extends CommandExecutor {
    private final TelegramSender telegramSender;

    public ParsePhotoCommandExecutor(TelegramSender telegramSender) {
        this.telegramSender = telegramSender;
    }

    @Override
    public Result execute(Command command) {
        final var result = telegramSender.downloadFileById(command.text());
        if (result.isEmpty()) {
            telegramSender.send(
                TelegramUtils.createSendMessageWithMaxLength(TextUtils.errorText(), command.userId().toString())
            );
            return new Result.Error("Can't download file with id: " + command.text());
        }
        final var scannedText = TesseractUtils.scanText(result.get());
        if (scannedText.isEmpty()) {
            telegramSender.send(
                TelegramUtils.createSendMessageWithMaxLength(TextUtils.errorText(), command.userId().toString())
            );
            return new Result.Error("Can't parse photo with id: " + command.text());
        }
        telegramSender.send(
            TelegramUtils.createSendMessageWithMaxLength(TextUtils.parsedText(scannedText.get()), command.userId().toString())
        );
        return new Result.NextCommand(new Command(command.userId(), scannedText.get(), CommandType.FIND_ADDITIVES_BY_TEXT));
    }

    @Override
    public CommandType commandType() {
        return CommandType.PARSE_PHOTO_TEXT;
    }
}
