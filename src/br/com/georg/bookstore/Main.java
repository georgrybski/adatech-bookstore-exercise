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
                    // TODO Create Account
                    case (1):
                        break;
                    // TODO Log In
                    case (2):
                        break;
                    // Exit
                    case 3:
                        run = false;
                        Printer.printFormattedMesage("Thanks for visiting my Bookstore!");
                        break;
                }
            }

            if (loggedAccount != null) {
                boolean customerLoggedIn = !loggedAccount.getUsername().equalsIgnoreCase("admin");
                if (customerLoggedIn) {
                    switch (Menu.getCustomerInput()) {
                        // TODO Browse all products
                        case (1):
                            break;
                        // TODO Browse products by category
                        case (2):
                            break;
                        // TODO Go to shopping cart
                        case (3):
                            break;
                        // TODO See my purchase history
                        case (4):
                            break;
                        // Log out
                        case (5):
                            loggedAccount = null;
                            break;
                        // Exit
                        case (6):
                            run = false;
                            Printer.printFormattedMesage("Thanks for visiting my Bookstore!");
                            break;
                    }
                }
            }

            if (loggedAccount != null) {
                boolean adminLoggedIn = loggedAccount.getUsername().equalsIgnoreCase("admin");
                if (adminLoggedIn) {
                    switch (Menu.getAdminInput()) {
                        // TODO See products list
                        case (1):
                            break;
                        // TODO Add new product
                        case (2):
                            Menu.addProduct(bookstore);
                            break;
                        // TODO Modify an existing product
                        case (3):
                            break;
                        // TODO Remove a product
                        case (4):
                            break;
                        // TODO See sales history
                        case (5):
                            break;
                        // Log out
                        case (6):
                            loggedAccount = null;
                            break;
                        // Exit
                        case (7):
                            run = false;
                            Printer.printFormattedMesage("Thanks for visiting my Bookstore!");
                            break;
                    }
                }
            }
        }
    }
}