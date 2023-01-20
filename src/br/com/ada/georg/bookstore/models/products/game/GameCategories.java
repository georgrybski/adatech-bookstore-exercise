package br.com.ada.georg.bookstore.models.products.game;

import br.com.ada.georg.bookstore.controller.HashMapTools;

import java.util.HashMap;

public class GameCategories {

    private static final String[] genreArray = new String[] {
            "First Person Shooter", "Action-Adventure",
            "Survival", "Puzzle", "Role-Playing",
            "MMO", "Sports", "Sandbox", "Educational"
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
