package ru.homyakin.ebot.model;

public sealed abstract class Result {
    public static final class Success extends Result {

    }

    public static final class Error extends Result {
        private final String info;

        public Error(String info) {
            this.info = info;
        }

        public String info() {
            return info;
        }
    }
}
