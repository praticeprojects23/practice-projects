package com.practice.framework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	//This will hold key-value pairs from the config file.
    private static final Properties properties = new Properties();
    //This block runs automatically the first time the class is loaded.
    //So when ConfigReader is first used, Java immediately tries to load the properties file.
    static {
    	//This looks for the file in the classpath
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