package br.com.georg.bookstore;

import br.com.georg.bookstore.service.Account;
import br.com.georg.bookstore.service.Bookstore;
import br.com.georg.bookstore.util.*;
import br.com.georg.bookstore.util.input.AccountInput;
import br.com.georg.bookstore.util.input.ProductInput;
import br.com.georg.bookstore.util.menu.Menu;
import br.com.georg.bookstore.util.printer.DashboardPrinter;
import br.com.georg.bookstore.util.printer.OrderPrinter;
import br.com.georg.bookstore.util.printer.Printer;

import java.util.Scanner;

public class BookstoreApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bookstore bookstore = new Bookstore();
        BookstoreTestScenario.populateBookstore(bookstore);
        Account loggedAccount = null;
        boolean run = true;

        while (run) {

            boolean notLoggedIn = loggedAccount == null;
            if (notLoggedIn) {
                switch (Menu.getLoggedOutInput()) {
                    // Create Account
                    case (1) -> loggedAccount = AccountInput.createNewAccount(bookstore);
                    // Log In
                    case (2) -> loggedAccount = AccountInput.logIn(bookstore);
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
                        case (2) -> ProductInput.addProductToCartUsingID(bookstore, loggedAccount);
                        // Go to shopping cart
                        case (3) ->  Menu.goToCart(bookstore, loggedAccount);
                        // See my purchase history
                        case (4) -> loggedAccount.viewOrders();
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
                        case (3) -> ProductInput.modifyExistingProduct(bookstore);
                        // Remove a product
                        case (4) -> ProductInput.removeProductUsingID(bookstore);
                        // See Dashboard
                        case (5) -> DashboardPrinter.printDashboard(bookstore);
                        // See sales history
                        case (6) -> OrderPrinter.printAllOrders(bookstore);
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