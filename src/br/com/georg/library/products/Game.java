package br.com.georg.library.products;

import br.com.georg.library.utilities.HashMapTools;

import java.math.BigDecimal;
import java.util.HashMap;

public class Game extends Product {

    private String distribuitor;

    private String genre;

    private String studio;

    private static String[] genresArray = new String[] {
            "First Person Shooter", "Action-Adventure",
            "Survival", "Puzzle", "Role-Playing Games",
            "MMO", "Sports", "Sandbox", "Educational"
    };
    private static HashMap<Integer,String> genres = HashMapTools.initializeGenresOrTypesHashMap(genresArray);


    public Game(String name, BigDecimal price, Integer quantity, String distribuitor, Integer genre, String studio) {
        super(name, price, quantity);
        this.distribuitor = distribuitor;
        this.genre = genres.get(genre);
        this.studio = studio;
    }

    public String getDistribuitor() {
        return distribuitor;
    }

    public String getGenre() {
        return genre;
    }

    public String getStudio() {
        return studio;
    }

    public static HashMap<Integer, String> getGenres() {
        return genres;
    }

    public static String[] getGenresArray() {
        return genresArray;
    }

    public void setDistribuitor(String distribuitor) {
        this.distribuitor = distribuitor;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public static void setGenres(HashMap<Integer, String> genres) {
        Game.genres = genres;
    }

    public static void setGenresArray(String[] genresArray) {
        Game.genresArray = genresArray;
    }
}
