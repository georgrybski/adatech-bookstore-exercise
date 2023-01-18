package br.com.georg.bookstore.products;

import br.com.georg.bookstore.utilities.HashMapTools;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;

public class Album extends Product {

    private String author;

    private String genre;

    private String recordLabel;

    private static String[] genreArray = new String[] {
            "Pop", "Hip hop", "Rock", "Rhythm and blues", "Soul", "Reggae",
            "Country", "Funk", "Folk", "Middle Eastern", "Jazz", "Disco",
            "Classical", "Electronic", "Latin American Music", "Blues",
            "New-age", "African music", "Christian music",
            "Islamic music", "Asian music", "Ska"
    };

    private static String[] sortedGenreArray = Arrays.stream(genreArray).sorted().toArray(String[]::new);

    private static HashMap<Integer,String> genres =
            HashMapTools.initializeCategoryGenresOrTypesHashMap(sortedGenreArray);

    public Album(String name, BigDecimal price, String genre,
                 String author, String recordLabel, Integer quantity) {

        super(name, price, quantity, "Albums", genre);
        this.author = author;
        this.genre = genre;
        this.recordLabel = recordLabel;
    }

    private Album(String name, BigDecimal price, String ID, Integer quantity,
                  String author, String genre, String recordLabel) {
        super(name, price, ID, quantity);
        this.author = author;
        this.genre =  genre;
        this.recordLabel = recordLabel;
    }

    @Override
    public Album copy(Integer quantity) {
        return new Album(this.getName(), this.getPrice(), this.getID(),
                quantity, this.getAuthor(), this.getGenre(), this.getRecordLabel());
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public static HashMap<Integer, String> getGenres() {
        return genres;
    }

    public static String[] getGenreArray() {
        return genreArray;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    @Override
    public String getCategory() {
        return "Albums";
    }

    @Override
    public String getGenreType() {return genre;}

}
