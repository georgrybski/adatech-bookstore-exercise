package br.com.georg.bookstore.utilities;

import br.com.georg.bookstore.database.Database;
import br.com.georg.bookstore.products.*;

import java.math.BigDecimal;
import java.util.HashMap;

public class Bookstore {
    private BigDecimal moneySum;
    private final Database database;
    private final Cashier cashier;

    private final Treasury treasury;

    public Bookstore(){
        moneySum = BigDecimal.valueOf(0);
        database = new Database(this);
        cashier = new Cashier(this);
    }

    public void completeSale(ShoppingCart shoppingCart) {
        cashier.processTransaction(shoppingCart);
    }

    public void addProduct(String category, String genreType, Product product) {
        database.insertProduct(category, genreType, product);
    }

    public boolean removeProduct(String ID) {
        if (database.getInventoryLocationByID(ID).containsKey(ID)) {
            database.getInventoryLocationByID(ID).remove(ID);
            return true;
        } else {
            return false;
        }
    }

    public Account registerAccount(String username, String password) {
        if (database.isUsernameFree(username)){
            Account account = new Account(username, password, this);
            database.insertAccount(account);
            return account;
        }
        return null;
    }

    public BigDecimal getMoneySum() {
        return moneySum;
    }

    public Database getDatabase() {
        return database;
    }

    public HashMap<String, HashMap<String, HashMap<String, Product>>> getInventory() {
        return database.getProducts3DHashMap();
    }

    public void setMoneySum(BigDecimal moneySum) {
        this.moneySum = moneySum;
    }
}
