package br.com.georg.bookstore.utilities;

import br.com.georg.bookstore.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> items = new ArrayList<>();
    private Account account;
    private Bookstore bookstore;

    public ShoppingCart(Account account) {

    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.valueOf(0);
        for (Product product: items) {
            total.add(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())));
        }
        return total;
    }

    public void checkout() {
        bookstore.completeSale(this);
    }

    public void emptyCart() {
        items = new ArrayList<>();
    }
}
