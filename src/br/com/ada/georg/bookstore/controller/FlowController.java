package br.com.ada.georg.bookstore.controller;

import br.com.ada.georg.bookstore.controller.account.Account;
import br.com.ada.georg.bookstore.controller.bookstore.Bookstore;
import br.com.ada.georg.bookstore.util.Printer;
import br.com.ada.georg.bookstore.view.menu.AdminUserInterface;
import br.com.ada.georg.bookstore.view.menu.CustomerUserInterface;
import br.com.ada.georg.bookstore.view.menu.LoggedOutUserInterface;

public class FlowController {

    boolean run = true;
    Account loggedAccount = null;
    Bookstore bookstore;

    LoggedOutUserInterface loggedOutUserInterface;
    AdminUserInterface adminUserInterface;
    CustomerUserInterface customerUserInterface;


    public FlowController(Bookstore bookstore) {
        this.bookstore = bookstore;
        loggedOutUserInterface = new LoggedOutUserInterface(this);
        adminUserInterface = new AdminUserInterface(this);
        customerUserInterface = new CustomerUserInterface(this);
    }

    public void run() {
        while (run) {

            loggedOutUserInterface.run();
            adminUserInterface.run();
            customerUserInterface.run();

        }
    }

    public void closeApplication() {
        run = false;
    }

    public boolean noAccountLoggedIn() {
        return loggedAccount == null;
    }

    public boolean customerLoggedIn() {
        return !loggedAccount.getUsername().equalsIgnoreCase("admin");
    }
    public boolean adminLoggedIn() {
        return loggedAccount.getUsername().equalsIgnoreCase("admin");
    }

    public void setLoggedAccount(Account loggedAccount) {
        this.loggedAccount = loggedAccount;
    }

    public Account getLoggedAccount() {
        return loggedAccount;
    }

    public void printAccountStatus() {
        Printer.printFormattedMessage(loggedAccount != null?
                "Logged in as '" +  loggedAccount.getUsername() + "'" : "You are not logged in yet"
        );
    }

    public Bookstore getBookstore() {
        return bookstore;
    }

}
