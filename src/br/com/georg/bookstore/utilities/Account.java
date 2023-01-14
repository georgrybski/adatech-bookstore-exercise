package br.com.georg.bookstore.utilities;

import java.util.ArrayList;

public class Account {

    private String username;

    private String password;

    private Cart shoppingCart = new Cart();

    private static ArrayList<Account> accountList = new ArrayList<>();

    private Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account register(String username, String password) {
        Account account = getAccount(username);
        if (account != null) {
            account = new Account(username, password);
            accountList.add(account);
        }
        return account;
    }

    public static Account getAccount(String username) {
        for (Account account: accountList) {
            if (account.username.equalsIgnoreCase(username)){
                return account;
            }
        }
        return null;
    }

}
