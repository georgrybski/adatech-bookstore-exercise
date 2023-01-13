package br.com.georg.library.utilities;

import br.com.georg.library.products.*;

import java.util.HashMap;

public class Menu {

    private static final String[] PRODUCT_CATEGORY_MENU_OPTIONS = createCategoryGenreAndTypeMenuOptions(Bookstore.getCategories());
    private static final String[] ALBUM_GENRE_MENU_OPTIONS = createCategoryGenreAndTypeMenuOptions(Album.getGenres());
    private static final String[] BOOK_GENRE_MENU_OPTIONS = createCategoryGenreAndTypeMenuOptions(Book.getGenres());
    private static final String[] FILM_GENRE_MENU_OPTIONS = createCategoryGenreAndTypeMenuOptions(Film.getGenres());
    private static final String[] GAME_GENRE_MENU_OPTIONS = createCategoryGenreAndTypeMenuOptions(Game.getGenres());
    private static final String[] TOY_TYPE_MENU_OPTIONS = createCategoryGenreAndTypeMenuOptions(Toy.getTypes());


    private static String[] createCategoryGenreAndTypeMenuOptions(HashMap<Integer, String> genres) {
        return genres.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toArray(String[]::new);
    }


}
