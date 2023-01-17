package br.com.georg.bookstore.service;

import br.com.georg.bookstore.products.Product;

import java.util.ArrayList;

public class Cashier {
    private final Bookstore bookstore;

    public Cashier(Bookstore bookstore) {
        this.bookstore = bookstore;
    }
    public void processTransaction(ShoppingCart shoppingCart) {
        bookstore.getTreasury().recieveMoneyFromSale(shoppingCart.getTotal());
        registerOrder(shoppingCart);
        takeProductsFormStock(shoppingCart.getItems());
        shoppingCart.emptyCart();
    }

    private void registerOrder(ShoppingCart shoppingCart) {
        bookstore.getDatabase().getOrderHistoryFrom(shoppingCart.getUsername()).add(new Order(shoppingCart));
    }

    private void takeProductsFormStock(ArrayList<Product> items) {
        items.stream().forEach(product -> {
            Product stock = bookstore.getDatabase().getProductByID(product.getID());
            Integer remainigStock = stock.getQuantity() - product.getQuantity();
            stock.setQuantity(remainigStock);
        });
    }
}
