package br.com.ada.georg.bookstore.view.menu;

import br.com.ada.georg.bookstore.controller.FlowController;
import br.com.ada.georg.bookstore.controller.bookstore.Bookstore;
import br.com.ada.georg.bookstore.util.Printer;
import br.com.ada.georg.bookstore.view.input.AccountInput;

public class LoggedOutUserInterface {

    private final FlowController controller;
    private final Bookstore bookstore;

    public LoggedOutUserInterface(FlowController controller) {
        this.controller = controller;
        this.bookstore = controller.getBookstore();
    }

    public void run() {
        controller.printAccountStatus();
        if (controller.noAccountLoggedIn()) {
            switch (Menu.getLoggedOutInput()) {
                // Create Account
                case (1) -> controller.setLoggedAccount(AccountInput.createNewAccount(bookstore));
                // Log In
                case (2) -> controller.setLoggedAccount(AccountInput.logIn(bookstore));
                // Exit
                case 3 -> {
                    controller.closeApplication();
                    Printer.printFormattedMessage("Thanks for visiting my Bookstore!");
                }
            }
        }
    }

}
