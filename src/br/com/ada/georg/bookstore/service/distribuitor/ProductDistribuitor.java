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

        public static Object[][] gameData = new Object[][] {
//              {String name, BigDecimal price, String genre, String distribuitor, String studio, int quantity}
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "First Person Shooter", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "First Person Shooter", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action-Adventure", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action-Adventure", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Survival", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Survival", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Puzzle", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Puzzle", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Role-Playing", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Role-Playing", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "MMO", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "MMO", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sports", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sports", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sandbox", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sandbox", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Educational", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Educational", "Distribuitor", "Studio", 100}
        };


        public static Object[][] toyData = new Object[][] {
//              {String name, BigDecimal price, int quantity, String genre}

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action figure", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action figure", 100},

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Animal", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Animal", 100},

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Car and radio controlled", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Car and radio controlled", 100},

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Construction", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Construction", 100},

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Creative", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Creative", 100},

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Doll", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Doll", 100},

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Educational", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Educational", 100},

                {"Toys", "Lego Porche 911 RSR - 42096", BigDecimal.valueOf(169.99), "Electronic", 100},
                {"Toys", "Lego Hogwarts Castle - 71043 ", BigDecimal.valueOf(469.99), "Electronic", 100},

                {"Toys", "Perpetual Motion Desktop Gadget", BigDecimal.valueOf(35.36), "Executive", 100},
                {"Toys", "Golden Winged Fidget Spinner", BigDecimal.valueOf(57.99), "Executive", 100},

                {"Toys", "Theo Klein Miele Petit Gourmet Play Kitchen", BigDecimal.valueOf(89.99), "Food-related", 100},
                {"Toys", "So Slime DIY Slimelicious Factory", BigDecimal.valueOf(31.99), "Food-related", 100},

                {"Toys", "CubicFun Titanic 3D", BigDecimal.valueOf(36.99), "Puzzle", 100},
                {"Toys", "Starry Night Vincent Van Gogh Jigsaw - 5070cm", BigDecimal.valueOf(12.99), "Puzzle", 100},

                {"Toys", "KidzLab Anti-Gravity Maglev", BigDecimal.valueOf(43.99), "Science and optical", 100},
                {"Toys", "NATIONAL GEOGRAPHIC Break Open 10 Premium Geodes", BigDecimal.valueOf(34.99), "Science and optical", 100},

                {"Toys", "Baby Einstein Take Along Tunes", BigDecimal.valueOf(9.99), "Sound and music", 100},
                {"Toys", "Hape Mighty Echo Microphone", BigDecimal.valueOf(11.99), "Sound and music", 100}
        };

        public static Object[][][] productData = new Object[][][] {
                albumData, bookData, filmData, gameData, toyData
        };
    }
}
