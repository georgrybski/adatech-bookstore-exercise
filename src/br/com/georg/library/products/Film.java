package br.com.georg.library.products;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Film extends Product {

    private String studio;

    private String directors;

    private String genre;

    private String producer;

    private static Map<Integer,String> genres = new HashMap(Map.of());

    private static String[] genreMenuOptions =
            genres.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + " - " + entry.getValue())
                    .toArray(String[]::new);

    public Film(String name, BigDecimal price, Integer quantity, String studio, String directors, Integer genre, String producer) {
        super(name, price, quantity);
        this.studio = studio;
        this.directors = directors;
        this.genre = genres.get(genre);
        this.producer = producer;
    }

    public String getStudio() {
        return studio;
    }

    public String getDirectors() {
        return directors;
    }

    public String getGenre() {
        return genre;
    }

    public String getProducer() {
        return producer;
    }

    public static Map<Integer, String> getGenres() {
        return genres;
    }

    public static String[] getGenreMenuOptions() {
        return genreMenuOptions;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public static void setGenres(Map<Integer, String> genres) {
        Film.genres = genres;
    }

    public static void setGenreMenuOptions(String[] genreMenuOptions) {
        Film.genreMenuOptions = genreMenuOptions;
    }
}
