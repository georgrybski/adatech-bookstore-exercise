package br.com.georg.library.utilities;

import br.com.georg.library.products.Product;

public class ProductStack {
    private Product product;
    private Integer quantity;

    public ProductStack(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductStack transferStack(Integer quantity) {
        return new ProductStack(product, quantity);
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
