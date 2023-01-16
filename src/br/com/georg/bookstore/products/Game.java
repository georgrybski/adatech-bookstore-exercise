package br.com.georg.bookstore.products;

import br.com.georg.bookstore.utilities.HashMapTools;

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
    private static HashMap<Integer,String> genres =
            HashMapTools.initializeCategoryGenresOrTypesHashMap(genresArray);


    public Game(String category, String name, BigDecimal price, String genre, String distribuitor, String studio, Integer quantity) {
        super(name, price, quantity, category, genre);
        this.distribuitor = distribuitor;
        this.genre = genre;
        this.studio = studio;
    }

    private Game(String name, BigDecimal price, String ID, Integer quantity, String distribuitor, String genre, String studio) {
        super(name, price, ID, quantity);
        this.distribuitor = distribuitor;
        this.genre = genre;
        this.studio = studio;
    }

    @Override
    public Game copy(Integer quantity) {
        return new Game(this.getName(), this.getPrice(), this.getID(), quantity,
                this.getDistribuitor(), this.getGenre(), this.getStudio());
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

    @Override
    public String getCategory() {
        return "Games";
    }

}
