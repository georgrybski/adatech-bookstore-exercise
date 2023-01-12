package br.com.georg.library.utilities;

import br.com.georg.library.products.Album;
import br.com.georg.library.products.Book;

import java.util.HashMap;

public class Menu {

    private static final String[] ALBUM_GENRE_MENU_OPTIONS = createGenreAndTypeMenuOptions(Album.getGenres());
    private static final String[] BOOK_GENRE_MENU_OPTIONS = createGenreAndTypeMenuOptions(Book.getGenres());




    private static String[] createGenreAndTypeMenuOptions(HashMap<Integer, String> genres) {
        return genres.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toArray(String[]::new);
    }


}
