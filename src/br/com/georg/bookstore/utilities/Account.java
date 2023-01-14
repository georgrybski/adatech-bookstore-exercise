package br.com.georg.bookstore.utilities;

import java.util.ArrayList;

public class Account {
    private String username;
    private String password;
    private Bookstore bookstore;
    private ShoppingCart shoppingCart;

    // TODO figure out where to put the ORDERS data structure

    private Account(String username, String password, Bookstore bookstore) {
        this.username = username;
        this.password = password;
        this.bookstore = bookstore;
        shoppingCart = new ShoppingCart(this);
    }
}
