package br.com.ada.georg.bookstore.view.menu;

import br.com.ada.georg.bookstore.util.ProductPrinter;
import br.com.ada.georg.bookstore.models.products.Product;
import br.com.ada.georg.bookstore.models.products.album.Album;
import br.com.ada.georg.bookstore.models.products.book.Book;
import br.com.ada.georg.bookstore.models.products.film.Film;
import br.com.ada.georg.bookstore.models.products.game.Game;
import br.com.ada.georg.bookstore.models.products.toy.Toy;
import br.com.ada.georg.bookstore.controller.bookstore.Bookstore;
import br.com.ada.georg.bookstore.view.input.ProductInput;
import br.com.ada.georg.bookstore.util.Printer;

public class ProductEditorMenu {

    public static Product editAlbum(Album album, Bookstore bookstore) {
        boolean changesInProgress = true;
        while (changesInProgress) {
            ProductPrinter.printProduct(album, album.getGenre(), "Albums");
            switch (Menu.getIntFrom(new String[]{"1 - Change name", "2 - Change price",
                    "3 - Change stock", "4 - Change author", "5 - Change genre",
                    "6 - Change record label", "7 - Finish changes"})) {

                case 1 -> album.setName(ProductInput.getProductName("Albums"));

                case 2 -> album.setPrice(ProductInput.getProductPrice("Albums"));

                case 3 -> album.setQuantity(ProductInput.getProductQuantity(album.getQuantity()));

                case 4 -> album.setAuthor(ProductInput.getProductAuthor("Albums"));

                case 5 -> {
                    String oldGenre = album.getGenre();
                    int genreTypeNumber = Menu.getIntFrom(MenuTools.getGenreTypeArray("Albums"));
                    String newGenreType = MenuTools.getGenreTypeArrays().get("Albums")[genreTypeNumber - 1];
                    if (newGenreType.equals(oldGenre)) {
                        Printer.printFormattedMessage(album.getName() + " is already registered as a " + newGenreType + " album");
                    } else {
                        album.setGenre(newGenreType);
                        bookstore.getDatabase().transferProduct(newGenreType, album);
                        Printer.printFormattedMessage("This product's ID has been changed to: " + album.getID());
                    }
                }

                case 6 -> album.setRecordLabel(ProductInput.getRecordLabel());

                case 7 -> changesInProgress = false;
            }
        }
        return album;
    }

    public static Product editBook(Book book, Bookstore bookstore) {
        boolean changesInProgress = true;
        while (changesInProgress) {

            ProductPrinter.printProduct(book, book.getGenre(), "Books");

            switch (Menu.getIntFrom(new String[]{"1 - Change name", "2 - Change price",
                    "3 - Change stock", "4 - Change author", "5 - Change genre",
                    "6 - Change publisher", "7 - Finish changes"})) {

                case 1 -> book.setName(ProductInput.getProductName("Books"));

                case 2 -> book.setPrice(ProductInput.getProductPrice("Books"));

                case 3 -> book.setQuantity(ProductInput.getProductQuantity(book.getQuantity()));

                case 4 -> book.setAuthor(ProductInput.getProductAuthor("Books"));

                case 5 -> {
                    String oldGenre = book.getGenre();
                    int genreTypeNumber = Menu.getIntFrom(MenuTools.getGenreTypeArray("Books"));
                    String newGenreType = MenuTools.getGenreTypeArrays().get("Books")[genreTypeNumber - 1];
                    if (newGenreType.equals(oldGenre)) {
                        Printer.printFormattedMessage(book.getName() + " is already registered as a " + newGenreType + " book");
                    } else {
                        book.setGenre(newGenreType);
                        bookstore.getDatabase().transferProduct(newGenreType, book);
                        Printer.printFormattedMessage("This product's ID has been changed to: " + book.getID());
                    }
                }

                case 6 -> book.setPublisher(ProductInput.getPublisher());

                case 7 -> changesInProgress = false;
            }
        }
        return book;
    }

