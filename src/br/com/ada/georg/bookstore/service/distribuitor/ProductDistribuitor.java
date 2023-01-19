package br.com.ada.georg.bookstore.service.distribuitor;

import br.com.ada.georg.bookstore.products.Product;
import br.com.ada.georg.bookstore.products.album.Album;
import br.com.ada.georg.bookstore.products.game.Game;
import br.com.ada.georg.bookstore.products.book.Book;
import br.com.ada.georg.bookstore.products.film.Film;
import br.com.ada.georg.bookstore.products.toy.Toy;
import br.com.ada.georg.bookstore.service.Bookstore;

import java.math.BigDecimal;

public class ProductDistribuitor {

    public static void populateBookstore(Bookstore bookstore) {
        for (Object[][] productDataMatrix: ProductList.productData) {
            for (Object[] productData : productDataMatrix) {
                String productCategory = (String) productData[0];
                String productGenre = (String) productData[3];
                Product newProduct = null;
                switch (productCategory) {
                    case "Albums" -> {
                        newProduct = new Album(
                                (String) productData[1], (BigDecimal) productData[2],
                                (String) productData[3], (String) productData[4],
                                (String) productData[5], (int) productData[6]
                        );
                    }
                    case "Books" -> {
                        newProduct = new Book(
                                        (String) productData[1], (BigDecimal) productData[2],
                                        (String) productData[3], (String) productData[4],
                                        (String) productData[5], (int) productData[6]
                        );
                    }
                    case "Films" -> {
                        newProduct =
                                new Film(
                                        (String) productData[1], (BigDecimal) productData[2],
                                        (String) productData[3], (String) productData[4],
                                        (String) productData[5], (String) productData[6],
                                        (int) productData[7]
                                );
                    }
                    case "Games" -> {
                        newProduct = new Game(
                                (String) productData[1], (BigDecimal) productData[2],
                                (String) productData[3], (String) productData[4],
                                (String) productData[5], (int) productData[6]
                        );
                    }
                    case "Toys" -> {
                        newProduct = new Toy(
                                (String) productData[1], (BigDecimal) productData[2],
                                (String) productData[3], (int) productData[4]
                        );
                    }
                }
                bookstore.addProduct(productCategory, productGenre, newProduct);
            }
        }
    }
    public static class ProductList {
        public static Object[][][] productData = new Object[][][] {
                albumData, bookData, filmData, gameData, toyData
        };
    }
}
