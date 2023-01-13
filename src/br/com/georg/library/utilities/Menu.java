package br.com.georg.library.utilities;

import br.com.georg.library.products.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private static final String[] PRODUCT_CATEGORY_MENU_OPTIONS =
            createCategoryGenreAndTypeMenuOptions(Product.getCategories());

    public static HashMap<String, String[]> GENRE_TYPE_ARRAYS = new HashMap<>(Map.of(
            "Albums", Album.getGenreArray(), "Books", Book.getGenreArray(),
            "Films", Film.getGenreArray(), "Games", Game.getGenresArray(),
            "Toys", Toy.getTypesArray()
    ));

    public static void addProduct() {

        Integer categoryNumber = getProductCategory() -1;

        String categoryString = Product.getCategoriesArray()[categoryNumber];

        int[] i = {1};
        Integer genreTypeNumber = Menu.getInt(
                Arrays.stream(GENRE_TYPE_ARRAYS.get(categoryString))
                        .map(s -> i[0]++ + " - " + s).toArray(String[]::new)
        );
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
                        Input.getDirector(),
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

        Bookstore.getInventory()
                .get(categoryString)
                .get(genreTypeString)
                .put(newProduct.getID(), newProduct);
    }

    public static int getProductCategory() {
        return getInt(PRODUCT_CATEGORY_MENU_OPTIONS);
    }

    public static int getInt(String[] opcoes) {
        String prompt = "Insert a value between " + 1 + " and " + opcoes.length;
        String msgValorInvalido = "Invalid value! " + prompt;
        return  Input.getIntegerFromMenu(opcoes, 1, opcoes.length, prompt,
                msgValorInvalido, true);
    }

    public static String[] createCategoryGenreAndTypeMenuOptions(HashMap<Integer, String> genres) {
        return genres.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toArray(String[]::new);
    }
}


