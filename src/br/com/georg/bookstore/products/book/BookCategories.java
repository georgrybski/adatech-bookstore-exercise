package br.com.georg.bookstore.products.book;

import br.com.georg.bookstore.utilities.HashMapTools;

import java.util.HashMap;

public class BookCategories {

    private static final String[] genreArray = new String[] {
            "Adventure stories", "Classics", "Crime",
            "Fairy tales, fables, and folk tales",
            "Fantasy", "Historical fiction", "Horror",
            "Humour and satire", "Literary fiction",
            "Mystery", "Poetry", "Plays", "Romance",
            "Science fiction", "Short stories",
            "Thrillers", "War", "Women’s fiction",
            "Young adult", "Autobiography and memoir",
            "Biography", "Essays", "Non-fiction novel",
            "Self-help", "Psychology", "Geology",
            "Chemistry", "Astronomy", "Zoology",
            "Mathematics and logic", "Programming", "Data Science"};

    private static final HashMap<Integer,String> genres =
            HashMapTools.initializeCategoryGenresOrTypesHashMap(genreArray);

    public static HashMap<Integer, String> getGenres() {
        return genres;
    }

    public static String[] getGenreArray() {
        return genreArray;
    }


}
