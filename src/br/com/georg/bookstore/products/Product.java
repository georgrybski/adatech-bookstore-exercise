package br.com.georg.bookstore.products;

import br.com.georg.bookstore.products.album.AlbumCategories;
import br.com.georg.bookstore.products.book.BookCategories;
import br.com.georg.bookstore.products.film.FilmCategories;
import br.com.georg.bookstore.products.game.GameCategories;
import br.com.georg.bookstore.products.toy.ToyCategories;
import br.com.georg.bookstore.utilities.HashMapTools;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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

    /*
    Evaluate making this class abstract and the copy method return this
     */
    public Product copy(Integer quantity) {
        return this;
    }

    public String getCategory() {
        return null;
    }

    public String getGenreType() {return null;}

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