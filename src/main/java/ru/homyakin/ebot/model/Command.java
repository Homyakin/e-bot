package ru.homyakin.ebot.model;

public record Command(
    Long userId,
    String text,
    CommandType commandType
) {
}
