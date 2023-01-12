package br.com.georg.library.products;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Book extends Product {

    private String genre;

    private String author;

    private String publisher;

    private static Map<Integer,String> genres = new HashMap(Map.of());

    private static String[] genreMenuOptions =
            genres.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + " - " + entry.getValue())
                    .toArray(String[]::new);

    public Book(String name, BigDecimal price, Integer quantity, Integer genre, String author, String publisher) {
        super(name, price, quantity);
        this.genre = genres.get(genre);
        this.author = author;
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public static Map<Integer, String> getGenres() {
        return genres;
    }

    public static String[] getGenreMenuOptions() {
        return genreMenuOptions;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public static void setGenres(Map<Integer, String> genres) {
        Book.genres = genres;
    }

    public static void setGenreMenuOptions(String[] genreMenuOptions) {
        Book.genreMenuOptions = genreMenuOptions;
    }
}
