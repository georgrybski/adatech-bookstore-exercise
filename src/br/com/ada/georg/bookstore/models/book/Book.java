package br.com.ada.georg.bookstore.models.book;

import br.com.ada.georg.bookstore.models.Product;

import java.math.BigDecimal;

public class Book extends Product {

    private String genre;

    private String author;

    private String publisher;

    public Book(String name, BigDecimal price,
                String genre, String author, String publisher, Integer quantity) {
        super(name, price, quantity, "Books", genre);
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
    }

    private Book(String name, BigDecimal price, String ID, Integer quantity,
                 String genre, String author, String publisher) {
        super(name, price, ID, quantity);
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
    }

    @Override
    public Book copy(Integer quantity) {
        return new Book(this.getName(), this.getPrice(), this.getID(), quantity,
                this.getGenre(), this.getAuthor(), this.getPublisher());
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

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String getCategory() {
        return "Books";
    }

    @Override
    public String getGenreType() {return genre;}
}
