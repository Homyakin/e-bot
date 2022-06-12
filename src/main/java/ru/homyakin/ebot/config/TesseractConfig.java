package ru.homyakin.ebot.config;

public class TesseractConfig {
    private static String datapath = "tesseract/";

    public static String datapath() {
        return datapath;
    }

    public static void setDatapath(String datapath) {
        TesseractConfig.datapath = datapath;
    }
}
