package br.com.georg.bookstore.util.input;

import br.com.georg.bookstore.service.Account;
import br.com.georg.bookstore.service.Bookstore;
import br.com.georg.bookstore.util.printer.Printer;

import java.util.Objects;

public class AccountInput {

    public static boolean isUsernameValid(String username) {
        boolean usernameLengthValid = (username.length() >= 4 && username.length() <= 15);
        boolean usernameCharactersValid = (username.matches("^[a-zA-Z0-9_]+$"));
        return usernameLengthValid && usernameCharactersValid;
    }

    public static String getUsername(Bookstore bookstore) {
        var username = Input.getString("Insert your desired username").toLowerCase();
        if (!isUsernameValid(username)) {
            Printer.printFormattedMessage("Usernames must have between 4 and 15 characters and " +
                    "contain only letters A-Z, numbers 0-9 or underscores");
            return getUsername(bookstore);

        } else if (!bookstore.getDatabase().isUsernameFree(username)) {
            Printer.printFormattedMessage("That username is already taken");
            return getUsername(bookstore);
        } else {
            return username;
        }
    }

    public static Account logIn(Bookstore bookstore) {
        Account account = null;
        String username = Input.getString("Insert your username");
        String password = Input.getString("Insert your password");

        if(bookstore.getDatabase().isLogInValid(username, password)) {
            account = bookstore.getDatabase().getAccountsHashMap().get(username);
        }

        String message = (account != null)? "Successfully logged in as '" + account.getUsername() + "'": "Invalid credentials";
        Printer.printFormattedMessage(message);
        return account;
    }

    public static Account createNewAccount(Bookstore bookstore){
        Account newAccount = bookstore.registerAccount(getUsername(bookstore),
                Input.getString("Insert your desired password"));
        return Objects.requireNonNullElseGet(newAccount, () -> createNewAccount(bookstore));
    }

}
