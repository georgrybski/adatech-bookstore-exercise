package br.com.georg.bookstore.products.film;

import br.com.georg.bookstore.products.Product;
import br.com.georg.bookstore.utilities.HashMapTools;

import java.math.BigDecimal;
import java.util.HashMap;

public class Film extends Product {

    private String studio;

    private String directors;

    private String genre;

    private String producer;


    public Film(String name, BigDecimal price, String genre, String studio, String directors, String producer, Integer quantity) {
        super(name, price, quantity, "Films", genre);
        this.studio = studio;
        this.directors = directors;
        this.genre = genre;
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

    @Override
    public String getCategory() {
        return "Films";
    }

    @Override
    public String getGenreType() {return genre;}
}
