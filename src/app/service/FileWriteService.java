package app.service;

import app.utils.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriteService {

    private final static String SUCCESS = "Recorded in: ";

    public String writeToFile(String fileName, String content) {
        Path path = Paths.get(Constants.BASE_PATH_IN + fileName + Constants.DEFAULT_FORMAT);
        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            return e.getMessage();
        }
        return SUCCESS + path;
    }
}
