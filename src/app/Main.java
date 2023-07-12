package app;

import app.service.FileReadService;
import app.service.FileWriteService;
import app.utils.Constants;

import java.util.Scanner;

public class Main {

    private final static String DEFAULT_INPUT = "Input file name:\n";
    private final static String SELECT_MODE_MESSAGE = """
            Make a choice:
            1) Create and write in file.
            2) Read file.
            """;
    private final static String ENTER_TEXT_MESSAGE = "Enter the text to be written to the file:\n";

    public static void main(String[] args) {
        getOutput(selectMode(getFileName()));
    }

    private static String getFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(DEFAULT_INPUT);
        return scanner.nextLine();
    }

    private static String readFileData(String file) {
        return new FileReadService().readFromFile(file);
    }

    private static String writeFileData(String file, String message) {
        return new FileWriteService().writeToFile(file, message);
    }

    private static String selectMode(String file) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(SELECT_MODE_MESSAGE);
        String mode = scanner.nextLine();

        switch (mode) {
            case Constants.WRITE -> {
                System.out.print(ENTER_TEXT_MESSAGE);
                String text = scanner.nextLine();
                return writeFileData(file, text);
            }
            case Constants.READ -> {
                return readFileData(file);
            }
            default -> {
                return Constants.UNKNOWN_MODE;
            }
        }
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
