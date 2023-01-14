package br.com.georg.bookstore.utilities;

import br.com.georg.bookstore.products.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Order {

    private ArrayList<Product> items;
    private BigDecimal total;
    private String username;
    private String date;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static HashMap<String, ArrayList<Order>> orders = new HashMap<>();

    private Order(ArrayList<Product> items, BigDecimal total, String username) {
        this.items = items;
        this.total = total;
        this.username = username;
        date = LocalDateTime.now().format(formatter);
    }

    public static void archive(ArrayList<Product> items, BigDecimal total, String username) {
        Order order = new Order(items, total, username);
        if (orders.containsKey(username)){
            orders.get(username).add(order);
        } else {
            ArrayList<Order> ordersArrayList = new ArrayList<Order>();
            ordersArrayList.add(order);
            orders.put(username, ordersArrayList);
        }
    }

    public static ArrayList<Order> getOrdersFrom(String username) {
        if(orders.containsKey(username)) {
            return orders.get(username);
        }
        return null;
    }

}
