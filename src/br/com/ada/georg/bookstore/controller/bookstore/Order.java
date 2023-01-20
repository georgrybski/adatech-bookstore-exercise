package br.com.ada.georg.bookstore.controller.bookstore;

import br.com.ada.georg.bookstore.models.Product;
import br.com.ada.georg.bookstore.controller.account.shoppingcart.ShoppingCart;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {
    private List<Product> items;
    private BigDecimal total;
    private String username;
    private String date;

    public Order(ShoppingCart shoppingCart, List<Product> items) {
        this.items = items;
        total = shoppingCart.getTotal();
        username = shoppingCart.getUsername();
        date = LocalDateTime.now().format(formatter);
    }

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public List<Product> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getUsername() {
        return username;
    }

    public String getDate() {
        return date;
    }

}
