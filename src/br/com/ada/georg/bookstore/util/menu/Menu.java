package br.com.ada.georg.bookstore.util.menu;

import br.com.ada.georg.bookstore.products.Product;
import br.com.ada.georg.bookstore.products.album.Album;
import br.com.ada.georg.bookstore.products.book.Book;
import br.com.ada.georg.bookstore.products.film.Film;
import br.com.ada.georg.bookstore.products.game.Game;
import br.com.ada.georg.bookstore.products.toy.Toy;
import br.com.ada.georg.bookstore.util.input.ProductInput;
import br.com.ada.georg.bookstore.util.printer.CartPrinter;
import br.com.ada.georg.bookstore.util.printer.ProductPrinter;
import br.com.ada.georg.bookstore.products.ProductCategories;
import br.com.ada.georg.bookstore.service.Account;
import br.com.ada.georg.bookstore.service.Bookstore;
import br.com.ada.georg.bookstore.util.input.Input;
import br.com.ada.georg.bookstore.util.printer.Printer;

import java.math.BigDecimal;

public class Menu {

    public static void seeProductList(Bookstore bookstore) {
        switch (Menu.getIntFrom(new String[]{"1 - All products", "2 -  Products of a certain category"})) {
            case 1 -> {
                ProductPrinter.printAllProducts(bookstore);
                Printer.printFormattedMessage("^ List of all products ^");
            }
            case 2 -> seeProductListByCategory(bookstore);
        }
    }

    public static void seeProductListByCategory(Bookstore bookstore) {
        int categoryNumber = getProductCategory() - 1;
        String categoryString = ProductCategories.getCategoriesArray()[categoryNumber];

        int input = Menu.getIntFrom(
                new String[]{
                        "1 - See all " + categoryString,
                        "2 - See " + categoryString + " of a specific "
                                + (categoryString.equals("Toys") ? "type" : "genre")
                }
        );

        switch (input) {
            case 1 -> {
                ProductPrinter.printProductsOfACategory(bookstore, categoryString);
                Printer.printFormattedMessage("^ List of " + categoryString + " ^");
            }
            case 2 -> seeProductByGenreType(bookstore, categoryString, categoryNumber);
        }
    }

    public static void goToCart(Bookstore bookstore, Account loggedAccount) {
        boolean checkingCart = true;
        while (checkingCart) {
            CartPrinter.printShoppingCart(loggedAccount);
        switch (Menu.getIntFrom(new String[]{"1 - Checkout", "2 - Remove or add items", "3 - Continue Shopping"})) {
                case (1) -> {
                    bookstore.completeSale(loggedAccount.getShoppingCart());
                    Printer.printFormattedMessage("Payment successful, thank you for your purchse!");
                    checkingCart = false;
                }
                case (2) -> alterCartItems(bookstore, loggedAccount);
                case (3) -> checkingCart = false;
            }
        }
    }

    public static void alterCartItems(Bookstore bookstore, Account loggedAccount) {

        switch (Menu.getIntFrom(new String[]{"1 - Add item", "2 - Remove item"})) {
            case 1 -> {
                CartPrinter.printShoppingCart(loggedAccount);
                ProductInput.addProductToCartUsingID(bookstore, loggedAccount);
            }
            case 2 -> {
                CartPrinter.printShoppingCart(loggedAccount);
                ProductInput.removeItemFromCartUsingID(loggedAccount);
            }
        }
    }


    public static void seeProductByGenreType(Bookstore bookstore, String category, int categoryNumber) {
        int genreTypeNumber = Menu.getIntFrom(MenuTools.getGenreTypeArray(category));
        String genreTypeString = MenuTools.getGenreTypeArrays().get(ProductCategories.getCategoriesArray()[categoryNumber])[genreTypeNumber - 1];
        ProductPrinter.printProductsOfAGenreType(bookstore, category, genreTypeString);
        Printer.printFormattedMessage("^ List of " + genreTypeString + " " + category + " ^");
    }

    public static void addProduct(Bookstore bookstore) {

        int categoryNumber = getProductCategory() - 1;
        String categoryString = ProductCategories.getCategoriesArray()[categoryNumber];
        int genreTypeNumber = Menu.getIntFrom(MenuTools.getGenreTypeArray(categoryString));
        String genreTypeString = MenuTools.getGenreTypeArrays().get(ProductCategories.getCategoriesArray()[categoryNumber])[genreTypeNumber - 1];
        String productName = ProductInput.getProductName(categoryString);
        BigDecimal productPrice = ProductInput.getProductPrice(categoryString);

        Product newProduct = switch (categoryString) {
            case "Albums" -> new Album(
                    productName, productPrice, genreTypeString,
                    ProductInput.getProductAuthor(categoryString),
                    ProductInput.getRecordLabel(), ProductInput.getProductQuantity(0)
            );
            case "Books" -> new Book(
                    productName, productPrice, genreTypeString,
                    ProductInput.getProductAuthor(categoryString),
                    ProductInput.getPublisher(), ProductInput.getProductQuantity(0)
            );
            case "Films" -> new Film(
                    productName, productPrice, genreTypeString,
                    ProductInput.getStudio(categoryString),
                    ProductInput.getDirector(),
                    ProductInput.getProducer(),
                    ProductInput.getProductQuantity(0)
            );
            case "Games" -> new Game(
                    productName, productPrice, genreTypeString,
                    ProductInput.getDistribuitor(),
                    ProductInput.getStudio(categoryString),
                    ProductInput.getProductQuantity(0)
            );
            case "Toys" -> new Toy(
                    productName, productPrice, genreTypeString,
                    ProductInput.getProductQuantity(0)
            );
            default -> null;
        };

        bookstore.addProduct(categoryString, genreTypeString, newProduct);
    }

    public static int getProductCategory() {
        return getIntFrom(MenuOptions.getProductCategoryMenuOptions());
    }

    public static int getLoggedOutInput() {
        return getIntFrom(MenuOptions.getLoggedOutMenuOptions());
    }

    public static int getCustomerInput() {
        return getIntFrom(MenuOptions.getCustomerMenuOptions());
    }

    public static int getAdminInput() {
        return getIntFrom(MenuOptions.getAdminMenuOptions());
    }


    protected static int getIntFrom(String[] opcoes) {
        String prompt = "Insert a value between " + 1 + " and " + opcoes.length;
        String invalidValueMessage = "Invalid value! " + prompt;
        return Input.getIntegerFromMenu(opcoes, 1, opcoes.length, prompt,
                invalidValueMessage, true);
    }
}



