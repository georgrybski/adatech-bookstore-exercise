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
    private static HashMap<Integer,String> types = HashMapTools.initializeGenresOrTypesHashMap(typesArray);

    public Toy(String name, BigDecimal price, Integer quantity, Integer type){
        super(name, price, quantity);
        this.type = types.get(type);
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
