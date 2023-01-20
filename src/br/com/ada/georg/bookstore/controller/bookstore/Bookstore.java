package br.com.ada.georg.bookstore.controller.bookstore;

import br.com.ada.georg.bookstore.models.Product;
import br.com.ada.georg.bookstore.repository.InMemoryDatabase;
import br.com.ada.georg.bookstore.controller.account.Account;
import br.com.ada.georg.bookstore.controller.account.shoppingcart.ShoppingCart;

import java.util.HashMap;

public class Bookstore {
    private final InMemoryDatabase inMemoryDatabase;
    private final Cashier cashier;
    private final Treasury treasury;
    private final Dashboard dashboard;

    public Bookstore(){
        inMemoryDatabase = new InMemoryDatabase(this);
        cashier = new Cashier(this);
        treasury = new Treasury(this);
        dashboard = new Dashboard(this);
    }

    public void completeSale(ShoppingCart shoppingCart) {
        cashier.processTransaction(shoppingCart);
    }

    public void addProduct(String category, String genreType, Product product) {
        dashboard.recieveNewProductData(product, category);
        inMemoryDatabase.insertProduct(category, genreType, product);
    }

    public boolean removeProduct(String ID) {
        if (inMemoryDatabase.productExists(ID)) {
            dashboard.recieveProductRemovalData(ID);
            inMemoryDatabase.removeProduct(ID);
            return true;
        } else {
            return false;
        }
    }

    public Account registerAccount(String username, String password) {
        if (inMemoryDatabase.isUsernameFree(username)){
            inMemoryDatabase.insertAccount(new Account(username, password, this));
            return inMemoryDatabase.getAccountByUsername(username);
        }
        return null;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public InMemoryDatabase getDatabase() {
        return inMemoryDatabase;
    }

    public HashMap<String, HashMap<String, HashMap<String, Product>>> getInventory() {
        return inMemoryDatabase.getProducts3DHashMap();
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

}
