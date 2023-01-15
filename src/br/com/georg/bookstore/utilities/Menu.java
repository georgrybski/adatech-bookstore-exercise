package br.com.georg.bookstore.utilities;

import br.com.georg.bookstore.products.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private static final String[] PRODUCT_CATEGORY_MENU_OPTIONS =
            createCategoryGenreAndTypeMenuOptions(Product.getCategories());

    private static final String[] LOGGED_OUT_MENU_OPTIONS = {
            "1 - Create an account", " 2 - Log in", "3 - Exit"
    };

    private static final String[] LOGGED_BUYER_MENU_OPTIONS = {
            "1 - Browse all products", "2 -  Add a product to shopping cart", "3 - Go to shopping cart",
            "4 - See my purchase history", "5 - Log out", "6 - Exit"
    };


    private static final String[] ADMIN_MENU_OPTIONS = {
            "1 - See products list", "2 - Add new product", "3 - Modify an existing product",
            "4 - Remove a product", "5 - See sales history", "6 - Log out", "7 - Exit"
    };

    public static HashMap<String, String[]> GENRE_TYPE_ARRAYS = new HashMap<>(Map.of(
            "Albums", Album.getGenreArray(), "Books", Book.getGenreArray(),
            "Films", Film.getGenreArray(), "Games", Game.getGenresArray(),
            "Toys", Toy.getTypesArray()
    ));

    private static String[] getGenreTypeArray(String category) {
        int[] i = {1};
        return Arrays.stream(GENRE_TYPE_ARRAYS.get(category))
                        .map(option -> i[0]++ + " - " + option).toArray(String[]::new);
    }

    public static void seeProductList(Bookstore bookstore) {
        switch (Menu.getIntFrom(new String[] {"1 - All products", "2 -  Products of a certain category"})) {
            case 1:
                Printer.printAllProducts(bookstore);
                Printer.printFormattedMesage("^ List of all products ^");
                break;
            case 2:
                seeProductListByCategory(bookstore);
                break;
        }
    }

    public static void seeProductListByCategory(Bookstore bookstore) {
        Integer categoryNumber = getProductCategory() -1;
        String categoryString = Product.getCategoriesArray()[categoryNumber];

        int input = Menu.getIntFrom(
                new String[]{
                        "1 - See all " + categoryString,
                        "2 - See " + categoryString + " of a specific "
                                + (categoryString.equals("Toys")? "type" : "genre")
                }
        );

        switch (input) {
            case 1:
                Printer.printProductsOfACategory(bookstore, categoryString);
                Printer.printFormattedMesage("^ List of " + categoryString + " ^");
                break;
            case 2:
                seeProductByGenreType(bookstore, categoryString, categoryNumber);
                break;
        }
    }

    public static void seeProductByGenreType(Bookstore bookstore, String category, int categoryNumber) {
        Integer genreTypeNumber = Menu.getIntFrom(getGenreTypeArray(category));
        String genreTypeString = GENRE_TYPE_ARRAYS.get(Product.getCategoriesArray()[categoryNumber])[genreTypeNumber -1];
        Printer.printProductsOfAGenreType(bookstore, category, genreTypeString);
        Printer.printFormattedMesage("^ List of " + genreTypeString  + " " + category + " ^");
    }



    public static void addProduct(Bookstore bookstore) {

        Integer categoryNumber = getProductCategory() -1;
        String categoryString = Product.getCategoriesArray()[categoryNumber];
        Integer genreTypeNumber = Menu.getIntFrom(getGenreTypeArray(categoryString));
        String genreTypeString = GENRE_TYPE_ARRAYS.get(Product.getCategoriesArray()[categoryNumber])[genreTypeNumber -1];
        String productName = Input.getProductName(categoryString);
        BigDecimal productPrice = Input.getProductPrice(categoryString);

        Product newProduct = null;
        switch (categoryString) {
            case "Albums":
                newProduct = new Album(
                        categoryString, productName, productPrice, genreTypeString,
                        Input.getProductAuthor(categoryString),
                        Input.getRecordLabel(), Input.getProductQuantity()
                );
                break;
            case "Books":
                newProduct = new Book(
                        categoryString, productName, productPrice, genreTypeString,
                        Input.getProductAuthor(categoryString),
                        Input.getPublisher(), Input.getProductQuantity()
                );
                break;
            case "Films":
                newProduct = new Film(
                        categoryString, productName, productPrice, genreTypeString,
                        Input.getStudio(categoryString),
                        Input.getDirector(),
                        Input.getProducer(),
                        Input.getProductQuantity()
                );
                break;
            case "Games":
                newProduct = new Game(
                        categoryString, productName, productPrice, genreTypeString,
                        Input.getDistribuitor(),
                        Input.getStudio(categoryString),
                        Input.getProductQuantity()
                );
                break;
            case "Toys":
                newProduct = new Toy(
                        categoryString, productName, productPrice, genreTypeString,
                        Input.getProductQuantity()
                );
                break;
        }

        bookstore.addProduct(categoryString, genreTypeString, newProduct);
    }




    public static void seeProductListByGenreType(Bookstore bookstore){

    }


    private static String[] buyerProductsByCategoryOptions(String category){
        return new String[] {
                "1 - See all " + category,
                "2 - See " + category + " by " + (category.equals("Toys")? "type" : "genre")
        };
    }

    public static String[] createCategoryGenreAndTypeMenuOptions(HashMap<Integer, String> genres) {
        return genres.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toArray(String[]::new);
    }

    public static int getProductCategory() {
        return getIntFrom(PRODUCT_CATEGORY_MENU_OPTIONS);
    }

    public static int getLoggedOutInput(){
        return getIntFrom(LOGGED_OUT_MENU_OPTIONS);
    }

    public static int getCustomerInput() {
        return getIntFrom(LOGGED_BUYER_MENU_OPTIONS);
    }

    public static int getAdminInput() {
        return getIntFrom(ADMIN_MENU_OPTIONS);
    }

//    public static int getInputAdminProducts() {
//        return getIntFrom(ADMIN_SEE_PRODUCTS_LIST);
//    }

    public static int getIntFrom(String[] opcoes) {
        String prompt = "Insert a value between " + 1 + " and " + opcoes.length;
        String msgValorInvalido = "Invalid value! " + prompt;
        return  Input.getIntegerFromMenu(opcoes, 1, opcoes.length, prompt,
                msgValorInvalido, true);
    }

}



