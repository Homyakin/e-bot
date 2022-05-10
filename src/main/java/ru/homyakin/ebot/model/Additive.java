package ru.homyakin.ebot.model;

import java.util.List;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "additive")
@CompoundIndexes(
    @CompoundIndex(name = "names", def = "{names: 1}", background = true)
)
public record Additive(
    List<String> names,
    Type type,
    String description,
    String positives,
    String negatives,
    List<Source> sources
) {
    public String toTelegramText(List<String> namesFromUser) {
        StringBuilder text = new StringBuilder("<b>");
        text.append(namesFromUser.get(0));
        for (int i = 1; i < namesFromUser.size(); ++i) {
            text.append(", ").append(namesFromUser.get(i));
        }
        text.append("</b>\n");
        text.append(type.toTelegramText()).append("\n");
        text.append("Описание: ").append(description).append("\n");
        if (positives != null) {
            text.append("Польза: ").append(positives).append("\n");
        }
        if (negatives != null) {
            text.append("Вред: ").append(negatives).append("\n");
        }
        text.append("Источники: ");
        for (final var source: sources) {
            text.append(source.toTelegramText()).append("; ");
        }
        return text.toString();
    }
}

enum Type {
    SAFE,
    ;
    public String toTelegramText() {
        return switch (this) {
            case SAFE -> "Безопасна:white_check_mark:";
        };
    }
}

@Document
record Source(
   String name,
   String link
) {
    public String toTelegramText() {
        return "<a href=\"" + link + "\">" + name + "</a>";
    }
}
