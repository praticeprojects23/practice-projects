package com.practice.framework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");

        if (input == null) {
            throw new RuntimeException("config.properties not found");
        }

        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}