package br.com.georg.bookstore.service;

import br.com.georg.bookstore.products.Product;
import br.com.georg.bookstore.service.ShoppingCart;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private ArrayList<Product> items;
    private BigDecimal total;
    private String username;
    private String date;

    public Order(ShoppingCart shoppingCart) {
        items = shoppingCart.getItems();
        total = shoppingCart.getTotal();
        username = shoppingCart.getUsername();
        date = LocalDateTime.now().format(formatter);
    }

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public ArrayList<Product> getItems() {
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

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }
}
