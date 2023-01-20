package br.com.ada.georg.bookstore.controller.bookstore;

import br.com.ada.georg.bookstore.models.products.Product;
import br.com.ada.georg.bookstore.controller.account.shoppingcart.ShoppingCart;
import br.com.ada.georg.bookstore.controller.account.shoppingcart.ShoppingCartItem;

import java.util.ArrayList;
import java.util.List;

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
        List<Product> items = shoppingCart.getItems().stream()
                .map(item -> item.getProduct().copy(item.getQuantity())).toList();

        Order newOrder = new Order(shoppingCart, items);
        bookstore.getDatabase().getOrderHistoryFrom(shoppingCart.getUsername()).add(newOrder);
        bookstore.getDashboard().recieveSaleData(newOrder);
    }

    private void takeProductsFormStock(ArrayList<ShoppingCartItem> items) {
        items.stream().forEach(shoppingCartItem -> {
            Product stock = bookstore.getDatabase().getProductByID(shoppingCartItem.getProduct().getID());
            Integer remainigStock = stock.getQuantity() - shoppingCartItem.getQuantity();
            stock.setQuantity(remainigStock);
        });
    }
}
