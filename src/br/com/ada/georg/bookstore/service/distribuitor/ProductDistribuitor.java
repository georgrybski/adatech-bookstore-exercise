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
        public static Object[][] bookData = new Object[][] {
//              {String name, BigDecimal price, String genre, String author, String publisher, int quantity}

                {"Books", "Journey to the Center of the Earth", BigDecimal.valueOf(169.99), "Adventure stories", "Jules Verne", "Publisher", 100},
                {"Books", "Neuromancer", BigDecimal.valueOf(30.87), "Adventure stories", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Classics", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Classics", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Crime", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Crime", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Fairy tales, fables, and folk tales", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Fairy tales, fables, and folk tales", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Fantasy", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Fantasy", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Historical fiction", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Historical fiction", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Horror", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Horror", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Humour and satire", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Humour and satire", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mystery", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mystery", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Poetry", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Poetry", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Plays", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Plays", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Romance", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Romance", "Author", "Publisher", 100},

                {"Books", "Neuromancer", BigDecimal.valueOf(30.87), "Science fiction", "William Gibson", "Ace", 100},
                {"Books", "Children of Time", BigDecimal.valueOf(12.59), "Science fiction", "Adrian Tchaikovsky", "Tor UK", 100},

                {"Books", "The World's Greatest Short Stories", BigDecimal.valueOf(5.99), "Short stories", "James Daley", "Dover Publications", 100},
                {"Books", "Fifty Great Short Stories", BigDecimal.valueOf(12.88), "Short stories", "Milton Crane", "Bantam Classics", 100},

                {"Books", "The Institute", BigDecimal.valueOf(13.79), "Thrillers", "Stephen King", "Scribner", 100},
                {"Books", "Axiom's End: Noumena Series 01", BigDecimal.valueOf(12.18), "Thrillers", "Lindsay Ellis", "St. Martin's Press", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "War", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "War", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Women’s fiction", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Women’s fiction", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Young adult", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Young adult", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Autobiography and memoir", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Autobiography and memoir", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Biography", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Biography", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Essays", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Essays", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Non-fiction novel", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Non-fiction novel", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Self-help", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Self-help", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Psychology", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Psychology", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Geology", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Geology", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Chemistry", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Chemistry", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Astronomy", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Astronomy", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Zoology", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Zoology", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mathematics and logic", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mathematics and logic", "Author", "Publisher", 100},

                {"Books", "The Pragmatic Programmer: Your Journey To Mastery", BigDecimal.valueOf(32.68), "Programming", "David Thomas & Andrew Hunt", "Addison-Wesley Professional", 100},
                {"Books", "Clean Code: A Handbook of Agile Software Craftsmanship", BigDecimal.valueOf(40.99), "Programming", "Robert Cecil Martin", "Pearson Education", 100},

                {"Books", "Data Science from Scratch: First Principles with Python", BigDecimal.valueOf(47.94), "Data Science", "Joel Grus", "O'Reilly Media, Inc.", 100},
                {"Books", "Designing Machine Learning Systems", BigDecimal.valueOf(28.25), "Data Science", "Chip Huyen", "O'Reilly Media, Inc.", 100},

        };

        public static Object[][] filmData = new Object[][] {
//              {String name, BigDecimal price, String genre, String studio, String director, String producer, int quantity}
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Adventure", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Adventure", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Comedy", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Comedy", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Drama", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Drama", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Horror", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Horror", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mystery", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mystery", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Romance", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Romance", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sports", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sports", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Thriller", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Thriller", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Western", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Western", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Science Fiction", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Science Fiction", "Studio", "Director", "Producer", 100},
        };

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
