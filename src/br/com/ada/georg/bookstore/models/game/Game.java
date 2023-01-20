package br.com.ada.georg.bookstore.models.game;

import br.com.ada.georg.bookstore.models.Product;

import java.math.BigDecimal;

public class Game extends Product {

    private String distribuitor;

    private String genre;

    private String studio;



    public Game(String name, BigDecimal price, String genre, String distribuitor, String studio, Integer quantity) {
        super(name, price, quantity, "Games", genre);
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

    @Override
    public String getGenreType() {return genre;}
}
