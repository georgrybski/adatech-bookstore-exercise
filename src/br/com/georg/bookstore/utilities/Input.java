package br.com.georg.bookstore.utilities;

import br.com.georg.bookstore.products.*;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Input {

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

    public static BigDecimal getProductPrice(String category) {
        return getBigDecimal(
                "Insert the " + category.substring(0,category.length()-1).toLowerCase() + "'s price ($USD)",
                "Invalid input! Please insert a positive value, separeted by a dot(.) if necessary.",
                true
                );
    }

    public static boolean isUsernameValid(String username) {
        boolean usernameLengthValid = (username.length() >= 4 && username.length() <= 15);
        boolean usernameCharactersValid = (username.matches("^[a-zA-Z0-9_]+$"));
        return usernameLengthValid && usernameCharactersValid;
    }

    public static String getUsername(Bookstore bookstore) {
        var username = getString("Insert your desired username").toLowerCase();
        if (!isUsernameValid(username)) {
            Printer.printFormattedMesage("Usernames must have between 4 and 15 characters and " +
                    "contain only letters A-Z, numbers 0-9 or underscores");
            return getUsername(bookstore);

        } else if (!bookstore.getDatabase().isUsernameFree(username)) {
            Printer.printFormattedMesage("That username is already taken");
            return getUsername(bookstore);
        } else {
            return username;
        }
    }

    public static Account logIn(Bookstore bookstore) {
        Account account = null;
        String username = getString("Insert your username");
        String password = getString("Insert your password");

        if(bookstore.getDatabase().isLogInValid(username, password)) {
            account = bookstore.getDatabase().getAccountsHashMap().get(username);
        }

        String message = (account != null)? "Successfully logged in as '" + account.getUsername() + "'": "Invalid credentials";
        Printer.printFormattedMesage(message);
        return account;
    }

    public static Account createNewAccount(Bookstore bookstore){
        Account newAccount = bookstore.registerAccount(getUsername(bookstore),
                getString("Insert your desired password"));
        return Objects.requireNonNullElseGet(newAccount, () -> createNewAccount(bookstore));
    }

    public static String getProductField(String category, String field) {
        return getString("Insert the " +
                category.substring(0,category.length()-1).toLowerCase()
                + "'s " + field);
    }

    public static String getProductName(String category) {
        return getProductField(category, "name");
    }

    public static String getProductGenre(String category) {
        return getProductField(category, "genre");
    }

    public static String getProductAuthor(String category) {
        return getProductField(category, "author");
    }

    public static String getStudio(String category) {
        return getProductField(category, "studio");
    }

    public static String getRecordLabel() {
        return getString("Insert the album's record label");
    }

    public static String getPublisher() {
        return getString("Insert the book's publisher");
    }

    public static String getProducer() {
        return getString("Insert the film's producer");
    }

    public static String getDirector() {
        return getString("Insert the film's director");
    }

    public static String getDistribuitor() {
        return getString("Insert the game's distribuitor");
    }

    public static BigDecimal getBigDecimal(String prompt, String invalidValueMsg, boolean firstTry) {
        BigDecimal input = (BigDecimal) input("BigDecimal", invalidValueMsg, prompt, firstTry);
        if (input != null && input.compareTo(BigDecimal.valueOf(0)) > 0) {
            return input;
        }
        return getBigDecimal(prompt, invalidValueMsg, false);
    }


    public static Integer getProductQuantity() {
        return getInteger(1, Integer.MAX_VALUE,
                "Insert the number of items to be added to stock",
                "Invalid Input. Please insert a integer greater than 0");
    }

    public static String getProductStudio(String category, String field) {
        return getString("Insert the " + category.substring(0,category.length()-1).toLowerCase() + "'s " + field);
    }

    private static boolean isIDValid(String ID) {
        return ID.matches("^[a-zA-Z]{6}.*[a-zA-Z0-9]{4,}$");
    }

    public static void removeProductUsingID(Bookstore bookstore) {
        String ID = getString("Insert the ID of the product you wanto to remove");
        if (isIDValid(ID)) {
            if (bookstore.removeProduct(ID)) {
                Printer.printFormattedMesage("The product has been removed");
            }
        } else {
            Printer.printFormattedMesage("The ID inserted is invalid");
        }
    }

    public static void addProductToCartUsingID(Bookstore bookstore, Account loggedAccount) {
        String ID = getString("Insert the ID of the product you want to add to your cart");
        if (isIDValid(ID)) {
            Product product = bookstore.getDatabase().getProductByID(ID);
            if (product != null) {
                loggedAccount.addToCart(product);
                Printer.printFormattedMesage("'" + product.getName() + "' has been added to your cart");
                return;
            }
        }
        Printer.printFormattedMesage("The ID inserted is invalid");
    }

    public static void modifyExistingProduct(Bookstore bookstore) {
        String ID = Input.getString("Insert the ID of the product you want to modify");
        if (Input.isIDValid(ID)) {
            Product rawProduct = bookstore.getDatabase().getProductByID(ID);
            if (rawProduct != null) {
                String[] categoryAndGenreType = bookstore.getDatabase().getCategoryAndGenreTypeByID(ID);
                switch (categoryAndGenreType[0]) {
                    case "Albums" -> {
                        Album product = (Album) rawProduct;
                        Menu.ProductEditor.editAlbum(product, bookstore);
                    }

                    case "Books" -> {
                        Book product = (Book) rawProduct;
                        Menu.ProductEditor.editBook(product, bookstore);
                    }

                    case "Films" -> {
                        Film product = (Film) rawProduct;
                        Menu.ProductEditor.editFilm(product, bookstore);
                    }

                    case "Games" -> {
                        Game product = (Game) rawProduct;
                        Menu.ProductEditor.editGame(product, bookstore);
                    }

                    case "Toys" -> {
                        Toy product = (Toy) rawProduct;
                        Menu.ProductEditor.editToy(product, bookstore);
                    }
                }
            }
        }
        Printer.printFormattedMesage("The ID inserted is invalid");
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
            return switch (type) {
                case "String" -> scn.nextLine();
                case "BigDecimal" -> scn.nextBigDecimal();
                case "int" -> scn.nextInt();
                default -> null;
            };
        } catch (InputMismatchException e) {
            return null;
        }
    }
}

