package br.com.georg.library.utilities;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private Input(){}

    public static String getString(String prompt) {
        return getString(prompt, true);
    }


    private static String getString(String prompt, boolean firstTry) {
        String string = (String) input("String", "Invalid input, " + prompt, prompt, firstTry );
        if (string != null && !string.isEmpty() && !string.isBlank()) {
            return string;
        }
        return getString(prompt, false);
    }

    protected static Integer getIntegerFromMenu(String[] options, int min, int max, String prompt,
                                            String invalidValueMessage, boolean firstTry) {

        Printer.printMenuWithOptions(options);
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


    private static BigDecimal getBigDecimal(String prompt, String invalidValueMsg, boolean firstTry) {
        BigDecimal input = (BigDecimal) input("BigDecimal", invalidValueMsg, prompt, firstTry);
        if (input != null && input.compareTo(BigDecimal.valueOf(1)) > 0) {
            return input;
        }
        return getBigDecimal(prompt, invalidValueMsg, false);
    }

    private static Object input(String type, String invalidValueMessage, String prompt, boolean firstTry) {
        Scanner scn = new Scanner(System.in);
        String message;
        if (!firstTry) {
            message = invalidValueMessage;
        }
        else {
            message = prompt;
        }
        Printer.printFormattedMesage(message);
        try {
            switch(type) {
                case "String":
                    return scn.nextLine();
                case "BigDecimal":
                    return scn.nextBigDecimal();
                case "int":
                    return scn.nextInt();
                default:
                    return null;
            }
        } catch (InputMismatchException e) {
            return null;
        }
    }
}

