package br.com.georg.library.utilities;

import br.com.georg.library.products.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Bookstore {

    private static BigDecimal money = BigDecimal.valueOf(0);

    private static HashMap<String, HashMap<Integer, String>> genresAndTypesHashMap =
            new HashMap<>(Map.of(
                    "Albums", Album.getGenres(), "Books", Book.getGenres(),
                    "Films", Film.getGenres(), "Games", Game.getGenres(),
                    "Toys", Toy.getTypes()
            ));

    private static HashMap<Integer, String> categories =
            HashMapTools.initializeGenresOrTypesHashMap(
                    genresAndTypesHashMap.keySet()
                                         .stream()
                                         .toArray(String[]::new)
            );

    private static HashMap<String, HashMap<String, HashMap<String, InventoryItem>>> inventory = initializeInventory();

    private Bookstore(){}

    public static void recieveMoney(BigDecimal total) {
        money.add(total);
    }

    private static HashMap<String, HashMap<String, HashMap<String, InventoryItem>>> initializeInventory() {
        var inventory = new HashMap<String, HashMap<String, HashMap<String, InventoryItem>>>();

        categories.values().stream()
                .forEach(category -> inventory.put(category, new HashMap<>()));

        for (Map.Entry<String, HashMap<Integer, String>> outerEntry: genresAndTypesHashMap.entrySet()) {
            for (Map.Entry<Integer, String> innerEntry : outerEntry.getValue().entrySet() ) {
                inventory.get(outerEntry.getKey()).put(innerEntry.getValue(), new HashMap<>());
            }
        }

        return inventory;
    }

    public static HashMap<Integer, String> getCategories() {
        return categories;
    }

    public static HashMap<String, HashMap<String, HashMap<String, InventoryItem>>> getInventory() {
        return inventory;
    }
}
