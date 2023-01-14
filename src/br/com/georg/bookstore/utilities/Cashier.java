package br.com.georg.bookstore.utilities;

public class Cashier {

    private Cashier() {}
    public static void completeSale(Cart shoppingCart) {
        Bookstore.recieveMoney(shoppingCart.getTotal());
        shoppingCart.emptyCart();
    }

}
