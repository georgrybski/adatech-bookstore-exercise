package br.com.ada.georg.bookstore.view.menu;

import br.com.ada.georg.bookstore.models.products.album.AlbumCategories;
import br.com.ada.georg.bookstore.models.products.toy.ToyCategories;
import br.com.ada.georg.bookstore.models.products.book.BookCategories;
import br.com.ada.georg.bookstore.models.products.film.FilmCategories;
import br.com.ada.georg.bookstore.models.products.game.GameCategories;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MenuTools {

    public static String[] createCategoryGenreAndTypeMenuOptions(HashMap<Integer, String> genres) {
        return genres.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toArray(String[]::new);
    }

    public static HashMap<String, String[]> GENRE_TYPE_ARRAYS = new HashMap<>(Map.of(
            "Albums", AlbumCategories.getGenreArray(), "Books", BookCategories.getGenreArray(),
            "Films", FilmCategories.getGenreArray(), "Games", GameCategories.getGenreArray(),
            "Toys", ToyCategories.getTypesArray()
    ));

    static String[] getGenreTypeArray(String category) {
        int[] i = {1};
        return Arrays.stream(GENRE_TYPE_ARRAYS.get(category))
                .map(option -> i[0]++ + " - " + option).toArray(String[]::new);
    }

    public static HashMap<String, String[]> getGenreTypeArrays() {
        return GENRE_TYPE_ARRAYS;
    }
}
