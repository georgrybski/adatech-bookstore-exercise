package br.com.georg.bookstore.database;

import br.com.georg.bookstore.products.Product;
import br.com.georg.bookstore.utilities.Account;

import java.util.HashMap;

public class Database {

    private static HashMap<String, HashMap<String, HashMap<String, Product>>> products3DHashMap = DatabaseTools.initializeInventory();

    private static HashMap<String, Account> stringAccountHashMap = new HashMap<>();

    public static void insertProduct(String category, String genreType, Product product) {
        products3DHashMap.get(category)
                .get(genreType)
                .put(product.getID(), product);
    }

    public static HashMap<String, HashMap<String, HashMap<String, Product>>> getProducts3DHashMap() {
        return products3DHashMap;
    }

}
