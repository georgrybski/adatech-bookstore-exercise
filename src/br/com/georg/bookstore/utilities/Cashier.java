package br.com.georg.bookstore.utilities;


import java.math.BigDecimal;

public class Cashier {

    private Bookstore bookstore;

    public Cashier(Bookstore bookstore) {
        this.bookstore = bookstore;
    }
    public void checkout(ShoppingCart shoppingCart) {
        recievePayment(shoppingCart.getTotal());
        shoppingCart.emptyCart();
    }

    public void recievePayment(BigDecimal addedMoney) {
        bookstore.getMoney().add(addedMoney);
    }

}
