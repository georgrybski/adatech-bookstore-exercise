package br.com.georg.library.utilities;

import br.com.georg.library.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Order {
    private ArrayList<Product> items;
    private BigDecimal total;
    private String username;

    private static HashMap<String, ArrayList<Order>> orders = new HashMap<>();

    private Order(ArrayList<Product> items, BigDecimal total, String username) {
        this.items = items;
        this.total = total;
        this.username = username;
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
