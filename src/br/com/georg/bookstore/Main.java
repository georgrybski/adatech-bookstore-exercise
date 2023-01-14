package br.com.georg.bookstore;

import br.com.georg.bookstore.utilities.*;
import br.com.georg.bookstore.utilities.Menu;

public class Main {
    public static void main(String[] args) {

        Bookstore bookstore = new Bookstore();

        for (int i = 0; i < 5; i++) {
            Menu.addProduct(bookstore);

            if(i == 3 || i == 4) {
                System.out.println(bookstore.getDatabase().getProductByID(Input.getString("Insert a product id")).toString());
            }


//            var hashMap = Bookstore.getInventory();

            Printer.printAllProducts(bookstore);

//            for (Map.Entry<String, HashMap<String, HashMap<String, Product>>> outerEntry : hashMap.entrySet()) {
//                System.out.println("Outer key: " + outerEntry.getKey() + " | Outer value: " + outerEntry.getValue());
//                System.out.println();
//                for (Map.Entry<String, HashMap<String, Product>> innerEntry : outerEntry.getValue().entrySet()) {
//                    System.out.println("    Inner key: " + innerEntry.getKey() + " | Inner value: " + innerEntry.getValue());
//                }
//                System.out.println();
//            }
//
//            for (Map.Entry<String, HashMap<String, String>> outerEntry : IDSearcher.getIDGenreTypeHashMap().entrySet()) {
//                System.out.println("Outer key: " + outerEntry.getKey() + " | Outer value: " + outerEntry.getValue());
//                System.out.println();
//                for (Map.Entry<String, String> innerEntry : outerEntry.getValue().entrySet()) {
//                    System.out.println("    Inner key: " + innerEntry.getKey() + " | Inner value: " + innerEntry.getValue());
//                }
//                System.out.println();
//            }
//
//            for (Map.Entry<String, String> outerEntry : IDSearcher.getIDCategorySearchHashMap().entrySet()) {
//                System.out.println("Outer key: " + outerEntry.getKey() + " | Outer value: " + outerEntry.getValue());
//                System.out.println();
//
//            }

        }
    }

}
