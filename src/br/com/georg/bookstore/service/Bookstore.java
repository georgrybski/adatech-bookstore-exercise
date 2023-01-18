package br.com.georg.bookstore.service;

import br.com.georg.bookstore.database.Database;
import br.com.georg.bookstore.products.*;

import java.util.HashMap;

public class Bookstore {
    private String name;
    private final Database database;
    private final Cashier cashier;
    private final Treasury treasury;

    private final Dashboard dashboard;

    public Bookstore(){
        database = new Database(this);
        cashier = new Cashier(this);
        treasury = new Treasury(this);
        dashboard = new Dashboard(this);
    }

    public void completeSale(ShoppingCart shoppingCart) {
        cashier.processTransaction(shoppingCart);
    }

    public void addProduct(String category, String genreType, Product product) {
        dashboard.recieveNewProductData(product, category);
        database.insertProduct(category, genreType, product);
    }

    public boolean removeProduct(String ID) {
        if (database.productExists(ID)) {
            treasury.recalculateInventoryValueRemovingItem(ID);
            dashboard.recieveProductRemovalData(ID);
            database.removeProduct(ID);
            return true;
        } else {
            return false;
        }
    }

    public Account registerAccount(String username, String password) {
        if (database.isUsernameFree(username)){
            database.insertAccount(new Account(username, password, this));
            return database.getAccountByUsername(username);
        }
        return null;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public Database getDatabase() {
        return database;
    }

    public HashMap<String, HashMap<String, HashMap<String, Product>>> getInventory() {
        return database.getProducts3DHashMap();
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public String getName() {
        return name;
    }
}
