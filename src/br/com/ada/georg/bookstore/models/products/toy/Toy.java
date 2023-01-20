package br.com.ada.georg.bookstore.models.products.toy;

import br.com.ada.georg.bookstore.models.products.Product;

import java.math.BigDecimal;

public class Toy extends Product {
    private String type;

    public Toy(String name, BigDecimal price, String type, Integer quantity){
        super(name, price, quantity, "Toys", type);
        this.type = type;
    }

    private Toy(String name, BigDecimal price, String ID, Integer quantity, String type) {
        super(name, price, ID,quantity);
        this.type = type;
    }

    @Override
    public Product copy(Integer quantity) {
        return new Toy(this.getName(), this.getPrice(), this.getID(), quantity, this.type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getCategory() {
        return "Toys";
    }

    @Override
    public String getGenreType() {return type;}
}
