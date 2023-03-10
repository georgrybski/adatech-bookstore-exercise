package br.com.ada.georg.bookstore.repository;

import br.com.ada.georg.bookstore.models.products.Product;
import br.com.ada.georg.bookstore.controller.bookstore.Order;
import br.com.ada.georg.bookstore.controller.account.shoppingcart.ShoppingCart;
import br.com.ada.georg.bookstore.models.products.ProductCategories;
import br.com.ada.georg.bookstore.controller.account.Account;
import br.com.ada.georg.bookstore.controller.bookstore.Bookstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
    private Bookstore bookstore;
    private SearchEngine searchEngine;
    private HashMap<String, HashMap<String, HashMap<String, Product>>> products3DHashMap;
    private HashMap<String, Account> accountsHashMap;
    private HashMap<String, ArrayList<Order>> ordersHashMap;
    private HashMap<String, ShoppingCart> shoppingCartsHashMap;

    public InMemoryDatabase(Bookstore bookstore) {
        this.bookstore = bookstore;
        searchEngine = new SearchEngine(this);
        products3DHashMap = DatabaseTools.initialize3DProductsHashMap();
        accountsHashMap = new HashMap<>();
        ordersHashMap = new HashMap<>();
        shoppingCartsHashMap = new HashMap<>();
        accountsHashMap.put("admin", Account.getAdmin(bookstore));
    }

    public void insertAccount(Account account) {
        accountsHashMap.put(account.getUsername(), account);
        ordersHashMap.put(account.getUsername(), new ArrayList<>());
        shoppingCartsHashMap.put(account.getUsername(), account.getShoppingCart());
    }

    public void insertProduct(String category, String genreType, Product product) {
        products3DHashMap.get(category)
                .get(genreType)
                .put(product.getID(), product);
    }

    public HashMap<String, HashMap<String, HashMap<String, Product>>> getProducts3DHashMap() {
        return products3DHashMap;
    }

    public ArrayList<Order> getOrderHistoryFrom(String username) {
        return searchEngine.getOrderArrayListWithUsername(username);
    }

    public Product getProductByID(String ID) {
        return searchEngine.getProductByID(ID);
    }

    public HashMap<String, Product> getInventoryLocationByID(String ID) {
        return searchEngine.getHashMapByID(ID);
    }

    public boolean isUsernameFree(String username) {
        return !searchEngine.usernameExists(username);
    }

    public boolean isLogInValid(String username, String password) {
        if (searchEngine.usernameExists(username)) {
            return searchEngine.isValidPassword(username, password);
        } else {
            return false;
        }
    }

    public HashMap<String, Account> getAccountsHashMap() {
        return accountsHashMap;
    }

    public HashMap<String, ArrayList<Order>> getOrdersHashMap() {
        return ordersHashMap;
    }

    public String[] getCategoryAndGenreTypeByID(String ID) {
        String category = searchEngine.getCategoryOfID(ID);
        String genreType = searchEngine.getGenreTypeOfID(ID, category);
        return new String[]{category, genreType};
    }

    public void transferProduct(String newGenreType, Product product) {

        String oldID = product.getID();

        String newID = oldID.substring(0,3) + newGenreType.substring(0,3).toUpperCase() + oldID.substring(6);

        product.setID(newID);
        getInventoryLocationByID(oldID).remove(oldID);
        getInventoryLocationByID(newID).put(newID, product);
    }

    public boolean productExists(String ID) {
        return getInventoryLocationByID(ID).containsKey(ID);
    }

    public void removeProduct(String ID) {
        getInventoryLocationByID(ID).remove(ID);
    }

    public Account getAccountByUsername(String username) {
        return getAccountsHashMap().get(username);
    }


    protected static class DatabaseTools {

        protected static HashMap<String, HashMap<String, HashMap<String, Product>>> initialize3DProductsHashMap() {
            var inventory = new HashMap<String, HashMap<String, HashMap<String, Product>>>();

            ProductCategories.getCategories().values().stream()
                    .forEach(category -> inventory.put(category, new HashMap<>()));

            for (Map.Entry<String, HashMap<Integer, String>> outerEntry: ProductCategories.getGenresAndTypesHashMap().entrySet()) {
                for (Map.Entry<Integer, String> innerEntry : outerEntry.getValue().entrySet() ) {
                    inventory.get(outerEntry.getKey()).put(innerEntry.getValue(), new HashMap<>());
                }
            }

            return inventory;
        }
    }

}
