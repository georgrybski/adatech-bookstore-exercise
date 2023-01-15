package br.com.georg.bookstore.utilities;

import br.com.georg.bookstore.database.Database;
import br.com.georg.bookstore.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Printer {

    private static final int LINE_LENGTH = 102;

    private Printer() {
    }

    public static void printFormattedMesage(String message) {
        printFrameLine();

        boolean messageLargerThanLine = (message.length() > LINE_LENGTH - 6);
        if (messageLargerThanLine) {
            printFormattedMultiLineString(message);
        } else {
            printIndentedFormattedLine(message);
        }
        printFrameLine();
    }

    protected static void printMenuWithOptions(String[] options) {

        String[][] optionsMatrix = getMenuComponentMatrix(options);
        printFrameLine();
        String buttonsOuterLine = "", innerButtonLine = "";

        for (int i = 0, addedOptions = 0; i < optionsMatrix.length; i++) {

            boolean optionFitsLine =
                    (optionsMatrix[i][1].length() + innerButtonLine.length() < LINE_LENGTH - 4);

            if (optionFitsLine) {
                String optionText = optionsMatrix[i][0], optionDelimiter = optionsMatrix[i][1];
                innerButtonLine += optionText + " ".repeat(2);
                buttonsOuterLine += optionDelimiter + " ".repeat(2);
                addedOptions++;
            }

            boolean lastIterationOrDontFitInLine = (!optionFitsLine || i == optionsMatrix.length - 1);
            if (lastIterationOrDontFitInLine) {
                String oddOrEvenOffset =
                        " ".repeat((LINE_LENGTH - innerButtonLine.trim().length()) % 2);
                String spacesEachSide =
                        " ".repeat((LINE_LENGTH - innerButtonLine.trim().length()) / 2);

                printOptionsLines(spacesEachSide, innerButtonLine,
                        buttonsOuterLine, oddOrEvenOffset);

                String optionText = optionsMatrix[i][0], optionDelimiter = optionsMatrix[i][1];
                buttonsOuterLine = "" + optionDelimiter + " ".repeat(2);
                innerButtonLine = "" + optionText + " ".repeat(2);

                // Checking last iteration avoid value duplicity on the fourth line of buttons.
                boolean lastIteration = (i == optionsMatrix.length - 1);

                // Checking if the number of options is bigger than 2 avoids possible value duplicity on the third line.
                boolean moreThanTwoOptions = (optionsMatrix.length > 2);

                // Checking if the number of options is odd helps avoid value duplicity in the last menu line when
                // option number is odd and bigger than 3
                boolean evenIterationNumber = (i % 2 != 0);

                // Checking if the iteration number is different from the added options number avoids missing options
                // and duplication in some cases.
                boolean aditionalOptionNumberDifferentThanIterationNumber = (addedOptions != i + 1);

                // Checking if the option number is different from 6 avoids option duplicity in non-existent line.
                boolean optionNumberDifferentThanSix = (optionsMatrix.length != 6);

                // Checking if the number of options is a multiple of 5 avoids missing last option in these situations.
                boolean notMultipleOf5 = !(optionsMatrix.length % 5 == 0);

                // Multiples of 10, 14 and 16 would have duplicity if not checked.
                boolean notMultipleOf3Or10or13Or14or16 = (
                                optionsMatrix.length != 2 &&
                                optionsMatrix.length % 3 != 0 &&
                                optionsMatrix.length % 7 != 0 &&
                                optionsMatrix.length % 10 != 0 &&
                                optionsMatrix.length % 11 != 0 &&
                                optionsMatrix.length % 13 != 0 &&
                                optionsMatrix.length % 14 != 0 &&
                                optionsMatrix.length % 16 != 0
                );

                boolean moreThanOneLineNecessary = (lastIteration && moreThanTwoOptions && evenIterationNumber &&
                        aditionalOptionNumberDifferentThanIterationNumber &&
                        optionNumberDifferentThanSix && notMultipleOf3Or10or13Or14or16)
                        || (lastIteration && notMultipleOf5 && notMultipleOf3Or10or13Or14or16);

                if (moreThanOneLineNecessary) {
                    oddOrEvenOffset =
                            " ".repeat((LINE_LENGTH - innerButtonLine.trim().length()) % 2);
                    spacesEachSide =
                            " ".repeat((LINE_LENGTH - innerButtonLine.trim().length()) / 2);

                    printOptionsLines(spacesEachSide, innerButtonLine,
                            buttonsOuterLine, oddOrEvenOffset);
                }
            }
        }
        printFrameLine();
    }

    private static void printOptionsLines(String spacesEachSide, String buttonsInnerLine, String buttonsOuterLine, String oddOrEvenOffset) {
        String outerLine = "|" + spacesEachSide + buttonsOuterLine.trim() + spacesEachSide + oddOrEvenOffset + "|";
        String innerLine = "|" + spacesEachSide + buttonsInnerLine.trim() + spacesEachSide + oddOrEvenOffset + "|";

        System.out.println(outerLine);
        System.out.println(innerLine);
        System.out.println(outerLine);
    }

    private static String[][] getMenuComponentMatrix(String[] options) {
        String[][] matrix = new String[options.length][2];
        for (int i = 0; i < options.length; i++) {
            String option = options[i];
            matrix[i][0] = "| " + option + " |";
            matrix[i][1] = "+" + "-".repeat(option.length() + 2) + "+";
        }
        return matrix;
    }

    private static void printFrameLine() {
        System.out.println("+" + "-".repeat(LINE_LENGTH) + "+");
    }

    private static void printFormattedMultiLineString(String string) {
        String[] stringArray = string.trim().split(" ");
        String currentLine = "";

        for (int index = 0; index < stringArray.length; index++) {

            String word = stringArray[index];

            boolean wordFitsInLine =
                    (word.length() + currentLine.length() + 1 < LINE_LENGTH - 6);

            if (wordFitsInLine) {
                currentLine += word + " ";
            } else {
                printIndentedFormattedLine(currentLine);
                currentLine = word + " ";
            }

            boolean lastLine = (index == stringArray.length - 1);
            if (lastLine) {
                printIndentedFormattedLine(currentLine);
                return;
            }
        }
    }

    private static void printIndentedFormattedLine(String line) {
        int spaceNumber = (LINE_LENGTH - line.length());
        int spacesEachSide = spaceNumber / 2;
        int oddOrEvenOffset = spaceNumber % 2;

        String formattedLine = "|" + " ".repeat(spacesEachSide) +
                line +
                " ".repeat(spacesEachSide + oddOrEvenOffset) + "|";

        System.out.println(formattedLine);
    }

    public static void printAllProducts(Bookstore bookstore) {
        for (Map.Entry<String, HashMap<String, HashMap<String, Product>>> categoryLayer : bookstore.getInventory().entrySet()) {
            printProductsOfACategory(bookstore, categoryLayer.getKey());
        }
    }

    public static void printAllOrdersFromList(ArrayList<Order> orders) {
        orders.stream().forEach(Printer::printOrder);
    }

    public static void printOrder(Order order) {
        printFrameLine();
        printIndentedFormattedLine("User: " + order.getUsername() + " | Date: " + order.getDate());
        printIndentedFormattedLine("Total: " + order.getTotal() + " USD");
        printIndentedFormattedLine(" ");
        for (Product product: order.getItems()) {
            printIndentedFormattedLine(product.toString());
        }
        printFrameLine();
    }

    public static void printProduct(Product product, String genre, String category) {
        printFrameLine();
        printIndentedFormattedLine(genre + " " + category.substring(0, category.length() - 1)+ " | ID: " + product.getID());
        printIndentedFormattedLine(product.getName() + " | Price: " + product.getPrice() + " USD");
        printIndentedFormattedLine(product.getQuantity() > 0 ? "In Stock - Only " + product.getQuantity() + " Left" : "Out of Stock");
        printFrameLine();
    }

    public static void printProductsOfACategory(Bookstore bookstore, String category) {
        for (Map.Entry<String, HashMap<String, Product>> genreTypeLayer : bookstore.getInventory().get(category).entrySet()) {
            printProductsOfAGenreType(bookstore, category, genreTypeLayer.getKey());
        }
    }

    public static void printProductsOfAGenreType(Bookstore bookstore, String category, String genreType) {
        for (Map.Entry<String, Product> productLayer : bookstore.getInventory().get(category).get(genreType).entrySet()) {
//            printFormattedMesage(genreType + " " + category.substring(0, category.length() - 1)
//                    + " | " + productLayer.getValue().toString());
            printProduct(productLayer.getValue(), genreType, category);

        }
    }
}


