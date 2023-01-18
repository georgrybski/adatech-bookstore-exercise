package br.com.georg.bookstore.service;

import br.com.georg.bookstore.products.Product;
import java.math.BigDecimal;
import java.util.ArrayList;


public class ShoppingCart {

    private ArrayList<ShoppingCartItem> items;
    private Account account;
    private Bookstore bookstore;

    public ShoppingCart(Account account, Bookstore bookstore) {
        this.account = account;
        this.bookstore = bookstore;
        items = new ArrayList<>();
    }

    public BigDecimal getTotal() {
        BigDecimal total = items.stream()
                .map(ShoppingCartItem::getItemValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }

    public ShoppingCartItem productIsInCart(Product product) {
        for (ShoppingCartItem item : items) {
            if (item.getProduct().equals(product)) {
                return item;
            }
        }
        return null;
    }

    public String addItemToCart(Product product, int quantity) {
        String message = "";
        ShoppingCartItem itemInCart = productIsInCart(product);
        if (itemInCart == null) {
            items.add(new ShoppingCartItem(product, quantity));
            return "Added " + quantity + " '" + product.getName() + "' to cart";
        } else {
            boolean enoughStock = itemInCart.getQuantity() + quantity < product.getQuantity();
            if (enoughStock) {
                itemInCart.setQuantity(itemInCart.getQuantity() + quantity);
                return "Added " + quantity + " '" + product.getName() + "' to cart";
            }
            else {
                itemInCart.setQuantity(product.getQuantity());
                return "You inserted a value above the availiable stock, your cart now has "
                        + product.getQuantity() + " units of '" + product.getName() + "'";
            }
        }
    }

    public ShoppingCartItem getItemInCart(String ID) {
        for (ShoppingCartItem item : items) {
            if(item.getProduct().getID().equals(ID)) {
                return item;
            }
        }
        return null;
    }


    public String removeItemFromCart(String ID) {
        ShoppingCartItem itemInCart = getItemInCart(ID);
        String message = null;
        if (itemInCart != null) {
            items.remove(itemInCart);
            message = "'" + itemInCart.getProduct().getName() + "' has been removed from your cart";
        }
        else {
            message = "This ID doesn't match any item in your cart";
        }
        return message;
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

    public ArrayList<ShoppingCartItem> getItems() {
        return items;
    }

    public Bookstore getBookstore() {
        return bookstore;
    }
}