    public static Product editFilm(Film film, Bookstore bookstore) {
        boolean changesInProgress = true;
        while (changesInProgress) {

            ProductPrinter.printProduct(film, film.getGenre(), "Films");

            switch (Menu.getIntFrom(new String[]{"1 - Change name", "2 - Change price",
                    "3 - Change stock", "4 - Change studio", "5 - Change director",
                    "6 - Change genre", "7 - Change producer", "8 - Finish changes"})) {

                case 1 -> film.setName(ProductInput.getProductName("Films"));

                case 2 -> film.setPrice(ProductInput.getProductPrice("Films"));

                case 3 -> film.setQuantity(ProductInput.getProductQuantity(film.getQuantity()));

                case 4 -> film.setStudio(ProductInput.getStudio("Films"));

                case 5 -> film.setDirectors(ProductInput.getDirector());

                case 6 -> {
                    String oldGenre = film.getGenre();
                    int genreTypeNumber = Menu.getIntFrom(MenuTools.getGenreTypeArray("Films"));
                    String newGenreType = MenuTools.getGenreTypeArrays().get("Films")[genreTypeNumber - 1];
                    if (newGenreType.equals(oldGenre)) {
                        Printer.printFormattedMessage(film.getName() + " is already registered as a " + newGenreType + " film");
                    } else {
                        film.setGenre(newGenreType);
                        bookstore.getDatabase().transferProduct(newGenreType, film);
                        Printer.printFormattedMessage("This product's ID has been changed to: " + film.getID());
                    }
                }

                case 7 -> film.setProducer(ProductInput.getProducer());

                case 8 -> changesInProgress = false;
            }
        }
        return film;
    }

    public static Product editGame(Game game, Bookstore bookstore) {
        boolean changesInProgress = true;
        while (changesInProgress) {

            ProductPrinter.printProduct(game, game.getGenre(), "Games");

            switch (Menu.getIntFrom(new String[]{"1 - Change name", "2 - Change price",
                    "3 - Change stock", "4 - Change distribuitor", "5 - Change genre",
                    "6 - Change studio", "7 - Finish changes"})) {

                case 1 -> game.setName(ProductInput.getProductName("Games"));

                case 2 -> game.setPrice(ProductInput.getProductPrice("Games"));

                case 3 -> game.setQuantity(ProductInput.getProductQuantity(game.getQuantity()));

                case 4 -> game.setDistribuitor(ProductInput.getDistribuitor());

                case 5 -> {
                    String oldGenre = game.getGenre();
                    int genreTypeNumber = Menu.getIntFrom(MenuTools.getGenreTypeArray("Games"));
                    String newGenreType = MenuTools.getGenreTypeArrays().get("Games")[genreTypeNumber - 1];
                    if (newGenreType.equals(oldGenre)) {
                        Printer.printFormattedMessage(game.getName() + " is already registered as a " + newGenreType + " game");
                    } else {
                        game.setGenre(newGenreType);
                        bookstore.getDatabase().transferProduct(newGenreType, game);
                        Printer.printFormattedMessage("This product's ID has been changed to: " + game.getID());
                    }
                }

                case 6 -> game.setStudio(ProductInput.getStudio("Games"));

                case 7 -> changesInProgress = false;
            }
        }
        return game;
    }

    public static Product editToy(Toy toy, Bookstore bookstore) {
        boolean changesInProgress = true;
        while (changesInProgress) {

            ProductPrinter.printProduct(toy, toy.getType(), "Toys");

            switch (Menu.getIntFrom(new String[]{"1 - Change name", "2 - Change price",
                    "3 - Change stock", "4 - Change distribuitor",
                    "5 - Change type", "6 - Finish changes"})) {

                case 1 -> toy.setName(ProductInput.getProductName("Toys"));

                case 2 -> toy.setPrice(ProductInput.getProductPrice("Toys"));

                case 3 -> toy.setQuantity(ProductInput.getProductQuantity(toy.getQuantity()));

                case 5 -> {
                    String oldGenre = toy.getType();
                    int genreTypeNumber = Menu.getIntFrom(MenuTools.getGenreTypeArray("Toys"));
                    String newGenreType = MenuTools.getGenreTypeArrays().get("Toys")[genreTypeNumber - 1];
                    if (newGenreType.equals(oldGenre)) {
                        Printer.printFormattedMessage(toy.getName() + " is already registered as a " + newGenreType + " toy");
                    } else {
                        toy.setType(newGenreType);
                        bookstore.getDatabase().transferProduct(newGenreType, toy);
                        Printer.printFormattedMessage("This product's ID has been changed to: " + toy.getID());
                    }
                }

                case 6 -> changesInProgress = false;
            }
        }
        return toy;
    }
}
