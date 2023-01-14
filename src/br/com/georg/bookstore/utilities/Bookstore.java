package br.com.georg.bookstore.utilities;

import br.com.georg.bookstore.database.Database;
import br.com.georg.bookstore.products.*;

import java.math.BigDecimal;
import java.util.HashMap;

public class Bookstore {
    private BigDecimal money;
    private Database database;

    private Cashier cashier;

    public Bookstore(){
        money = BigDecimal.valueOf(0);
        database = new Database(this);
        cashier = new Cashier(this);
    }

    public void completeSale(ShoppingCart shoppingCart) {
        cashier.checkout(shoppingCart);
    }

    public void addProduct(String category, String genreType, Product product) {
        database.insertProduct(category, genreType, product);
    }

    public void registerAccount(String username, String password) {

        database.insertAccount(new Account(username, password, this));
    }


    public BigDecimal getMoney() {
        return money;
    }

    public Database getDatabase() {
        return database;
    }

    public HashMap<String, HashMap<String, HashMap<String, Product>>> getInventory() {
        return database.getProducts3DHashMap();
    }

    public Cashier getCashier() {
        return cashier;
    }
}
