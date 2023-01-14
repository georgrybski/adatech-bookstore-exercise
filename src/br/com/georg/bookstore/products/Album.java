package br.com.georg.bookstore.products;

import br.com.georg.bookstore.utilities.HashMapTools;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;

public class Album extends Product {

    private String author;

    private String genre;

    private String seal;

    private static String[] genreArray = new String[] {
            "Pop", "Hip hop", "Rock", "Rhythm and blues", "Soul", "Reggae",
            "Country", "Funk", "Folk", "Middle Eastern", "Jazz", "Disco",
            "Classical", "Electronic", "Latin American Music", "Blues",
            "New-age", "Vocal music", "African music", "Christian music",
            "Asian music", "Ska", "Traditional music", "Independent music"
    };

    private static String[] sortedGenreArray = Arrays.stream(genreArray).sorted().toArray(String[]::new);

    private static HashMap<Integer,String> genres = HashMapTools.initializeCategoryGenresOrTypesHashMap(sortedGenreArray);

    public Album(String category, String name, BigDecimal price, String genre, String author, String seal, Integer quantity) {
        super(name, price, quantity, category, genre);
        this.author = author;
        this.genre = genre;
        this.seal = seal;
    }

    private Album(String name, BigDecimal price, String ID, Integer quantity,
                  String author, String genre, String seal) {
        super(name, price, ID, quantity);
        this.author = author;
        this.genre =  genre;
        this.seal = seal;
    }

    @Override
    public Album copy(Integer quantity) {
        return new Album(this.getName(), this.getPrice(), this.getID(),
                quantity, this.getAuthor(), this.getGenre(), this.getSeal());
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

    public static HashMap<Integer, String> getGenres() {
        return genres;
    }

    public static String[] getSortedGenreArray() {
        return sortedGenreArray;
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

    public void setSeal(String seal) {
        this.seal = seal;
    }

    public static void setGenres(HashMap<Integer, String> genres) {
        Album.genres = genres;
    }

    public static void setGenreArray(String[] genreArray) {
        Album.genreArray = genreArray;
    }
}
