package br.com.georg.bookstore.utilities;

import java.math.BigDecimal;

public class Cashier {
    private Bookstore bookstore;

    public Cashier(Bookstore bookstore) {
        this.bookstore = bookstore;
    }
    public void processTransaction(ShoppingCart shoppingCart) {
        recievePayment(shoppingCart.getTotal());
        registerOrder(shoppingCart);
        shoppingCart.emptyCart();
    }

    public void recievePayment(BigDecimal addedMoney) {
        bookstore.getMoneySum().add(addedMoney);
    }

    private void registerOrder(ShoppingCart shoppingCart) {
        bookstore.getDatabase().getOrderHistoryFrom(shoppingCart.getUsername()).add(new Order(shoppingCart));
    }
}
