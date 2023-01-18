package br.com.georg.bookstore.products;

import br.com.georg.bookstore.products.album.AlbumCategories;
import br.com.georg.bookstore.products.book.BookCategories;
import br.com.georg.bookstore.products.film.FilmCategories;
import br.com.georg.bookstore.products.game.GameCategories;
import br.com.georg.bookstore.products.toy.ToyCategories;
import br.com.georg.bookstore.utilities.HashMapTools;

import java.util.HashMap;
import java.util.Map;

public class ProductCategories {

    private static final String[] categoriesArray =
            new String[]{"Albums", "Books", "Films", "Games", "Toys"};

    private static final HashMap<Integer, String> categories =
            HashMapTools.initializeCategoryGenresOrTypesHashMap(categoriesArray);

    private static final HashMap<String, HashMap<Integer, String>> genresAndTypesHashMap =
            new HashMap<>(Map.of(
                    "Albums", AlbumCategories.getGenres(), "Books", BookCategories.getGenres(),
                    "Films", FilmCategories.getGenres(), "Games", GameCategories.getGenres(),
                    "Toys", ToyCategories.getTypes()
            ));

    public static HashMap<String, HashMap<Integer, String>> getGenresAndTypesHashMap() {
        return genresAndTypesHashMap;
    }

    public static HashMap<Integer, String> getCategories() {
        return categories;
    }

    public static String[] getCategoriesArray() {
        return categoriesArray;
    }
}
