package com.example.springboottutorial.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    private final static ConfigurationReader configuration = new ConfigurationReader();
    private Properties properties = new Properties();

    private ConfigurationReader() {
        try {
            String configFilePath = "application.properties";
            InputStream inputStream = new FileInputStream(configFilePath);
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ConfigurationReader getInstance(){
        return configuration;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
