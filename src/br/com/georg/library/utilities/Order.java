package br.com.georg.library.utilities;

import br.com.georg.library.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {
    private ArrayList<Product> items;
    private BigDecimal total;
    private String address;

    protected Order(ArrayList<Product> items, BigDecimal total, String address) {
        this.items = items;
        this.total = total;
        this.address = address;
    }
}
