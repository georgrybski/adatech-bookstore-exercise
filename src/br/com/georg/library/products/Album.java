package br.com.georg.library.products;

import br.com.georg.library.utilities.HashMapTools;

import java.math.BigDecimal;
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

    private static HashMap<Integer,String> genres = HashMapTools.initializeCategoryGenresOrTypesHashMap(genreArray);

    public Album(String name, BigDecimal price, Integer quantity, String author, Integer genre, String seal) {
        super(name, price, quantity);
        this.author = author;
        this.genre = genres.get(genre);
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
