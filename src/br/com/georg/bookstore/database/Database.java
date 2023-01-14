package br.com.georg.bookstore.database;

import br.com.georg.bookstore.products.Book;
import br.com.georg.bookstore.products.Product;
import br.com.georg.bookstore.utilities.Account;
import br.com.georg.bookstore.utilities.Bookstore;

import java.util.HashMap;

public class Database {

    private Bookstore bookstore;
    private IDSearcher searchEngine;
    private HashMap<String, HashMap<String, HashMap<String, Product>>> products3DHashMap;
    private HashMap<String, Account> stringAccountHashMap;

    public Database(Bookstore bookstore) {
        products3DHashMap = DatabaseTools.initializeInventory();
        stringAccountHashMap = new HashMap<>();
        this.bookstore = bookstore;
        searchEngine = new IDSearcher(this);
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

}
