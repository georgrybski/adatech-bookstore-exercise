package br.com.georg.bookstore.products.film;

import br.com.georg.bookstore.util.HashMapTools;

import java.util.HashMap;

public class FilmCategories {

    private static final String[] genreArray = new String[] {
            "Action", "Adventure", "Comedy", "Drama",
            "Horror", "Mystery", "Romance", "Sports",
            "Thriller", "Western", "Science Fiction"
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
