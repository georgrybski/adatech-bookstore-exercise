package br.com.georg.bookstore.service;

import br.com.georg.bookstore.products.Product;
import br.com.georg.bookstore.util.printer.OrderPrinter;
import br.com.georg.bookstore.util.printer.Printer;

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
