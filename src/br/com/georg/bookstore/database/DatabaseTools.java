package br.com.georg.bookstore.database;

import br.com.georg.bookstore.products.Product;

import java.util.HashMap;
import java.util.Map;

public class DatabaseTools {

    protected static HashMap<String, HashMap<String, HashMap<String, Product>>> initializeInventory() {
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

}
