package br.com.ada.georg.bookstore;

import br.com.ada.georg.bookstore.controller.distribuitor.ProductDistribuitor;
import br.com.ada.georg.bookstore.view.input.AccountInput;
import br.com.ada.georg.bookstore.view.input.ProductInput;
import br.com.ada.georg.bookstore.view.menu.Menu;
import br.com.ada.georg.bookstore.util.DashboardPrinter;
import br.com.ada.georg.bookstore.util.OrderPrinter;
import br.com.ada.georg.bookstore.util.Printer;
import br.com.ada.georg.bookstore.controller.account.Account;
import br.com.ada.georg.bookstore.controller.bookstore.Bookstore;

public class BookstoreApplication {
    public static void main(String[] args) {

        Bookstore bookstore = new Bookstore();
        ProductDistribuitor distribuitor = new ProductDistribuitor();
        distribuitor.deliverProductShippment(bookstore);
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