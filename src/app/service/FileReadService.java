package app.service;

import app.utils.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadService {

    private final static String MISTAKE = "Something wrong ";

    public String readFromFile(String fileName) {
        Path path = Paths.get(Constants.BASE_PATH_IN + fileName);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            return MISTAKE + e.getMessage();
        }
    }
}
