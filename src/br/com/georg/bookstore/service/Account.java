package br.com.georg.bookstore.service;

import br.com.georg.bookstore.products.Product;

public class Account {
    private String username;
    private String password;
    private Bookstore bookstore;
    private ShoppingCart shoppingCart;

    public Account(String username, String password, Bookstore bookstore) {
        this.username = username;
        this.password = password;
        this.bookstore = bookstore;
        shoppingCart = new ShoppingCart(this, bookstore);
    }
    public void purchaseItemsInCart() {
        shoppingCart.checkout();
    }

    public String addToCart(Product product, int quantity) {

        return shoppingCart.addItemToCart(product, quantity);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Bookstore getBookstore() {
        return bookstore;
    }

    public void setBookstore(Bookstore bookstore) {
        this.bookstore = bookstore;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public static Account getAdmin(Bookstore bookstore) {
        return new Account("admin", "admin", bookstore);
    }
}
