package br.com.ada.georg.bookstore.util;

import br.com.ada.georg.bookstore.models.products.Product;
import br.com.ada.georg.bookstore.models.products.album.Album;
import br.com.ada.georg.bookstore.models.products.game.Game;
import br.com.ada.georg.bookstore.models.products.book.Book;
import br.com.ada.georg.bookstore.models.products.film.Film;
import br.com.ada.georg.bookstore.controller.bookstore.Bookstore;

import java.util.HashMap;
import java.util.Map;

public class ProductPrinter {

    public static void printAllProducts(Bookstore bookstore) {
        for (Map.Entry<String, HashMap<String, HashMap<String, Product>>> categoryLayer : bookstore.getInventory().entrySet()) {
            printProductsOfACategory(bookstore, categoryLayer.getKey());
        }
    }

    public static void printProduct(Product product, String genreType, String category) {
        Printer.printFrameLine();
        Printer.printIndentedFormattedLine(genreType + " " + category.substring(0, category.length() - 1)+ " | ID: " + product.getID());
        Printer.printIndentedFormattedLine(product.getName() + " | Price: " + product.getPrice() + " USD");

        switch (category) {
            case "Albums" -> {
                Album album = (Album) product;
                Printer.printFormattedMultiLineString("Author: " + album.getAuthor() + " | Record label: " + album.getRecordLabel());
            }
            case "Books" -> {
                Book book = (Book) product;
                Printer.printFormattedMultiLineString("Author: " + book.getAuthor() + " | Published by: " + book.getPublisher());
            }
            case "Films" -> {
                Film film = (Film) product;
                Printer.printFormattedMultiLineString("Directed by: " + film.getDirectors() + " | Produced by: " + film.getProducer());
            }
            case "Games" -> {
                Game game = (Game) product;
                Printer.printFormattedMultiLineString("Studio: " + game.getStudio() + " | Distribuitor: " + game.getDistribuitor());
            }
        }
        Printer.printIndentedFormattedLine(product.getQuantity() > 0 ? "In Stock - Only " + product.getQuantity() + " Left" : "Out of Stock");
        Printer.printFrameLine();
    }

    public static void printProductsOfACategory(Bookstore bookstore, String category) {
        for (Map.Entry<String, HashMap<String, Product>> genreTypeLayer : bookstore.getInventory().get(category).entrySet()) {
            printProductsOfAGenreType(bookstore, category, genreTypeLayer.getKey());
        }
    }

    public static void printProductsOfAGenreType(Bookstore bookstore, String category, String genreType) {
        for (Map.Entry<String, Product> productLayer : bookstore.getInventory().get(category).get(genreType).entrySet()) {
            printProduct(productLayer.getValue(), genreType, category);

        }
    }

}
