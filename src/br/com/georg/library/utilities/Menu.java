package br.com.georg.library.utilities;

import br.com.georg.library.products.*;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private static final String[] PRODUCT_CATEGORY_MENU_OPTIONS =
            createCategoryGenreAndTypeMenuOptions(Bookstore.getCategories());

    public static HashMap<String, String[]> GENRE_TYPE_ARRAYS = new HashMap<>(Map.of(
            "Albums", Album.getGenreArray(), "Books", Book.getGenreArray(),
            "Films", Film.getGenreArray(), "Games", Game.getGenresArray(),
            "Toys", Toy.getTypesArray()
    ));



//    private static final String[] ALBUM_GENRE_MENU_OPTIONS =
//            createCategoryGenreAndTypeMenuOptions(Album.getGenres());
//    private static final String[] BOOK_GENRE_MENU_OPTIONS =
//            createCategoryGenreAndTypeMenuOptions(Book.getGenres());
//    private static final String[] FILM_GENRE_MENU_OPTIONS =
//            createCategoryGenreAndTypeMenuOptions(Film.getGenres());
//    private static final String[] GAME_GENRE_MENU_OPTIONS =
//            createCategoryGenreAndTypeMenuOptions(Game.getGenres());
//    private static final String[] TOY_TYPE_MENU_OPTIONS =
//            createCategoryGenreAndTypeMenuOptions(Toy.getTypes());

    public static int getProductCategory() {
        return getInt(PRODUCT_CATEGORY_MENU_OPTIONS);
    }
//
//    public static int getAlbumGenre() {
//        return getInt(ALBUM_GENRE_MENU_OPTIONS);
//    }
//
//    public static int getBookGenre() {
//        return getInt(BOOK_GENRE_MENU_OPTIONS);
//    }
//
//    public static int getFilmGenre() {
//        return getInt(FILM_GENRE_MENU_OPTIONS);
//    }
//
//    public static int getGameGenre() {
//        return getInt(GAME_GENRE_MENU_OPTIONS);
//    }
//
//    public static int getToyType() {
//        return getInt(TOY_TYPE_MENU_OPTIONS);
//    }

    public static int getInt(String[] opcoes) {
        String prompt = "Insert a value between " + 1 + " and " + opcoes.length;
        String msgValorInvalido = "Invalid value! " + prompt;
        return  Input.getIntegerFromMenu(opcoes, 1, opcoes.length, prompt,
                msgValorInvalido, true);
    }

    private static String[] createCategoryGenreAndTypeMenuOptions(HashMap<Integer, String> genres) {
        return genres.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toArray(String[]::new);
    }
}


