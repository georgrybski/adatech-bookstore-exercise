package br.com.georg.library.utilities;

public class Cashier {

    private Cashier() {}
    public static void completeSale(Cart shoppingCart) {
        Bookstore.recieveMoney(shoppingCart.getTotal());
        shoppingCart.emptyCart();
    }

}
