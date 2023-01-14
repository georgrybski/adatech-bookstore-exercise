package br.com.georg.bookstore.database;

import br.com.georg.bookstore.products.Product;

import java.util.HashMap;
import java.util.Map;

public class IDSearcher {

    private static HashMap<String, String> IDCategorySearchHashMap = initializeIDCategorySearchHashmap();

    private static HashMap<String, HashMap<String, String>> IDGenreTypeHashMap = initializeIDGenreTypeSearchHashmap();

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

    public static HashMap<String, String> getIDCategorySearchHashMap() {
        return IDCategorySearchHashMap;
    }

    public static HashMap<String, HashMap<String, String>> getIDGenreTypeHashMap() {
        return IDGenreTypeHashMap;
    }

    public static HashMap<String, Product> getHashMapWhereIDIsLocated(String category, String genreType) {
        return Database.getProducts3DHashMap().get(category).get(genreType);
    }

    public static Product getProductByID(String ID) {
        String categoryCode = ID.substring(0, 3);
        String genreTypeCode = ID.substring(3,6);
        String categoryKey = IDCategorySearchHashMap.get(categoryCode);
        String genreTypeKey = IDGenreTypeHashMap.get(categoryKey).get(genreTypeCode);
        return getHashMapWhereIDIsLocated(categoryKey, genreTypeKey).get(ID);
    }


}
