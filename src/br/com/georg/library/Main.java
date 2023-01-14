package br.com.georg.library;


import br.com.georg.library.products.Product;
import br.com.georg.library.utilities.Bookstore;
import br.com.georg.library.utilities.IDSearcher;
import br.com.georg.library.utilities.Input;
import br.com.georg.library.utilities.Menu;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Menu.addProduct();

            if(i == 3 || i == 4) {
                System.out.println(IDSearcher.getProductByID(Input.getString("Insert a product id")).toString());
            }

            var hashMap = Bookstore.getInventory();

            System.out.println();
            System.out.println();

            for (Map.Entry<String, HashMap<String, HashMap<String, Product>>> outerEntry : hashMap.entrySet()) {
                System.out.println("Outer key: " + outerEntry.getKey() + " | Outer value: " + outerEntry.getValue());
                System.out.println();
                for (Map.Entry<String, HashMap<String, Product>> innerEntry : outerEntry.getValue().entrySet()) {
                    System.out.println("    Inner key: " + innerEntry.getKey() + " | Inner value: " + innerEntry.getValue());
                }
                System.out.println();
            }

            for (Map.Entry<String, HashMap<String, String>> outerEntry : IDSearcher.getIDGenreTypeHashMap().entrySet()) {
                System.out.println("Outer key: " + outerEntry.getKey() + " | Outer value: " + outerEntry.getValue());
                System.out.println();
                for (Map.Entry<String, String> innerEntry : outerEntry.getValue().entrySet()) {
                    System.out.println("    Inner key: " + innerEntry.getKey() + " | Inner value: " + innerEntry.getValue());
                }
                System.out.println();
            }

            for (Map.Entry<String, String> outerEntry : IDSearcher.getIDCategorySearchHashMap().entrySet()) {
                System.out.println("Outer key: " + outerEntry.getKey() + " | Outer value: " + outerEntry.getValue());
                System.out.println();

            }

        }
    }

}
