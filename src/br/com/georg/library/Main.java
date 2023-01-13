package br.com.georg.library;


import br.com.georg.library.products.Product;
import br.com.georg.library.products.Toy;
import br.com.georg.library.utilities.Bookstore;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

//        var hashMap = Bookstore.getInventory();
//
//        System.out.println();
//        System.out.println();
//
//        for (Map.Entry<String, HashMap<String, HashMap<String, Product>>> outerEntry : hashMap.entrySet()) {
//            System.out.println("Outer key: " + outerEntry.getKey() + " | Outer value: " + outerEntry.getValue());
//            System.out.println();
//            for (Map.Entry<String, HashMap<String, Product>> innerEntry : outerEntry.getValue().entrySet()) {
//                System.out.println("    Inner key: " + innerEntry.getKey() + " | Inner value: " + innerEntry.getValue());
//            }
//            System.out.println();
//        }

        Bookstore.addProductToStock();
    }
}
