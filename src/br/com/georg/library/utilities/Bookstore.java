package br.com.georg.library.utilities;

import br.com.georg.library.products.*;

import java.math.BigDecimal;
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

    public static void insertProduct(String category, String genreType, Product product) {
        inventory.get(category)
                .get(genreType)
                .put(product.getID(), product);
    }

    public static Product findById(String ID) {
        return null;
    }

    public static HashMap<String, HashMap<String, HashMap<String, Product>>> getInventory() {
        return inventory;
    }
}
