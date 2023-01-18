package br.com.georg.bookstore.products.album;

import br.com.georg.bookstore.products.Product;

import java.math.BigDecimal;

public class Album extends Product {

    private String author;

    private String genre;

    private String recordLabel;


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
