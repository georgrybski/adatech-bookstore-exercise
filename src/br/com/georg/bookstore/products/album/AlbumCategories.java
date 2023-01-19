package br.com.georg.bookstore.products.album;

import br.com.georg.bookstore.util.HashMapTools;

import java.util.HashMap;

public class AlbumCategories {

    private static final String[] genreArray = new String[] {
            "Pop", "Hip hop", "Rock", "Rhythm and blues", "Soul", "Reggae",
            "Country", "Funk", "Folk", "Middle Eastern", "Jazz", "Disco",
            "Classical", "Electronic", "Latin American Music", "Blues",
            "New-age", "African music", "Christian music",
            "Islamic music", "Asian music", "Ska"
    };

    private static final HashMap<Integer,String> genres =
            HashMapTools.initializeCategoryGenresOrTypesHashMap(genreArray);

    public static HashMap<Integer, String> getGenres() {
        return genres;
    }

    public static String[] getGenreArray() {
        return genreArray;
    }

}
