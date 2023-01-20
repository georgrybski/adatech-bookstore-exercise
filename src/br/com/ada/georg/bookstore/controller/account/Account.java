package br.com.ada.georg.bookstore.controller.account;

import br.com.ada.georg.bookstore.models.products.Product;
import br.com.ada.georg.bookstore.controller.bookstore.Bookstore;
import br.com.ada.georg.bookstore.controller.account.shoppingcart.ShoppingCart;
import br.com.ada.georg.bookstore.util.OrderPrinter;
import br.com.ada.georg.bookstore.util.Printer;

public class Account {
    private String username;
    private String password;
    private Bookstore bookstore;
    private final ShoppingCart shoppingCart;

    public Account(String username, String password, Bookstore bookstore) {
        this.username = username;
        this.password = password;
        this.bookstore = bookstore;
        shoppingCart = new ShoppingCart(this, bookstore);
    }

    public String addToCart(Product product, int quantity) {
        return shoppingCart.addItemToCart(product, quantity);
    }

    public void viewOrders() {
        if(bookstore.getDatabase().getOrderHistoryFrom(username).isEmpty()) {
            Printer.printFormattedMessage("You have not placed any orders yet");
        }
        OrderPrinter.printOrdersFromList(bookstore.getDatabase().getOrderHistoryFrom(username));
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
