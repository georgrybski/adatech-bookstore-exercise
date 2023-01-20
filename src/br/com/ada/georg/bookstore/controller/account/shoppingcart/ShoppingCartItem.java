package br.com.ada.georg.bookstore.controller.account.shoppingcart;

import br.com.ada.georg.bookstore.models.Product;

import java.math.BigDecimal;

public class ShoppingCartItem {

    private Product product;
    private int quantity;

    public ShoppingCartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getItemValue() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}

