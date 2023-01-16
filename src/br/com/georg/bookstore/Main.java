package br.com.georg.bookstore;

import br.com.georg.bookstore.utilities.*;

public class Main {
    public static void main(String[] args) {

        Bookstore bookstore = new Bookstore();
        Account loggedAccount = null;
        boolean run = true;


        while (run) {

            boolean notLoggedIn = loggedAccount == null;
            if (notLoggedIn) {
                switch (Menu.getLoggedOutInput()) {
                    // Create Account
                    case (1) -> loggedAccount = Input.createNewAccount(bookstore);
                    // Log In
                    case (2) -> loggedAccount = Input.logIn(bookstore);
                    // Exit
                    case 3 -> {
                        run = false;
                        Printer.printFormattedMesage("Thanks for visiting my Bookstore!");
                    }
                }
            }

            if (loggedAccount != null) {
                boolean customerLoggedIn = !loggedAccount.getUsername().equalsIgnoreCase("admin");
                if (customerLoggedIn) {
                    Printer.printFormattedMesage("Logged in as '" + loggedAccount.getUsername() + "'");
                    switch (Menu.getCustomerInput()) {
                        // Browse all products
                        case (1) -> Menu.seeProductList(bookstore);
                        // Add a product to shopping cart
                        case (2) -> Input.addProductToCartUsingID(bookstore, loggedAccount);
//                        // TODO Go to shopping cart
//                        case (3) ->
//                        // TODO See my purchase history
//                        case (4) ->
                        // Log out
                        case (5) -> loggedAccount = null;
                        // Exit
                        case (6) -> {
                            run = false;
                            Printer.printFormattedMesage("Thanks for visiting my Bookstore!");
                        }
                    }
                }
            }

            if (loggedAccount != null) {
                boolean adminLoggedIn = loggedAccount.getUsername().equalsIgnoreCase("admin");
                if (adminLoggedIn) {
                    Printer.printFormattedMesage("Logged in as '" + loggedAccount.getUsername() + "'");
                    switch (Menu.getAdminInput()) {
                        // See products list
                        case (1) -> Menu.seeProductList(bookstore);
                        // Add new product
                        case (2) -> Menu.addProduct(bookstore);
                        // Modify an existing product
                        case (3) -> Input.modifyExistingProduct(bookstore);
                        // Remove a product
                        case (4) -> Input.removeProductUsingID(bookstore);
//                        // TODO See sales history
//                        case (5) ->
                        // Log out
                        case (6) -> loggedAccount = null;
                        // Exit
                        case (7) -> {
                            run = false;
                            Printer.printFormattedMesage("Thanks for visiting my Bookstore!");
                        }
                    }
                }
            }
        }
    }
}