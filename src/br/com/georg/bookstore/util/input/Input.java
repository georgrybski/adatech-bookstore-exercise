package br.com.georg.bookstore.util.input;

import br.com.georg.bookstore.service.Account;
import br.com.georg.bookstore.service.Bookstore;
import br.com.georg.bookstore.util.printer.MenuPrinter;
import br.com.georg.bookstore.util.printer.Printer;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public abstract class Input {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Input(){}

    public static String getString(String prompt) {
        return getString(prompt, true).trim();
    }


    private static String getString(String prompt, boolean firstTry) {
        String string = (String) input("String", "Invalid input, " + prompt, prompt, firstTry );
        if (string != null && !string.isEmpty() && !string.isBlank()) {
            return string;
        }
        return getString(prompt, false);
    }

    public static Integer getIntegerFromMenu(String[] options, int min, int max, String prompt,
                                             String invalidValueMessage, boolean firstTry) {

        MenuPrinter.printMenuWithOptions(options);
        Integer input = (Integer) input("int", invalidValueMessage, prompt, firstTry);
        if (input != null) {
            if (input >= min && input <= max) {
                return input;
            }
        }
        return getIntegerFromMenu(options, min, max, prompt, invalidValueMessage, false);
    }

    public static Integer getInteger(int min, int max, String prompt, String invalidValueMsg) {
        return getInteger(min, max, prompt, invalidValueMsg, true);
    }

    private static Integer getInteger(int min, int max, String prompt, String invalidValueMessage, boolean firstTry) {
        Integer input = (Integer) input("int", invalidValueMessage, prompt, firstTry);
        if (input != null) {
            if (input >= min && input <= max) {
                return input;
            }
        }
        return getInteger(min, max, prompt, invalidValueMessage, false);
    }

    public static BigDecimal getBigDecimal(String prompt, String invalidValueMsg, boolean firstTry) {
        BigDecimal input = (BigDecimal) input("BigDecimal", invalidValueMsg, prompt, firstTry);
        if (input != null && input.compareTo(BigDecimal.valueOf(0)) > 0) {
            return input;
        }
        return getBigDecimal(prompt, invalidValueMsg, false);
    }


    private static Object input(String type, String invalidValueMessage, String prompt, boolean firstTry) {
        String message;
        Object input;
        if (!firstTry) {
            message = invalidValueMessage;
        }
        else {
            message = prompt;
        }
        Printer.printFormattedMessage(message);
        try {
            switch (type) {
                case "String" -> input = SCANNER.nextLine();
                case "BigDecimal" -> input = SCANNER.nextBigDecimal();
                case "int" -> {
                    input = SCANNER.nextInt();
                    SCANNER.skip("((?<!\\R)\\s)*");
                }
                default -> input = null;
            }
            return input;
        } catch (InputMismatchException e) {
            SCANNER.next();
            return null;
        }
    }
}

