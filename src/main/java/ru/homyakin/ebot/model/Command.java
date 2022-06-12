package ru.homyakin.ebot.model;

import java.util.Optional;

public record Command(
    Long userId,
    String text,
    CommandType commandType
) {
}
