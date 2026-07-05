package com.piyush.portfoliobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@SpringBootApplication
public class PortfoliobackendApplication {

	public static void main(String[] args) {
		loadEnv();
		SpringApplication.run(PortfoliobackendApplication.class, args);
	}

	private static void loadEnv() {
		File envFile = new File(".env");
		if (envFile.exists()) {
			try {
				List<String> lines = Files.readAllLines(envFile.toPath());
				for (String line : lines) {
					line = line.trim();
					if (line.isEmpty() || line.startsWith("#")) {
						continue;
					}
					int eqIndex = line.indexOf('=');
					if (eqIndex > 0) {
						String key = line.substring(0, eqIndex).trim();
						String value = line.substring(eqIndex + 1).trim();
						// Strip surrounding quotes if any
						if (value.startsWith("\"") && value.endsWith("\"")) {
							value = value.substring(1, value.length() - 1);
						} else if (value.startsWith("'") && value.endsWith("'")) {
							value = value.substring(1, value.length() - 1);
						}
						System.setProperty(key, value);
					}
				}
			} catch (IOException e) {
				System.err.println("Failed to load .env file: " + e.getMessage());
			}
		}
	}
}
