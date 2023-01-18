package br.com.georg.bookstore;

import br.com.georg.bookstore.service.Account;
import br.com.georg.bookstore.service.Bookstore;
import br.com.georg.bookstore.utilities.*;
import br.com.georg.bookstore.utilities.printer.Printer;

public class BookstoreApplication {
    public static void main(String[] args) {

        Bookstore bookstore = new Bookstore();
        BookstoreTestScenario.populateBookstore(bookstore);
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
                        Printer.printFormattedMessage("Thanks for visiting my Bookstore!");
                    }
                }
            }

            if (loggedAccount != null) {
                boolean customerLoggedIn = !loggedAccount.getUsername().equalsIgnoreCase("admin");
                if (customerLoggedIn) {
                    Printer.printFormattedMessage("Logged in as '" + loggedAccount.getUsername() + "'");
                    switch (Menu.getCustomerInput()) {
                        // Browse all products
                        case (1) -> Menu.seeProductList(bookstore);
                        // Add a product to shopping cart
                        case (2) -> Input.addProductToCartUsingID(bookstore, loggedAccount);
                        // Go to shopping cart
                        case (3) ->  Menu.goToCart(bookstore, loggedAccount);
//                        // TODO See my purchase history
//                        case (4) ->
                        // Log out
                        case (5) -> loggedAccount = null;
                        // Exit
                        case (6) -> {
                            run = false;
                            Printer.printFormattedMessage("Thanks for visiting my Bookstore!");
                        }
                    }
                }
            }

            if (loggedAccount != null) {
                boolean adminLoggedIn = loggedAccount.getUsername().equalsIgnoreCase("admin");
                if (adminLoggedIn) {
                    Printer.printFormattedMessage("Logged in as '" + loggedAccount.getUsername() + "'");
                    switch (Menu.getAdminInput()) {
                        // See products list
                        case (1) -> Menu.seeProductList(bookstore);
                        // Add new product
                        case (2) -> Menu.addProduct(bookstore);
                        // Modify an existing product
                        case (3) -> Input.modifyExistingProduct(bookstore);
                        // Remove a product
                        case (4) -> Input.removeProductUsingID(bookstore);
//                        // TODO See Dashboard
//                        case (5) ->
//                        // TODO See sales history
//                        case (6) ->
                        // Log out
                        case (7) -> loggedAccount = null;
                        // Exit
                        case (8) -> {
                            run = false;
                            Printer.printFormattedMessage("Thanks for visiting my Bookstore!");
                        }
                    }
                }
            }
        }
    }
}