package br.com.georg.library.products;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Game extends Product {

    private String distribuitor;

    private String genre;

    private String studio;

    private static Map<Integer,String> genres = new HashMap(Map.of());

    private static String[] genreMenuOptions =
            genres.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + " - " + entry.getValue())
                    .toArray(String[]::new);

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

    public static Map<Integer, String> getGenres() {
        return genres;
    }

    public static String[] getGenreMenuOptions() {
        return genreMenuOptions;
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

    public static void setGenres(Map<Integer, String> genres) {
        Game.genres = genres;
    }

    public static void setGenreMenuOptions(String[] genreMenuOptions) {
        Game.genreMenuOptions = genreMenuOptions;
    }
}
