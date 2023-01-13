package br.com.georg.library.products;

import java.math.BigDecimal;

public class Product {
    private String name;
    private String ID;
    private BigDecimal price;
    private Integer quantity;
    private static Integer IDCounter = 1;

    protected Product(String name, BigDecimal price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        ID = (IDCounter++).toString();
    }

    protected Product(String name, BigDecimal price, String ID, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ID = ID;
    }

    protected Product copy(Integer quantity) {
        return new Product(this.name, this.price, this.ID, quantity);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}