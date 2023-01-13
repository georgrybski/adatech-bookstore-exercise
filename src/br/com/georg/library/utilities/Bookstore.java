package br.com.georg.library.utilities;

import br.com.georg.library.products.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Bookstore {

    private static BigDecimal money = BigDecimal.valueOf(0);


    private static HashMap<String, HashMap<String, HashMap<String, Product>>> inventory = initializeInventory();


    private Bookstore(){}

    public static void recieveMoney(BigDecimal total) {
        money.add(total);
    }

    private static HashMap<String, HashMap<String, HashMap<String, Product>>> initializeInventory() {
        var inventory = new HashMap<String, HashMap<String, HashMap<String, Product>>>();

        Product.getCategories().values().stream()
                .forEach(category -> inventory.put(category, new HashMap<>()));

        for (Map.Entry<String, HashMap<Integer, String>> outerEntry: Product.getGenresAndTypesHashMap().entrySet()) {
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
        String categoryString = Product.getCategoriesArray()[category];
        Integer genreType = Menu.getInt(Arrays.stream(Menu.GENRE_TYPE_ARRAYS.get(categoryString)).map(s -> i[0]++ + " - " + s).toArray(String[]::new));

//        Menu.createCategoryGenreAndTypeMenuOptions(Album.getGenres());
        String genreTypeString = Menu.GENRE_TYPE_ARRAYS.get(Product.getCategoriesArray()[category])[genreType -1];

        Product product = new Album(
                categoryString,
                Input.getString("Insert the name of the " + categoryString),
                Input.getBigDecimal("Insert the " + categoryString + " price", "Invalid value!", true),
                Input.getString("Insert the" + categoryString + " author"),
                genreTypeString,
                Input.getString("Insert the " +categoryString + "Seal"),
                Input.getInteger(1, Integer.MAX_VALUE, "How many are being put in stock?", "Invalid value Insert a positive integer.")
                );

        inventory.get(categoryString).get(genreTypeString).put(product.getID(), product);
        System.out.println(inventory);

    }

    public static void addAlbum() {

    }

    public static void addBook() {

    }

    public static void addFilm() {

    }

    public static void addGame() {

    }

    public static void addToy() {

    }

    public static HashMap<String, HashMap<String, HashMap<String, Product>>> getInventory() {
        return inventory;
    }
}
