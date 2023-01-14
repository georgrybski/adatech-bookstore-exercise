package br.com.georg.bookstore.products;

import br.com.georg.bookstore.utilities.HashMapTools;

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
    private static HashMap<Integer,String> genres =
            HashMapTools.initializeCategoryGenresOrTypesHashMap(genreArray);


    public Film(String category, String name, BigDecimal price, String genre, String studio, String directors, String producer, Integer quantity) {
        super(name, price, quantity, category, genre);
        this.studio = studio;
        this.directors = directors;
        this.genre = genres.get(genre);
        this.producer = producer;
    }

    private Film(String name, BigDecimal price, String ID , Integer quantity,
                 String studio, String directors, String genre, String producer){
        super(name, price, ID, quantity);
        this.studio = studio;
        this.directors = directors;
        this.genre = genre;
        this.producer = producer;
    }

    @Override
    public Film copy(Integer quantity) {
        return new Film(this.getName(), this.getPrice(), this.getID(), quantity,
                this.getStudio(), this.getDirectors(), this.getGenre(), this.getProducer());
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
