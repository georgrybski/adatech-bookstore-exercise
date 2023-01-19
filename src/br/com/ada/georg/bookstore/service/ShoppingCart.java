package br.com.ada.georg.bookstore.service;

import br.com.ada.georg.bookstore.products.Product;
import java.math.BigDecimal;
import java.util.ArrayList;


public class ShoppingCart {

    private final ArrayList<ShoppingCartItem> items;
    private final Account account;
    private final Bookstore bookstore;

    public ShoppingCart(Account account, Bookstore bookstore) {
        this.account = account;
        this.bookstore = bookstore;
        items = new ArrayList<>();
    }

    public BigDecimal getTotal() {
        return items.stream()
                .map(ShoppingCartItem::getItemValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
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
        items.clear();
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
