package br.com.ada.georg.bookstore.models.products;

import java.math.BigDecimal;

public abstract class Product {

    private static Integer IDCounter = 1;

    private String name;

    private String ID;

    private BigDecimal price;

    private Integer quantity;

    protected Product(String name, BigDecimal price, Integer quantity, String category, String genreType) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        String id = (IDCounter++).toString();
        ID = category.substring(0,3).toUpperCase() +
                genreType.substring(0,3).toUpperCase() +
                "0".repeat(4 - id.length()) + id;
    }

    protected Product(String name, BigDecimal price, String ID, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ID = ID;
    }

    public abstract Product copy(Integer quantity);

    public abstract String getCategory();

    public abstract String getGenreType();

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

    public BigDecimal getValueOfItemStack() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}