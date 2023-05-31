package com.example.java_12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class FileHashingApp implements CommandLineRunner {
    private String inputFile = "C:\\Users\\gemmi\\IdeaProjects\\Java_12\\src\\main\\resources\\inputFile.txt";
    private String outputFile = "C:\\Users\\gemmi\\IdeaProjects\\Java_12\\src\\main\\resources\\outputFile.txt";

    @Override
    public void run(String... args) throws Exception {
        // Хеширование файла при запуске приложения
        hashFile(inputFile, outputFile);
    }

    @PostConstruct
    public void initialize() throws IOException {
        // Создание второго файла с записью строки "null",
        // если первый файл отсутствует
        if (!Files.exists(Paths.get(inputFile))) {
            createNullFile(outputFile);
        }
    }

    @PreDestroy
    public void cleanup() throws IOException {
        // Удаление исходного файла при остановке приложения
        Files.deleteIfExists(Paths.get(inputFile));
    }

    private void hashFile(String inputFilePath, String outputFilePath) throws IOException, NoSuchAlgorithmException {
        byte[] fileBytes = Files.readAllBytes(Paths.get(inputFilePath));
        byte[] hashBytes = calculateHash(fileBytes);

        String hashString = bytesToHexString(hashBytes);
        writeToFile(hashString, outputFilePath);
    }

    private byte[] calculateHash(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(data);
    }

    private String bytesToHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    private void writeToFile(String content, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }

    private void createNullFile(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("null");
        }
    }
}
