package br.com.georg.library.products;

import br.com.georg.library.utilities.HashMapTools;

import java.math.BigDecimal;
import java.util.HashMap;

public class Film extends Product {

    private String studio;

    private String directors;

    private String genre;

    private String producer;

    private static String[] genreArray = new String[] {
            "Action", "Adventure", "Comedy", "Drama",
            "Horror", "Mystery", "Romance", "Sports",
            "Thriller", "Western", "Science Fiction"
    };
    private static HashMap<Integer,String> genres = HashMapTools.initializeGenresOrTypesHashMap(genreArray);


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

    public static HashMap<Integer, String> getGenres() {
        return genres;
    }

    public static String[] getGenreArray() {
        return genreArray;
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

    public static void setGenres(HashMap<Integer, String> genres) {
        Film.genres = genres;
    }

    public static void setGenreArray(String[] genreArray) {
        Film.genreArray = genreArray;
    }
}
