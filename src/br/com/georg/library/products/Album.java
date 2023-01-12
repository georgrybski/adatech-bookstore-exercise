package br.com.georg.library.products;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Album extends Product {

    private String author;

    private String genre;

    private String seal;

    private static Map<Integer,String> genres = new HashMap(Map.of());

    private static String[] genreMenuOptions =
            genres.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + " - " + entry.getValue())
                    .toArray(String[]::new);

    public Album(String name, BigDecimal price, Integer quantity, String author, String genre, String seal) {
        super(name, price, quantity);
        this.author = author;
        this.genre = genres.get(genre);
        this.seal = seal;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getSeal() {
        return seal;
    }

    public static Map<Integer, String> getGenres() {
        return genres;
    }

    public static String[] getGenreMenuOptions() {
        return genreMenuOptions;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSeal(String seal) {
        this.seal = seal;
    }

    public static void setGenres(Map<Integer, String> genres) {
        Album.genres = genres;
    }

    public static void setGenreMenuOptions(String[] genreMenuOptions) {
        Album.genreMenuOptions = genreMenuOptions;
    }
}
