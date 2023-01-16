package br.com.georg.bookstore.products;

import br.com.georg.bookstore.utilities.HashMapTools;

import java.math.BigDecimal;
import java.util.HashMap;

public class Toy extends Product {
    private String type;

    private static String[] typesArray = new String[]{
        "Action figure", "Animal", "Car and radio controlled", "Construction",
        "Creative", "Doll", "Educational", "Electronic", "Executive",
        "Food-related", "Puzzle", "Science and optical", "Sound and music"
    };
    private static HashMap<Integer,String> types =
            HashMapTools.initializeCategoryGenresOrTypesHashMap(typesArray);

    public Toy(String name, BigDecimal price, String type, Integer quantity){
//        super(name, price, quantity, category, type);
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

    public static HashMap<Integer, String> getTypes() {
        return types;
    }

    public static String[] getTypesArray() {
        return typesArray;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getCategory() {
        return "Toys";
    }
}
