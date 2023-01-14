package br.com.georg.bookstore.database;

import br.com.georg.bookstore.products.Product;
import br.com.georg.bookstore.utilities.Account;
import br.com.georg.bookstore.utilities.Bookstore;
import br.com.georg.bookstore.utilities.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private Bookstore bookstore;
    private SearchEngine searchEngine;
    private HashMap<String, HashMap<String, HashMap<String, Product>>> products3DHashMap;
    private HashMap<String, Account> stringAccountHashMap;
    private HashMap<String, HashMap<String, ArrayList<Order>>> ordersHashMap;

    public Database(Bookstore bookstore) {
        this.bookstore = bookstore;
        searchEngine = new SearchEngine(this);
        products3DHashMap = DatabaseTools.initializeInventory();
        stringAccountHashMap = new HashMap<>();
        ordersHashMap = new HashMap<>();
    }

    public void insertProduct(String category, String genreType, Product product) {
        products3DHashMap.get(category)
                .get(genreType)
                .put(product.getID(), product);
    }

    public HashMap<String, HashMap<String, HashMap<String, Product>>> getProducts3DHashMap() {
        return products3DHashMap;
    }

    public Product getProductByID(String ID) {
        return searchEngine.getProductByID(ID);
    }

    protected static class DatabaseTools {

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

}
