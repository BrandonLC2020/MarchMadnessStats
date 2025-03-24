package com.blc.backend.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private static final Dotenv dotenv = Dotenv.configure()
        .directory("march-madness-stats/.env") // Folder containing .env
        .load();


    public static String getApiKey() {
        return dotenv.get("API_KEY");
    }

    public static void main(String[] args) {
        System.out.println("Your API Key: " + getApiKey()); // For testing purposes only, avoid printing in production.
    }
}

