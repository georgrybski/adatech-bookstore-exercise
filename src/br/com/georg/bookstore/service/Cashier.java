package br.com.georg.bookstore.service;

public class Cashier {
    private final Bookstore bookstore;

    public Cashier(Bookstore bookstore) {
        this.bookstore = bookstore;
    }
    public void processTransaction(ShoppingCart shoppingCart) {

        bookstore.getTreasury().recieveMoneyFromSale(shoppingCart.getTotal());
        registerOrder(shoppingCart);
        shoppingCart.emptyCart();
    }

    private void registerOrder(ShoppingCart shoppingCart) {
        bookstore.getDatabase().getOrderHistoryFrom(shoppingCart.getUsername()).add(new Order(shoppingCart));
    }
}
