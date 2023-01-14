package br.com.georg.bookstore.utilities;

import br.com.georg.bookstore.database.Database;
import br.com.georg.bookstore.products.*;

import java.math.BigDecimal;

public class Bookstore {

    private static BigDecimal money = BigDecimal.valueOf(0);

    private Bookstore(){}

    public static void recieveMoney(BigDecimal total) {
        money.add(total);
    }

    public static void addProduct(String category, String genreType, Product product) {
        Database.insertProduct(category, genreType, product);
    }

    public static Product findById(String ID) {
        return null;
    }


}
