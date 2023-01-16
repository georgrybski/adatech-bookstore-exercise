package br.com.georg.bookstore.database;

import br.com.georg.bookstore.products.Product;
import br.com.georg.bookstore.utilities.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchEngine {

    private Database database;

    private static HashMap<String, String> IDCategorySearchHashMap;

    private static HashMap<String, HashMap<String, String>> IDGenreTypeHashMap;

    protected SearchEngine(Database database) {
        this.database = database;
        IDCategorySearchHashMap = SearchEngineInitializer.initializeIDCategorySearchHashmap();
        IDGenreTypeHashMap = SearchEngineInitializer.initializeIDGenreTypeSearchHashmap();
    }

    public HashMap<String, Product> getHashMapWhereIDIsLocated(String category, String genreType) {
        return database.getProducts3DHashMap().get(category).get(genreType);
    }

    protected Product getProductByID(String ID) {
        return getHashMapByID(ID).getOrDefault(ID, null);
    }

    protected HashMap<String, Product> getHashMapByID(String ID) {
        String categoryCode = ID.substring(0, 3);
        String genreTypeCode = ID.substring(3,6);
        String categoryKey = IDCategorySearchHashMap.get(categoryCode);
        String genreTypeKey = IDGenreTypeHashMap.get(categoryKey).get(genreTypeCode);
        return getHashMapWhereIDIsLocated(categoryKey, genreTypeKey);
    }

    protected String getCategoryOfID(String ID) {
        String categoryCode = ID.substring(0, 3);
        return IDCategorySearchHashMap.get(categoryCode);
    }
    protected String getGenreTypeOfID(String ID, String category) {
        String genreTypeKey = ID.substring(3, 6);
        return IDGenreTypeHashMap.get(category).get(genreTypeKey);
    }

    protected boolean usernameExists(String username) {
        return database.getAccountsHashMap().containsKey(username);
    }

    protected boolean isValidPassword(String username, String password) {
        return database.getAccountsHashMap().get(username).getPassword().equals(password);
    }

    protected ArrayList<Order> getOrderArrayListWithUsername(String username) {
        return database.getOrdersHashMap().get(username);
    }

    private static class SearchEngineInitializer {

        private static HashMap<String, HashMap<String, String>> initializeIDGenreTypeSearchHashmap() {
            var IDGenreTypeHashMap = new HashMap<String, HashMap<String, String>>();

            Product.getCategories().values().stream()
                    .forEach(category -> IDGenreTypeHashMap.put(category, new HashMap<>()));

            for (Map.Entry<String, HashMap<Integer, String>> outerEntry: Product.getGenresAndTypesHashMap().entrySet()) {
                for (Map.Entry<Integer, String> innerEntry : outerEntry.getValue().entrySet() ) {
                    IDGenreTypeHashMap.get(outerEntry.getKey())
                            .put(innerEntry.getValue().substring(0,3).toUpperCase(), innerEntry.getValue());
                }
            }
            return IDGenreTypeHashMap;
        }

        private static HashMap<String, String> initializeIDCategorySearchHashmap() {
            var IDCategorySearchHashMap = new HashMap<String, String>();

            Product.getCategories().values().stream()
                    .forEach(category -> IDCategorySearchHashMap.put(category.substring(0,3).toUpperCase(), category));

            return IDCategorySearchHashMap;
        }
    }

}
