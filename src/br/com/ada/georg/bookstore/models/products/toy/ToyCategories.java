package br.com.ada.georg.bookstore.models.products.toy;

import br.com.ada.georg.bookstore.controller.HashMapTools;

import java.util.HashMap;

public class ToyCategories {

    private static final String[] typesArray = new String[]{
            "Action figure", "Animal", "Car and radio controlled", "Construction",
            "Creative", "Doll", "Educational", "Electronic", "Executive",
            "Food-related", "Puzzle", "Science and optical", "Sound and music"
    };

    private static final HashMap<Integer,String> types =
            HashMapTools.initializeCategoryGenresOrTypesHashMap(typesArray);

    public static String[] getTypesArray() {
        return typesArray;
    }

    public static HashMap<Integer, String> getTypes() {
        return types;
    }

}
