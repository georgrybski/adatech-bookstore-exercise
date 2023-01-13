package br.com.georg.library.utilities;

import br.com.georg.library.products.*;

import java.math.BigDecimal;
import java.util.Arrays;
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


    private static String[] categoriesArray =
            new String[]{"Albums", "Books", "Films", "Games", "Toys"};

//    private static HashMap<Integer, String> categories =
//            HashMapTools.initializeCategoryGenresOrTypesHashMap(
//                    genresAndTypesHashMap.keySet()
//                                         .stream()
//                                         .toArray(String[]::new)
//            );
    private static HashMap<Integer, String> categories = HashMapTools.initializeCategoryGenresOrTypesHashMap(categoriesArray);



    private static HashMap<String, HashMap<String, HashMap<String, Product>>> inventory = initializeInventory();

    private Bookstore(){}

    public static void recieveMoney(BigDecimal total) {
        money.add(total);
    }

    private static HashMap<String, HashMap<String, HashMap<String, Product>>> initializeInventory() {
        var inventory = new HashMap<String, HashMap<String, HashMap<String, Product>>>();

        categories.values().stream()
                .forEach(category -> inventory.put(category, new HashMap<>()));

        for (Map.Entry<String, HashMap<Integer, String>> outerEntry: genresAndTypesHashMap.entrySet()) {
            for (Map.Entry<Integer, String> innerEntry : outerEntry.getValue().entrySet() ) {
                inventory.get(outerEntry.getKey()).put(innerEntry.getValue(), new HashMap<>());
            }
        }

        return inventory;
    }

    // Todo
    public static void addProductToStock() {
        int[] i = {1};


        Integer category = (Menu.getProductCategory()) -1;
        String categoryString = categoriesArray[category];
        Integer genreType = Menu.getInt(Arrays.stream(Menu.GENRE_TYPE_ARRAYS.get(categoryString)).map(s -> i[0]++ + " - " + s).toArray(String[]::new));
        String genreTypeString = Menu.GENRE_TYPE_ARRAYS.get(categoriesArray[category])[genreType -1];
        Product product = new Game("StarField", BigDecimal.valueOf(100), 72, "Bethesda", genreType, "Bethesda");
        String id = categoryString.substring(0,3) + genreTypeString.substring(0,3) + "0".repeat(4-product.getID().length()) + product.getID();
        System.out.println(id);
        product.setID(id);
        inventory.get(categoryString).get(genreTypeString).put(id, product);
        System.out.println(inventory);


//        Integer type = Menu.getInt((inventory.get(categoriesArray[category-1])).keySet().stream().map(key -> i[0]++ + " | " + key).toArray(String[]::new));
    }

    public static HashMap<Integer, String> getCategories() {
        return categories;
    }

    public static HashMap<String, HashMap<String, HashMap<String, Product>>> getInventory() {
        return inventory;
    }
}
