package br.com.georg.library.products;

import br.com.georg.library.utilities.HashMapTools;

import java.math.BigDecimal;
import java.util.HashMap;

public class Toy extends Product {
    private String type;

    private static String[] typesArray = new String[]{
        "Action figures", "Animals", "Cars and radio controlled", "Construction toys",
        "Creative toys", "Dolls", "Educational toys", "Electronic toys", "Executive toys",
        "Food-related toys", "Puzzle", "Science and optical", "Sound toys"
    };
    private static HashMap<Integer,String> types =
            HashMapTools.initializeCategoryGenresOrTypesHashMap(typesArray);

    public Toy(String category, String name, BigDecimal price, Integer quantity, String type){
        super(name, price, quantity, category, type);
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

    public static void setTypes(HashMap<Integer, String> types) {
        Toy.types = types;
    }

    public static void setTypesArray(String[] typesArray) {
        Toy.typesArray = typesArray;
    }

}
