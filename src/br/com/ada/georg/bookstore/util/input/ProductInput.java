package br.com.ada.georg.bookstore.util.input;

import br.com.ada.georg.bookstore.util.menu.ProductEditorMenu;
import br.com.ada.georg.bookstore.products.Product;
import br.com.ada.georg.bookstore.products.album.Album;
import br.com.ada.georg.bookstore.products.book.Book;
import br.com.ada.georg.bookstore.products.film.Film;
import br.com.ada.georg.bookstore.products.game.Game;
import br.com.ada.georg.bookstore.products.toy.Toy;
import br.com.ada.georg.bookstore.service.Account;
import br.com.ada.georg.bookstore.service.Bookstore;
import br.com.ada.georg.bookstore.util.printer.Printer;

import java.math.BigDecimal;

public class ProductInput {

    static boolean isIDValid(String ID) {
        return ID.matches("^[a-zA-Z]{6}.*[a-zA-Z0-9]{4,}$");
    }

    public static void addProductToCartUsingID(Bookstore bookstore, Account loggedAccount) {
        String ID = Input.getString("Insert the ID of the product you want to add to your cart");
        String message = "The ID inserted is invalid";
        if (isIDValid(ID)) {
            Product product = bookstore.getDatabase().getProductByID(ID);
            if (product != null) {
                if (product.getQuantity() > 0) {
                    int quantity = Input.getInteger(
                            1,product.getQuantity(),
                            "Insert how many '" + product.getName() + " " + product.getGenreType() + " " + product.getCategory()
                                    + "' you would like to add to your shopping cart",
                            "Invalid value! Insert a number of " + product.getCategory()
                                    + " between 1 and " + product.getQuantity() + " to add to your cart");
                    message = loggedAccount.addToCart(product, quantity);
                }
            }
        }
        Printer.printFormattedMessage(message);
    }

    public static void removeProductUsingID(Bookstore bookstore) {
        String ID = Input.getString("Insert the ID of the product you wanto to remove");
        if (isIDValid(ID)) {
            if (bookstore.removeProduct(ID)) {
                Printer.printFormattedMessage("The product has been removed");
            }
        } else {
            Printer.printFormattedMessage("The ID inserted is invalid");
        }
    }

    public static void modifyExistingProduct(Bookstore bookstore) {
        String ID = Input.getString("Insert the ID of the product you want to modify");
        if (isIDValid(ID)) {
            Product rawProduct = bookstore.getDatabase().getProductByID(ID);
            if (rawProduct != null) {
                Product oldProduct = rawProduct.copy(rawProduct.getQuantity());
                Product newProduct = null;
                String[] categoryAndGenreType = bookstore.getDatabase().getCategoryAndGenreTypeByID(ID);
                switch (categoryAndGenreType[0]) {
                    case "Albums" -> {
                        Album product = (Album) rawProduct;
                        newProduct = ProductEditorMenu.editAlbum(product, bookstore);
                    }

                    case "Books" -> {
                        Book product = (Book) rawProduct;
                        newProduct = ProductEditorMenu.editBook(product, bookstore);
                    }

                    case "Films" -> {
                        Film product = (Film) rawProduct;
                        newProduct = ProductEditorMenu.editFilm(product, bookstore);
                    }

                    case "Games" -> {
                        Game product = (Game) rawProduct;
                        newProduct = ProductEditorMenu.editGame(product, bookstore);
                    }

                    case "Toys" -> {
                        Toy product = (Toy) rawProduct;
                        newProduct = ProductEditorMenu.editToy(product, bookstore);
                    }
                }
                bookstore.getDashboard().recieveProductUpdateData(oldProduct, newProduct);
            }
        }
        Printer.printFormattedMessage("The ID inserted is invalid");
    }

    public static BigDecimal getProductPrice(String category) {
        return Input.getBigDecimal(
                "Insert the " + category.substring(0,category.length()-1).toLowerCase() + "'s price ($USD)",
                "Invalid input! Please insert a positive value, separeted by a dot(.) if necessary.",
                true
        );
    }

    public static String getProductField(String category, String field) {
        return Input.getString("Insert the " +
                category.substring(0,category.length()-1).toLowerCase()
                + "'s " + field);
    }

    public static Integer getProductQuantity(Integer currentQuantity) {
        return Input.getInteger(1, Integer.MAX_VALUE,
                "Insert the number of items to be added to stock",
                "Invalid Input. Please insert a integer greater than 0") + currentQuantity;
    }

    public static String getProductStudio(String category, String field) {
        return Input.getString("Insert the " + category.substring(0,category.length()-1).toLowerCase() + "'s " + field);
    }

    public static void removeItemFromCartUsingID(Account loggedAccount) {
        Printer.printFormattedMessage(
                loggedAccount.getShoppingCart().removeItemFromCart(
                        Input.getString("Insert the ID of the product you want to remove from your cart")
                )
        );
    }

    public static String getProductName(String category) {
        return getProductField(category, "name");
    }

    public static String getProductGenre(String category) {
        return getProductField(category, "genre");
    }

    public static String getProductAuthor(String category) {
        return getProductField(category, "author");
    }

    public static String getStudio(String category) {
        return getProductField(category, "studio");
    }

    public static String getRecordLabel() {
        return Input.getString("Insert the album's record label");
    }

    public static String getPublisher() {
        return Input.getString("Insert the book's publisher");
    }

    public static String getProducer() {
        return Input.getString("Insert the film's producer");
    }

    public static String getDirector() {
        return Input.getString("Insert the film's director");
    }

    public static String getDistribuitor() {
        return Input.getString("Insert the game's distribuitor");
    }


}
