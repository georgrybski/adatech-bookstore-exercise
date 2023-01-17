package br.com.georg.bookstore.service;

import br.com.georg.bookstore.products.Product;
import java.math.BigDecimal;
import java.util.ArrayList;


public class ShoppingCart {

    private ArrayList<Product> items;
    private Account account;
    private Bookstore bookstore;

    public ShoppingCart(Account account, Bookstore bookstore) {
        this.account = account;
        this.bookstore = bookstore;
        items = new ArrayList<>();
    }

    public BigDecimal getTotal() {
        BigDecimal total = items.stream().map(Product::getValueOfItemStack).reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }

    public boolean productIsInCart(Product product) {
        return items.contains(product);
    }

    public boolean addItemToCart(Product product) {
        if (!productIsInCart(product)) {
            items.add(product);
            return true;
        } else {
            items.stream()
                    .filter(productInList -> product.getID().equals(productInList.getID()))
                    .forEach(product1 -> product1.setQuantity(product1.getQuantity() + 1));
            return false;
        }
    }

    public void checkout() {
        bookstore.completeSale(this);
    }

    public void emptyCart() {
        items = new ArrayList<>();
    }

    public String getUsername() {
        return account.getUsername();
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public Bookstore getBookstore() {
        return bookstore;
    }
}
