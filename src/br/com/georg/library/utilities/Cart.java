package br.com.georg.library.utilities;

import br.com.georg.library.products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Cart {

    private ArrayList<Product> items = new ArrayList<>();

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.valueOf(0);
        for (Product product: items) {
            total.add(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())));
        }
        return total;
    }

    public void checkout() {
        Cashier.completeSale(this);
    }

    public void emptyCart() {
        items = new ArrayList<>();
    }
}
